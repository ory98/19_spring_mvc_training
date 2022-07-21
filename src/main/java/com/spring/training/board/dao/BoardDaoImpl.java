package com.spring.training.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.training.board.dto.BoardDto;

@Repository
public class BoardDaoImpl implements BoardDao {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void insertBoard(BoardDto boardDto) throws Exception{ // 던지는 이유 : 에러 관리를 서비스에서 관리하기 위해
		sqlSession.insert("board.insertBoard" , boardDto); // Mapper의 namespace/id
	}

	@Override
	public List<BoardDto> selectListBoard() throws Exception{ //MAPPER에서 데이터를 가져오고 
		return sqlSession.selectList("board.selectListBoard"); 
		// 데이터를 다시 담아서 돌려줌 서비스 > controller > view까지 넘어감.
	}

	@Override
	public BoardDto selectOneBoard(int num) throws Exception{
		return sqlSession.selectOne("board.selectOneBoard" , num);
	}

	@Override
	public void updateReadCount(int num) throws Exception{
		sqlSession.update("board.updateReadCount" , num);
	}

	@Override
	public BoardDto validateUserCheck(BoardDto boardDto) throws Exception{
		return sqlSession.selectOne("board.validateUserCheck", boardDto);
	}

	@Override
	public void updateBoard(BoardDto boardDto) throws Exception{
		sqlSession.update("board.updateBoard" , boardDto);
	}

	@Override
	public void deleteBoard(int num) throws Exception{
		sqlSession.delete("board.deleteBoard", num);
	}
	
	

	

	
	
	

}
