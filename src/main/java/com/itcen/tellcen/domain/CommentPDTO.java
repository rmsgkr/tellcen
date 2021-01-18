package com.itcen.tellcen.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class CommentPDTO {

	private int commentPNo; //번호
	private int petitionNo; //FK
	private String id; //아이디
    private String commentPContent; //내용(Defalut:동의합니다.)
    private Timestamp commentPDate; //작성일 
}
