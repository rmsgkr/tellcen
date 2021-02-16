package com.itcen.tellcen.domain;

import java.sql.Date;
import java.sql.Timestamp;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class SuggestionDTO {

	private int suggestionNo; //번호
	private String id; // FK
    private String suggestionTitle; //제목
    private String suggestionProblem; //제안내용 - 현황 및 문제점
    private String suggestionPlan; //제안내용 - 개선방안
    private String suggestionEffect; //제안내용 - 기대효과
    @DateTimeFormat(pattern="yyyy/MM/dd")
    private Date suggestionDate; //작성일 
    private int suggestionCount; //조회수
    private int suggestionStatus; //상태(0.심사 1.승인 2.거부)
    
    @DateTimeFormat(pattern="yyyy/MM/dd")
    private Date suggestionSdate; //시작일 
    @DateTimeFormat(pattern="yyyy/MM/dd")
    private Date suggestionEdate; //종료일 
}
