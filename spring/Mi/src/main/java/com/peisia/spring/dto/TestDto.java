package com.peisia.spring.dto;

import lombok.Data;


@Data
public class TestDto {
	private Long no;
	private String str_data;   //     TestMapper.xml���� �԰��� ����ٰ� �ߴµ� �԰��̶� �̸��� �����ϴ°�
	
	
	//�Һ� ���̺귯���� �Ʒ� �����Լ�, �����Լ��� �ڵ����� �������. @Data ��� ���̸�.
	
	//����, �����Լ�, ���͸޼ҵ�
//	public Long getNo() {
//		return no;
//	}
	
	//����
//	public void setNo(Long no) {
//		this.no = no;
//	}
	
	//str_data �� ����,���͵� ...

}



	
