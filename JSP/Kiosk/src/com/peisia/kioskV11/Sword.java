package com.peisia.kioskV11;

public class Sword extends Item {
	int attack;

	@Override
	void info() {
		System.out.println("=== 무기 정보 ===");
		System.out.println("이름: " + name);
		System.out.println("무게: " + weight);
		System.out.println("수명: " + 수명);
		System.out.println("공격력: " + attack);
	}
}