package com.itcen.tellcen.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class SugeestionDTO {

	private int suggestionNo; //번호
	private String id; // FK
    private String suggestionTitle; //제목
    private String suggestionProblem; //제안내용 - 현황 및 문제점
    private String suggestionPlan; //제안내용 - 개선방안
    private String suggestionEffect; //제안내용 - 기대효과
    private Timestamp suggestionDate; //작성일 
    private int suggestionCount; //조회수
    private int suggestionStatus; //상태(0.신청 1.심사중 2.승인 3.거부)
}
