package com.itcen.tellcen.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itcen.tellcen.domain.MemberDTO;
import com.itcen.tellcen.domain.PetitionDTO;
import com.itcen.tellcen.service.PetitionService;
import com.itcen.tellcen.util.PagingVO;

@Controller
@RequestMapping("/petition")
public class PetitionController {
	
	@Autowired
	PetitionService petitionService;
	
	// 청원 목록
	@GetMapping("/petitionList")
	public String notice(PagingVO vo, Model model, @RequestParam(value = "nowPage", required = false) String nowPage,
			@RequestParam(value = "cntPerPage", required = false) String cntPerPage) throws Exception {
		int total = petitionService.getArticleCount(null, null);
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
		System.out.println(petition);
		petitionService.petitionWrite(petition);
		return "redirect:/";
	}
}
