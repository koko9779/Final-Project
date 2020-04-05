package com.itwill.staily.main.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	@RequestMapping("/main/main")
	public String test(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			List<Bookmark> bmList = mainService.selectByBookmark(4);
			request.setAttribute("bmList", bmList);
			request.setAttribute("mNo", 4);
			
			List<Product> hotList = mainService.selectByView();
			request.setAttribute("hotList", hotList);
			
			List<Work> todayList = mainService.selectTodayOfWork();
			request.setAttribute("todayList", todayList);
			
			List<Work> dramaList = mainService.selectByCategory("D");
			request.setAttribute("dramaList", dramaList);
			
			List<Work> movieList = mainService.selectByCategory("M");
			request.setAttribute("movieList", movieList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "maintest";
	}
}
