package com.toyProject.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.toyProject.models.entity.Member;

@RestController
public class HttpControllerTest {
	// http://localhost:3000/http/get
	@GetMapping("http/get")
	public String getTest(Member m) {
		return "get 요청 : " + m.getId() + " | " + m.getPassword() + " | " + m.getUsername() + " | " + m.getEmail();
	}
	// http://localhost:3000/http/post
	@PostMapping("http/post")
	public String postTest(@RequestBody Member m) {
		return "post 요청 : " + m.getId() + " | " + m.getPassword() + " | " + m.getUsername() + " | " + m.getEmail();
	}
	// http://localhost:3000/http/put
	@PutMapping("http/put")
	public String putTest() {
		return "put 요청";
	}
	// http://localhost:3000/http/delete
	@DeleteMapping("http/delete")
	public String deleteTest() {
		return "delete 요청";
	}
}
