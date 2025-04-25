package com.peisia.easyboard;

import java.util.ArrayList;
import java.util.Scanner;

public class Board {
	Scanner sc = new Scanner(System.in);
	ArrayList<Post> ps = new ArrayList<>();
	int saveNo = 0;

	void run() {

		xx: while (true) {
			// todo
			// 메뉴 선택하게 하기
			System.out.println("crud 1.쓰기 2.읽기 3.리스트. 4.수정 5.삭제 e.프로그램 종료");
			String cmd = sc.next();
			switch (cmd) {
			case "1":
				System.out.println("쓰기");
				System.out.println("제목:");
				String title = sc.next();
				System.out.println("본문:");
				String content = sc.next();
				System.out.println("작성자:");
				String writer = sc.next();
				saveNo = saveNo + 1; // 글 번호 증가
				String no = saveNo + "";
				Post p = new Post(title, content, writer, no);
				ps.add(p);
				break;
			case "2":
				System.out.println("읽기");
				System.out.println("몇번글을 읽을까? :");
				cmd = sc.next();

				for (int i = 0; i < ps.size(); i++) {
					Post post = ps.get(i);
//					String postStringNo = postNo + "";
					if (post.no.equals(cmd)) {
						// if (postNo + " " == cmd) {
//					if (postNo.equals(cmd)) { // 찾았다!
						// 읽기 출력
						System.out.println("글번호:" + post.no + "글내용:" + post.content + "작성자:" + post.writer);
					}
				}
				break;

			case "3":
				System.out.println("리스트");
//				for(int i=0;i<ps.size();i++)
				for (int i = 0; i < ps.size(); i = i + 1) {
					String t = ps.get(i).title;
					String c = ps.get(i).content;
					String w = ps.get(i).writer;
					int no1 = ps.get(i).no(); // 콘솔에 글쓰기 가능한 프로그램
					System.out.println("제목: " + "작성자: " + w);
				}
				break;
			case "4":
				System.out.println("수정");
				System.out.println("몇번을 수정할까여? :");
				cmd = sc.next();

				for (int i = 0; i < ps.size(); i++) {
					Post post = ps.get(i);
					String postStringNo = post.no + "";
					if (postStringNo.equals(cmd)) {
						System.out.println("바꿀내용은? :");
						post.content = sc.next();

					}

				}
				break;

			case "5":
				System.out.println("삭제");
				System.out.println("몇번을 삭제할까여? :");
				cmd = sc.next();
				boolean x = false;                        // 분리 내가 의문이 들었던것은 쓰기에 3개를 넣었다고 가정하고 5삭제쪽에 숫자 말고 아무거나 넣었어 그러면 쓰기에있는 첫번쨰로 넣었던 것이 사라져서 넣은 코드
				int searchNo = 0;
				for (int i = 0; i < ps.size(); i++) {
					Post post = ps.get(i);
					String postStringNo = post.no + "";
					if (postStringNo.equals(cmd)) {// A.equals(B) → A와 B의 내용이 같으면 true, 다르면 false
						// 인덱스를 기억헤넣기
						searchNo = i;
						x = true;
					}
				}
				// 삭제
				if(x) {
					ps.remove(searchNo);					
				}
				
				break;
			case "e":
				System.out.println("프로그램 종료");
				break xx;

			}
		}
	}

	private boolean postStringNo(String cmd) {
		// TODO Auto-generated method stub
		return false;
	}
}