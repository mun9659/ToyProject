package com.toyProject.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.toyProject.common.JsonResult;
import com.toyProject.models.entity.user.RoleType;
import com.toyProject.models.entity.user.User;
import com.toyProject.service.user.UserService;

import jakarta.servlet.http.HttpSession;

@RestController
public class UserApiController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/api/join")
	public JsonResult<?> join(@RequestBody User user) {
		System.out.println("UserApiController 발동 : join 함수 작동");
		user.setRole(RoleType.USER);
		userService.join(user);
		return new JsonResult<>(true, "정상적으로 추가되었습니다.", null);
	}
	
	@PostMapping("/api/login")
	public JsonResult<?> login(@RequestBody User user, HttpSession session) {
		System.out.println("UserApiController 발동 : login 함수 작동");
		User principal = userService.login(user).orElseThrow(() -> {
			throw new NullPointerException("로그인 할 아이디/비밀번호가 존재하지 않습니다.");
		});
		
		if(principal != null) session.setAttribute("principal", principal);
		
		return new JsonResult<>(true, "로그인이 완료되었습니다.", null);
	}
	
}
