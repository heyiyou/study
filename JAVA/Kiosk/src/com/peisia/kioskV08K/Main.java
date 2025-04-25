package com.peisia.kioskV08K;

public class Main {

	public static void main(String[] args) {
		Character elf = new Character();
		elf.name = "1";
		elf.hp = 1;
		elf.info();
		
		Item book = new Item();
		book.weight = 100;
		book.name = "개";
		book.info();
		
		Sword shortSword = new Sword();
		shortSword.name = "단검";
		shortSword.attack = 100;
		shortSword.weight = 10;
		
	}
}

