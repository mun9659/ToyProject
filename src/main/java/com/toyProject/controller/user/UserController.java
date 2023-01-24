package com.toyProject.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
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

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/user/joinForm")
	public String join(Model model) {
		
		model.addAttribute("addScript", new String[] {"join"});
		
		return "user/joinForm";
	}
	
	@GetMapping("/user/loginForm")
	public String login(Model model) {
		
		model.addAttribute("addScript", new String[] {"join"});
		
		return "user/loginForm";
	}
}
