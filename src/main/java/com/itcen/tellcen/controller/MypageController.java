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

import com.itcen.tellcen.domain.AnswerCDTO;
import com.itcen.tellcen.domain.AnswerIDTO;
import com.itcen.tellcen.domain.AnswerPDTO;
import com.itcen.tellcen.domain.AnswerSDTO;
import com.itcen.tellcen.domain.CommentPDTO;
import com.itcen.tellcen.domain.CommentSDTO;
import com.itcen.tellcen.domain.ComplaintDTO;
import com.itcen.tellcen.domain.InquiryDTO;
import com.itcen.tellcen.domain.MemberDTO;
import com.itcen.tellcen.domain.PetitionDTO;
import com.itcen.tellcen.domain.SuggestionDTO;
import com.itcen.tellcen.service.MypageService;
import com.itcen.tellcen.util.PagingVO;




@Controller
@RequestMapping("/mypage")
public class MypageController {

	@Autowired
	MypageService mypageService;
	
	@GetMapping("")
	public String index(HttpServletRequest request, Model model) throws Exception {
		
		HttpSession session = request.getSession();
		String id = null;
		try {
			MemberDTO member = (MemberDTO) session.getAttribute("member");
			id = member.getId();
		} catch (Exception e) {
			e.printStackTrace();
		}
		int petitionCount = mypageService.getMyPetitionCount(id);
		int complaintCount = mypageService.getMyComplaintCount(id);
		int suggestionCount = mypageService.getMySuggestionCount(id);
		int inquiryCount = mypageService.getMyInquiryCount(id);

		model.addAttribute("petitionCount", petitionCount);
		model.addAttribute("complaintCount", complaintCount);
		model.addAttribute("suggestionCount", suggestionCount);
		model.addAttribute("inquiryCount", inquiryCount);
		return "mypage/mypage";
	}
	
	// 청원 목록
	@GetMapping("/petitionList")
	public String petitionList(HttpServletRequest request, PagingVO vo, Model model, @RequestParam(value = "nowPage", required = false) String nowPage,
			@RequestParam(value = "cntPerPage", required = false) String cntPerPage) throws Exception {
		
		HttpSession session = request.getSession();
		String id = null;
		try {
			MemberDTO member = (MemberDTO) session.getAttribute("member");
			id = member.getId();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int total = mypageService.getPetitionCount(id);
		
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

		List<PetitionDTO> list = mypageService.getPetitionInfo(vo);
		model.addAttribute("petition", list);
		return "mypage/petitionList";
	}
	
	// 각각의 청원 보기
	@GetMapping("petition/{petitionNo}")
	public String petitionDetail(Model model, @PathVariable("petitionNo") int petitionNo, HttpServletRequest request)
			throws Exception {
		HttpSession session = request.getSession();
		String id = null;
		MemberDTO member = (MemberDTO) session.getAttribute("member");
		id = member.getId(); 

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("petitionNo", petitionNo);

		PetitionDTO petition = mypageService.getPetition(map);
		model.addAttribute("petition", petition);

		List<AnswerPDTO> answerP = mypageService.getAnswerP(petitionNo);
		model.addAttribute("answerP", answerP);

		List<CommentPDTO> commentP = mypageService.getCommentP(petitionNo);
		model.addAttribute("commentP", commentP);
		
		return "mypage/petitionDetail";
	}
	
	
	// 민원 목록
	@GetMapping("/complaintList")
	public String complaintList(HttpServletRequest request, PagingVO vo, Model model, @RequestParam(value = "nowPage", required = false) String nowPage,
			@RequestParam(value = "cntPerPage", required = false) String cntPerPage) throws Exception {
		
		HttpSession session = request.getSession();
		String id = null;
		try {
			MemberDTO member = (MemberDTO) session.getAttribute("member");
			id = member.getId();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int total = mypageService.getComplaintCount(id);
		
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

		List<ComplaintDTO> list = mypageService.getComplaintInfo(vo);
		model.addAttribute("complaint", list);
		return "mypage/complaintList";
	}
	
	// 각각의 민원 보기
	@GetMapping("complaint/{complaintNo}")
	public String complaintDetail(Model model, @PathVariable("complaintNo") int complaintNo, HttpServletRequest request)
			throws Exception {
		HttpSession session = request.getSession();
		String id = null;
		MemberDTO member = (MemberDTO) session.getAttribute("member");
		id = member.getId(); 

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("complaintNo", complaintNo);

		ComplaintDTO complaint = mypageService.getComplaint(map);
		model.addAttribute("complaint", complaint);

		List<AnswerCDTO> answerC = mypageService.getAnswerC(complaintNo);
		model.addAttribute("answerC", answerC);

		return "mypage/complaintDetail";
	}
	
	
	// 제안 목록
	@GetMapping("/suggestionList")
	public String suggestionList(HttpServletRequest request, PagingVO vo, Model model, @RequestParam(value = "nowPage", required = false) String nowPage,
			@RequestParam(value = "cntPerPage", required = false) String cntPerPage) throws Exception {
		
		HttpSession session = request.getSession();
		String id = null;
		try {
			MemberDTO member = (MemberDTO) session.getAttribute("member");
			id = member.getId();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int total = mypageService.getSuggestionCount(id);
		
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

		List<SuggestionDTO> list = mypageService.getSuggestionInfo(vo);
		model.addAttribute("suggestion", list);
		return "mypage/suggestionList";
	}
	
	// 각각의 제안 보기
	@GetMapping("suggestion/{suggestionNo}")
	public String suggestionDetail(Model model, @PathVariable("suggestionNo") int suggestionNo, HttpServletRequest request)
			throws Exception {
		HttpSession session = request.getSession();
		String id = null;
		MemberDTO member = (MemberDTO) session.getAttribute("member");
		id = member.getId(); 

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("suggestionNo", suggestionNo);

		SuggestionDTO suggestion = mypageService.getSuggestion(map);
		model.addAttribute("suggestion", suggestion);

		List<AnswerSDTO> answerS = mypageService.getAnswerS(suggestionNo);
		model.addAttribute("answerS", answerS);

		List<CommentSDTO> commentS = mypageService.getCommentS(suggestionNo);
		model.addAttribute("commentS", commentS);
		
		return "mypage/suggestionDetail";
	}
	
	
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
