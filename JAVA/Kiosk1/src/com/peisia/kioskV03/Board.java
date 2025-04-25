package com.peisia.kioskV03;

import java.util.ArrayList;
import java.util.Scanner;

public class Board {
	Scanner sc = new Scanner(System.in);
	ArrayList<Post> ps = new ArrayList<>();
	int saveNo = 0;
	
	void run() {
		xx:while(true) {
			//todo
			//메뉴 선택하게 하기
			System.out.println("crud 1.쓰기 2.읽기 3.리스트 4.수정 5.삭제 e.프로그램 종료");
			String cmd = sc.next();
			switch(cmd) {
			case "1":
				System.out.println("쓰기");
				System.out.println("제목:");
				String title = sc.next();
				System.out.println("본문:");
				String content = sc.next();
				System.out.println("작성자:");
				String writer = sc.next();
				saveNo = saveNo + 1;
				Post p = new Post(title,content,writer,saveNo);
				ps.add(p);
				break;
			case "2":
				System.out.println("읽기");
				//몇번글을 읽을지 물어보기
				System.out.println("몇번글을 읽을까요? :");
				cmd = sc.next();
				
				//해당 글을 찾기
				for(int i=0;i<ps.size();i=i+1) {
					Post post = ps.get(i);
					
//					int postNo = post.no;
//					String postStringNo = postNo + "";
					String postStringNo = post.no + "";
					
//					if(postStringNo == cmd) {
					if(postStringNo.equals(cmd)) {	//찾았다!
						//읽기(출력)
						System.out.println("글번호:"+post.no+" 글내용:"+post.content+" 작성자:"+post.writer);
					}
				}
				break;
			case "3":
				System.out.println("리스트");
//				for(int i=0;i<ps.size();i++)
				for(int i=0;i<ps.size();i=i+1) {
					String t = ps.get(i).title;
					String c = ps.get(i).content;
					String w = ps.get(i).writer;
					int no = ps.get(i).no;
					System.out.println("글번호:"+no+"제목: "+t+" 작성자: "+w);
				}
				break;
			case "4":
				System.out.println("수정");
				break;
			case "5":
				System.out.println("삭제");
				break;
			case "e":
				System.out.println("프로그램종료");
				break xx;
			}
		}
	}
}
