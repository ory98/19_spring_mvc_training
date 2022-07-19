package com.spring.training.board.dao;

import java.util.List;

import com.spring.training.board.dto.BoardDto;

public interface BoardDao {
	
	public void insertBoard(BoardDto boardDto); // void : 반환이 없을 때 
	public List<BoardDto> selectListBoard();	// 앞에 반환 타입 작성 
	public BoardDto selectOneBoard(int num);
	public void updateReadCount(int num);		// 괄호 안에는 받는 타입 작성 
	
}