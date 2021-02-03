package com.itcen.tellcen.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itcen.tellcen.domain.CommentPDTO;
import com.itcen.tellcen.domain.PetitionDTO;
import com.itcen.tellcen.util.PagingVO;

@Repository
public class PetitionDAO extends AbstractMybatisDAO {
	private String namespace = "petitionMapper";
	HashMap<String, Object> map = new HashMap<String, Object>();

	// 카운트
	public int getArticleCount(String petitionTitle, String petitionArea, String petitionField) throws Exception {

		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("petitionTitle", petitionTitle);
			map.put("petitionArea", petitionArea);
			map.put("petitionField", petitionField);

			return sqlSession.selectOne(namespace + ".getArticleCount", map);
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

	// 각각의 청원 보기
	public PetitionDTO getArticle(Map<String, Object> map) throws Exception {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		PetitionDTO article = new PetitionDTO();
		try {
			article = (PetitionDTO) sqlSession.selectOne(namespace + ".getArticle", map);
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

	// 청원 댓글(동의) 작성
	public void commentPWrite(CommentPDTO commentP) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int result = 0;
		try {
			result = sqlSession.insert(namespace + ".commentPWrite", commentP);
			if (result != 0) {
				sqlSession.commit();
			}
		} finally {
			sqlSession.close();
		}
	}

	// 청원 댓글(동의) 작성
	public void agreementPlus(int petitionNo) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int result = 0;
		try {
			result = sqlSession.update(namespace + ".agreementPlus", petitionNo);
			if (result != 0) {
				sqlSession.commit();
			}
		} finally {
			sqlSession.close();
		}
	}

	// 청원 작성
	public void petitionWrite(PetitionDTO petition) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int result = 0;
		try {
			result = sqlSession.insert(namespace + ".petitionWrite", petition);
			if (result != 0) {
				sqlSession.commit();
			}
		} finally {
			sqlSession.close();
		}
	}

	// 청원 검색
	public List<PetitionDTO> getSearchInfo(PagingVO vo) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			return sqlSession.selectList(namespace + ".getSearchInfo", vo);
		} finally {
			sqlSession.close();
		}
	}

}
