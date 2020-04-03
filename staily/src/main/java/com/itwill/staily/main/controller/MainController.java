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
import com.itwill.staily.util.Product;
import com.itwill.staily.util.Work;

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
			request.setAttribute("mNo", 2);
			
			List<Product> hotList = mainService.selectByView();
			request.setAttribute("hotList", hotList);
			
			List<Work> todayList = mainService.selectTodayOfWork();
			request.setAttribute("todayList", todayList);
			
			List<Work> dramaList = mainService.selectByCategory("d");
			request.setAttribute("dramaList", dramaList);
			
			List<Work> movieList = mainService.selectByCategory("m");
			request.setAttribute("movieList", movieList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("maintest");
		return mv;
	}
	/*
	@RequestMapping("/maintest2")
	public ModelAndView test2(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("maintest2");
		return mv;
	}
	*/
}
