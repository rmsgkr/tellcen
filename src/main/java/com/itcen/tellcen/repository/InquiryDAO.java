package com.itcen.tellcen.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itcen.tellcen.domain.InquiryDTO;




@Repository
public class InquiryDAO extends AbstractMybatisDAO {
	private String namespace = "inquiryMapper";
	HashMap<String, Object> map = new HashMap<String, Object>();

	public void inquiryWrite(InquiryDTO inquiry) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int result = 0;
		try {
			result = sqlSession.insert(namespace + ".inquiryWrite", inquiry);
			if (result != 0) {
				sqlSession.commit();
			}
		} finally {
			sqlSession.close();
		}
	}
}
