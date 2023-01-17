package com.toyProject.controllers.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toyProject.models.entity.user.RoleType;
import com.toyProject.models.entity.user.User;
import com.toyProject.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/user/join")
	public String join(User user) {
		System.out.println("id : " + user.getId());
		System.out.println("username : " + user.getUsername());
		System.out.println("password : " + user.getPassword());
		System.out.println("email : " + user.getEmail());
		System.out.println("role : " + user.getRole());
		System.out.println("regDt : " + user.getRegDt());
		System.out.println("modDt : " + user.getModDt());
		
		user.setRole(RoleType.USER);
		userRepository.save(user); // Insert 작업
		
		return "회원가입이 완료되었습니다.";
	}
}
