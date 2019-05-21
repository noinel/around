package com.cos.around.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cos.around.Model.Board;
import com.cos.around.Repository.BoardRepository;

@Service
public class BoardService{
	
	@Autowired
	private BoardRepository boardRepository;
	
	public Board create(Optional<Board> optionalBoard) {
		if(optionalBoard.isPresent()) {
		Board board = optionalBoard.get();
		
		Board result = boardRepository.save(board);
	
		return result;
		}else {
			return null;
		}
	}
	
}
