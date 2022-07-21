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
	public void boardWirte(BoardDto boardDto) throws Exception{  // 오류처리를 서비스에서 한다. > 컨트롤러로도 보낼 수 있다.
		boardDao.insertBoard(boardDto);
	}

	@Override
	public List<BoardDto> boardList() throws Exception{
		return boardDao.selectListBoard();
	}

	@Override
	public BoardDto boardInfo(int num) throws Exception{ // 하나의 게시글을 열람할 때
			boardDao.updateReadCount(num);
			return boardDao.selectOneBoard(num);		
	}

	@Override
	public boolean modifyBoard(BoardDto boardDto) throws Exception{
		boolean isUpdate = false;
		
		if (boardDao.validateUserCheck(boardDto) != null) { // 아이디와 비밀번호가 맞을 경우 
			boardDao.updateBoard(boardDto); // Dao에 넘겨주는 타입 작성이 수정이기 때문에 여러가지를 담고 있기 때문에 Dto사용
			isUpdate = true;
		}
		return isUpdate;
	}

	@Override
	public boolean removeBoard(BoardDto boardDto) throws Exception{
		boolean isDelete = false;
		
		if (boardDao.validateUserCheck(boardDto) != null) {
			boardDao.deleteBoard(boardDto.getNum()); // Dao에 넘겨주는 타입 작성 
			isDelete = true;
		}
		return isDelete;
	}

	
	
	

}
