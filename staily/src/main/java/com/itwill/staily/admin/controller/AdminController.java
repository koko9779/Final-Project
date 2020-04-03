package com.itwill.staily.admin.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.itwill.staily.admin.service.AdminService;
import com.itwill.staily.util.Member;
import com.itwill.staily.util.Product;

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
			List<Product>productList = adminService.selectProductAll();
			request.setAttribute("productList", productList);
			request.setAttribute("member", member);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("test");
		return mv;
	}
	@RequestMapping("/admin.do")
	public String adminTest() {
		return "admin/index";
	}
	
	@RequestMapping("/admin_member.do")
	public ModelAndView memberAdminForm(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv =new ModelAndView();
		try {
			List<Member> memberList = new ArrayList();
			memberList = adminService.selectMemberAll();
			request.setAttribute("data", memberList);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		mv.setViewName("/admin/member");
		return mv;
	}
	@RequestMapping("/admin_product.do")
	public ModelAndView productAdminForm(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		try {
			List<Product> productList= new ArrayList();
			productList = adminService.selectProductAll();
			request.setAttribute("data", productList);
		}catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("/admin/product");
		return mv;
	}
}
