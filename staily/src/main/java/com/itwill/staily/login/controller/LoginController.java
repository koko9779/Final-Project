package com.itwill.staily.login.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.staily.login.exception.NoExistedIdException;
import com.itwill.staily.login.exception.NoSearchMemberException;
import com.itwill.staily.login.exception.PasswordMissmatchException;
import com.itwill.staily.login.service.LoginService;
import com.itwill.staily.util.Member;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	public LoginController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(value = "/login")
	public String login() {
		return "login/login";
	}
	
	
	@RequestMapping(value = "/login_action", method = RequestMethod.GET)
	public String login_action_get() {
		return "login/login";
	}
	
	//에러 떳을 시 부분 아작스
	@RequestMapping(value = "/login_action", method = RequestMethod.POST)
	public String login_action_post(@RequestParam String userId, String userPw, HttpSession session, Model model) {
		String forwardPath = "";
		Member member = new Member();
		Member successMember;
		member.setmId(userId);
		member.setmPw(userPw);
		
		try {
			successMember = loginService.login(member);
			session.setAttribute("userId", successMember.getmId());
			session.setAttribute("userNo", successMember.getmNo());
			
			forwardPath = "login/main";
		} catch (NoExistedIdException e) {
				e.printStackTrace();
				model.addAttribute("msg", e.getMessage());
				forwardPath = "login/login";
		} catch (PasswordMissmatchException e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			forwardPath = "login/login";
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath = "에러...";
		}
		return forwardPath;
	}
	
	@RequestMapping(value = "/logout_action")
	public String logout_action(HttpSession session) {
		session.invalidate();
		return "login/main";
	}
	
	@RequestMapping(value = "/find_id")
	public String find_id() {
		return "login/find_id";
	}
	
	@RequestMapping(value = "/find_id_action", method = RequestMethod.GET)
	public String find_id_action_get() {
		return "login/find_id";
	}
	
	//아작스...?
	@RequestMapping(value = "/find_id_action", method = RequestMethod.POST)
	public String find_id_action_post(@RequestParam String name, String phone, Model model) {
		String forwardPath = "";
		String findId = "login/find_id";
		try {
			findId = loginService.findId(phone, name);
			model.addAttribute("findId", findId);
			
			forwardPath = "login/find_id_show";
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath = "/에러페이지..";
		}
		//알럿창으로 띄우기 id 보여주기...
		return forwardPath;
	}

	@RequestMapping(value = "/find_pw")
	public String find_pw() {
		return "login/find_pw";
	}
	
	//아작스...?
	@RequestMapping(value = "/find_pw_action", method = RequestMethod.POST)
	public String find_pw_action_post(@RequestParam String id, String phone, Model model) {
		String forwardPath = "";
		int successCount = 0;
		
		try {
			successCount = loginService.isIdExistForPw(id, phone);
			if(successCount == 1) {
				forwardPath = "login/modify_pw";
			}else {
				//알럿창으로 아이디가 존재하지 않습니다
				forwardPath = "login/에러...";
			}
		}catch(NoSearchMemberException e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			forwardPath = "login/...";
		}catch(Exception e) {
			e.printStackTrace();
			forwardPath = "/에러페이지..";
		}
		return forwardPath;
	}
	
	@RequestMapping(value = "/signup")
	public String singup_member() {
		return "login/signup";
	}
	
	@RequestMapping(value = "/signup_action", method = RequestMethod.GET)
	public String singup_member_action_get() {
		return "login/signup";
	}
	
	@RequestMapping(value = "/signup_action", method = RequestMethod.POST)
	public String singup_member_action_post(@ModelAttribute Member signupMember, Model model) {
		String forwardPath = "";
		
		try {
			if(signupMember.getmType().equals("M")) {
				loginService.signUpMember(signupMember);
			}else if(signupMember.getmType().equals("C")) {
				loginService.signUpCompany(signupMember);
			}
			forwardPath = "login/login";
		}catch(PasswordMissmatchException e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			forwardPath = "login/signup";
		}catch(Exception e) {
			e.printStackTrace();
			forwardPath = "/에러페이지..";
		}
		return forwardPath;
	}
	
	
	
	
	
	
	
}  
