package com.itwill.staily.login.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.staily.login.service.LoginService;
import com.itwill.staily.util.Member;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	public LoginController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login/login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login_action(@RequestParam String userId, String userPw, HttpSession session) {
		Member member = new Member();
		Member successMember;
		member.setmId(userId);
		member.setmPw(userPw);
		
		successMember = loginService.login(member);

		session.setAttribute("userId", successMember.getmId());
		session.setAttribute("userNo", successMember.getmNo());
		
		return "login/main";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout_action_get(HttpSession session) {
		return "login/main";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout_action_post(HttpSession session) {
		session.invalidate();
		return "login/main";
	}
	
	@RequestMapping(value = "/find_id", method = RequestMethod.GET)
	public String find_id_get() {
		return "login/find_id";
	}
	
	/************************************ 질문 ********************************************/
	@RequestMapping(value = "/find_id", method = RequestMethod.POST)
	public String find_id_action(@RequestParam String name, String phone, Model model) {
		String findId = "";
		
		findId = loginService.findId(phone, name);
		model.addAttribute("findId", findId);
		//알럿창으로 띄우기 id 보여주기...
		return "login/login";
	}
	/********************************************************************************/
	@RequestMapping(value = "/find_pw", method = RequestMethod.GET)
	public String find_pw_get() {
		return "login/find_pw";
	}
	
	/************************************ 질문 ********************************************/
	@RequestMapping(value = "/find_pw", method = RequestMethod.POST)
	public String find_pw_action(@RequestParam String id, String phone) {
		String forwardPath = "";
		int successCount = 0;
		
		successCount = loginService.isIdExist(id, phone);
		if(successCount == 1) {
			forwardPath = "login/modify_pw";
		}else {
			//알럿창으로 아이디가 존재하지 않습니다
			forwardPath = "login/...";
		}
		
		return forwardPath;
	}
	/********************************************************************************/
	
	@RequestMapping(value = "/singup", method = RequestMethod.GET)
	public String singup_member() {
		return "login/login";
	}
	
	@RequestMapping(value = "/singup", method = RequestMethod.POST)
	public String singup_member_action() {
		
		return "login/login";
	}
	
	
	
	
	
	
	
}
