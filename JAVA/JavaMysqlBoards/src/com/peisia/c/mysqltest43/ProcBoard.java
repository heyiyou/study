package com.peisia.c.mysqltest43;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ProcBoard {
	Connection con = null;
	Statement st = null;
	ResultSet result = null;
	Scanner sc = new Scanner(System.in);

	public void run() {
		Display.showTitle();
		dbInit();
		int currentPage = 1;
		final int PER_PAGE = 5;
		boolean isSearching = false;
		String searchKeyword = "";

		loop:
		while (true) {
			dbPostCount();
			Display.showMainMenu();
			System.out.println("명령입력: ");
			String cmd = sc.next();

			switch (cmd) {
			case "1": // 글리스트
				showPostList(currentPage, PER_PAGE, isSearching, searchKeyword);
				break;
			case "2": // 글읽기
				System.out.println("읽을 글 번호를 입력해주세요:");
				int readNo = sc.nextInt();
				showDetail(readNo);
				break;
			case "3": // 글쓰기
				writePost();
				break;
			case "4": // 글삭제
				System.out.println("삭제할 글번호를 입력해주세요:");
				int delNo = sc.nextInt();
				dbExecuteUpdate("DELETE FROM board WHERE b_no=" + delNo);
				break;
			case "5": // 글수정
				editPost();
				break;
			case "s": // 검색
				System.out.println("검색할 제목 키워드 입력:");
				searchKeyword = sc.next();
				isSearching = true;
				currentPage = 1;
				break;
			case "n": // 다음 페이지
				currentPage++;
				break;
			case "p": // 이전 페이지
				if (currentPage > 1) {
					currentPage--;
				} else {
					System.out.println("첫 페이지입니다.");
				}
				break;
			case "a": // 전체 목록 모드로
				isSearching = false;
				currentPage = 1;
				break;
			case "e": // 프로그램 종료
				System.out.println("프로그램 종료");
				break loop;
			default:
				System.out.println("올바른 명령어를 입력하세요.");
			}
		}
	}

	// 게시글 리스트 출력
	private void showPostList(int currentPage, int perPage, boolean isSearching, String searchKeyword) {
		int startIndex = (currentPage - 1) * perPage;
		String sql;
		if (isSearching) {
			sql = "SELECT * FROM board WHERE b_title LIKE '%" + searchKeyword + "%' ORDER BY b_no DESC LIMIT " + startIndex + ", " + perPage;
		} else {
			sql = "SELECT * FROM board ORDER BY b_no DESC LIMIT " + startIndex + ", " + perPage;
		}

		try {
			result = st.executeQuery(sql);
			System.out.println("===== " + (isSearching ? ("검색결과: " + searchKeyword) : "전체목록") + " (" + currentPage + "페이지) =====");
			while (result.next()) {
				String no = result.getString("b_no");
				String title = result.getString("b_title");
				String id = result.getString("b_id");
				String datetime = result.getString("b_datetime");
				System.out.println(no + " " + title + " " + id + " " + datetime);
			}
			System.out.println("==========================");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 글 상세보기
	private void showDetail(int postNo) {
		try {
			result = st.executeQuery("SELECT * FROM board WHERE b_no=" + postNo);
			if (result.next()) {
				System.out.println("===== 글 상세보기 =====");
				System.out.println("글번호: " + result.getInt("b_no"));
				System.out.println("제목: " + result.getString("b_title"));
				System.out.println("작성자: " + result.getString("b_id"));
				System.out.println("작성시간: " + result.getString("b_datetime"));
				System.out.println("본문: " + result.getString("b_text"));
				System.out.println("======================");
			} else {
				System.out.println("해당 글을 찾을 수 없습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 글쓰기
	private void writePost() {
		sc.nextLine(); // 버퍼 비우기
		System.out.println("제목을 입력해주세요:");
		String title = sc.nextLine();
		System.out.println("글내용을 입력해주세요:");
		String content = sc.nextLine();
		System.out.println("작성자id를 입력해주세요:");
		String id = sc.next();

		String sql = "INSERT INTO board (b_title, b_id, b_datetime, b_text, b_hit) "
				+ "VALUES ('" + title + "', '" + id + "', NOW(), '" + content + "', 0)";
		dbExecuteUpdate(sql);
	}

	// 글수정
	private void editPost() {
		System.out.println("수정할 글번호를 입력해주세요:");
		String editNo = sc.next();
		sc.nextLine();
		System.out.println("수정할 제목을 입력해주세요:");
		String edTitle = sc.nextLine();
		System.out.println("수정할 작성자id를 입력해주세요:");
		String edId = sc.next();
		sc.nextLine();
		System.out.println("수정할 글내용을 입력해주세요:");
		String edContent = sc.nextLine();
 
		
		                    //이거 밑에 board 라고 적혀있는데 여기가  테이블 이름 적는곳 연결
		String sql = "UPDATE board SET b_title='" + edTitle + "', b_id='" + edId + "', b_datetime=NOW(), b_text='" + edContent + "' WHERE b_no=" + editNo;
		dbExecuteUpdate(sql);
	}

	// DB 초기 연결
	private void dbInit() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_cat", "root", "root");
			st = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// insert, update, delete용
	private void dbExecuteUpdate(String query) {
		try {
			int resultCount = st.executeUpdate(query);
			System.out.println("처리된 행 수: " + resultCount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 게시글 수 표시
	private void dbPostCount() {
		try {
			result = st.executeQuery("SELECT COUNT(*) FROM board");
			result.next();
			String count = result.getString("COUNT(*)");
			System.out.println("총 글 수: " + count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}