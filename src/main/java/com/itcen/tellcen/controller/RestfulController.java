package com.itcen.tellcen.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itcen.tellcen.domain.TopicInfoDTO;
import com.itcen.tellcen.service.RestFulService;

@Controller
@RequestMapping("/today")
public class RestfulController {
	@Autowired RestFulService restFulService; 
	
	// 오늘의 이슈
	@GetMapping("/topicInfo")
	public String topicInfo(Model model) throws IOException {
		
		List<TopicInfoDTO> list = restFulService.getTopicInfo();
		model.addAttribute("topicInfo", list);
		
		return "today/topicInfo";
	}
}
