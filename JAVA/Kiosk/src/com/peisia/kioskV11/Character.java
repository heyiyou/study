package com.peisia.kioskV11;

public class Character extends GameObj {
	int hp;
	int attack;

	@Override
	void info() {
		System.out.println("=== 캐릭터 정보 ===");
		System.out.println("이름: " + name);
		System.out.println("HP: " + hp);
		System.out.println("공격력: " + attack);
		
//		Color.sum(Color.BG_GREEN, name);
//		Color.sumLn(Color.BG_BLUE, hp+"");
		
		
	}
	
}