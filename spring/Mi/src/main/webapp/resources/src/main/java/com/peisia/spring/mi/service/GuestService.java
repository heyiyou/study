package com.peisia.spring.mi.service;


import com.peisia.spring.mi.vo.GuestVO;

public interface GuestService {
	public BoardListProcessor getList(int currentPage);
	public GuestVO read(long bno);
	public void del(long bno);
	public void write(GuestVO gvo);
	public void modify(GuestVO gvo);
}
