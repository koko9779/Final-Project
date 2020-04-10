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
import com.itwill.staily.util.Company;
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
			forwardPath = "redirect:/404.jsp";
		}
		return forwardPath;
	}
	
	@RequestMapping(value = "/logout_action")
	public String logout_action(HttpSession session) {
		session.invalidate();
		return "login/main";
	}
	
	@RequestMapping(value = "/id_read")
	public String id_read() {
		return "login/id_read";
	}
	
	@RequestMapping(value = "/id_read_action", method = RequestMethod.GET)
	public String id_read_action_get() {
		return "login/id_read";
	}
	
	@RequestMapping(value = "/id_read_action", method = RequestMethod.POST)
	public String find_id_action_post(@RequestParam String name, String phone, Model model) {
		String forwardPath = "";
		String findId = "";
		try {
			findId = loginService.findId(phone, name);
			model.addAttribute("findId", findId);
			
			forwardPath = "login/login";
		} catch(NoSearchMemberException e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			forwardPath = "login/id_read";
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath = "redirect:/404.jsp";
		}
		return forwardPath;
	}
	
	@RequestMapping(value = "/pw_count_read")
	public String pw_read() {
		return "login/pw_count_read";
	}
	
	@RequestMapping(value = "/pw_count_read_action", method = RequestMethod.GET)
	public String pw_count_read_action_get() {
		return "login/pw_count_read";
	}
	
	@RequestMapping(value = "/pw_count_read_action", method = RequestMethod.POST)
	public String pw_count_read_action_post(@RequestParam String id, String phone, Model model) {
		String forwardPath = "";
		
		try {
			loginService.isIdExistForPw(id, phone);
			model.addAttribute("id", id);
			forwardPath = "login/pw_update";
		}catch(NoSearchMemberException e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			forwardPath = "login/pw_count_read";
		}catch(Exception e) {
			e.printStackTrace();
			forwardPath = "redirect:/404.jsp";
		}
		return forwardPath;
	}
	
	@RequestMapping(value = "/pw_update", method = RequestMethod.GET)
	public String update_pw_get() {
		return "login/pw_count_read";
	}
	
	@RequestMapping(value = "/pw_update", method = RequestMethod.POST)
	public String update_pw_post(@RequestParam String id, String pw) {
		String forwardPath = "";
		Member updateMember = new Member();
		updateMember.setmId(id);
		updateMember.setmPw(pw);
		
		try {
			loginService.updatePw(updateMember);
			forwardPath = "login/login";
		} catch(Exception e) {
			e.printStackTrace();
			forwardPath = "redirect:/404.jsp";
		}
		return forwardPath;
	}
	
	
	@RequestMapping(value = "/member_create")
	public String member_create() {
		return "login/member_create";
	}
	
	@RequestMapping(value = "/member_create_action", method = RequestMethod.GET)
	public String member_create_action_get() {
		return "login/member_create";
	}
	
	@RequestMapping(value = "/member_creater_action", method = RequestMethod.POST)
	public String member_create_action_post(@ModelAttribute Member signupMember, String coNo, Model model) {
		String forwardPath = "";
		
		try {
			if(signupMember.getmType().equals("M")) {
				loginService.signUpMember(signupMember);
			}else if(signupMember.getmType().equals("C")) {
				Company com = new Company();
				int intCoNo = Integer.parseInt(coNo);
				com.setCoNo(intCoNo);
				
				signupMember.setmCompany(com);
				loginService.signUpCompany(signupMember);
			}
			forwardPath = "login/login";
		}catch(Exception e) {
			e.printStackTrace();
			forwardPath = "redirect:/404.jsp";
		}
		return forwardPath; 
	}
	
	
	
	
	
	
	
}  
