package com.peisia.rpc;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("가위바위보 중에 하나 입력해주세요:");
		
		Scanner sc = new Scanner(System.in);   //중요 이건  통째로 외워둘것 
		
		String userRpc = sc.next("");    //이 코드를 넣으면 입역란에 깜빡 거리면서 입력 가능
		
		System.out.println("님이 낸것은:"+userRpc);
		
		int r = (int)(Math.random() * 3 + 1);	// 1~6 까지 랜덤하 뽑음
		System.out.println("주사위를 굴려 "+r+"이 나왔습니다.");
		
		String comRpc = "";
		if(r == 1) {
			comRpc = "가위";
		} else if(r == 2) {
			comRpc = "바위";
		} else if(r == 3) {
			comRpc = "보";
		}
		
		System.out.println("컴퓨터가 "+comRpc+" 냈습니다.");
		
		//todo
		//결과 판정
		String result = "";
		//스위치switch으로 해도됨
		
		    if(userRpc.equals("가위")) {
			if(comRpc.equals("가위")) {
				result="비김";
			}
			if(comRpc.equals("바위")) {
				result="짐";
			}
			if(comRpc.equals("보")) {
				result="이김";
			}
		}
		if(userRpc.equals("바위")) {
			if(comRpc.equals("가위")) {
				result="이김";
			}
			if(comRpc.equals("바위")) {
				result="비김";
			}
			if(comRpc.equals("보")) {
				result="짐";
			}
		}
		if(userRpc.equals("보")) {
			if(comRpc.equals("가위")) {
				result="짐";
			}
			if(comRpc.equals("바위")) {
				result="이김";
			}
			if(comRpc.equals("보")) {
				result="비김";
			}
		}
		System.out.println("결과:"+result);
	}
}
