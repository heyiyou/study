
package com.peisia.dto;

import lombok.Data;

@Data
public class CardDto {
	private Long no;        // 카드 번호 (선택사항)
	private String job;     // 직업명
	private String grade;   // 등급
	private String id;      // 사용자 ID
	public CardDto() {
		
	}
	public CardDto(String job, String grade) {
		this.job = job;
		this.grade = grade;
	
	}
}