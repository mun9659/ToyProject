package com.toyProject.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.toyProject.common.JsonResult;

@ControllerAdvice("com.toyProject.controller")
@RestController
public class ExceptionController {
	
	@ExceptionHandler(value=Exception.class)
	public JsonResult<?> handleArgumentException(Exception e) {
		return new JsonResult<>(false, "회원가입이 실패하였습니다.", null);
	}
	
}
