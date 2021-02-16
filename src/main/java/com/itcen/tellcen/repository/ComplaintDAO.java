package com.itcen.tellcen.repository;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itcen.tellcen.domain.AnswerCDTO;
import com.itcen.tellcen.domain.AnswerPDTO;
import com.itcen.tellcen.domain.ComplaintDTO;
import com.itcen.tellcen.domain.PetitionDTO;
import com.itcen.tellcen.util.PagingVO;


@Repository
public class ComplaintDAO extends AbstractMybatisDAO {
	private String namespace = "complaintMapper";

	// 민원 작성
	public void complaintWrite(ComplaintDTO complaint) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int result = 0;
		try {
			result = sqlSession.insert(namespace + ".complaintWrite", complaint);
			if (result != 0) {
				sqlSession.commit();
			}
		} finally {
			sqlSession.close();
		}
	}
	
	// 카운트
	public int getArticleCount(String complaintTitle, String complaintOrganization, String complaintOrganizationDetail, String complaintSdate, String complaintEdate) throws Exception {

		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("complaintTitle", complaintTitle);
			map.put("complaintOrganization", complaintOrganization);
			map.put("complaintOrganizationDetail", complaintOrganizationDetail);
			map.put("complaintSdate",complaintSdate);
			map.put("complaintEdate",complaintEdate);
			return sqlSession.selectOne(namespace + ".getArticleCount", map);
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
	public ComplaintDTO getArticle(Map<String, Object> map) throws Exception {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		ComplaintDTO article = new ComplaintDTO();
		try {
			article = (ComplaintDTO) sqlSession.selectOne(namespace + ".getArticle", map);
			// 조회수 증가
			sqlSession.update(namespace + ".addReadCount", map);
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
	
	// 민원 검색
	public List<ComplaintDTO> getSearchInfo(PagingVO vo) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			return sqlSession.selectList(namespace + ".getSearchInfo", vo);
		} finally {
			sqlSession.close();
		}
	}
}
