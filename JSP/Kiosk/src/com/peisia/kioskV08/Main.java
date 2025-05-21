package com.peisia.kioskV08;

public class Main {

	public static void main(String[] args) {
		Character elf = new Character();
		elf.name = "지운";
		elf.hp = 100;
		elf.info();
		
		Item book = new Item();
		book.weight = 100;
		book.name = "개";
		book.info();
		
		Sword s= new Sword();
		s.name = "평범한 단검";
		s.수명 = 100;
		s.attack = 100;
		s.weight = 10;
		s.info();
	}
}

