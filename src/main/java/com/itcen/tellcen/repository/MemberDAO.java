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
	
	
	// 아이디 찾기(이메일로 찾기)
	public String getMemberId(Map<String, String> map) {
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		try {
			return sqlsession.selectOne(namespace + ".getMemberId", map);
		} finally {
			sqlsession.close();
		}
	}
	
	// 비밀번호 변경(비밀번호 찾기시)
	public String getMemberEmail(String id) {
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		try {
			return sqlsession.selectOne(namespace + ".getMemberEmail", id);
		} finally {
			sqlsession.close();
		}
	}

	// 비밀번호 변경
	public void changeMemberPwd(Map<String, String> map) {
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		int result = 0;
		try {
			result = sqlsession.update(namespace + ".changeMemberPwd", map);
			if (result != 0) {
				sqlsession.commit();
			}
		} finally {
			sqlsession.close();
		}
	}

}
