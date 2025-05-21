package com.peisia.kioskV07;

public class ProcMenuDrink {
	
	public void run() {
		yy:while(true) {
			//메뉴출력
			Kiosk.p1.info();
			Kiosk.p2.info();
			Kiosk.p3.info();
			
			System.out.println("[1.아아/2.뜨아/3.오렌지쥬스/x.이전메뉴로]");   // 옆으로 이어간다 외우기
			System.out.println(""); 
			Kiosk.cmd = Kiosk.sc.next();                        // 밑으로 보내기<"br">랑 같음
			switch(Kiosk.cmd) {
			case "1":
				System.out.println("아아 선택됨");
				
//				Product x = new Product("아아",1000);
				Kiosk.basket.add(Kiosk.p1);
				
				break;
			case "2":
				System.out.println("뜨아 선택됨");
				break;
			case "3":
				System.out.println("오렌지쥬스 선택됨");
				break;
			case "x":
				System.out.println("이전 메뉴 이동");
				break yy;
			}
		}
	}
}
