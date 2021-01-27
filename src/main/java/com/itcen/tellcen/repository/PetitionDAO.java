package com.itcen.tellcen.repository;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itcen.tellcen.domain.PetitionDTO;
import com.itcen.tellcen.util.PagingVO;

@Repository
public class PetitionDAO extends AbstractMybatisDAO {
	private String namespace = "petitionMapper";
	HashMap<String, Object> map = new HashMap<String, Object>();

	// 카운트
	public int getArticleCount(String category, String sentence) throws Exception {
		
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("category", category);
			map.put("sentence", sentence);
			//null이 떠서 안됨?
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


}
