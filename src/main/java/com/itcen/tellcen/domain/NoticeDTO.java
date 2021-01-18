package com.itcen.tellcen.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class NoticeDTO {

	private int noticeNo; //번호
    private String noticeTitle; //제목
    private String noticeContent; //내용
    private String noticeFile; //파일
    private Timestamp noticeDate; //작성일 
    private int noticeCount; //조회수
}
