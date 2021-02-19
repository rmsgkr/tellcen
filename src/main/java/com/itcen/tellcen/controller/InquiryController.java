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

import com.itcen.tellcen.domain.InquiryDTO;
import com.itcen.tellcen.domain.MemberDTO;
import com.itcen.tellcen.service.InquiryService;



@Controller
@RequestMapping("/inquiry")
public class InquiryController {

	@Autowired
	InquiryService inquiryService;
	
	@GetMapping("/inquiryWrite")
	public String inquiryWriteForm() {
		return "inquiry/inquiryWrite";
	}
	@PostMapping("/inquiryWrite")
	public String inquiryWrite(MultipartHttpServletRequest mulRequest, @ModelAttribute InquiryDTO inquiry, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		String id = null;
		try {
			MemberDTO member = (MemberDTO) session.getAttribute("member");
			id = member.getId();
			inquiry.setId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		MultipartFile file = mulRequest.getFile("file");
		if (!file.isEmpty()) {
			String filename = file.getOriginalFilename();
			String uploadFolder = mulRequest.getServletContext().getRealPath("/resources/upload");
			inquiry.setInquiryFile(filename);
			File saveFile = new File(uploadFolder, filename);
			System.out.println(uploadFolder);
			try {
				file.transferTo(saveFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		inquiryService.inquiryWrite(inquiry);
		
		return "inquiry/inquirySuccess";
	}
	
	@GetMapping("/inquiryQuestion")
	public String inquiryQuestionForm() {
		return "inquiry/inquiryQuestion";
	}

}
