package com.cos.around.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cos.around.Model.Board;
import com.cos.around.Repository.BoardRepository;

@Controller
@RequestMapping("/web")
public class WebController {
	
	@Autowired
	BoardRepository boardRepository;
	
	
	
	
	@GetMapping
	public String main(Model model) {
		List<Board> boards= boardRepository.findAll();
		model.addAttribute("boards", boards);
		return "main";
	}

}
