package com.itwill.staily.main.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String test(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		try {
			
			Integer userNo = (Integer)session.getAttribute("userNo");
			request.setAttribute("userNo", userNo);							
			
			if(userNo!=null) {
				List<Bookmark> bmList = mainService.selectByBookmark(userNo);
				request.setAttribute("bmList", bmList);		
			}

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

		return "index";
	}
	@RequestMapping("/worklist_select")
	public String workList(@RequestParam int wNo, HttpServletRequest request, HttpSession session) throws Exception {
		try {
			
			Integer userNo = (Integer)session.getAttribute("userNo");
			request.setAttribute("userNo", userNo);		
			
			if(userNo!=null) {
				List<Bookmark> bmList = mainService.selectByBookmark(userNo);
				request.setAttribute("bmList", bmList);		
			}
			
			Work w = listService.selectWorkOne(wNo);
			request.setAttribute("w", w);
			
			int tepisode = listService.selectTepisode(wNo);
			request.setAttribute("tepisode", tepisode);
			
			List<Work> cw = listService.selectCProductList(wNo);
			request.setAttribute("cw", cw);
			
			List<Work> mw = listService.selectMProductList(wNo);
			request.setAttribute("mw", mw);
	
			int pCnt = listService.selectProductCount();
			request.setAttribute("pCnt", pCnt);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "main/worklist";
	}
	
	@RequestMapping(value="worklist_read/detail", produces="application/json;charset=UTF-8")
	@ResponseBody
	public Map worklist_detail(@RequestParam int wNo, @RequestParam int wdEpisode) throws Exception{
		Map map1 = new HashMap();
		map1.put("wNo", wNo);
		map1.put("wdEpisode", wdEpisode);
				
		List<Work> cwe = listService.selectCProductListByEpisode(map1);
		List<Work> mwe = listService.selectMProductListByEpisode(map1);
		
		Map map2 = new HashMap();
		map2.put("cwe", cwe);
		map2.put("mwe", mwe);

		return map2;
	}
	
	/************Controller create_bookmark*******************/
/*
	@RequestMapping("/create_bookmark")
	public String createBookmark(@RequestParam("userNo") int userNo, @RequestParam("pNo") int pNo) {
		try {
			//(Integer)request.getAttribute("");
			//String mNo = request.getParameter("mNo");
			Map map1 = new HashMap();
			//int mNo = (Integer)request.getAttribute("mNo");
			//int pNo = (Integer)request.getAttribute("pNo");
			System.out.println(userNo+" "+pNo);
			map1.put("mNo", userNo);
			map1.put("pNo", pNo);
			int success = listService.createBookmark(map1);
			System.out.println(success);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "forward:/main/index";
	}
*/	
	/************RestController create_bookmark*******************/

	@RequestMapping(value="/create_bookmark", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String createBookmark(@RequestParam int userNo, @RequestParam int pNo) throws Exception{
		String result = "false";
		try {
			
			Map map1 = new HashMap();
			map1.put("mNo", userNo);
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

	/**************Controller delete_bookmark*******************/
	
	@RequestMapping("/delete_bookmark")
	@ResponseBody
	public String deleteBookmark(@RequestParam(name="bmNo",defaultValue = "-999") int bmNo, HttpServletRequest request) {
		String result = "";
		try {
			if(bmNo==-999) {
				bmNo = (Integer)request.getAttribute("bmNo");			
			}
			System.out.println(bmNo);
			int success = listService.deleteBookmark(bmNo);
			if(success==1) {
				result = "true";
			}else {
				result = "false";
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
/*	
	@RequestMapping("/select_bookmark")
	public String selectBookmarkNo(@RequestParam int userNo, @RequestParam int pNo, HttpServletRequest request) {
		try {
			int bmNo = listService.selectBookmarkNo(userNo, pNo);
			request.setAttribute("bmNo", bmNo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "forward:/main/delete_bookmark";
	}
*/
	@RequestMapping("/select_bookmark")
	@ResponseBody
	public String selectBookmarkNo(@RequestParam int userNo, @RequestParam int pNo, HttpServletRequest request) {
		String bmNo = "";
		try {
			bmNo = String.valueOf(listService.selectBookmarkNo(userNo, pNo));
			request.setAttribute("bmNo", bmNo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bmNo;
	}
}
	
