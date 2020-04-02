package com.itwill.staily.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.staily.login.service.LoginService;
import com.itwill.staily.util.Member;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "로그인페이지";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login_action(@RequestParam String userId, String userPw) {
		Member member = new Member();
		Member successMember;
		member.setmId(userId);
		member.setmPw(userPw);
		
		successMember = loginService.login(member);
		//이 뒤 작업 해야함. session에 박아넣기
		
		return "메인화면";
	}
	
}
