package com.itcen.tellcen.controller;

import java.sql.Timestamp;
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
import com.itcen.tellcen.domain.AnswerCDTO;
import com.itcen.tellcen.domain.AnswerPDTO;
import com.itcen.tellcen.domain.AnswerSDTO;
import com.itcen.tellcen.domain.CommentPDTO;
import com.itcen.tellcen.domain.CommentSDTO;
import com.itcen.tellcen.domain.ComplaintDTO;
import com.itcen.tellcen.domain.MemberDTO;
import com.itcen.tellcen.domain.PetitionDTO;
import com.itcen.tellcen.domain.SuggestionDTO;
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

	/* -------------------------회원------------------------------- */
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

		vo = new PagingVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage), id, null, null, null);
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

	/* -------------------------청원------------------------------- */
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
	@GetMapping("/petition/{petitionNo}")
	public String petitionDetail(Model model, @PathVariable("petitionNo") int petitionNo) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("petitionNo", petitionNo);

		PetitionDTO petition = adminService.getPetition(map);
		model.addAttribute("petition", petition);

		List<AnswerPDTO> answerP = adminService.getAnswerP(petitionNo);
		model.addAttribute("answerP", answerP);

		List<CommentPDTO> commentP = adminService.getCommentP(petitionNo);
		model.addAttribute("commentP", commentP);

		return "admin/petitionDetail";
	}

	// 청원 답변 하기
	@GetMapping("/petition/{petitionNo}/answer")
	public String answerPWriteForm(Model model, @PathVariable("petitionNo") int petitionNo) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("petitionNo", petitionNo);
		PetitionDTO petition = adminService.getPetition(map);
		model.addAttribute("petition", petition);
		return "admin/answerPWrite";
	}

	// 청원 답변 하기
	@PostMapping("petition/{petitionNo}/answer")
	public String answerPWrite(Model model, @ModelAttribute AnswerPDTO answerP,
			@PathVariable("petitionNo") int petitionNo) throws Exception {
		answerP.setPetitionNo(petitionNo);
		// answerP테이블에 insert
		adminService.answerPWrite(answerP);
		// 청원상태 2(답변완료)로 업데이트
		adminService.updatePetitionStatus2(petitionNo);
		model.addAttribute("petitionNo", petitionNo);

		return "/admin/answerPWriteSuccess";
	}

	// 청원 마감 하기
	@GetMapping("/petition/{petitionNo}/finish")
	public String petitionFinishForm(Model model, @PathVariable("petitionNo") int petitionNo) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("petitionNo", petitionNo);
		PetitionDTO petition = adminService.getPetition(map);
		model.addAttribute("petition", petition);
		return "/admin/petitionFinish";
	}

	// 청원 마감 하기
	@PostMapping("petition//{petitionNo}/finish")
	public String petitionFinish(@PathVariable("petitionNo") int petitionNo) throws Exception {
		adminService.updatePetitionStatus1(petitionNo);
		return "/admin/petitionFinishSuccess";
	}

	// 청원 삭제 하기
	@GetMapping("/petition/{petitionNo}/delete")
	public String petitionDeleteForm(Model model, @PathVariable("petitionNo") int petitionNo) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("petitionNo", petitionNo);
		PetitionDTO petition = adminService.getPetition(map);
		model.addAttribute("petition", petition);
		return "/admin/petitionDelete";
	}

	// 청원 삭제 하기
	@PostMapping("petition/{petitionNo}/delete")
	public String petitionDelete(@PathVariable("petitionNo") int petitionNo) throws Exception {
		adminService.updatePetitionStatus3(petitionNo);
		return "/admin/petitionDeleteSuccess";
	}

	// 상태별 청원 보기
	@GetMapping("/petitionStatus/{petitionStatus}")
	public String petitionStatus(PagingVO vo, Model model,
			@RequestParam(value = "nowPage", required = false) String nowPage,
			@RequestParam(value = "cntPerPage", required = false) String cntPerPage,
			@PathVariable("petitionStatus") int petitionStatus) throws Exception {
		int total = adminService.getPetitionStatusCount(petitionStatus);
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) {
			cntPerPage = "10";
		}

		vo = new PagingVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage), petitionStatus, 0, 0);
		model.addAttribute("paging", vo);

		List<PetitionDTO> list = adminService.getPetitionStatus(vo);
		model.addAttribute("petition", list);
		return "admin/petitionStatus";
	}

	/* -------------------------민원------------------------------- */
	// 민원 관리
	@GetMapping("/complaint")
	public String complaint(PagingVO vo, Model model, @RequestParam(value = "nowPage", required = false) String nowPage,
			@RequestParam(value = "cntPerPage", required = false) String cntPerPage) throws Exception {
		int total = adminService.getSearchComplaintCount(null, null, null, null, null);
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

		List<ComplaintDTO> list = adminService.getComplaintInfo(vo);
		model.addAttribute("complaint", list);

		return "admin/complaint";
	}

	// 각각의 민원 보기
	@GetMapping("/complaint/{complaintNo}")
	public String complaintDetail(Model model, @PathVariable("complaintNo") int complaintNo) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("complaintNo", complaintNo);

		ComplaintDTO complaint = adminService.getComplaint(map);
		model.addAttribute("complaint", complaint);

		List<AnswerCDTO> answerC = adminService.getAnswerC(complaintNo);
		model.addAttribute("answerC", answerC);
		return "admin/complaintDetail";
	}

	// 민원 답변 하기
	@GetMapping("/complaint/{complaintNo}/answer")
	public String answerCWriteForm(Model model, @PathVariable("complaintNo") int complaintNo) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("complaintNo", complaintNo);
		ComplaintDTO complaint = adminService.getComplaint(map);
		model.addAttribute("complaint", complaint);
		return "admin/answerCWrite";
	}

	// 민원 답변 하기
	@PostMapping("complaint/{complaintNo}/answer")
	public String answerCWrite(Model model, @ModelAttribute AnswerCDTO answerC,
			@PathVariable("complaintNo") int complaintNo) throws Exception {
		answerC.setComplaintNo(complaintNo);
		// answerC테이블에 insert
		adminService.answerCWrite(answerC);
		// 민원상태 1(답변완료)로 업데이트
		adminService.updateComplaintStatus1(complaintNo);
		model.addAttribute("complaintNo", complaintNo);

		return "/admin/answerCWriteSuccess";
	}

	// 민원 삭제 하기
	@GetMapping("/complaint/{complaintNo}/delete")
	public String complaintDeleteForm(Model model, @PathVariable("complaintNo") int complaintNo) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("complaintNo", complaintNo);
		ComplaintDTO complaint = adminService.getComplaint(map);
		model.addAttribute("complaint", complaint);
		return "/admin/complaintDelete";
	}

	// 민원 삭제 하기
	@PostMapping("complaint/{complaintNo}/delete")
	public String complaintDelete(@PathVariable("complaintNo") int complaintNo) throws Exception {
		adminService.updateComplaintStatus2(complaintNo);
		return "/admin/complaintDeleteSuccess";
	}

	// 민원 검색
	@GetMapping("/searchComplaint")
	public String complaintSearch(PagingVO vo, Model model,
			@RequestParam(value = "nowPage", required = false) String nowPage,
			@RequestParam(value = "cntPerPage", required = false) String cntPerPage,
			@RequestParam(value = "complaintTitle", required = false, defaultValue = "") String complaintTitle,
			@RequestParam(value = "complaintOrganization", required = false, defaultValue = "") String complaintOrganization,
			@RequestParam(value = "complaintOrganizationDetail", required = false, defaultValue = "") String complaintOrganizationDetail,
			@RequestParam(value = "complaintSdate", required = false, defaultValue = "") String complaintSdate,
			@RequestParam(value = "complaintEdate", required = false, defaultValue = "") String complaintEdate)
			throws Exception {

		int total = adminService.getSearchComplaintCount(complaintTitle, complaintOrganization,
				complaintOrganizationDetail, complaintSdate, complaintEdate);
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) {
			cntPerPage = "10";
		}

		vo = new PagingVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage), complaintTitle,
				complaintOrganization, complaintOrganizationDetail, complaintSdate, complaintEdate);
		model.addAttribute("paging", vo);

		List<ComplaintDTO> list = adminService.getSearchComplaintInfo(vo);
		model.addAttribute("complaint", list);

		return "admin/searchComplaint";
	}

	// 상태별 민원 보기
	@GetMapping("/complaintStatus/{complaintStatus}")
	public String complaintStatus(PagingVO vo, Model model,
			@RequestParam(value = "nowPage", required = false) String nowPage,
			@RequestParam(value = "cntPerPage", required = false) String cntPerPage,
			@PathVariable("complaintStatus") int complaintStatus) throws Exception {
		int total = adminService.getComplaintStatusCount(complaintStatus);
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) {
			cntPerPage = "10";
		}

		vo = new PagingVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage), 0, complaintStatus, 0);
		model.addAttribute("paging", vo);

		List<ComplaintDTO> list = adminService.getComplaintStatus(vo);
		model.addAttribute("complaint", list);
		return "admin/complaintStatus";
	}

	/* -------------------------제안------------------------------- */
	// 제안 목록
	@GetMapping("/suggestion")
	public String suggestion(PagingVO vo, Model model,
			@RequestParam(value = "nowPage", required = false) String nowPage,
			@RequestParam(value = "cntPerPage", required = false) String cntPerPage) throws Exception {
		int total = adminService.getSearchSuggestionCount(null, null, null);
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

		List<SuggestionDTO> list = adminService.getSuggestionInfo(vo);
		model.addAttribute("suggestion", list);

		return "admin/suggestion";
	}
	
	// 제안 검색
	@GetMapping("/searchSuggestion")
	public String suggestionSearch(PagingVO vo, Model model,
			@RequestParam(value = "nowPage", required = false) String nowPage,
			@RequestParam(value = "cntPerPage", required = false) String cntPerPage,
			@RequestParam(value = "suggestionTitle", required = false, defaultValue = "") String suggestionTitle,
			@RequestParam(value = "suggestionSdate", required = false, defaultValue = "") String suggestionSdate,
			@RequestParam(value = "suggestionEdate", required = false, defaultValue = "") String suggestionEdate)
			throws Exception {

		int total = adminService.getSearchSuggestionCount(suggestionTitle, suggestionSdate, suggestionEdate);
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
		
		List<SuggestionDTO> list = adminService.getSearchSuggestionInfo(vo);
		model.addAttribute("suggestion", list);
		

		return "admin/searchSuggestion";
	}
	
	// 각각의 제안 보기
	@GetMapping("/suggestion/{suggestionNo}")
	public String suggestionDetail(Model model, @PathVariable("suggestionNo") int suggestionNo, HttpServletRequest request)
			throws Exception {
		HttpSession session = request.getSession();
		String id = null;
		MemberDTO member = (MemberDTO) session.getAttribute("member");
		id = member.getId(); 

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("suggestionNo", suggestionNo);

		SuggestionDTO suggestion = adminService.getSuggestion(map);
		model.addAttribute("suggestion", suggestion);

		List<AnswerSDTO> answerS = adminService.getAnswerS(suggestionNo);
		model.addAttribute("answerS", answerS);
		
		List<CommentSDTO> commentS = adminService.getCommentS(suggestionNo);
		model.addAttribute("commentS", commentS);

		return "admin/suggestionDetail";
	}

	// 제안 답변 하기
	@GetMapping("/suggestion/{suggestionNo}/answer")
	public String answerSWriteForm(Model model, @PathVariable("suggestionNo") int suggestionNo) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("suggestionNo", suggestionNo);
		SuggestionDTO suggestion = adminService.getSuggestion(map);
		model.addAttribute("suggestion", suggestion);
		return "admin/answerSWrite";
	}

	// 제안 답변 하기
	@PostMapping("suggestion/{suggestionNo}/answer")
	public String answerSWrite(Model model, @ModelAttribute AnswerSDTO answerS,
			@PathVariable("suggestionNo") int suggestionNo) throws Exception {
		answerS.setSuggestionNo(suggestionNo);
		// answerC테이블에 insert
		adminService.answerSWrite(answerS);
		// 제안상태 1(답변완료)로 업데이트
		adminService.updateSuggestionStatus1(suggestionNo);
		model.addAttribute("suggestionNo", suggestionNo);

		return "/admin/answerSWriteSuccess";
	}

	// 제안 삭제 하기
	@GetMapping("/suggestion/{suggestionNo}/delete")
	public String suggestionDeleteForm(Model model, @PathVariable("suggestionNo") int suggestionNo) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("suggestionNo", suggestionNo);
		SuggestionDTO suggestion = adminService.getSuggestion(map);
		model.addAttribute("suggestion", suggestion);
		return "/admin/suggestionDelete";
	}

	// 제안 삭제 하기
	@PostMapping("suggestion/{suggestionNo}/delete")
	public String suggestionDelete(@PathVariable("suggestionNo") int suggestionNo) throws Exception {
		adminService.updateSuggestionStatus2(suggestionNo);
		return "/admin/suggestionDeleteSuccess";
	}
	
	// 상태별 제안 보기
	@GetMapping("/suggestionStatus/{suggestionStatus}")
	public String suggestionStatus(PagingVO vo, Model model,
			@RequestParam(value = "nowPage", required = false) String nowPage,
			@RequestParam(value = "cntPerPage", required = false) String cntPerPage,
			@PathVariable("suggestionStatus") int suggestionStatus) throws Exception {
		int total = adminService.getSuggestionStatusCount(suggestionStatus);
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) {
			cntPerPage = "10";
		}

		vo = new PagingVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage), 0, 0, suggestionStatus);
		model.addAttribute("paging", vo);

		List<SuggestionDTO> list = adminService.getSuggestionStatus(vo);
		model.addAttribute("suggestion", list);
		return "admin/suggestionStatus";
	}
}
