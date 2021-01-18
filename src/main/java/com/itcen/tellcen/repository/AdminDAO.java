package com.itcen.tellcen.repository;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itcen.tellcen.domain.MemberDTO;
import com.itcen.tellcen.util.PagingVO;

@Repository
public class AdminDAO extends AbstractMybatisDAO {
	private String namespace = "adminMapper";
	HashMap<String, Object> map = new HashMap<String, Object>();

	// ADMIN
	public List<MemberDTO> getFullInfo(PagingVO vo) {
		SqlSession sqlsession =

				getSqlSessionFactory().openSession();
		try {
			return sqlsession.selectList(namespace + ".getFullInfo", vo);
		} finally {
			sqlsession.close();
		}
	}

	public int countMember() {
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		try {
			return sqlsession.selectOne(namespace + ".countMember");
		} finally {
			sqlsession.close();
		}
	}

	public List<MemberDTO> getDelInfo(PagingVO vo) {
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		try {
			return sqlsession.selectList(namespace + ".getDelInfo", vo);
		} finally {
			sqlsession.close();
		}
	}

	public int countDelMember() {
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		try {
			return sqlsession.selectOne(namespace + ".countDelMember");
		} finally {
			sqlsession.close();
		}
	}

	public int checkId(String id) {
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		try {
			return sqlsession.selectOne(namespace + ".checkId", id);
		} finally {
			sqlsession.close();
		}
	}

//	public int getArticleCount(String boardid, String category, String sentence) {
//		SqlSession sqlsession = getSqlSessionFactory().openSession();
//		try {
//			map.clear();
//			map.put("boardid", boardid);
//			map.put("category", category);
//			map.put("sentence", sentence);
//			return sqlsession.selectOne(namespace + ".getArticleCount", map);
//		} finally {
//			sqlsession.close();
//		}
//	}

}
