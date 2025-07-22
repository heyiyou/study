package com.cal.mapper; 
import java.util.List;

import com.cal.dto.BoardDto;
 

public interface BoardMapper {
	
	
	//종훈님//
	public void boardRegister(BoardDto dto);
//내가 한 부분 	
int updateBoard(BoardDto dto);
  BoardDto selectBoardById(int id);
  List<BoardDto> selectAllBoards();
}
