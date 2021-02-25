package com.itcen.tellcen.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itcen.tellcen.domain.MemberDTO;
import com.itcen.tellcen.repository.MemberDAO;

@Service
public class MemberService {

	@Autowired
	private MemberDAO memberDao;

	// 회원가입
	public void signup(MemberDTO member) {
		memberDao.signup(member);
	}

	// 로그인
	public MemberDTO login(Map<String, String> map) {
		return memberDao.login(map);
	}

	// 이메일 인증 키 추가
	public void insertAuthKey(Map<String, String> map) {
		memberDao.insertAuthKey(map);
	}

	// 이메일 인증 체크
	public boolean checkAuthKey(Map<String, String> map) {
		String authKey = memberDao.checkAuthKey(map);
		boolean result = authKey.equals(map.get("authKey"));
		if (result) {
			// 이메일 인증 완료
			memberDao.changeAuthCheck(map.get("id"));
		}
		return result;
	}

	// 아이디 찾기(이메일 / 전화번호로 찾기)
	public String getMemberId(Map<String, String> map) {
		return memberDao.getMemberId(map);
	}


	// 비밀번호 변경(비밀번호 찾기시)
	public String getMemberEmail(String id) {
		return memberDao.getMemberEmail(id);
	}

	// 비밀번호 변경
	public void changeMemberPwd(Map<String, String> map) {
		memberDao.changeMemberPwd(map);
	}


}
