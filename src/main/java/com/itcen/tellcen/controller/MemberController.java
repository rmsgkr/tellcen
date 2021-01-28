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

	/*
	 * // 회원가입 목록(카카오, 네이버, 말해주센 중 택 1 - 나중에)
	 * 
	 * @GetMapping("/signuplist") public String signuplist() { return
	 * "member/signuplist"; }
	 */
	// 로그인 인터셉터
	@GetMapping("/loginInterceptor")
	public String Interceptor() {
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

		return "member/signupOk";
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

	// 회원 정보 수정
	@GetMapping("/modify")
	public String modifyForm(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO) session.getAttribute("member");
		String id = dto.getId();

		MemberDTO member = memberService.getInfo(id);
		String email = member.getEmail();
		String tel = member.getTel();
		String address = member.getAddress();

		member.setEmail1(email.substring(0, email.indexOf("@")));
		member.setEmail2(email.substring(email.indexOf("@") + 1));
		member.setTel1(tel.substring(0, tel.indexOf("-")));
		member.setTel2(tel.substring(tel.indexOf("-") + 1, tel.lastIndexOf("-")));
		member.setTel3(tel.substring(tel.lastIndexOf("-") + 1));
		member.setAddress1(address.substring(0, address.indexOf(",")));
		member.setAddress2(address.substring(address.indexOf(",") + 1, address.indexOf("(")));
		member.setAddress3(address.substring(address.indexOf("(")));
		model.addAttribute("info", member);

		return "member/modify";
	}

	@PostMapping("/modify")
	public String modify(@ModelAttribute MemberDTO member) {
		member.setEmail();
		member.setTel();
		member.setAddress();
		String dbPwd = memberService.getPwd(member.getId());

		boolean passMatch = passEncoder.matches(member.getPwd(), dbPwd);
		if (passMatch) {
			memberService.modify(member);
		}
		return "redirect:/member/modify";
	}

	// 회원탈퇴
	@GetMapping("/delete")
	public String delete() {
		return "member/delete";
	}

	@PostMapping("/delete")
	public String delete(@RequestParam("id") String id, @RequestParam("pwd") String pwd) {
		String dbPwd = memberService.getPwd(id);
		boolean passMatch = passEncoder.matches(pwd, dbPwd);
		if (passMatch) {
			memberService.delete(id);
			return "member/deleteOk";
		} else {
			return "redirect:/member/delete";
		}
	}

	// 아이디 찾기
	@GetMapping("/seekId")
	public String seekIdForm() {
		return "member/seekId";
	}

	@PostMapping("/seekId")
	public String seekId(Model model, @ModelAttribute MemberDTO member) {
		String id = memberService.getId(member);
		model.addAttribute("id", id);
		return "member/seekIdOk"; // 아이디 알려줌
	}

	// 비밀번호 찾기
	@GetMapping("/seekPwd")
	public String seekPwdForm() {
		return "member/seekPwd";
	}

	@PostMapping("/seekPwd")
	public String seekPwd(HttpServletResponse response, @RequestParam("id") String id,
			@RequestParam("email") String email) { // 인증번호 발송
		String dbEmail = memberService.getEmail(id);
		boolean result = dbEmail.equals(email);

		if (result) {
			String authKey = mss.sendPwdMail(id, email);
			Cookie cookie = new Cookie("authKey", authKey);
			cookie.setMaxAge(60 * 10);
			response.addCookie(cookie);

			Cookie cookie2 = new Cookie("id", id);
			cookie.setMaxAge(60 * 10);
			response.addCookie(cookie2);

			return "member/authenPwd"; // 인증번호 입력
		} else {
			return "javascript:history.back()";
		}
	}

	// 비밀번호 인증
	@PostMapping("/authenPwd")
	public String authenPwd(HttpServletRequest request, @RequestParam("key") String inputKey) { // 인증번호 일치여부
		Cookie[] cookie = request.getCookies();
		String authKey = null;
		for (Cookie c : cookie) {
			if (c.getName().equals("authKey"))
				authKey = c.getValue();
		}

		boolean result = inputKey.equals(authKey);
		if (result) {
			return "member/changePwd"; // 비밀번호 변경
		} else {
			return "javascript:history.back()";
		}
	}

	// 비밀번호 변경
	@GetMapping("/changePwd")
	public String changePwdForm() {
		return "member/changePwd";
	}

	@PostMapping("/changePwd")
	public String changePwd(HttpServletRequest request, @RequestParam("pwd") String pwd) {
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
		memberService.changePwd(map);
		return "redirect:/";
	}

	/*
	 * @GetMapping("/idCheck")
	 * 
	 * @ResponseBody public int idCheck(@RequestParam("id") String id) {
	 * System.out.println(id); return memberService.checkId(id); }
	 */
}
