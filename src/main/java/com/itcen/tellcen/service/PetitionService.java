package com.itcen.tellcen.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	// 청원 작성
	public void petitionWrite(PetitionDTO petition) {
		petitionDao.petitionWrite(petition);
	}
	
	

}
