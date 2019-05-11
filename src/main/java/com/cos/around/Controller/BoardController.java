package com.cos.around.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.around.Model.Board;
import com.cos.around.Model.BoardDTO;
import com.cos.around.Model.Heart;
import com.cos.around.Repository.BoardRepository;
import com.cos.around.Utils.MyUtils;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
	public Board save(@RequestBody Board board) {
		board.setBoardCreateDate(MyUtils.getCurrentTime());
		board.setBoardUpdateDate(MyUtils.getCurrentTime());
		return boardRepository.save(board);
	}
	
	@GetMapping("/test/findall")
	public List<BoardDTO> findAll() {
		List<Board> boards = boardRepository.findAll();
		List<BoardDTO> bDTOs = new ArrayList<BoardDTO>();
		for (Board b : boards) {
			BoardDTO bDTO = new BoardDTO();
			bDTO.setBoardNum(b.getBoardNum());
			bDTO.setBoardRegion(b.getBoardRegion());
			bDTO.setBoardContent(b.getBoardContent());
			bDTO.setBoardAttach(b.getBoardAttach());
			bDTO.setBoardCreateDate(b.getBoardCreateDate());
			bDTO.setBoardUpdateDate(b.getBoardUpdateDate());
			bDTO.setFeelingNum(b.getFeeling().getFeelingNum());
			bDTO.setUserNum(b.getUser().getUserNum());
			List<Integer> hi = new ArrayList<Integer>();
			for (Heart h : b.getHeart()) {
				hi.add(h.getHeartNum());
			}
			bDTO.setHeartNums(hi);
			
			List<Integer> iTi = new ArrayList<Integer>();
			for (Heart h : b.getHeart()) {
				iTi.add(h.getHeartNum());
			}
			bDTO.setInsertTagNums(iTi);
			
			List<Integer> ri = new ArrayList<Integer>();
			for (Heart h : b.getHeart()) {
				ri.add(h.getHeartNum());
			}
			bDTO.setReplyNums(ri);
			bDTOs.add(bDTO);
		}

		return bDTOs;
	}

	@GetMapping("/test/findby/{num}")
	public Board findByID(@PathVariable int num) {

		Optional<Board> opR = boardRepository.findById(num);
		if (opR.isPresent()) {
			Board board = opR.get();
			System.out.println(board.getUser().getUserNum());
			return board;

		}
		return null;

	}

	@PostMapping("/test/update")
	public Board update(Board board) {

		return boardRepository.save(board);
	}

	@PostMapping("/test/delete/{num}")
	public String delete(@PathVariable int num) {

		boardRepository.deleteById(num);

		return " \"delete\" : " + num;
	}

}
