package com.itcen.tellcen.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itcen.tellcen.domain.AnswerPDTO;
import com.itcen.tellcen.domain.CommentPDTO;
import com.itcen.tellcen.domain.MemberDTO;
import com.itcen.tellcen.domain.PetitionDTO;
import com.itcen.tellcen.service.PetitionService;
import com.itcen.tellcen.util.PagingVO;

@Controller
@RequestMapping("/petition")
public class PetitionController {

	@Autowired
	PetitionService petitionService;

	// 청원이란?
	@GetMapping("/petitionInfo")
	public String petitionInfo() {
		return "petition/petitionInfo";
	}

	// 청원 목록
	@GetMapping("/petitionList")
	public String petitionList(PagingVO vo, Model model,
			@RequestParam(value = "nowPage", required = false) String nowPage,
			@RequestParam(value = "cntPerPage", required = false) String cntPerPage) throws Exception {
		int total = petitionService.getArticleCount(null, null, null);
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

		List<PetitionDTO> list = petitionService.getPetitionInfo(vo);
		model.addAttribute("petition", list);

		return "petition/petitionList";
	}

	// 청원 검색
	@GetMapping("/search")
	public String petitionSearch(PagingVO vo, Model model,
			@RequestParam(value = "nowPage", required = false) String nowPage,
			@RequestParam(value = "cntPerPage", required = false) String cntPerPage,
			@RequestParam(value = "petitionTitle", required = false, defaultValue = "") String petitionTitle,
			@RequestParam(value = "petitionArea", required = false, defaultValue = "") String petitionArea,
			@RequestParam(value = "petitionField", required = false, defaultValue = "") String petitionField)
			throws Exception {

		int total = petitionService.getArticleCount(petitionTitle, petitionArea, petitionField);
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1"; 
			cntPerPage = "10";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) {
			cntPerPage = "10";
		}

		vo = new PagingVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage), petitionTitle , petitionArea, petitionField);
		model.addAttribute("paging", vo);
		
		List<PetitionDTO> list = petitionService.getSearchInfo(vo);
		model.addAttribute("petition", list);
		

		return "petition/search";
	}

	// 각각의 청원 보기
	@GetMapping("/{petitionNo}")
	public String petitionDetail(Model model, @PathVariable("petitionNo") int petitionNo, HttpServletRequest request)
			throws Exception {
		HttpSession session = request.getSession();
		String id = null;
		MemberDTO member = (MemberDTO) session.getAttribute("member");
		id = member.getId(); 

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("petitionNo", petitionNo);

		PetitionDTO petition = petitionService.getArticle(map);
		model.addAttribute("petition", petition);

		List<AnswerPDTO> answerP = petitionService.getAnswerP(petitionNo);
		model.addAttribute("answerP", answerP);
		
		List<CommentPDTO> commentP = petitionService.getCommentP(petitionNo);
		model.addAttribute("commentP", commentP);

		return "petition/petitionDetail";
	}

	// 청원 댓글(동의) 작성
	@PostMapping("/{petitionNo}/agree")
	public String commentPWrite(Model model, HttpServletRequest request, @ModelAttribute CommentPDTO commentP,
			@PathVariable("petitionNo") int petitionNo) {
		HttpSession session = request.getSession();
		String id = null;
		try {
			MemberDTO member = (MemberDTO) session.getAttribute("member");
			id = member.getId();
			commentP.setId(id);
			commentP.setPetitionNo(petitionNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		petitionService.agreementPlus(petitionNo);
		petitionService.commentPWrite(commentP);
		model.addAttribute("petitionNo", petitionNo);

		return "/petition/agreeSuccess";
	}

	// 청원 작성
	@GetMapping("/petitionWrite")
	public String petitionWriteForm() {
		return "petition/petitionWrite";
	}

	// 청원 작성
	@PostMapping("/petitionWrite")
	public String petitionWrite(HttpServletRequest request, @ModelAttribute PetitionDTO petition) {
		HttpSession session = request.getSession();
		String id = null;
		try {
			MemberDTO member = (MemberDTO) session.getAttribute("member");
			id = member.getId();
			petition.setId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		petitionService.petitionWrite(petition);
		return "/petition/petitionSuccess";
	}

}
