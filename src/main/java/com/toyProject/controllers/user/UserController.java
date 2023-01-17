package com.toyProject.controllers.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.toyProject.models.entity.user.RoleType;
import com.toyProject.models.entity.user.User;
import com.toyProject.repository.UserRepository;

import jakarta.transaction.Transactional;

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
	
	@GetMapping("/user/{id}")
	public User findUser(@PathVariable Long id) {
		
		User user = userRepository.findById(id).orElseThrow(() -> {
			// IllegalArgumentException 예외 처리
			throw new IllegalArgumentException("해당하는 아이디가 없습니다 id : " + id);
		});
		
		return user;
	}
	
	@GetMapping("/user")
	public List<User> findAllUser() {
		return userRepository.findAll();
	}
	
	@GetMapping("/user/page/{page}")
	public List<User> pageList(@PageableDefault(size=2, sort="id", direction=Sort.Direction.DESC) Pageable pageable) {
		Page<User> users = userRepository.findAll(pageable);
		List<User> list = users.getContent();
		return list;
	}
	
	@Transactional
	@PutMapping("/user/{id}")
	public void update(@PathVariable Long id, @RequestBody User requestUser) {
		User user = userRepository.findById(id).orElseThrow(() -> {
			// IllegalArgumentException 예외 처리
			throw new IllegalArgumentException("해당하는 아이디가 없습니다 id : " + id);
		});
		
		user.setPassword(requestUser.getPassword());
		user.setEmail(requestUser.getEmail());
		
		// userRepository.save(user);
	}
}
