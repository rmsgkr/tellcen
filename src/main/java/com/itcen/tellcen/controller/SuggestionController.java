package com.itcen.tellcen.controller;

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

import com.itcen.tellcen.domain.AnswerPDTO;
import com.itcen.tellcen.domain.AnswerSDTO;
import com.itcen.tellcen.domain.CommentPDTO;
import com.itcen.tellcen.domain.CommentSDTO;
import com.itcen.tellcen.domain.MemberDTO;
import com.itcen.tellcen.domain.SuggestionDTO;
import com.itcen.tellcen.service.SuggestionService;
import com.itcen.tellcen.util.PagingVO;

@Controller
@RequestMapping("/suggestion")
public class SuggestionController {

	@Autowired
	SuggestionService suggestionService;
	
	// 제안 이란?
	@GetMapping("/suggestionInfo")
	public String suggestionInfo() {
		return "suggestion/suggestionInfo";
	}
	
	// 제안 작성
	@GetMapping("/suggestionWrite")
	public String suggestionWriteForm() {
		return "suggestion/suggestionWrite";
	}

	// 제안 작성
	@PostMapping("/suggestionWrite")
	public String suggestionWrite(HttpServletRequest request, @ModelAttribute SuggestionDTO suggestion) {
		HttpSession session = request.getSession();
		String id = null;
		try {
			MemberDTO member = (MemberDTO) session.getAttribute("member");
			id = member.getId();
			suggestion.setId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		suggestionService.suggestionWrite(suggestion);
		return "/suggestion/suggestionSuccess";
	}
	
	
	// 제안 목록
	@GetMapping("/suggestionList")
	public String suggestionList(PagingVO vo, Model model,
			@RequestParam(value = "nowPage", required = false) String nowPage,
			@RequestParam(value = "cntPerPage", required = false) String cntPerPage) throws Exception {
		int total = suggestionService.getArticleCount(null, null, null);
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

		List<SuggestionDTO> list = suggestionService.getSuggestionInfo(vo);
		model.addAttribute("suggestion", list);

		return "suggestion/suggestionList";
	}
	
	// 제안 검색
	@GetMapping("/search")
	public String suggestionSearch(PagingVO vo, Model model,
			@RequestParam(value = "nowPage", required = false) String nowPage,
			@RequestParam(value = "cntPerPage", required = false) String cntPerPage,
			@RequestParam(value = "suggestionTitle", required = false, defaultValue = "") String suggestionTitle,
			@RequestParam(value = "suggestionSdate", required = false, defaultValue = "") String suggestionSdate,
			@RequestParam(value = "suggestionEdate", required = false, defaultValue = "") String suggestionEdate)
			throws Exception {

		int total = suggestionService.getArticleCount(suggestionTitle, suggestionSdate, suggestionEdate);
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1"; 
			cntPerPage = "10";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) {
			cntPerPage = "10";
		}

		vo = new PagingVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage), null, suggestionTitle, suggestionSdate, suggestionEdate);
		model.addAttribute("paging", vo);
		
		List<SuggestionDTO> list = suggestionService.getSearchInfo(vo);
		model.addAttribute("suggestion", list);
		

		return "suggestion/search";
	}
	

	// 각각의 제안 보기
	@GetMapping("/{suggestionNo}")
	public String suggestionDetail(Model model, @PathVariable("suggestionNo") int suggestionNo, HttpServletRequest request)
			throws Exception {
		HttpSession session = request.getSession();
		String id = null;
		MemberDTO member = (MemberDTO) session.getAttribute("member");
		id = member.getId(); 

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("suggestionNo", suggestionNo);

		SuggestionDTO suggestion = suggestionService.getArticle(map);
		model.addAttribute("suggestion", suggestion);

		List<AnswerSDTO> answerS = suggestionService.getAnswerS(suggestionNo);
		model.addAttribute("answerS", answerS);
		
		List<CommentSDTO> commentS = suggestionService.getCommentS(suggestionNo);
		model.addAttribute("commentS", commentS);

		return "suggestion/suggestionDetail";
	}

	// 제안 댓글 작성
	@PostMapping("/{suggestionNo}/comment")
	public String commentSWrite(Model model, HttpServletRequest request, @ModelAttribute CommentSDTO commentS,
			@PathVariable("suggestionNo") int suggestionNo) {
		HttpSession session = request.getSession();
		String id = null;
		try {
			MemberDTO member = (MemberDTO) session.getAttribute("member");
			id = member.getId();
			commentS.setId(id);
			commentS.setSuggestionNo(suggestionNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		suggestionService.commentSWrite(commentS);
		model.addAttribute("suggestionNo", suggestionNo);

		return "/suggestion/commentSuccess";
	}
}
