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

import com.cos.around.Model.Users;

import com.cos.around.Repository.UsersRepository;
import com.cos.around.Utils.MyUtils;

@RestController
@RequestMapping("/users")
public class UsersController {

	@Autowired
	UsersRepository userRepository;

	@PostMapping("/test/save")
	public Users save(@RequestBody Users user) {

		user.setUserActivate(1);
	
		return userRepository.save(user);
	}

	@GetMapping("/test/findall")
	public List<Users> findAll() {

		return userRepository.findAll();
	}

	@GetMapping("/test/findby/{num}")
	public Users findByID(@PathVariable int num) {

		Optional<Users> opR = userRepository.findById(num);
		if (opR.isPresent()) {
			Users user = opR.get();
			System.out.println(user.getUserRegion().getRegionName());
			return user;
		}
		return null;

	}

	@PostMapping("/test/update")
	public Users update(Users user) {
		System.out.println(user.getUserNum());

		return userRepository.save(user);
	}

	@PostMapping("/test/delete/{num}")
	public String delete(@PathVariable int num) {

		userRepository.deleteById(num);

		return " \"delete\" : " + num;
	}
}
