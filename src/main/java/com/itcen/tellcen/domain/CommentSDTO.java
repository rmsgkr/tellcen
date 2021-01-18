package com.itcen.tellcen.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class CommentSDTO {

	private int commentSNo; //번호
	private int suggestionNo; //FK
	private String id; //아이디
    private String commentSContent; //내용
    private Timestamp commentSDate; //작성일 
}
