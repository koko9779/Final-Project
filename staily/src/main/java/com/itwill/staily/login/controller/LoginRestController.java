package com.itwill.staily.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.staily.login.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginRestController {
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value = "/login_error_id", produces = "text/plain;charset=UTF-8")
	public String login_error_id(@RequestParam String msg) {
		String errorMsg = 
		"<label id='user_id-error' class='error' for='user_id'>"+msg+"</label>";
		return errorMsg;
	}
	
	@RequestMapping(value = "/login_error_pw", produces = "text/plain;charset=UTF-8")
	public String login_error_pw(@RequestParam String msg) {
		String errorMsg = 
		"<label id='user_pw-error' class='error' for='user_pw'>"+msg+"</label>";
		return errorMsg;
	}
}
