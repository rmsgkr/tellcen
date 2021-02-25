package com.itcen.tellcen.repository;

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
import com.itcen.tellcen.domain.PetitionDTO;
import com.itcen.tellcen.domain.SuggestionDTO;
import com.itcen.tellcen.util.PagingVO;

@Repository
public class MypageDAO extends AbstractMybatisDAO {
	private String namespace = "mypageMapper";
	HashMap<String, Object> map = new HashMap<String, Object>();
	
	// 나의 청원 / 민원 / 제안 / 문의 카운트
	public int getMyPetitionCount(String id) throws Exception {

		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			return sqlSession.selectOne(namespace + ".getMyPetitionCount", id);
		} finally {
			sqlSession.close();
		}
	}
	public int getMyComplaintCount(String id) throws Exception {

		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			return sqlSession.selectOne(namespace + ".getMyComplaintCount", id);
		} finally {
			sqlSession.close();
		}
	}
	public int getMySuggestionCount(String id) throws Exception {

		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			return sqlSession.selectOne(namespace + ".getMySuggestionCount", id);
		} finally {
			sqlSession.close();
		}
	}
	public int getMyInquiryCount(String id) throws Exception {

		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			return sqlSession.selectOne(namespace + ".getMyInquiryCount", id);
		} finally {
			sqlSession.close();
		}
	}
	
	// 청원 카운트
	public int getPetitionCount(String id) throws Exception {

		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			map.put("id", id);
			return sqlSession.selectOne(namespace + ".getPetitionCount", map);
		} finally {
			sqlSession.close();
		}
	}
		
	// 청원 목록
	public List<PetitionDTO> getPetitionInfo(PagingVO vo) {
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		try {
			return sqlsession.selectList(namespace + ".getPetitionInfo", vo);
		} finally {
			sqlsession.close();
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
	
	// 각각의 청원 보기(답변)
	public List<AnswerPDTO> getAnswerP(int petitionNo) throws Exception {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			return sqlSession.selectList(namespace + ".getAnswerP", petitionNo);
		} finally {
			sqlSession.close();
		}
	}
	
	// 각각의 청원 보기(댓글)
	public List<CommentPDTO> getCommentP(int petitionNo) throws Exception {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			return sqlSession.selectList(namespace + ".getCommentP", petitionNo);
		} finally {
			sqlSession.close();
		}
	}
	
	// 민원 카운트
	public int getComplaintCount(String id) throws Exception {

		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			map.put("id", id);
			return sqlSession.selectOne(namespace + ".getComplaintCount", map);
		} finally {
			sqlSession.close();
		}
	}
		
	// 민원 목록
	public List<ComplaintDTO> getComplaintInfo(PagingVO vo) {
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		try {
			return sqlsession.selectList(namespace + ".getComplaintInfo", vo);
		} finally {
			sqlsession.close();
		}
	}
	
	// 각각의 민원 보기
	public ComplaintDTO getComplaint(Map<String, Object> map) throws Exception {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		ComplaintDTO article = new ComplaintDTO();
		try {
			article = (ComplaintDTO) sqlSession.selectOne(namespace + ".getComplaint", map);
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
	
	// 제안 카운트
	public int getSuggestionCount(String id) throws Exception {

		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			map.put("id", id);
			return sqlSession.selectOne(namespace + ".getSuggestionCount", map);
		} finally {
			sqlSession.close();
		}
	}
		
	// 제안 목록
	public List<SuggestionDTO> getSuggestionInfo(PagingVO vo) {
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		try {
			return sqlsession.selectList(namespace + ".getSuggestionInfo", vo);
		} finally {
			sqlsession.close();
		}
	}
	
	// 각각의 제안 보기
	public SuggestionDTO getSuggestion(Map<String, Object> map) throws Exception {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		SuggestionDTO article = new SuggestionDTO();
		try {
			article = (SuggestionDTO) sqlSession.selectOne(namespace + ".getSuggestion", map);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
		return article;
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
	
	// 각각의 제안 보기(댓글)
	public List<CommentSDTO> getCommentS(int suggestionNo) throws Exception {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			return sqlSession.selectList(namespace + ".getCommentS", suggestionNo);
		} finally {
			sqlSession.close();
		}
	}
	
	// 문의 카운트
	public int getInquiryCount(String id) throws Exception {

		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			map.put("id", id);
			return sqlSession.selectOne(namespace + ".getInquiryCount", map);
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
	
	// 사용자 정보
	public MemberDTO getMemberInfo(String id) {
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		try {
			return sqlsession.selectOne(namespace + ".getMemberInfo", id);
		} finally {
			sqlsession.close();
		}
	}
	
	// 회원 정보 수정(이메일,전화번호,주소)
	public int modifyMember(MemberDTO member) {
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		int result = 0;
		try {
			result = sqlsession.update(namespace + ".modifyMember", member);
			if (result != 0) {
				sqlsession.commit();
			}
			return result;
		} finally {
			sqlsession.close();
		}
	}
	
	// 비밀번호 찾기
	public String getMemberPwd(String pwd) {
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		try {
			return sqlsession.selectOne(namespace + ".getMemberPwd", pwd);
		} finally {
			sqlsession.close();
		}
	}
	
	// 회원 탈퇴
	public void deleteMember(String id) {
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		int result = 0;
		try {
			result = sqlsession.update(namespace + ".deleteMember", id);
			if (result != 0) {
				sqlsession.commit();
			}
		} finally {
			sqlsession.close();
		}
	}
	
}
