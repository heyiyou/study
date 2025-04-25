package com.peisia.easyboard;

public class Post {
	public Post(String title2, String content2, String writer2) {
		// TODO Auto-generated constructor stub
	}

	String title;
	String content;
	String writer;
	String no;

	public Post(String t, String c, String w, String saveNo) {
		this.title = t;
		this.content = c;
		this.writer = w;
		this.no = saveNo;
	}

	public int no() {
		// TODO Auto-generated method stub
		return Integer.parseInt(no);
	}
}