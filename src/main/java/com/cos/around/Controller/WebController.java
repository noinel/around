package com.cos.around.Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cos.around.Model.Board;
import com.cos.around.Model.Heart;
import com.cos.around.Model.HeartCountDTO;
import com.cos.around.Model.InsertTag;
import com.cos.around.Model.Tags;
import com.cos.around.Repository.BoardRepository;
import com.cos.around.Repository.HeartRepository;
import com.cos.around.Repository.InsertTagRepository;
import com.cos.around.Repository.TagsRepository;

@Controller
@RequestMapping("/web")
public class WebController {

	@Autowired
	BoardRepository boardRepository;

	@Autowired
	HeartRepository heartRepository;

	@Autowired
	InsertTagRepository insertTagRepository;

	@Autowired
	TagsRepository tagRepository;

	@GetMapping("/findall")
	public String main(Model model) {
		List<Board> boards = boardRepository.findByBoardActivate(0);
		model.addAttribute("boards", boards);
		return "main";
	}
	@GetMapping("/search")
	public String search(){
		return "search";
	}

	@GetMapping("/detail/{num}")
	public String findByID(@PathVariable int num) {
		// 게시글
		Optional<Board> opR = boardRepository.findById(num);
		Board board = new Board();
		if (opR.isPresent()) {
			board = opR.get();
		}
		System.out.println("2222222222");
		// 우측인기게시글
		List<Integer> popBoardNum = heartRepository.findCountPopularBoard();
		List<Board> popBoards = boardRepository.findAllById(popBoardNum);
		System.out.println("333333");
		// 우측인기 태그
		List<Board> boards= boardRepository.findAll();
		System.out.println("3434343434");
		List<Tags> tags = tagRepository.findAll();
		System.out.println("444444444422221131");
		List<HeartCountDTO> tagHeartCounts = new ArrayList<HeartCountDTO>();
		List<HeartCountDTO> boardHeartCount = new ArrayList<HeartCountDTO>();
		List<Tags> poptags = new ArrayList<Tags>();
		
		System.out.println("4444");
		//보드 하트 카운터 뽑아냄
		for(Board b : boards) {
			int heartCount=b.getHeart().size();
			HeartCountDTO tagHCount = new HeartCountDTO();
			
			tagHCount.setNum(b.getBoardNum());
			tagHCount.setHeartCount(heartCount);
			boardHeartCount.add(tagHCount);
		}
		
		System.out.println("5555555555");

		// 태그 하나 뽑아냄
		for (Tags tag : tags) {
			List<InsertTag> insertTags = tag.getInsertTag();
			HeartCountDTO tagHCount = new HeartCountDTO();
			int heartCount = 0;

			// 태그를 사용한 게시글 하나 뽑아냄
			for (InsertTag insertTag : insertTags) {
				int bNum = insertTag.getBoard().getBoardNum();
				// 게시글의 하트를 더해줌
				for (HeartCountDTO hDTO : boardHeartCount) {
					if (hDTO.getNum() == bNum) {
						heartCount += hDTO.getHeartCount();
					}
				}
			}
			tagHCount.setNum(tag.getTagNum());
			tagHCount.setHeartCount(heartCount);
			tagHeartCounts.add(tagHCount);
		}
		System.out.println("66666666666");
		Collections.sort(tagHeartCounts);
		if(tagHeartCounts.size() > 7){
		tagHeartCounts = tagHeartCounts.subList(0, 7);	
		}
		for(HeartCountDTO hd: tagHeartCounts) {
			Tags tag = new Tags();
			Optional<Tags> tagO =tagRepository.findById(hd.getNum());
			if(tagO.isPresent()) {
				tag= tagO.get();
			}
			
		poptags.add(tag);
		}
		System.out.println("7777777777");
		int prevNum = board.getBoardNum() -1;
		Optional<Board> prevBoardO = boardRepository.findById(prevNum);
		Board prevBoard = new Board();
		if(prevBoardO.isPresent()) {
			prevBoard= prevBoardO.get();
		}
		System.out.println("888888888888");
		int nextNum = board.getBoardNum() -1;
		Optional<Board> nextBoardO = boardRepository.findById(nextNum);
		Board nextBoard = new Board();
		if(nextBoardO.isPresent()) {
			nextBoard= nextBoardO.get();
		}
		
		
		
			
		
		return "insert";
	}
}
