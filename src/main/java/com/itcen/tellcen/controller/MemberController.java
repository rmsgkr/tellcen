package com.itcen.tellcen.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itcen.tellcen.domain.MemberDTO;
import com.itcen.tellcen.service.MailSendService;
import com.itcen.tellcen.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	MemberService memberService;
	@Autowired
	MailSendService mss;
	@Autowired
	BCryptPasswordEncoder passEncoder;


	// 로그인 인터셉터
	@GetMapping("/loginInterceptor")
	public String loginInterceptor() {
		return "member/loginInterceptor";
	}
	
	// 회원가입
	@GetMapping("/signup")
	public String signup() {
		return "member/signup";
	}

	@PostMapping("/signup")
	public String signup(@ModelAttribute MemberDTO member) {
		member.setEmail();
		member.setTel();
		member.setAddress();
		// 비밀번호 암호화
		String pwd = member.getPwd();
		String CypPwd = passEncoder.encode(pwd);
		member.setPwd(CypPwd);

		memberService.signup(member);

		// 이메일 인증번호 발송
		String authKey = mss.sendAuthMail(member.getId(), member.getEmail());
		member.setEmailAuthKey(authKey);

		Map<String, String> map = new HashMap<String, String>();
		map.put("id", member.getId());
		map.put("email", member.getEmail());
		map.put("authKey", member.getEmailAuthKey());
		memberService.insertAuthKey(map);

		return "member/signupSuccess";
	}

	// 인증번호 확인
	@GetMapping("/signupCheck")
	public String signupCheck(@RequestParam("id") String id, @RequestParam("email") String email,
			@RequestParam("authKey") String authKey) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("email", email);
		map.put("authKey", authKey);

		boolean result = memberService.checkAuthKey(map);
		if (result) {
			return "member/authen";
		}
		return "index";
	}

	// 로그인
	@GetMapping("/login")
	public String loginForm() {
		return "member/login";
	}

	@PostMapping("/login")
	public String login(HttpServletRequest request, @RequestParam("id") String id, @RequestParam("pwd") String pwd) {
		Map<String, String> map = new HashMap<String, String>();
		HttpSession session = request.getSession();
		map.put("id", id);
		map.put("pwd", pwd);
		MemberDTO member = memberService.login(map);
		
		// DB에 정보가 없는 경우(아이디/패스워드 잘못됐을 때와 동일한 것이 좋음)
		// ID 및 PW 체크해서 안맞을 경우 (matches를 이용한 암호화 체크를 해야함)
		if (member==null || !id.equals(member.getId()) ||!passEncoder.matches(pwd, member.getPwd()) ) { 
			return "member/loginFail";
		}
		// 이메일 인증 안됨
		else if (member.getEmailAuthCheck() != 1) { 
			return "member/authNotYet";
		}
		// 로그인 성공
		else { 
			session.setAttribute("member", member);
			// 세션 유지시간 30분
		    session.setMaxInactiveInterval(60*30) ;
			return "member/loginSuccess";
		}	
	}

	// 로그아웃
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "member/logout";
	}

	
	// 아이디 찾기
	@GetMapping("/seekMemberId")
	public String seekMemberIdForm() {
		return "member/seekMemberId";
	}

	@PostMapping("/seekMemberId")
	public String seekMemberId(Model model, 
			@RequestParam("name") String name, 
			@RequestParam("email") String email) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", name);
		map.put("email", email);
		String id = memberService.getMemberId(map);
		System.out.println(id);
		
		model.addAttribute("id", id);
		return "member/seekMemberIdSuccess"; // 아이디 알려줌 
		
	}

	// 비밀번호 찾기
	@GetMapping("/seekMemberPwd")
	public String seekMemberPwdForm() {
		return "member/seekMemberPwd";
	}

	@PostMapping("/seekMemberPwd")
	public String seekMemberPwd(HttpServletResponse response, @RequestParam("id") String id,
			@RequestParam("email") String email) { // 인증번호 발송
		
		String dbEmail = memberService.getMemberEmail(id);
		if(dbEmail==null) {
			dbEmail = "dbEmail";
		}
		
		boolean result = dbEmail.equals(email);
		
	
		if (result) {
			String authKey = mss.sendPwdMail(id, email);
			Cookie cookie = new Cookie("authKey", authKey);
			cookie.setMaxAge(60 * 10);
			response.addCookie(cookie);

			Cookie cookie2 = new Cookie("id", id);
			cookie.setMaxAge(60 * 10);
			response.addCookie(cookie2);
 
			return "member/authenMemberPwd"; // 인증번호 입력
		} 
		else {
			return "member/notMatchEmail";
		}
	}

	// 비밀번호 인증
	@PostMapping("/authenMemberPwd")
	public String authenMemberPwd(HttpServletRequest request, @RequestParam("key") String inputKey) { // 인증번호 일치여부
		Cookie[] cookie = request.getCookies();
		String authKey = null;
		for (Cookie c : cookie) {
			if (c.getName().equals("authKey"))
				authKey = c.getValue();
		}

		boolean result = inputKey.equals(authKey);
		if (result) {
			return "member/changeMemberPwd"; // 비밀번호 변경
		} else {
			return "member/authenMemberPwdFail";
		}
	}

	// 비밀번호 변경
	@GetMapping("/changeMemberPwd")
	public String changeMemberPwdForm() {
		return "member/changeMemberPwd";
	}

	@PostMapping("/changeMemberPwd")
	public String changeMemberPwd(HttpServletRequest request, @RequestParam("pwd") String pwd) {
		HttpSession session = request.getSession();
		String id = null;
		try {
			MemberDTO member = (MemberDTO) session.getAttribute("member");
			id = member.getId();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (id == null) {
			Cookie[] cookie = request.getCookies();
			for (Cookie c : cookie) {
				if (c.getName().equals("id"))
					id = c.getValue();
			}
		}

		String CypPwd = passEncoder.encode(pwd);

		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("pwd", CypPwd);
		memberService.changeMemberPwd(map);
		return "member/changeMemberPwdSuccess";
	}

}
