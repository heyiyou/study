package com.peisia.kioskV07;

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
