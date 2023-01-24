package com.toyProject.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toyProject.models.entity.user.User;
import com.toyProject.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public void join(User user) {
		userRepository.save(user);
	}
	
}
