package com.cos.around.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.around.Model.Users;
import com.cos.around.Repository.UsersRepository;
import com.cos.around.Utils.MyUtils;

@RestController
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
	UsersRepository usersRepository;
	
	@PostMapping("/test/save")
	public Users save(Users user) {
		user.setUserUpdateDate(MyUtils.getCurrentTime());
		user.setUserCreateDate(MyUtils.getCurrentTime());
		
		
		return usersRepository.save(user); 
	}
}
