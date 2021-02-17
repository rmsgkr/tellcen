package com.itcen.tellcen.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itcen.tellcen.domain.AnswerCDTO;
import com.itcen.tellcen.domain.AnswerIDTO;
import com.itcen.tellcen.domain.ComplaintDTO;
import com.itcen.tellcen.domain.InquiryDTO;
import com.itcen.tellcen.domain.MemberDTO;
import com.itcen.tellcen.util.PagingVO;

@Repository
public class MypageDAO extends AbstractMybatisDAO {
	private String namespace = "mypageMapper";
	HashMap<String, Object> map = new HashMap<String, Object>();

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
}
