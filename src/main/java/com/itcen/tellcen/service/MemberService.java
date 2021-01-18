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

	// 사용자 정보
	public MemberDTO getInfo(String id) {
		return memberDao.getInfo(id);
	}

	// 회원 정보 수정(이메일,전화번호,주소)
	public int modify(MemberDTO member) {
		return memberDao.modify(member);
	}

	// 회원 탈퇴
	public void delete(String id) {
		memberDao.delete(id);
	}

	// 아이디 찾기(이메일 / 전화번호로 찾기)
	public String getId(MemberDTO member) {
		return memberDao.getId(member);
	}

	// 비밀번호 찾기
	public String getPwd(String pwd) {
		return memberDao.getPwd(pwd);
	}

	// 비밀번호 변경(비밀번호 찾기시)
	public String getEmail(String id) {
		return memberDao.getEmail(id);
	}

	// 비밀번호 변경
	public void changePwd(Map<String, String> map) {
		memberDao.changePwd(map);
	}

	/*
	 * // ADMIN public List<MemberDTO> getFullInfo(PagingVO vo) { return
	 * memberDao.getFullInfo(vo); } public int countNumber() { return
	 * memberDao.countMember(); }
	 * 
	 * public List<MemberDTO> getDelInfo(PagingVO vo) { return
	 * memberDao.getDelInfo(vo); } public int countDelNumber() { return
	 * memberDao.countDelMember(); }
	 * 
	 * public int checkId(String id) { return memberDao.checkId(id); }
	 */
}
