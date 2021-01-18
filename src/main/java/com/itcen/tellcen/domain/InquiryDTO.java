package com.itcen.tellcen.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class InquiryDTO {

	private int inquiryNo; //번호
	private String id; // FK
    private String inquiryTitle; //제목
    private String inquiryContent; //내용
    private String inquiryFile; //파일
    private Timestamp petitionDate; //작성일 
}
