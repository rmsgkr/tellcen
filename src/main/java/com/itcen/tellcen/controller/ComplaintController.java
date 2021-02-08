package com.itcen.tellcen.controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itcen.tellcen.domain.ComplaintDTO;
import com.itcen.tellcen.domain.MemberDTO;
import com.itcen.tellcen.domain.PetitionDTO;
import com.itcen.tellcen.service.ComplaintService;
import com.itcen.tellcen.service.PetitionService;

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
}
