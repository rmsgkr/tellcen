package com.itcen.tellcen.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itcen.tellcen.domain.CommentPDTO;
import com.itcen.tellcen.domain.PetitionDTO;
import com.itcen.tellcen.repository.PetitionDAO;
import com.itcen.tellcen.util.PagingVO;

@Service
public class PetitionService {

	@Autowired
	private PetitionDAO petitionDao;
	
	// 카운트
	public int getArticleCount(String category, String sentence)throws Exception {
		return petitionDao.getArticleCount(category, sentence);
	}
	
	// 청원 목록
	public List<PetitionDTO> getPetitionInfo(PagingVO vo) {
		return petitionDao.getPetitionInfo(vo);
	}
	
	// 각각의 청원 보기
	public PetitionDTO getArticle(int petitionNo) throws Exception	{
		return petitionDao.getArticle(petitionNo);
	}
	
	// 각각의 청원 보기(댓글-동의)
	public List<CommentPDTO> getCommentP(int petitionNo) throws Exception	{
		return petitionDao.getCommentP(petitionNo);
	}

	// 청원 댓글(동의) 작성 
	public void commentPWrite(CommentPDTO commentP) {
		petitionDao.commentPWrite(commentP);
	}
	
	// 청원 댓글(동의) 작성 
	public void agreementPlus(int petitionNo) {
		petitionDao.agreementPlus(petitionNo);
	}
		
	// 청원 작성
	public void petitionWrite(PetitionDTO petition) {
		petitionDao.petitionWrite(petition);
	}
	
	

}
