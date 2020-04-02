package com.itwill.staily.main.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itwill.staily.main.service.MainService;
import com.itwill.staily.mypage.model.dto.Bookmark;

@Controller
public class MainController {
	@Autowired
	private MainService mainService;

	public MainController() {
		
	}
	@RequestMapping("/maintest")
	public ModelAndView test(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv =new ModelAndView();
		try {
			List<Bookmark> bmList = mainService.selectByBookmark(2);
			request.setAttribute("bmList", bmList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("maintest");
		return mv;
	}
}
