package com.cos.around.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.around.Model.Tags;
import com.cos.around.Repository.TagsRepository;

@RestController
@RequestMapping("/tags")
public class TagsController {

	@Autowired
	TagsRepository tagRepository;

	@PostMapping("/test/save")
	public Tags save(@RequestBody Tags tag) {

		return tagRepository.save(tag);
	}

	@GetMapping("/test/findall")
	public List<Tags> findAll() {

		return tagRepository.findAll();
	}

	@GetMapping("/test/findby/{num}")
	public Tags findByID(@PathVariable int num) {

		Optional<Tags> opR = tagRepository.findById(num);
		if (opR.isPresent()) {
			Tags tag = opR.get();
			return tag;
		}
		return null;

	}

	@PostMapping("/test/update")
	public Tags update(Tags tag) {

		return tagRepository.save(tag);
	}

	@PostMapping("/test/delete/{num}")
	public String delete(@PathVariable int num) {

		tagRepository.deleteById(num);

		return " \"delete\" : " + num;
	}
}
