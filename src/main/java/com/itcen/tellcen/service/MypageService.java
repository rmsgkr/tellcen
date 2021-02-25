package com.itcen.tellcen.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itcen.tellcen.domain.AnswerCDTO;
import com.itcen.tellcen.domain.AnswerIDTO;
import com.itcen.tellcen.domain.AnswerPDTO;
import com.itcen.tellcen.domain.AnswerSDTO;
import com.itcen.tellcen.domain.CommentPDTO;
import com.itcen.tellcen.domain.CommentSDTO;
import com.itcen.tellcen.domain.ComplaintDTO;
import com.itcen.tellcen.domain.InquiryDTO;
import com.itcen.tellcen.domain.MemberDTO;
import com.itcen.tellcen.domain.PetitionDTO;
import com.itcen.tellcen.domain.SuggestionDTO;
import com.itcen.tellcen.repository.InquiryDAO;
import com.itcen.tellcen.repository.MypageDAO;
import com.itcen.tellcen.util.PagingVO;



@Service
public class MypageService {

	@Autowired
	private MypageDAO mypageDao;


	// 나의 청원 / 민원 / 제안 / 문의 카운트
	public int getMyPetitionCount(String id) throws Exception {
		return mypageDao.getMyPetitionCount(id);
	}
	public int getMyComplaintCount(String id) throws Exception {
		return mypageDao.getMyComplaintCount(id);
	}
	public int getMySuggestionCount(String id) throws Exception {
		return mypageDao.getMySuggestionCount(id);
	}
	public int getMyInquiryCount(String id) throws Exception {
		return mypageDao.getMyInquiryCount(id);
	}
	
	// 청원 카운트
	public int getPetitionCount(String id) throws Exception {
		return mypageDao.getPetitionCount(id);
	}
	
	// 청원 목록
	public List<PetitionDTO> getPetitionInfo(PagingVO vo) {
		return mypageDao.getPetitionInfo(vo);
	}

	// 각각의 청원 보기
	public PetitionDTO getPetition(Map<String, Object> map) throws Exception {
		return mypageDao.getPetition(map);
	}
	
	// 각각의 청원 보기(답변)
	public List<AnswerPDTO> getAnswerP(int petitionNo) throws Exception {
		return mypageDao.getAnswerP(petitionNo);
	}
	
	// 각각의 청원 보기(댓글)
	public List<CommentPDTO> getCommentP(int petitionNo) throws Exception {
		return mypageDao.getCommentP(petitionNo);
	}
	
	// 민원 카운트
	public int getComplaintCount(String id) throws Exception {
		return mypageDao.getComplaintCount(id);
	}
	
	// 민원 목록
	public List<ComplaintDTO> getComplaintInfo(PagingVO vo) {
		return mypageDao.getComplaintInfo(vo);
	}

	// 각각의 민원 보기
	public ComplaintDTO getComplaint(Map<String, Object> map) throws Exception {
		return mypageDao.getComplaint(map);
	}
	
	// 각각의 민원 보기(답변)
	public List<AnswerCDTO> getAnswerC(int complaintNo) throws Exception {
		return mypageDao.getAnswerC(complaintNo);
	}
	
	// 제안 카운트
	public int getSuggestionCount(String id) throws Exception {
		return mypageDao.getSuggestionCount(id);
	}
	
	// 제안 목록
	public List<SuggestionDTO> getSuggestionInfo(PagingVO vo) {
		return mypageDao.getSuggestionInfo(vo);
	}

	// 각각의 제안 보기
	public SuggestionDTO getSuggestion(Map<String, Object> map) throws Exception {
		return mypageDao.getSuggestion(map);
	}
	
	// 각각의 제안 보기(답변)
	public List<AnswerSDTO> getAnswerS(int suggestionNo) throws Exception {
		return mypageDao.getAnswerS(suggestionNo);
	}
	
	// 각각의 제안 보기(댓글)
	public List<CommentSDTO> getCommentS(int suggestionNo) throws Exception {
		return mypageDao.getCommentS(suggestionNo);
	}
	
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
	
	// 사용자 정보
	public MemberDTO getMemberInfo(String id) {
		return mypageDao.getMemberInfo(id);
	}

	// 회원 정보 수정(이메일,전화번호,주소)
	public int modifyMember(MemberDTO member) {
		return mypageDao.modifyMember(member);
	}
	
	// 비밀번호 찾기
	public String getMemberPwd(String pwd) {
		return mypageDao.getMemberPwd(pwd);
	}
	

	// 회원 탈퇴
	public void deleteMember(String id) {
		mypageDao.deleteMember(id);
	}

}
