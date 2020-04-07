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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.itwill.staily.main.service.ListService;
import com.itwill.staily.main.service.MainService;
import com.itwill.staily.mypage.model.dto.Bookmark;
import com.itwill.staily.util.Product;
import com.itwill.staily.util.Work;

@Controller
@RequestMapping("/main")
public class MainController {
	@Autowired
	private MainService mainService;
	@Autowired
	private ListService listService;

	public MainController() {
		
	}

	@RequestMapping("/index")
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

		return "index2";
	}
	@RequestMapping("/worklist")
	public String workList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			
			request.setAttribute("mNo", 4);
			
			Work w = listService.selectWorkOne(1);
			request.setAttribute("w", w);
			int tepisode = listService.selectTepisode(1);
			request.setAttribute("tepisode", tepisode);
			/*
			 * wNo값을 받아서 상품뽑아내기
			 * wdEpisode 값이 null이라면 일반정렬
			 * 				 null이 아니라면 회차별 정렬
			 */
			
			List<Work> cw = listService.selectCProductList(4);
			request.setAttribute("cw", cw);
			
			List<Work> mw = listService.selectMProductList(4);
			request.setAttribute("mw", mw);
			
			Map map1 = new HashMap();
			map1.put("wNo", 4);
			map1.put("wdEpisode", 1);
			List<Work> cwe = listService.selectCProductListByEpisode(map1);
			request.setAttribute("cwe", cwe);

			map1.put("wNo", 4);
			map1.put("wdEpisode", 1);
			List<Work> mwe = listService.selectMProductListByEpisode(map1);
			request.setAttribute("mwe", mwe);
	
			int pCnt = listService.selectProductCount();
			request.setAttribute("pCnt", pCnt);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "work_detail";
	}

//	@RequestMapping("/create_bookmark")
//	public String createBookmark(@RequestParam int mNo, @RequestParam int pNo) {
//		try {
//			//(Integer)request.getAttribute("");
//			//String mNo = request.getParameter("mNo");
//			Map map1 = new HashMap();
//			//int mNo = (Integer)request.getAttribute("mNo");
//			//int pNo = (Integer)request.getAttribute("pNo");
//			System.out.println(mNo+" "+pNo);
//			map1.put("mNo", mNo);
//			map1.put("pNo", pNo);
//			int success = listService.createBookmark(map1);
//			System.out.println(success);
//			
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//		return "forward:/main/index";
//	}
	
	@ResponseBody
	@RequestMapping(value="/create_bookmark", produces = "text/plain;charset=UTF-8")
	public String createBookmark(@RequestParam int mNo, @RequestParam int pNo) throws Exception{
		String result = "false";
		try {
			
			Map map1 = new HashMap();
			map1.put("mNo", mNo);
			map1.put("pNo", pNo);
			int success = listService.createBookmark(map1);
			if(success==1) {
				result = "true";
			}else {
				result = "false";
			}
			
		}catch (Exception e) {
			result = "false";
		}
		return result;
	}
	
	@RequestMapping("/delete_bookmark")
	public String deleteBookmark(@RequestParam int bmNo) {
		try {
			System.out.println(bmNo);
			int success = listService.deleteBookmark(bmNo);
			System.out.println(success);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "forward:/main/index";
	}
}
