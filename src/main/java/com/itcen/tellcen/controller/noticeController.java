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

import com.itcen.tellcen.domain.AnswerSDTO;
import com.itcen.tellcen.domain.CommentSDTO;
import com.itcen.tellcen.domain.MemberDTO;
import com.itcen.tellcen.domain.NoticeDTO;
import com.itcen.tellcen.domain.SuggestionDTO;
import com.itcen.tellcen.service.NoticeService;
import com.itcen.tellcen.util.PagingVO;



@Controller
@RequestMapping("/notice")
public class noticeController {

	@Autowired
	NoticeService noticeService;
	
	// 공지 목록
	@GetMapping("/noticeList")
	public String noticeList(PagingVO vo, Model model,
			@RequestParam(value = "nowPage", required = false) String nowPage,
			@RequestParam(value = "cntPerPage", required = false) String cntPerPage) throws Exception {
		int total = noticeService.getArticleCount(null);
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

		List<NoticeDTO> list = noticeService.getNoticeInfo(vo);
		model.addAttribute("notice", list);

		return "notice/noticeList";
	}
	
	// 공지 검색
	@GetMapping("/search")
	public String noticeSearch(PagingVO vo, Model model,
			@RequestParam(value = "nowPage", required = false) String nowPage,
			@RequestParam(value = "cntPerPage", required = false) String cntPerPage,
			@RequestParam(value = "noticeTitle", required = false, defaultValue = "") String noticeTitle) throws Exception {
		int total = noticeService.getArticleCount(noticeTitle);
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) {
			cntPerPage = "10";
		}

		vo = new PagingVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage), noticeTitle);
		model.addAttribute("paging", vo);

		List<NoticeDTO> list = noticeService.getSearchInfo(vo);
		model.addAttribute("notice", list);

		return "notice/search";
	}
	
	// 각각의 공지 보기
	@GetMapping("/{noticeNo}")
	public String noticeDetail(Model model, @PathVariable("noticeNo") int noticeNo)
			throws Exception {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("noticeNo", noticeNo);

		NoticeDTO notice = noticeService.getArticle(map);
		model.addAttribute("notice", notice);


		return "notice/noticeDetail";
	}
	


}
