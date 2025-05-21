package com.peisia.kioskV11;

import java.text.DecimalFormat;

public class Main {
	public static void main(String[] args) {
		Character elf = new Character();
		elf.name = "엘프";
		elf.hp = 100;
		elf.attack = 30;
		elf.info();

		Item book = new Item();
		book.name = "마법책";
		book.weight = 5;
		book.수명 = 1000;
		book.info();

		Sword sword = new Sword();
		sword.name = "단검";
		sword.수명 = 500000;
		sword.attack = 50;
		sword.info();
		DecimalFormat df = new DecimalFormat("#,###");
		System.out.println(df.format(1000000));
		
		
	}
	
}