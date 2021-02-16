package com.itcen.tellcen.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itcen.tellcen.domain.AnswerPDTO;
import com.itcen.tellcen.domain.AnswerSDTO;
import com.itcen.tellcen.domain.CommentPDTO;
import com.itcen.tellcen.domain.CommentSDTO;
import com.itcen.tellcen.domain.SuggestionDTO;
import com.itcen.tellcen.util.PagingVO;



@Repository
public class SuggestionDAO extends AbstractMybatisDAO {
	private String namespace = "suggestionMapper";
	HashMap<String, Object> map = new HashMap<String, Object>();

	// 제안 작성
	public void suggestionWrite(SuggestionDTO suggestion) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int result = 0;
		try {
			result = sqlSession.insert(namespace + ".suggestionWrite", suggestion);
			if (result != 0) {
				sqlSession.commit();
			}
		} finally {
			sqlSession.close();
		}
	}
	
	// 카운트
	public int getArticleCount(String suggestionTitle, String suggestionSdate, String suggestionEdate) throws Exception {

		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("suggestionTitle", suggestionTitle);
			map.put("suggestionSdate", suggestionSdate);
			map.put("suggestionEdate", suggestionEdate);
			return sqlSession.selectOne(namespace + ".getArticleCount", map);
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
	public List<SuggestionDTO> getSearchInfo(PagingVO vo) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			return sqlSession.selectList(namespace + ".getSearchInfo", vo);
		} finally {
			sqlSession.close();
		}
	}
	
	// 각각의 제안 보기
	public SuggestionDTO getArticle(Map<String, Object> map) throws Exception {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		SuggestionDTO article = new SuggestionDTO();
		try {
			article = (SuggestionDTO) sqlSession.selectOne(namespace + ".getArticle", map);
			// 조회수 증가
			sqlSession.update(namespace + ".addReadCount", map);
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

	// 제안 댓글 작성
	public void commentSWrite(CommentSDTO commentS) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int result = 0;
		try {
			result = sqlSession.insert(namespace + ".commentSWrite", commentS);
			if (result != 0) {
				sqlSession.commit();
			}
		} finally {
			sqlSession.close();
		}
	}
}
