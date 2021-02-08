package com.itcen.tellcen.repository;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itcen.tellcen.domain.ComplaintDTO;
import com.itcen.tellcen.domain.PetitionDTO;


@Repository
public class ComplaintDAO extends AbstractMybatisDAO {
	private String namespace = "complaintMapper";
	HashMap<String, Object> map = new HashMap<String, Object>();

	// 민원 작성
	public void complaintWrite(ComplaintDTO complaint) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int result = 0;
		try {
			result = sqlSession.insert(namespace + ".complaintWrite", complaint);
			if (result != 0) {
				sqlSession.commit();
			}
		} finally {
			sqlSession.close();
		}
	}
}
