package com.itcen.tellcen.service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itcen.tellcen.domain.AnswerPDTO;
import com.itcen.tellcen.domain.CommentPDTO;
import com.itcen.tellcen.domain.MemberDTO;
import com.itcen.tellcen.domain.PetitionDTO;
import com.itcen.tellcen.repository.AdminDAO;
import com.itcen.tellcen.util.PagingVO;

@Service
public class AdminService {

	@Autowired
	private AdminDAO adminDao;

	// 미해결 청원 / 민원 / 제안 / 문의 카운트
	public int getPetitionCount() throws Exception {
		return adminDao.getPetitionCount();
	}
	public int getComplaintCount() throws Exception {
		return adminDao.getComplaintCount();
	}
	public int getSuggestionCount() throws Exception {
		return adminDao.getSuggestionCount();
	}
	public int getInquiryCount() throws Exception {
		return adminDao.getInquiryCount();
	}
	
	// 회원 목록
	public List<MemberDTO> getMemberInfo(PagingVO vo) {
		return adminDao.getMemberInfo(vo);
	}

	// 카운트
	public int getMemberCount(String word) throws Exception {
		return adminDao.getMemberCount(word);
	}
	
	// 회원 검색
	public List<MemberDTO> getSearchMemberInfo(PagingVO vo) {
		return adminDao.getSearchMemberInfo(vo);
	}
	
	// 검색 카운트
	public int getSearchPetitionCount(String petitionTitle, String petitionArea, String petitionField) throws Exception {
		return adminDao.getSearchPetitionCount(petitionTitle, petitionArea, petitionField);
	}

	// 청원 목록
	public List<PetitionDTO> getPetitionInfo(PagingVO vo) {
		return adminDao.getPetitionInfo(vo);
	}
	
	// 청원 검색
	public List<PetitionDTO> getSearchPetitionInfo(PagingVO vo) {
		return adminDao.getSearchPetitionInfo(vo);
	}

	// 각각의 청원 보기
	public PetitionDTO getArticle(Map<String, Object> map) throws Exception {
		return adminDao.getArticle(map);
	}

	// 각각의 청원 보기(댓글-동의)
	public List<CommentPDTO> getCommentP(int petitionNo) throws Exception {
		return adminDao.getCommentP(petitionNo);
	}
	
	// 각각의 청원 보기(답변)
	public List<AnswerPDTO> getAnswerP(int petitionNo) throws Exception {
		return adminDao.getAnswerP(petitionNo);
	}
	
	// 청원 답변 작성
	public void answerPWrite(AnswerPDTO answerP) {
		adminDao.answerPWrite(answerP);
	}
	public void updateStatus(int petitionNo) {
		adminDao.updateStatus(petitionNo);
	}
}
