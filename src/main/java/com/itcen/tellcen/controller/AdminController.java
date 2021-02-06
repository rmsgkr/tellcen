package com.itcen.tellcen.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.itcen.tellcen.util.PagingVO;
import com.itcen.tellcen.domain.AnswerPDTO;
import com.itcen.tellcen.domain.CommentPDTO;
import com.itcen.tellcen.domain.MemberDTO;
import com.itcen.tellcen.domain.PetitionDTO;
import com.itcen.tellcen.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminService adminService;

	@GetMapping("")
	public String index(Model model) throws Exception {
		int petitionCount = adminService.getPetitionCount();
		int complaintCount = adminService.getComplaintCount();
		int suggestionCount = adminService.getSuggestionCount();
		int inquiryCount = adminService.getInquiryCount();

		model.addAttribute("petitionCount", petitionCount);
		model.addAttribute("complaintCount", complaintCount);
		model.addAttribute("suggestionCount", suggestionCount);
		model.addAttribute("inquiryCount", inquiryCount);
		return "admin/admin";
	}

	// 회원 관리
	@GetMapping("/member")
	public String member(PagingVO vo, Model model, @RequestParam(value = "nowPage", required = false) String nowPage,
			@RequestParam(value = "cntPerPage", required = false) String cntPerPage) throws Exception {
		int total = adminService.getMemberCount(null);
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

		List<MemberDTO> list = adminService.getMemberInfo(vo);
		model.addAttribute("member", list);
		return "admin/member";
	}

	// 회원 검색
	@GetMapping("/searchMember")
	public String memberSearch(PagingVO vo, Model model,
			@RequestParam(value = "nowPage", required = false) String nowPage,
			@RequestParam(value = "cntPerPage", required = false) String cntPerPage,
			@RequestParam(value = "id", required = false, defaultValue = "") String id) throws Exception {

		int total = adminService.getMemberCount(id);
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) {
			cntPerPage = "10";
		}

		vo = new PagingVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage), id);
		model.addAttribute("paging", vo);

		List<MemberDTO> list = adminService.getSearchMemberInfo(vo);
		model.addAttribute("memberInfo", list);

		return "admin/searchMember";
	}

	// 회원별 활동내역 보기
	/*
	 * @GetMapping("/member/{id}") public String member(Model
	 * model, @PathVariable("id") String id) { List<PetitionDTO> petitionList =
	 * adminService.memberPetitionList(id); List<OrdersDTO> list =
	 * orderService.memberOrderlist(id); int sum = orderService.memberSum(id); Date
	 * date = orderService.memberLastest(id);
	 * 
	 * model.addAttribute("list", list); model.addAttribute("id", id);
	 * model.addAttribute("sum", sum); model.addAttribute("date", date); return
	 * "admin/memberOrder"; }
	 */

	// 청원 관리
	@GetMapping("/petition")
	public String petition(PagingVO vo, Model model, @RequestParam(value = "nowPage", required = false) String nowPage,
			@RequestParam(value = "cntPerPage", required = false) String cntPerPage) throws Exception {
		int total = adminService.getSearchPetitionCount(null, null, null);
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

		List<PetitionDTO> list = adminService.getPetitionInfo(vo);
		model.addAttribute("petition", list);
		return "admin/petition";
	}

	// 청원 검색
	@GetMapping("/searchPetition")
	public String petitionSearch(PagingVO vo, Model model,
			@RequestParam(value = "nowPage", required = false) String nowPage,
			@RequestParam(value = "cntPerPage", required = false) String cntPerPage,
			@RequestParam(value = "petitionTitle", required = false, defaultValue = "") String petitionTitle,
			@RequestParam(value = "petitionArea", required = false, defaultValue = "") String petitionArea,
			@RequestParam(value = "petitionField", required = false, defaultValue = "") String petitionField)
			throws Exception {

		int total = adminService.getSearchPetitionCount(petitionTitle, petitionArea, petitionField);
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) {
			cntPerPage = "10";
		}

		vo = new PagingVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage), petitionTitle, petitionArea,
				petitionField);
		model.addAttribute("paging", vo);

		List<PetitionDTO> list = adminService.getSearchPetitionInfo(vo);
		model.addAttribute("petition", list);

		return "admin/searchPetition";
	}

	// 각각의 청원 보기
	@GetMapping("/{petitionNo}")
	public String petitionDetail(Model model, @PathVariable("petitionNo") int petitionNo) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("petitionNo", petitionNo);

		PetitionDTO petition = adminService.getArticle(map);
		model.addAttribute("petition", petition);

		List<AnswerPDTO> answerP = adminService.getAnswerP(petitionNo);
		model.addAttribute("answerP", answerP);

		List<CommentPDTO> commentP = adminService.getCommentP(petitionNo);
		model.addAttribute("commentP", commentP);

		return "admin/petitionDetail";
	}

	
	// 청원 답변 하기
	@GetMapping("/{petitionNo}/answer")
	public String answerPWriteForm(Model model, @PathVariable("petitionNo") int petitionNo) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("petitionNo", petitionNo);
		PetitionDTO petition = adminService.getArticle(map);
		model.addAttribute("petition", petition);
		return "admin/answerPWrite";
	}
	
	// 청원 답변 하기
	@PostMapping("/{petitionNo}/answer")
	public String answerPWrite(Model model, @ModelAttribute AnswerPDTO answerP,
			@PathVariable("petitionNo") int petitionNo) throws Exception {
		answerP.setPetitionNo(petitionNo);
		// answerP테이블에 insert
		adminService.answerPWrite(answerP);
		// 청원상태 2(답변완료)로 업데이트
		adminService.updateStatus(petitionNo);
		model.addAttribute("petitionNo", petitionNo);

		return "/admin/answerPWriteSuccess";
	}

}
