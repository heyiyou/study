package com.peisia.kioskV08;

public class Item extends GameObj {
	public int weight;
	public int 수명;

	public void info() {
		super.info();
		System.out.println("==== [무기 정보] ====");
		System.out.println("아이템 이름: " + name);
		System.out.println("무게: " + weight);
		System.out.println("수명: " + 수명);
	}
}