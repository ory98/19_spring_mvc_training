package com.spring.training.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.training.board.dao.BoardDao;
import com.spring.training.board.dto.BoardDto;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDao boardDao; // boardDao를 스프링이 가져와서 넣어준다. 
	
	@Override
	public void boardWirte(BoardDto boardDto) {
		boardDao.insertBoard(boardDto);
	}

	@Override
	public List<BoardDto> boardList() {
		return boardDao.selectListBoard();
	}

	@Override
	public BoardDto boardInfo(int num) {
		boardDao.updateReadCount(num);
		return boardDao.selectOneBoard(num);
	}
	
	

}
