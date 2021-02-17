package com.itcen.tellcen.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itcen.tellcen.domain.AnswerCDTO;
import com.itcen.tellcen.domain.AnswerIDTO;
import com.itcen.tellcen.domain.ComplaintDTO;
import com.itcen.tellcen.domain.InquiryDTO;
import com.itcen.tellcen.domain.MemberDTO;
import com.itcen.tellcen.repository.InquiryDAO;
import com.itcen.tellcen.repository.MypageDAO;
import com.itcen.tellcen.util.PagingVO;



@Service
public class MypageService {

	@Autowired
	private MypageDAO mypageDao;

	// 문의 카운트
	public int getInquiryCount(String id) throws Exception {
		return mypageDao.getInquiryCount(id);
	}
	
	// 문의 목록
	public List<InquiryDTO> getInquiryInfo(PagingVO vo) {
		return mypageDao.getInquiryInfo(vo);
	}

	// 각각의 문의 보기
	public InquiryDTO getInquiry(Map<String, Object> map) throws Exception {
		return mypageDao.getInquiry(map);
	}
	
	// 각각의 문의 보기(답변)
	public List<AnswerIDTO> getAnswerI(int inquiryNo) throws Exception {
		return mypageDao.getAnswerI(inquiryNo);
	}
	
}
