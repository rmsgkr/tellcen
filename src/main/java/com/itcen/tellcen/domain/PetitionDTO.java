package com.itcen.tellcen.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class PetitionDTO {

	private int petitionNo; //번호
	private String id; // FK
    private String petitionTitle; //제목
    private String petitionContent; //내용
    private String petitionArea; //지역
    private String petitionField; //분야
    private Timestamp petitionSdate; //등록일 
    private Timestamp petitionEdate; //마감일 
    private int petitionAgreement; //동의수
    private int petitionStatus; 
	/*
	 * 0.진행  1.종료  2.답변완료
	 */
    private int agreeCheck; 
}
