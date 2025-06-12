package com.peisia.dto;

import lombok.Data;

@Data
public class SkillDto {
	public SkillDto(String name, int level) {
		this.name = name;
		this.level = level;
	}
	public String name;
	public int level;
}