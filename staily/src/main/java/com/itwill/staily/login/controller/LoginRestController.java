package com.itwill.staily.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.staily.login.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginRestController {
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value = "/signup_Id_check", produces = "application/json", method = RequestMethod.POST)
	public int signup_Id_check(@RequestParam String mId) throws Exception {
		return loginService.isExistedId(mId);
	}
	
	
}
