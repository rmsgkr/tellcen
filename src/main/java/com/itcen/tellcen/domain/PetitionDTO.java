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
	 * 상태( 
	 *  0.접수- 관리자가 승인 시 목록에 보여지게 됨
	 *  1.진행 - 일정 동의 수 넘길시 대기상태로 변함
	 *  2.대기 - 관리자가 답변을남기려는 상태 
	 *  3.완료
	 *  )
	 */
    
    private int agreeCheck; 
}
