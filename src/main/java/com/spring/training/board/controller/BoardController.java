package com.spring.training.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.training.board.dto.BoardDto;
import com.spring.training.board.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService; // boardServiceImpl을 불러왔다. (형식을 사용하여 불러옴)
	
	@RequestMapping(value="/boardWrite" , method=RequestMethod.GET)
	public ModelAndView boardWrite() {
		return new ModelAndView("board/bWrite"); // 변수 생략 (jsp파일)
	}
	
	@RequestMapping(value="/boardWrite" , method=RequestMethod.POST) // 게시글 내용을 가지고와야함.
	public ModelAndView boardWrite(BoardDto boardDto) { // 받아오는 형식
		boardService.boardWirte(boardDto); // (디비 연결)서비스의 준다. (인터페이스에 선언한 후에 impl에 작성하기)
		return new ModelAndView("redirect:boardList"); // redirect : 뒤의 컨트롤로 이동하게 해준다 > 리스트를 보여줌
	}
	
	@RequestMapping(value="/boardList" , method=RequestMethod.GET)
	public ModelAndView boardList() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/bList");	// jsp 파일 
		mv.addObject("boardList", boardService.boardList()); //  내용을 같이 가지고 감 (키, 서비스 ) > 이때 키는 JSP의 ITEM으로 간다.
		return mv;
	}
	
	@RequestMapping(value="/boardInfo" , method=RequestMethod.GET)
	public ModelAndView boardInfo(@RequestParam("num") int num) {
		ModelAndView mv= new ModelAndView();
		mv.setViewName("board/bInfo");
		mv.addObject("boardDto", boardService.boardInfo(num));
		return mv;
		
	}
}
