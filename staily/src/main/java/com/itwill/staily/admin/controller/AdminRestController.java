package com.itwill.staily.admin.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.itwill.staily.admin.service.AdminService;
import com.itwill.staily.util.Member;

@RestController
public class AdminRestController {
	
	@Autowired
	private AdminService adminService;
	/*
	 구현해야하는 페이지 
	  
	 
	 */
	@RequestMapping("/admin_member")
	public ModelAndView adminBoardForm(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv =new ModelAndView();
		try {
			List<Member> memberList = new ArrayList();
			memberList = adminService.selectMemberAll();
			request.setAttribute("memberList", memberList);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		mv.setViewName("/admin/member");
		return mv;
	}
}
