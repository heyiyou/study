package com.peisia.kioskV06;

public class Post {
	
	/* [버전0.0.6] */
	/* 에서 수정한 코드 */
	//todo
	////	외부에서 접근하는 변수들도 이미 있지만 FM 원칙으로 private 을 걸고
	////	그래서 에러나는 코드에 대해 해결책으로 get set 함수 추가 처리도 해보겠음
	private int no = 0;
	private String title;
	private String content;
	private String writer;
	
	public Post(int no, String title, String content, String writer) {
		this.no = no;
		this.title = title;
		this.content = content;
		this.writer = writer;
	}
	
	void info() {
		String s  = String.format("글번호: %s 제목: %s 작성자: %s", no, title, writer);
		System.out.println(s);
	}
	void infoForRead() {
		String s  = String.format("글번호: %s 제목: %s 작성자: %s", no, title, writer);
		System.out.println("================================================");
		System.out.println(s);
		System.out.println("================================================");
		System.out.println(content);
		System.out.println("================================================");
	}

	/* [버전0.0.6] */
	// 참고: getㅇㅇㅇ setㅁㅁㅁ 함수 자동 생성하는법
	// 현재 편집창에서 마우스우클릭-소스-제너레이트 게터세터
	// -자동으로 생성하고 싶은 멤버변수들 체크하고 엔터. 끝.
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}	
}