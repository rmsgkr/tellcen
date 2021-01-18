package com.itcen.tellcen.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class AnswerPDTO {

	private int answerPNo; //번호
	private int petitionNo; //FK
    private String answerPContent; //내용
    private Timestamp answerPDate; //작성일 
}
