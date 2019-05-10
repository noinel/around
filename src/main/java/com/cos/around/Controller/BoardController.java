package com.cos.around.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.around.Model.Board;
import com.cos.around.Repository.BoardRepository;
import com.cos.around.Utils.MyUtils;

@RestController
@RequestMapping("/board")
public class BoardController {

	@Autowired
	BoardRepository boardRepository;

	@GetMapping("/test")
	@ResponseBody
	public String test() {
		return "test";
	}
	
	@PostMapping("/test/save")
	public Board testSave(Board board) {
		
		board.setBoardCreateDate(MyUtils.getCurrentTime());
		board.setBoardUpdateDate(MyUtils.getCurrentTime());
		
		
		return boardRepository.save(board);
	}
	
	
	
	
	
	
	
	
	
	
}
