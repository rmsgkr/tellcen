package com.itcen.tellcen.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itcen.tellcen.domain.MemberDTO;
import com.itcen.tellcen.util.PagingVO;


@Repository
public class MemberDAO extends AbstractMybatisDAO {
	private String namespace = "memberMapper";
	HashMap<String, Object> map = new HashMap<String, Object>();

	// 회원가입
	public int signup(MemberDTO member) {
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		int result = 0;
		try {
			result = sqlsession.insert(namespace + ".signup", member);
			if (result != 0) {
				sqlsession.commit();
			}
			return result;
		} finally {
			sqlsession.close();
		}
	}
	
	// 로그인
	public MemberDTO login(Map<String, String> map) {
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		try {
			return sqlsession.selectOne(namespace + ".login", map);
		} finally {
			sqlsession.close();
		}
	}

	// 이메일 인증 키 추가
	public void insertAuthKey(Map<String, String> map) {
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		int result = 0;
		try {
			result = sqlsession.update(namespace + ".insertAuthKey", map);
			if (result != 0) {
				sqlsession.commit();
			}
		} finally {
			sqlsession.close();
		}
	}

	// 이메일 인증 체크
	public String checkAuthKey(Map<String, String> map) {
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		try {
			return sqlsession.selectOne(namespace + ".checkAuthKey", map);
		} finally {
			sqlsession.close();
		}
	}

	// 이메일 인증 완료
	public void changeAuthCheck(String id) {
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		try {
			sqlsession.update(namespace + ".changeAuthCheck", id);
			sqlsession.commit();
		} finally {
			sqlsession.close();
		}
	}
	
	// 사용자 정보
	public MemberDTO getInfo(String id) {
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		try {
			return sqlsession.selectOne(namespace + ".getInfo", id);
		} finally {
			sqlsession.close();
		}
	}
	
	// 회원 정보 수정(이메일,전화번호,주소)
	public int modify(MemberDTO member) {
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		int result = 0;
		try {
			result = sqlsession.update(namespace + ".modify", member);
			if (result != 0) {
				sqlsession.commit();
			}
			return result;
		} finally {
			sqlsession.close();
		}
	}
	
	// 회원 탈퇴
	public void delete(String id) {
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		int result = 0;
		try {
			result = sqlsession.update(namespace + ".delete", id);
			if (result != 0) {
				sqlsession.commit();
			}
		} finally {
			sqlsession.close();
		}
	}
	
	// 아이디 찾기(이메일 / 전화번호로 찾기)
	public String getId(MemberDTO member) {
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		try {
			return sqlsession.selectOne(namespace + ".getId", member);
		} finally {
			sqlsession.close();
		}
	}
	
	// 비밀번호 찾기
	public String getPwd(String pwd) {
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		try {
			return sqlsession.selectOne(namespace + ".getPwd", pwd);
		} finally {
			sqlsession.close();
		}
	}

	// 비밀번호 변경(비밀번호 찾기시)
	public String getEmail(String id) {
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		try {
			return sqlsession.selectOne(namespace + ".getEmail", id);
		} finally {
			sqlsession.close();
		}
	}

	// 비밀번호 변경
	public void changePwd(Map<String, String> map) {
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		int result = 0;
		try {
			result = sqlsession.update(namespace + ".changePwd", map);
			if (result != 0) {
				sqlsession.commit();
			}
		} finally {
			sqlsession.close();
		}
	}
	
	/*
	 * // ADMIN public List<MemberDTO> getFullInfo(PagingVO vo) { SqlSession
	 * sqlsession = getSqlSessionFactory().openSession(); try { return
	 * sqlsession.selectList(namespace + ".getFullInfo", vo); } finally {
	 * sqlsession.close(); } }
	 * 
	 * public int countMember() { SqlSession sqlsession =
	 * getSqlSessionFactory().openSession(); try { return
	 * sqlsession.selectOne(namespace + ".countMember"); } finally {
	 * sqlsession.close(); } }
	 * 
	 * public List<MemberDTO> getDelInfo(PagingVO vo) { SqlSession sqlsession =
	 * getSqlSessionFactory().openSession(); try { return
	 * sqlsession.selectList(namespace + ".getDelInfo", vo); } finally {
	 * sqlsession.close(); } }
	 * 
	 * public int countDelMember() { SqlSession sqlsession =
	 * getSqlSessionFactory().openSession(); try { return
	 * sqlsession.selectOne(namespace + ".countDelMember"); } finally {
	 * sqlsession.close(); } }
	 * 
	 * public int checkId(String id) { SqlSession sqlsession =
	 * getSqlSessionFactory().openSession(); try { return
	 * sqlsession.selectOne(namespace + ".checkId", id); } finally {
	 * sqlsession.close(); } }
	 */



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
