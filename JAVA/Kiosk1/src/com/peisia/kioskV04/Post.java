package com.peisia.kioskV04;

public class Post {
	int no;
	String title;
	String content;
	String writer;
	
	public Post(String t, String c, String w, int saveNo) {
		title = t;
		content = c;
		writer = w;
		no = saveNo;
	}
}
