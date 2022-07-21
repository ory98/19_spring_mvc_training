package com.spring.training.board.dao;

import java.util.List;

import com.spring.training.board.dto.BoardDto;

public interface BoardDao {
	
	public void insertBoard(BoardDto boardDto) throws Exception; // void : 반환이 없을 때 
	public List<BoardDto> selectListBoard() throws Exception;	// 앞에 반환 타입 작성 
	public BoardDto selectOneBoard(int num) throws Exception;
	public void updateReadCount(int num) throws Exception;		// 괄호 안에는 받는 타입 작성 
	public BoardDto validateUserCheck(BoardDto boardDto) throws Exception;
	public void updateBoard(BoardDto boardDto) throws Exception;
	public void deleteBoard(int num) throws Exception; // 서비스에서 num으로 보내줌 
}