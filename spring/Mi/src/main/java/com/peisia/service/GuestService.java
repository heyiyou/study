package com.peisia.service;

import java.util.ArrayList;

import com.peisia.dto.GuestDto;


public interface GuestService {
	public ArrayList<GuestDto> getList(int currentPage);                //페이지 1 수정
	public GuestDto read(long bno);
	public void del(long bno);
	public void write(GuestDto dto);
	public void modify(GuestDto dto);
}
