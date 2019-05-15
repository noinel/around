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
import com.cos.around.Model.InsertTag;
import com.cos.around.Model.MainDTO;
import com.cos.around.Model.Tags;
import com.cos.around.Repository.BoardRepository;
import com.cos.around.Repository.InsertTagRepository;
import com.cos.around.Repository.TagsRepository;

@RestController
@RequestMapping("/board")
public class BoardController {

	@Autowired
	BoardRepository boardRepository;
	
	@Autowired
	TagsRepository tagsRepository;
	
	@Autowired
	InsertTagRepository insertTagRepository;
	
	
	
	@GetMapping("/test")
	@ResponseBody
	public String test() {
		return "test";
	}

	@PostMapping("/test/save")
	public Board save(@RequestBody Board board) {
		System.out.println(board);	
//		List<String> tagNames = new ArrayList<String>();
		List<InsertTag> insTags= board.getInsertTag();
//		for(InsertTag insTag : insTags) {
//			String tagName = insTag.getTag().getTagName();
//			tagNames.add(tagName);
//		}
//		int len = tagNames.size();
		
		if(insTags == null) {
			return null;
		}
		int len = insTags.size();
		
		for(int i = 0; i< len ; i++)
		{
			Tags tag = insTags.get(i).getTag();
			Optional<Tags> opTag = tagsRepository.findByTagName(tag.getTagName());
			if(opTag.isPresent()) {
				tag.setTagNum(opTag.get().getTagNum());
			}else {
				tagsRepository.save(tag);
			}	
		}
		   Board result =    boardRepository.save(board);
		   for(InsertTag insTag : insTags) {
			   insTag.getBoard().setBoardNum(result.getBoardNum());
			   insertTagRepository.save(insTag);
			   
		   }
			return result;
	}
	
	
	@GetMapping("/test/findall")
	public List<Board> findAll() {
		
		return boardRepository.findAll();
		
	}
	
	@GetMapping("/test/find/main")
	public MainDTO mainDTO() {
		
		MainDTO mDTO = new MainDTO();
		
		Optional<Board> opR = boardRepository.findById(5);
		
		if (opR.isPresent()) {
			
			Board b = opR.get();
			
			mDTO.setBoardNum(b.getBoardNum());
			
			mDTO.setBoardContent(b.getBoardContent());
			
			mDTO.setBoardRegion(b.getBoardRegion());
			
			mDTO.setBoardCreateDate(b.getBoardCreateDate());
			
			mDTO.setBoardUpdateDate(b.getBoardUpdateDate());
			
			mDTO.setUser(b.getUser());
			
			mDTO.setHearts(b.getHeart());
			
			mDTO.setFeeling(b.getFeeling());
			
			return mDTO;
			
			
			
		}
		
		
		
		
		
		return null;
	}
	

	@GetMapping("/test/findby/{num}")
	public Board findByID(@PathVariable int num) {

		Optional<Board> opR = boardRepository.findById(num);
		if (opR.isPresent()) {
			Board board = opR.get();
			
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
