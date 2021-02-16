package com.itcen.tellcen.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itcen.tellcen.domain.AnswerCDTO;
import com.itcen.tellcen.domain.AnswerPDTO;
import com.itcen.tellcen.domain.ComplaintDTO;
import com.itcen.tellcen.domain.PetitionDTO;
import com.itcen.tellcen.repository.ComplaintDAO;
import com.itcen.tellcen.util.PagingVO;

@Service
public class ComplaintService {

	@Autowired
	private ComplaintDAO complaintDao;

	// 민원 작성
	public void complaintWrite(ComplaintDTO complaint) {
		complaintDao.complaintWrite(complaint);
	}
	
	// 카운트
	public int getArticleCount(String complaintTitle, String complaintOrganization, String complaintOrganizationDetail, String complaintSdate, String complaintEdate) throws Exception {
		return complaintDao.getArticleCount(complaintTitle, complaintOrganization, complaintOrganizationDetail, complaintSdate, complaintEdate);
	}

	// 민원 목록
	public List<ComplaintDTO> getComplaintInfo(PagingVO vo) {
		return complaintDao.getComplaintInfo(vo);
	}
	
	// 각각의 민원 보기
	public ComplaintDTO getArticle(Map<String, Object> map) throws Exception {
		return complaintDao.getArticle(map);
	}
	
	// 각각의 민원 보기(답변)
	public List<AnswerCDTO> getAnswerC(int complaintNo) throws Exception {
		return complaintDao.getAnswerC(complaintNo);
	}
	
	// 민원 검색
	public List<ComplaintDTO> getSearchInfo(PagingVO vo) {
		return complaintDao.getSearchInfo(vo);
	}

}
