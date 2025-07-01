package com.peisia.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.peisia.dto.Cat;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/api/*")
@AllArgsConstructor
@RestController
public class ApiCatController {
	@GetMapping("/catOne")
	public Cat getCatOne() {
		Cat cat = new Cat(null, 0);
		cat.setName("야옹이");
		cat.setAge(5);
		return cat;
	}

	@GetMapping("/catTwo")
	public Cat getCatTwo() {
		Cat cat = new Cat(null, 0);
		cat.setName("떼껄룩");
		cat.setAge(10);
		return cat;
	}

	class X {
		public String a = "a";
		public String b = "b";
	}

	class Xs {
		public String a = "a";
		public ArrayList<String> as = new ArrayList<>();

		Xs() {
			as.add("야옹이");
			as.add("개");
		}
	}

	class Weapon {
		public String name;
		public int atk;

		public Weapon(String name, int atk) {
			this.name = name;
			this.atk = atk;
		}
	}

	class Z {
		public String catName;
		public Weapon myWeapon;

		public Z(String catName, Weapon myWeapon) {
			this.catName = catName;
			this.myWeapon = myWeapon;
		}
	}

	@GetMapping("/x")
	public X x() {
		return new X();
	}

	@GetMapping("/xs")
	public Xs xs() {
		return new Xs();
	}

	@GetMapping("/xw")
	public Z xw() {
		Weapon w = new Weapon("발톱", 100);
		return new Z("키티", w);
	}

}