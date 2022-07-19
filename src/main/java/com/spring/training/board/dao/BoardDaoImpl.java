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
	public void insertBoard(BoardDto boardDto) {
		sqlSession.insert("board.insertBoard" , boardDto); // Mapper의 namespace/id
	}

	@Override
	public List<BoardDto> selectListBoard() { //MAPPER에서 데이터를 가져오고 
		return sqlSession.selectList("board.selectListBoard"); 
		// 데이터를 다시 담아서 돌려줌 서비스 > controller > view까지 넘어감.
	}

	@Override
	public BoardDto selectOneBoard(int num) {
		return sqlSession.selectOne("board.selectOneBoard" , num);
	}

	@Override
	public void updateReadCount(int num) {
		sqlSession.update("board.updateReadCount" , num);
	}
	
	

	

	
	
	

}
