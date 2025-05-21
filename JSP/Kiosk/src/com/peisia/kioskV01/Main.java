package com.peisia.kioskV01;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("============================================");
		System.out.println("================= 고양이카페       ===========");
		System.out.println("============================================");
		//ctrl + shift + o(영문자). 자동 임포트.
		Scanner sc = new Scanner(System.in);
		String cmd;
		loop_a:                  // 라벨을 붙여 놓은거 x ㅇ나오면 레벨을 실행 시켜 while로 전체가 break로 나오게 하는 명령어
		while(true) {
			System.out.print("명령:");
			cmd = sc.next();
			switch(cmd) {
			case "1":
				System.out.println("1번명령");
				break;
			case "2":
				System.out.println("2번명령");
				break;
			case "x":
				break loop_a;
			}
		}
		System.out.println("프로그램 종료");

	}

}
