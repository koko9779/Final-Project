package com.itwill.staily.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.itwill.staily.admin.service.AdminService;
import com.itwill.staily.util.Member;

@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	public AdminController() {
	}
	@RequestMapping("/test")
	public ModelAndView test(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv =new ModelAndView();
		try {
			Member member = adminService.selectMemberOne(1);
			request.setAttribute("member", member);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("test");
		return mv;
	}
	@RequestMapping("/admin")
	public String adminTest() {
		return "admin/index";
	}
}
