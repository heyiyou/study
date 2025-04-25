package com.peisia.kioskV08;

public class Sword extends Item {
	int attack;


public void info() {
    super.info();  // Item의 info() 먼저 출력
    System.out.println("공격력: " + attack);
}
}