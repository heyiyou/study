package com.peisia.dto;
import java.util.ArrayList;
import lombok.Data;

@Data
public class Cat {
	String name;
	int age;
	public ArrayList<String> hobby = new ArrayList<>();
	public ArrayList<Animal> friends = new ArrayList<>();
	public Cat(String name, int age) {
		this.name = name;
		this.age = age;
	}
}
