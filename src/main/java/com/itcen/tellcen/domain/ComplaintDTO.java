package com.itcen.tellcen.domain;

import java.sql.Date;
import java.sql.Timestamp;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class ComplaintDTO {

	private int complaintNo; //번호
	private String id; // FK
    private String complaintTitle; //제목
    private String complaintContent; //내용
    private String complaintOrganization; //기관분류
    private String complaintOrganizationDetail; //상세기관
    
    @DateTimeFormat(pattern="yyyy/MM/dd")
    private Date complaintDate; //작성일 
    private int complaintCount; //조회수
    private int complaintStatus; //상태 0.심사중 1.답변완료 2.미승인(삭제)
    @DateTimeFormat(pattern="yyyy/MM/dd")
    private Date complaintSdate; // 날짜 조회 시작일
    @DateTimeFormat(pattern="yyyy/MM/dd")
    private Date complaintEdate; // 날짜 조회 종료일
    
}
