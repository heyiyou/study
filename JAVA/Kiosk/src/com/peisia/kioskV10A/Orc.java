package com.peisia.kioskV10A;

import com.peisia.c.util.So;

public class Orc extends Monster{

	@Override
	void attack(Player p) {
		super.attack(p);
		attack = 5;
		So.ln(String.format("몽둥이로 %s에게 피해를 %d 줌",p.name,attack));
	}
	
}
