package com.itcen.tellcen.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.itcen.tellcen.domain.MemberDTO;
import com.itcen.tellcen.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminService adminService;

	@GetMapping("")
	public String index() {
		return "admin/admin";
	}

	@GetMapping("/member")
	public String member(PagingVO vo, Model model, 
			@RequestParam(value = "nowPage", required = false) String nowPage,
			@RequestParam(value = "cntPerPage", required = false) String cntPerPage) throws ParseException {
		int total = adminService.countMember();
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

		List<MemberDTO> list = adminService.getFullInfo(vo);
		model.addAttribute("infoList", list);
		return "admin/member";
	}

	// 탈퇴 회원 보기
	@GetMapping("/member/delete")
	public String memberDelList(PagingVO vo, Model model,
			@RequestParam(value = "nowPage", required = false) String nowPage,
			@RequestParam(value = "cntPerPage", required = false) String cntPerPage) {
		int total = adminService.countDelMember();
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

		List<MemberDTO> list = adminService.getDelInfo(vo);
		model.addAttribute("infoList", list);

		return "admin/memberDelete";
	}
	
	/*
	 * // 회원별 활동내역 보기
	 * 
	 * @GetMapping("/member/{id}") public String member(Model
	 * model, @PathVariable("id") String id) { List<OrdersDTO> list =
	 * orderService.memberOrderlist(id); int sum = orderService.memberSum(id); Date
	 * date = orderService.memberLastest(id);
	 * 
	 * model.addAttribute("list", list); model.addAttribute("id", id);
	 * model.addAttribute("sum", sum); model.addAttribute("date", date); return
	 * "admin/memberOrder"; }
	 */

}
