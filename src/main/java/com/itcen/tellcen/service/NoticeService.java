package com.itcen.tellcen.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itcen.tellcen.domain.NoticeDTO;
import com.itcen.tellcen.domain.SuggestionDTO;
import com.itcen.tellcen.repository.NoticeDAO;
import com.itcen.tellcen.util.PagingVO;



@Service
public class NoticeService {

	@Autowired
	private NoticeDAO noticeDao;

	// 카운트
	public int getArticleCount(String suggestionTitle) throws Exception {
		return noticeDao.getArticleCount(suggestionTitle);
	}

	// 공지 목록
	public List<NoticeDTO> getNoticeInfo(PagingVO vo) {
		return noticeDao.getNoticeInfo(vo);
	}
	
	// 공지 검색
	public List<NoticeDTO> getSearchInfo(PagingVO vo) {
		return noticeDao.getSearchInfo(vo);
	}
	
	// 각각의 공지 보기
	public NoticeDTO getArticle(Map<String, Object> map) throws Exception {
		return noticeDao.getArticle(map);
	}

}
