package com.spring.training.board.service;

import java.util.List;

import com.spring.training.board.dto.BoardDto;

public interface BoardService {
	
	public void boardWirte(BoardDto boardDto); // insert : view > db
	public List<BoardDto> boardList(); // select : db > view
	public BoardDto boardInfo(int num);
	public boolean modifyBoard(BoardDto boardDto);
}
