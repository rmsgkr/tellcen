package com.itcen.tellcen.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class AnswerSDTO {

	private int answerSNo; //번호
	private int suggestionNo; //FK
    private String answerSContent; //내용
    private Timestamp answerSDate; //작성일 
}
