package com.itcen.tellcen.repository;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

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
import com.itcen.tellcen.util.PagingVO;

@Repository
public class AdminDAO extends AbstractMybatisDAO {
	private String namespace = "adminMapper";

	// 미해결 청원 / 민원 / 제안 / 문의 카운트
	public int getPetitionCount() throws Exception {

		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			return sqlSession.selectOne(namespace + ".getPetitionCount");
		} finally {
			sqlSession.close();
		}
	}
	public int getComplaintCount() throws Exception {

		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			return sqlSession.selectOne(namespace + ".getComplaintCount");
		} finally {
			sqlSession.close();
		}
	}
	public int getSuggestionCount() throws Exception {

		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			return sqlSession.selectOne(namespace + ".getSuggestionCount");
		} finally {
			sqlSession.close();
		}
	}
	public int getInquiryCount() throws Exception {

		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			return sqlSession.selectOne(namespace + ".getInquiryCount");
		} finally {
			sqlSession.close();
		}
	}
	
	// 카운트
	public int getMemberCount(String id) throws Exception {

		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("id", id);

			return sqlSession.selectOne(namespace + ".getMemberCount", map);
		} finally {
			sqlSession.close();
		}
	}
		
	// 회원 목록
	public List<MemberDTO> getMemberInfo(PagingVO vo) {
		SqlSession sqlsession =

				getSqlSessionFactory().openSession();
		try {
			return sqlsession.selectList(namespace + ".getMemberInfo", vo);
		} finally {
			sqlsession.close();
		}
	}

	// 회원 검색
	public List<MemberDTO> getSearchMemberInfo(PagingVO vo) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			return sqlSession.selectList(namespace + ".getSearchMemberInfo", vo);
		} finally {
			sqlSession.close();
		}
	}

	// 청원 카운트
	public int getSearchPetitionCount(String petitionTitle, String petitionArea, String petitionField) throws Exception {

		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("petitionTitle", petitionTitle);
			map.put("petitionArea", petitionArea);
			map.put("petitionField", petitionField);

			return sqlSession.selectOne(namespace + ".getSearchPetitionCount", map);
		} finally {
			sqlSession.close();
		}
	}

	// 청원 목록
	public List<PetitionDTO> getPetitionInfo(PagingVO vo) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			return sqlSession.selectList(namespace + ".getPetitionInfo", vo);
		} finally {
			sqlSession.close();
		}
	}
	
	// 청원 검색
	public List<PetitionDTO> getSearchPetitionInfo(PagingVO vo) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			return sqlSession.selectList(namespace + ".getSearchPetitionInfo", vo);
		} finally {
			sqlSession.close();
		}
	}
	
	// 각각의 청원 보기
	public PetitionDTO getPetition(Map<String, Object> map) throws Exception {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		PetitionDTO article = new PetitionDTO();
		try {
			article = (PetitionDTO) sqlSession.selectOne(namespace + ".getPetition", map);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
		return article;
	}

	// 각각의 청원 보기(댓글-동의)
	public List<CommentPDTO> getCommentP(int petitionNo) throws Exception {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			return sqlSession.selectList(namespace + ".getCommentP", petitionNo);
		} finally {
			sqlSession.close();
		}
	}
	
	// 각각의 청원 보기(답변)
	public List<AnswerPDTO> getAnswerP(int petitionNo) throws Exception {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			return sqlSession.selectList(namespace + ".getAnswerP", petitionNo);
		} finally {
			sqlSession.close();
		}
	}
	
	
	// 청원 마감
	public void updatePetitionStatus1(int petitionNo) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int result = 0;
		try {
			result = sqlSession.update(namespace + ".updatePetitionStatus1", petitionNo);
			if (result != 0) {
				sqlSession.commit();
			}
		} finally {
			sqlSession.close();
		}
	}
	
	// 청원 댓글(동의) 작성
	public void answerPWrite(AnswerPDTO answerP) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int result = 0;
		try {
			result = sqlSession.insert(namespace + ".answerPWrite", answerP);
			if (result != 0) {
				sqlSession.commit();
			}
		} finally {
			sqlSession.close();
		}
	}
	public void updatePetitionStatus2(int petitionNo) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int result = 0;
		try {
			result = sqlSession.update(namespace + ".updatePetitionStatus2", petitionNo);
			if (result != 0) {
				sqlSession.commit();
			}
		} finally {
			sqlSession.close();
		}
	}
	
	// 청원 삭제
	public void updatePetitionStatus3(int petitionNo) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int result = 0;
		try {
			result = sqlSession.update(namespace + ".updatePetitionStatus3", petitionNo);
			if (result != 0) {
				sqlSession.commit();
			}
		} finally {
			sqlSession.close();
		}
	}
	
	// 청원 상태별 카운트
	public int getPetitionStatusCount(int petitionStatus) throws Exception {

		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("petitionStatus", petitionStatus);

			return sqlSession.selectOne(namespace + ".getPetitionStatusCount", map);
		} finally {
			sqlSession.close();
		}
	}
	
	// 청원 상태별 리스트
	public List<PetitionDTO> getPetitionStatus(PagingVO vo) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			return sqlSession.selectList(namespace + ".getPetitionStatus", vo);
		} finally {
			sqlSession.close();
		}
	}
	
	// 민원 카운트
	public int getSearchComplaintCount(String complaintTitle, String complaintOrganization, String complaintOrganizationDetail, String complaintSdate, String complaintEdate) throws Exception {

		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("complaintTitle", complaintTitle);
			map.put("complaintOrganization", complaintOrganization);
			map.put("complaintOrganizationDetail", complaintOrganizationDetail);
			map.put("complaintSdate",complaintSdate);
			map.put("complaintEdate",complaintEdate);
			return sqlSession.selectOne(namespace + ".getSearchComplaintCount", map);
		} finally {
			sqlSession.close();
		}
	}
	
	// 민원 목록
	public List<ComplaintDTO> getComplaintInfo(PagingVO vo) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			return sqlSession.selectList(namespace + ".getComplaintInfo", vo);
		} finally {
			sqlSession.close();
		}
	}
	
	// 각각의 민원 보기
	public ComplaintDTO getComplaint(Map<String, Object> map) throws Exception {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		ComplaintDTO article = new ComplaintDTO();
		try {
			article = (ComplaintDTO) sqlSession.selectOne(namespace + ".getComplaint", map);
			// 조회수 증가
			/* sqlSession.update(namespace + ".addReadCount", map); */
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
		return article;
	}
	
	// 각각의 민원 보기(답변)
	public List<AnswerCDTO> getAnswerC(int complaintNo) throws Exception {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			return sqlSession.selectList(namespace + ".getAnswerC", complaintNo);
		} finally {
			sqlSession.close();
		}
	}
	
	// 민원 답변 작성
	public void answerCWrite(AnswerCDTO answerC) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int result = 0;
		try {
			result = sqlSession.insert(namespace + ".answerCWrite", answerC);
			if (result != 0) {
				sqlSession.commit();
			}
		} finally {
			sqlSession.close();
		}
	}
	public void updateComplaintStatus1(int complaintNo) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int result = 0;
		try {
			result = sqlSession.update(namespace + ".updateComplaintStatus1", complaintNo);
			if (result != 0) {
				sqlSession.commit();
			}
		} finally {
			sqlSession.close();
		}
	}
	
	// 민원 삭제
	public void updateComplaintStatus2(int complaintNo) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int result = 0;
		try {
			result = sqlSession.update(namespace + ".updateComplaintStatus2", complaintNo);
			if (result != 0) {
				sqlSession.commit();
			}
		} finally {
			sqlSession.close();
		}
	}
	
	// 민원 검색
	public List<ComplaintDTO> getSearchComplaintInfo(PagingVO vo) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			return sqlSession.selectList(namespace + ".getSearchComplaintInfo", vo);
		} finally {
			sqlSession.close();
		}
	}
	
	// 민원 상태별 카운트
	public int getComplaintStatusCount(int complaintStatus) throws Exception {

		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("complaintStatus", complaintStatus);

			return sqlSession.selectOne(namespace + ".getComplaintStatusCount", map);
		} finally {
			sqlSession.close();
		}
	}
	
	// 민원 상태별 리스트
	public List<ComplaintDTO> getComplaintStatus(PagingVO vo) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			return sqlSession.selectList(namespace + ".getComplaintStatus", vo);
		} finally {
			sqlSession.close();
		}
	}
	
	// 카운트
	public int getSearchSuggestionCount(String suggestionTitle, String suggestionSdate, String suggestionEdate) throws Exception {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("suggestionTitle", suggestionTitle);
			map.put("suggestionSdate", suggestionSdate);
			map.put("suggestionEdate", suggestionEdate);
			return sqlSession.selectOne(namespace + ".getSearchSuggestionCount", map);
		} finally {
			sqlSession.close();
		}
	}

	// 제안 목록
	public List<SuggestionDTO> getSuggestionInfo(PagingVO vo) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			return sqlSession.selectList(namespace + ".getSuggestionInfo", vo);
		} finally {
			sqlSession.close();
		}
	}	
	
	// 제안 검색
	public List<SuggestionDTO> getSearchSuggestionInfo(PagingVO vo) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			return sqlSession.selectList(namespace + ".getSearchSuggestionInfo", vo);
		} finally {
			sqlSession.close();
		}
	}
	
	// 각각의 제안 보기
	public SuggestionDTO getSuggestion(Map<String, Object> map) throws Exception {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		SuggestionDTO article = new SuggestionDTO();
		try {
			article = (SuggestionDTO) sqlSession.selectOne(namespace + ".getSuggestion", map);
			// 조회수 증가
			/* sqlSession.update(namespace + ".addReadCount", map); */
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
		return article;
	}

	// 각각의 제안 보기(댓글-동의)
	public List<CommentSDTO> getCommentS(int suggestionNo) throws Exception {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			return sqlSession.selectList(namespace + ".getCommentS", suggestionNo);
		} finally {
			sqlSession.close();
		}
	}
	
	// 각각의 제안 보기(답변)
	public List<AnswerSDTO> getAnswerS(int suggestionNo) throws Exception {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			return sqlSession.selectList(namespace + ".getAnswerS", suggestionNo);
		} finally {
			sqlSession.close();
		}
	}

	// 제안 답변 작성
	public void answerSWrite(AnswerSDTO answerS) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int result = 0;
		try {
			result = sqlSession.insert(namespace + ".answerSWrite", answerS);
			if (result != 0) {
				sqlSession.commit();
			}
		} finally {
			sqlSession.close();
		}
	}
	public void updateSuggestionStatus1(int suggestionNo) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int result = 0;
		try {
			result = sqlSession.update(namespace + ".updateSuggestionStatus1", suggestionNo);
			if (result != 0) {
				sqlSession.commit();
			}
		} finally {
			sqlSession.close();
		}
	}
	
	// 제안 삭제
	public void updateSuggestionStatus2(int suggestionNo) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int result = 0;
		try {
			result = sqlSession.update(namespace + ".updateSuggestionStatus2", suggestionNo);
			if (result != 0) {
				sqlSession.commit();
			}
		} finally {
			sqlSession.close();
		}
	}
	

	// 제안 상태별 카운트
	public int getSuggestionStatusCount(int suggestionStatus) throws Exception {

		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("suggestionStatus", suggestionStatus);

			return sqlSession.selectOne(namespace + ".getSuggestionStatusCount", map);
		} finally {
			sqlSession.close();
		}
	}
	
	// 제안 상태별 리스트
	public List<SuggestionDTO> getSuggestionStatus(PagingVO vo) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			return sqlSession.selectList(namespace + ".getSuggestionStatus", vo);
		} finally {
			sqlSession.close();
		}
	}
	
	
	
	// 문의 카운트
	public int getAllInquiryCount() throws Exception {

		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			return sqlSession.selectOne(namespace + ".getAllInquiryCount");
		} finally {
			sqlSession.close();
		}
	}
		
	// 문의 목록
	public List<InquiryDTO> getInquiryInfo(PagingVO vo) {
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		try {
			return sqlsession.selectList(namespace + ".getInquiryInfo", vo);
		} finally {
			sqlsession.close();
		}
	}
	
	// 각각의 문의 보기
	public InquiryDTO getInquiry(Map<String, Object> map) throws Exception {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		InquiryDTO article = new InquiryDTO();
		try {
			article = (InquiryDTO) sqlSession.selectOne(namespace + ".getInquiry", map);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
		return article;
	}
	
	// 각각의 문의 보기(답변)
	public List<AnswerIDTO> getAnswerI(int inquiryNo) throws Exception {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			return sqlSession.selectList(namespace + ".getAnswerI", inquiryNo);
		} finally {
			sqlSession.close();
		}
	}
	
	
	// 문의 답변 작성
	public void answerIWrite(AnswerIDTO answerI) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int result = 0;
		try {
			result = sqlSession.insert(namespace + ".answerIWrite", answerI);
			if (result != 0) {
				sqlSession.commit();
			}
		} finally {
			sqlSession.close();
		}
	}
	public void updateInquiryStatus1(int inquiryNo) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int result = 0;
		try {
			result = sqlSession.update(namespace + ".updateInquiryStatus1", inquiryNo);
			if (result != 0) {
				sqlSession.commit();
			}
		} finally {
			sqlSession.close();
		}
	}
	
	// 문의 삭제
	public void updateInquiryStatus2(int inquiryNo) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int result = 0;
		try {
			result = sqlSession.update(namespace + ".updateInquiryStatus2", inquiryNo);
			if (result != 0) {
				sqlSession.commit();
			}
		} finally {
			sqlSession.close();
		}
	}
	

	// 문의 상태별 카운트
	public int getInquiryStatusCount(int inquiryStatus) throws Exception {

		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("inquiryStatus", inquiryStatus);

			return sqlSession.selectOne(namespace + ".getInquiryStatusCount", map);
		} finally {
			sqlSession.close();
		}
	}
	
	// 문의 상태별 리스트
	public List<InquiryDTO> getInquiryStatus(PagingVO vo) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			return sqlSession.selectList(namespace + ".getInquiryStatus", vo);
		} finally {
			sqlSession.close();
		}
	}
	
	// 공지 카운트
	public int getNoticeCount(String noticeTitle) throws Exception {

		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("noticeTitle", noticeTitle);
			return sqlSession.selectOne(namespace + ".getNoticeCount", map);
		} finally {
			sqlSession.close();
		}
	}

	// 공지 목록
	public List<NoticeDTO> getNoticeInfo(PagingVO vo) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			return sqlSession.selectList(namespace + ".getNoticeInfo", vo);
		} finally {
			sqlSession.close();
		}
	}	
	
	// 공지 검색
	public List<NoticeDTO> getSearchNoticeInfo(PagingVO vo) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			return sqlSession.selectList(namespace + ".getSearchNoticeInfo", vo);
		} finally {
			sqlSession.close();
		}
	}
	
	// 각각의 공지 보기
	public NoticeDTO getNotice(Map<String, Object> map) throws Exception {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		NoticeDTO article = new NoticeDTO();
		try {
			article = (NoticeDTO) sqlSession.selectOne(namespace + ".getNotice", map);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
		return article;
	}
	
	// 공지 등록
	public void noticeWrite(NoticeDTO notice) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int result = 0;
		try {
			result = sqlSession.insert(namespace + ".noticeWrite", notice);
			if (result != 0) {
				sqlSession.commit();
			}
		} finally {
			sqlSession.close();
		}
	}

	// 공지 수정
	public void noticeModify(NoticeDTO notice) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int result = 0;
		try {
			result = sqlSession.update(namespace + ".noticeModify", notice);
			if (result != 0) {
				sqlSession.commit();
			}
		} finally {
			sqlSession.close();
		}
		
	}

	// 공지 삭제
	public void noticeDelete(int noticeNo) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int result = 0;
		try {
			result = sqlSession.delete(namespace + ".noticeDelete", noticeNo);
			if (result != 0) {
				sqlSession.commit();
			}
		} finally {
			sqlSession.close();
		}
	}	
}
