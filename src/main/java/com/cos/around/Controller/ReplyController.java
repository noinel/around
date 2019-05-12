package com.cos.around.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.around.Model.Reply;
import com.cos.around.Repository.ReplyRepository;

@RestController
@RequestMapping("/reply")
public class ReplyController {

	@Autowired
	ReplyRepository replyRepository;

	@PostMapping("/test/save")
	public Reply save(Reply reply) {

		return replyRepository.save(reply);
	}

	@GetMapping("/test/findall")
	public List<Reply> findAll() {

		return replyRepository.findAll();
	}

	@GetMapping("/test/findby/{num}")
	public Reply findByID(@PathVariable int num) {

		Optional<Reply> opR = replyRepository.findById(num);
		if (opR.isPresent()) {
			Reply reply = opR.get();
			return reply;
		}
		return null;

	}

	@PostMapping("/test/update")
	public Reply update(Reply reply) {

		return replyRepository.save(reply);
	}

	@PostMapping("/test/delete/{num}")
	public String delete(@PathVariable int num) {

		replyRepository.deleteById(num);

		return " \"delete\" : " + num;
	}
}
