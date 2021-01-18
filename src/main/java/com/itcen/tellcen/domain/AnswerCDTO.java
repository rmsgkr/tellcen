package com.itcen.tellcen.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class AnswerCDTO {

	private int answerCNo; //번호
	private int complaintNo; //FK
    private String answerCContent; //내용
    private Timestamp answerCDate; //작성일 
}
