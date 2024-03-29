package com.itcen.tellcen.service;

import java.sql.Timestamp;
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
import com.itcen.tellcen.domain.NoticeDTO;
import com.itcen.tellcen.domain.PetitionDTO;
import com.itcen.tellcen.domain.SuggestionDTO;
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
	
	// 청원 검색 카운트
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
	public PetitionDTO getPetition(Map<String, Object> map) throws Exception {
		return adminDao.getPetition(map);
	}

	// 각각의 청원 보기(댓글-동의)
	public List<CommentPDTO> getCommentP(int petitionNo) throws Exception {
		return adminDao.getCommentP(petitionNo);
	}
	
	// 각각의 청원 보기(답변)
	public List<AnswerPDTO> getAnswerP(int petitionNo) throws Exception {
		return adminDao.getAnswerP(petitionNo);
	}
	
	// 청원 마감
	public void updatePetitionStatus1(int petitionNo) {
		adminDao.updatePetitionStatus1(petitionNo);
	}
	
	// 청원 답변 작성
	public void answerPWrite(AnswerPDTO answerP) {
		adminDao.answerPWrite(answerP);
	}
	public void updatePetitionStatus2(int petitionNo) {
		adminDao.updatePetitionStatus2(petitionNo);
	}
	
	// 청원 삭제
	public void updatePetitionStatus3(int petitionNo) {
		adminDao.updatePetitionStatus3(petitionNo);
	}
	
	// 청원 상태별 카운트
	public int getPetitionStatusCount(int petitionStatus) throws Exception {
		return adminDao.getPetitionStatusCount(petitionStatus);
	}
	
	// 청원 상태별 리스트
	public List<PetitionDTO> getPetitionStatus(PagingVO vo) {
		return adminDao.getPetitionStatus(vo);
	}
	
	// 민원 검색 카운트
	public int getSearchComplaintCount(String complaintTitle, String complaintOrganization, String complaintOrganizationDetail, String complaintSdate, String complaintEdate) throws Exception {
		return adminDao.getSearchComplaintCount(complaintTitle, complaintOrganization, complaintOrganizationDetail, complaintSdate, complaintEdate);
	}
	
	// 민원 목록
	public List<ComplaintDTO> getComplaintInfo(PagingVO vo) {
		return adminDao.getComplaintInfo(vo);
	}
	
	// 각각의 민원 보기
	public ComplaintDTO getComplaint(Map<String, Object> map) throws Exception {
		return adminDao.getComplaint(map);
	}
	
	// 각각의 민원 보기(답변)
	public List<AnswerCDTO> getAnswerC(int complaintNo) throws Exception {
		return adminDao.getAnswerC(complaintNo);
	}
	
	// 민원 답변 작성
	public void answerCWrite(AnswerCDTO answerC) {
		adminDao.answerCWrite(answerC);
	}
	public void updateComplaintStatus1(int complaintNo) {
		adminDao.updateComplaintStatus1(complaintNo);
	}
	
	// 민원 삭제
	public void updateComplaintStatus2(int complaintNo) {
		adminDao.updateComplaintStatus2(complaintNo);
	}
	
	// 민원 검색
	public List<ComplaintDTO> getSearchComplaintInfo(PagingVO vo) {
		return adminDao.getSearchComplaintInfo(vo);
	}
	
	// 민원 상태별 카운트
	public int getComplaintStatusCount(int complaintStatus) throws Exception {
		return adminDao.getComplaintStatusCount(complaintStatus);
	}
	// 민원 상태별 리스트
	public List<ComplaintDTO> getComplaintStatus(PagingVO vo) {
		return adminDao.getComplaintStatus(vo);
	}
	
	// 카운트
	public int getSearchSuggestionCount(String suggestionTitle, String suggestionSdate, String suggestionEdate) throws Exception {
		return adminDao.getSearchSuggestionCount(suggestionTitle, suggestionSdate, suggestionEdate);
	}

	// 제안 목록
	public List<SuggestionDTO> getSuggestionInfo(PagingVO vo) {
		return adminDao.getSuggestionInfo(vo);
	}
	
	// 제안 검색
	public List<SuggestionDTO> getSearchSuggestionInfo(PagingVO vo) {
		return adminDao.getSearchSuggestionInfo(vo);
	}
	
	// 각각의 제안 보기
	public SuggestionDTO getSuggestion(Map<String, Object> map) throws Exception {
		return adminDao.getSuggestion(map);
	}

	// 각각의 제안 보기(댓글)
	public List<CommentSDTO> getCommentS(int suggestionNo) throws Exception {
		return adminDao.getCommentS(suggestionNo);
	}
	
	// 각각의 제안 보기(답변)
	public List<AnswerSDTO> getAnswerS(int suggestionNo) throws Exception {
		return adminDao.getAnswerS(suggestionNo);
	}
	
	// 제안 답변 작성
	public void answerSWrite(AnswerSDTO answerS) {
		adminDao.answerSWrite(answerS);
	}
	public void updateSuggestionStatus1(int suggestionNo) {
		adminDao.updateSuggestionStatus1(suggestionNo);
	}
	
	// 제안 삭제
	public void updateSuggestionStatus2(int suggestionNo) {
		adminDao.updateSuggestionStatus2(suggestionNo);
	}
	
	// 제안 상태별 카운트
	public int getSuggestionStatusCount(int suggestionStatus) throws Exception {
		return adminDao.getSuggestionStatusCount(suggestionStatus);
	}
	// 제안 상태별 리스트
	public List<SuggestionDTO> getSuggestionStatus(PagingVO vo) {
		return adminDao.getSuggestionStatus(vo);
	}
	
	
	// 문의 카운트
	public int getAllInquiryCount() throws Exception {
		return adminDao.getAllInquiryCount();
	}
	
	// 문의 목록
	public List<InquiryDTO> getInquiryInfo(PagingVO vo) {
		return adminDao.getInquiryInfo(vo);
	}

	// 각각의 문의 보기
	public InquiryDTO getInquiry(Map<String, Object> map) throws Exception {
		return adminDao.getInquiry(map);
	}
	
	// 각각의 문의 보기(답변)
	public List<AnswerIDTO> getAnswerI(int inquiryNo) throws Exception {
		return adminDao.getAnswerI(inquiryNo);
	}
	
	// 문의 답변 작성
	public void answerIWrite(AnswerIDTO answerI) {
		adminDao.answerIWrite(answerI);
	}
	public void updateInquiryStatus1(int inquiryNo) {
		adminDao.updateInquiryStatus1(inquiryNo);
	}
	
	// 문의 삭제
	public void updateInquiryStatus2(int inquiryNo) {
		adminDao.updateInquiryStatus2(inquiryNo);
	}
	
	// 문의 상태별 카운트
	public int getInquiryStatusCount(int inquiryStatus) throws Exception {
		return adminDao.getInquiryStatusCount(inquiryStatus);
	}
	// 문의 상태별 리스트
	public List<InquiryDTO> getInquiryStatus(PagingVO vo) {
		return adminDao.getInquiryStatus(vo);
	}
	
	
	// 공지 카운트
	public int getNoticeCount(String suggestionTitle) throws Exception {
		return adminDao.getNoticeCount(suggestionTitle);
	}

	// 공지 목록
	public List<NoticeDTO> getNoticeInfo(PagingVO vo) {
		return adminDao.getNoticeInfo(vo);
	}
	
	// 공지 검색
	public List<NoticeDTO> getSearchNoticeInfo(PagingVO vo) {
		return adminDao.getSearchNoticeInfo(vo);
	}
	
	// 각각의 공지 보기
	public NoticeDTO getNotice(Map<String, Object> map) throws Exception {
		return adminDao.getNotice(map);
	}
	
	// 공지 등록
	public void noticeWrite(NoticeDTO notice) {
		adminDao.noticeWrite(notice);
	}

	// 공지 수정
	public void noticeModify(NoticeDTO notice) {
		adminDao.noticeModify(notice);
	}

	// 공지 삭제
	public void noticeDelete(int noticeNo) {
		adminDao.noticeDelete(noticeNo);
	}
}
