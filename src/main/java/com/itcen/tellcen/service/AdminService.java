package com.itcen.tellcen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itcen.tellcen.domain.MemberDTO;
import com.itcen.tellcen.repository.AdminDAO;
import com.itcen.tellcen.util.PagingVO;

@Service
public class AdminService {

	@Autowired
	private AdminDAO adminDao;

	// ADMIN
	public List<MemberDTO> getFullInfo(PagingVO vo) {
		return adminDao.getFullInfo(vo);
	}

	public int countMember() {
		return adminDao.countMember();
	}

	public List<MemberDTO> getDelInfo(PagingVO vo) {
		return adminDao.getDelInfo(vo);
	}

	public int countDelMember() {
		return adminDao.countDelMember();
	}

	public int checkId(String id) {
		return adminDao.checkId(id);
	}

}
