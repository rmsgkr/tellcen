package com.itcen.tellcen.domain;

import lombok.Data;

@Data
public class TopicInfoDTO {
	
	private String topic; // 이슈 명
	private int rank; // 순위
	private int count; // 건수
    
}
