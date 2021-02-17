package com.itcen.tellcen.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itcen.tellcen.domain.InquiryDTO;
import com.itcen.tellcen.repository.InquiryDAO;



@Service
public class InquiryService {

	@Autowired
	private InquiryDAO inquiryDao;

	public void inquiryWrite(InquiryDTO inquiry) {
		inquiryDao.inquiryWrite(inquiry);
	}
}
