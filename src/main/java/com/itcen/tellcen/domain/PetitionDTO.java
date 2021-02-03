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
    private Timestamp petitionDate; //작성일 
    private int petitionAgreement; //동의수
    private int petitionStatus; 
	/*
	 * 0.신청 1.진행  2.종료 3.답변
	 */
    private int agreeCheck; 
}
