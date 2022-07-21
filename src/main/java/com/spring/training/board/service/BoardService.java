package com.spring.training.board.service;

import java.util.List;

import com.spring.training.board.dto.BoardDto;

public interface BoardService {
	
	public void boardWirte(BoardDto boardDto) throws Exception; // insert : view > db
	public List<BoardDto> boardList() throws Exception; // select : db > view
	public BoardDto boardInfo(int num) throws Exception;
	public boolean modifyBoard(BoardDto boardDto) throws Exception;
	public boolean removeBoard(BoardDto boardDto) throws Exception;
	
}
