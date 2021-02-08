package com.itcen.tellcen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itcen.tellcen.domain.ComplaintDTO;
import com.itcen.tellcen.domain.PetitionDTO;
import com.itcen.tellcen.repository.ComplaintDAO;

@Service
public class ComplaintService {

	@Autowired
	private ComplaintDAO complaintDao;

	// 청원 작성
	public void complaintWrite(ComplaintDTO complaint) {
		complaintDao.complaintWrite(complaint);
	}
	

	

}
