package com.peisia.kiosk06;

public class Main {
	//1.변수들
	String name;
	int price;
	
	Main(String xx, int yy){
		name = xx;
		price = yy;
	}
	
	//2.함수들 (메인 말고)
	void info() {
		System.out.println("상품명:"+name+" 가격:"+price);
	}
	
}
