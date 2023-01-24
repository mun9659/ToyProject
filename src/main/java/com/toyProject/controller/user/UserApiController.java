package com.toyProject.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.toyProject.common.JsonResult;
import com.toyProject.models.entity.user.RoleType;
import com.toyProject.models.entity.user.User;
import com.toyProject.service.user.UserService;

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
	
}
