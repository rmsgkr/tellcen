package com.itcen.tellcen.repository;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itcen.tellcen.domain.AnswerCDTO;
import com.itcen.tellcen.domain.AnswerPDTO;
import com.itcen.tellcen.domain.CommentPDTO;
import com.itcen.tellcen.domain.ComplaintDTO;
import com.itcen.tellcen.domain.MemberDTO;
import com.itcen.tellcen.domain.PetitionDTO;
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
}
