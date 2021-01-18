package com.itcen.tellcen.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class AnswerIDTO {

	private int answerINo; //번호
	private int inquiryNo; //FK
    private String answerIContent; //내용
    private Timestamp answerIDate; //작성일 
}
