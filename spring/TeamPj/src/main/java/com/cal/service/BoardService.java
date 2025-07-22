package com.cal.service;

import java.util.List;

import com.cal.dto.BoardDto;

public interface BoardService {

	BoardDto getBoardById(int id);

	void updateBoard(int id, BoardDto dto);

	List<BoardDto> getBoardList();
//종훈님
	public void boardRegister(BoardDto dto);

}