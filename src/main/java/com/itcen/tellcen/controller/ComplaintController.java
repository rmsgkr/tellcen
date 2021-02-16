package com.itcen.tellcen.controller;

import java.util.*;
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

import com.itcen.tellcen.domain.AnswerCDTO;
import com.itcen.tellcen.domain.ComplaintDTO;
import com.itcen.tellcen.domain.MemberDTO;
import com.itcen.tellcen.service.ComplaintService;
import com.itcen.tellcen.util.PagingVO;

@Controller
@RequestMapping("/complaint")
public class ComplaintController {

	@Autowired
	ComplaintService complaintService;

	// 민원이란?
	@GetMapping("/complaintInfo")
	public String complaintInfo() {
		return "complaint/complaintInfo";
	}
	
	// 민원 작성
	@GetMapping("/complaintWrite")
	public String complaintWriteForm() {
		return "complaint/complaintWrite";
	}

	// 민원 작성
	@PostMapping("/complaintWrite")
	public String complaintWrite(HttpServletRequest request, @ModelAttribute ComplaintDTO complaint) {
		HttpSession session = request.getSession();
		String id = null;
		try {
			MemberDTO member = (MemberDTO) session.getAttribute("member");
			id = member.getId();
			complaint.setId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		complaintService.complaintWrite(complaint);
		return "/complaint/complaintSuccess";
	}
	
	// 민원 목록
	@GetMapping("/complaintList")
	public String complaintList(PagingVO vo, Model model,
			@RequestParam(value = "nowPage", required = false) String nowPage,
			@RequestParam(value = "cntPerPage", required = false) String cntPerPage) throws Exception {
		int total = complaintService.getArticleCount(null, null, null, null, null);
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) {
			cntPerPage = "10";
		}

		vo = new PagingVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		model.addAttribute("paging", vo);

		List<ComplaintDTO> list = complaintService.getComplaintInfo(vo);
		model.addAttribute("complaint", list);
		return "complaint/complaintList";
	}
	
	// 각각의 민원 보기
	@GetMapping("/{complaintNo}")
	public String complaintDetail(Model model, @PathVariable("complaintNo") int complaintNo)
			throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("complaintNo", complaintNo);

		ComplaintDTO complaint = complaintService.getArticle(map);
		model.addAttribute("complaint", complaint);

		List<AnswerCDTO> answerC = complaintService.getAnswerC(complaintNo);
		model.addAttribute("answerC", answerC);
		return "complaint/complaintDetail";
	}
	
	
	// 민원 검색
	@GetMapping("/search")
	public String complaintSearch(PagingVO vo, Model model,
			@RequestParam(value = "nowPage", required = false) String nowPage,
			@RequestParam(value = "cntPerPage", required = false) String cntPerPage,
			@RequestParam(value = "complaintTitle", required = false, defaultValue = "") String complaintTitle,
			@RequestParam(value = "complaintOrganization", required = false, defaultValue = "") String complaintOrganization,
			@RequestParam(value = "complaintOrganizationDetail", required = false, defaultValue = "") String complaintOrganizationDetail,
			@RequestParam(value = "complaintSdate", required = false, defaultValue = "")  String complaintSdate,
			@RequestParam(value = "complaintEdate", required = false, defaultValue = "") String complaintEdate) throws Exception {
		int total = complaintService.getArticleCount(complaintTitle, complaintOrganization, complaintOrganizationDetail, complaintSdate, complaintEdate);
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) {
			cntPerPage = "10";
		}

		vo = new PagingVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage), complaintTitle, complaintOrganization, complaintOrganizationDetail, complaintSdate, complaintEdate);
		model.addAttribute("paging", vo);

		List<ComplaintDTO> list = complaintService.getSearchInfo(vo);
		model.addAttribute("complaint", list);
		
		
		return "complaint/search";
	}
	
	
}
