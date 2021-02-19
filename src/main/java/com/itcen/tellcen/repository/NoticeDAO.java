package com.itcen.tellcen.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itcen.tellcen.domain.NoticeDTO;
import com.itcen.tellcen.domain.SuggestionDTO;
import com.itcen.tellcen.util.PagingVO;




@Repository
public class NoticeDAO extends AbstractMybatisDAO {
	private String namespace = "noticeMapper";
	HashMap<String, Object> map = new HashMap<String, Object>();

	// 카운트
	public int getArticleCount(String noticeTitle) throws Exception {

		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("noticeTitle", noticeTitle);
			return sqlSession.selectOne(namespace + ".getArticleCount", map);
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
	public List<NoticeDTO> getSearchInfo(PagingVO vo) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			return sqlSession.selectList(namespace + ".getSearchInfo", vo);
		} finally {
			sqlSession.close();
		}
	}
	
	// 각각의 공지 보기
	public NoticeDTO getArticle(Map<String, Object> map) throws Exception {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		NoticeDTO article = new NoticeDTO();
		try {
			article = (NoticeDTO) sqlSession.selectOne(namespace + ".getArticle", map);
			// 조회수 증가
			sqlSession.update(namespace + ".addReadCount", map);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
		return article;
	}
	
}
