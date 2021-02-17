package com.itcen.tellcen.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.itcen.tellcen.domain.AnswerIDTO;
import com.itcen.tellcen.domain.AnswerSDTO;
import com.itcen.tellcen.domain.CommentSDTO;
import com.itcen.tellcen.domain.InquiryDTO;
import com.itcen.tellcen.domain.MemberDTO;
import com.itcen.tellcen.domain.SuggestionDTO;
import com.itcen.tellcen.service.MypageService;
import com.itcen.tellcen.util.PagingVO;




@Controller
@RequestMapping("/mypage")
public class MypageController {

	@Autowired
	MypageService mypageService;
	
	// 문의 목록
	@GetMapping("/inquiryList")
	public String inquiryList(HttpServletRequest request, PagingVO vo, Model model, @RequestParam(value = "nowPage", required = false) String nowPage,
			@RequestParam(value = "cntPerPage", required = false) String cntPerPage) throws Exception {
		
		HttpSession session = request.getSession();
		String id = null;
		try {
			MemberDTO member = (MemberDTO) session.getAttribute("member");
			id = member.getId();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int total = mypageService.getInquiryCount(id);
		
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) {
			cntPerPage = "10";
		}

		vo = new PagingVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage), id, null, null, null);
		model.addAttribute("paging", vo);

		List<InquiryDTO> list = mypageService.getInquiryInfo(vo);
		model.addAttribute("inquiry", list);
		return "mypage/inquiryList";
	}
	
	// 각각의 문의 보기
	@GetMapping("inquiry/{inquiryNo}")
	public String inquiryDetail(Model model, @PathVariable("inquiryNo") int inquiryNo, HttpServletRequest request)
			throws Exception {
		HttpSession session = request.getSession();
		String id = null;
		MemberDTO member = (MemberDTO) session.getAttribute("member");
		id = member.getId(); 

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("inquiryNo", inquiryNo);

		InquiryDTO inquiry = mypageService.getInquiry(map);
		model.addAttribute("inquiry", inquiry);

		List<AnswerIDTO> answerI = mypageService.getAnswerI(inquiryNo);
		model.addAttribute("answerI", answerI);

		return "mypage/inquiryDetail";
	}

}
