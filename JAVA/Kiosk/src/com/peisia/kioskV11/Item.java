package com.peisia.kioskV11;

public class Item extends GameObj {
	int weight;
	int 수명;

	@Override
	void info() {
		System.out.println("=== 아이템 정보 ===");
		System.out.println("이름 :" + Color.BG_GREEN+name+Color.EXIT);   // 색깔 입히기
		System.out.println("무게 : " + weight);
		System.out.println("수명 : " + 수명);
	}
}