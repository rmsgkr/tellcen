package com.itcen.tellcen.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itcen.tellcen.domain.AnswerPDTO;
import com.itcen.tellcen.domain.AnswerSDTO;
import com.itcen.tellcen.domain.CommentPDTO;
import com.itcen.tellcen.domain.CommentSDTO;
import com.itcen.tellcen.domain.PetitionDTO;
import com.itcen.tellcen.domain.SuggestionDTO;
import com.itcen.tellcen.repository.SuggestionDAO;
import com.itcen.tellcen.util.PagingVO;

@Service
public class SuggestionService {

	@Autowired
	private SuggestionDAO suggestionDao;

	// 제안 작성
	public void suggestionWrite(SuggestionDTO suggestion) {
		suggestionDao.suggestionWrite(suggestion);
	}

	// 카운트
	public int getArticleCount(String suggestionTitle, String suggestionSdate, String suggestionEdate) throws Exception {
		return suggestionDao.getArticleCount(suggestionTitle, suggestionSdate, suggestionEdate);
	}

	// 제안 목록
	public List<SuggestionDTO> getSuggestionInfo(PagingVO vo) {
		return suggestionDao.getSuggestionInfo(vo);
	}
	
	// 제안 검색
	public List<SuggestionDTO> getSearchInfo(PagingVO vo) {
		return suggestionDao.getSearchInfo(vo);
	}
	
	// 각각의 제안 보기
	public SuggestionDTO getArticle(Map<String, Object> map) throws Exception {
		return suggestionDao.getArticle(map);
	}

	// 각각의 제안 보기(댓글)
	public List<CommentSDTO> getCommentS(int suggestionNo) throws Exception {
		return suggestionDao.getCommentS(suggestionNo);
	}
	
	// 각각의 제안 보기(답변)
	public List<AnswerSDTO> getAnswerS(int suggestionNo) throws Exception {
		return suggestionDao.getAnswerS(suggestionNo);
	}
	
	// 제안 댓글 작성
	public void commentSWrite(CommentSDTO commentS) {
		suggestionDao.commentSWrite(commentS);
	}
}
