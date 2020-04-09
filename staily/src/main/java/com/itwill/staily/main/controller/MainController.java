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
			/*
			 * wNo값을 받아서 상품뽑아내기
			 * 임시 (mNo=4, wNo=1)
			 */
			
			Work w = listService.selectWorkOne(1);
			request.setAttribute("w", w);
			
			int tepisode = listService.selectTepisode(1);
			request.setAttribute("tepisode", tepisode);
			
			List<Work> cw = listService.selectCProductList(4);
			request.setAttribute("cw", cw);
			
			List<Work> mw = listService.selectMProductList(4);
			request.setAttribute("mw", mw);
	
			int pCnt = listService.selectProductCount();
			request.setAttribute("pCnt", pCnt);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "work_detail";
	}
	
	@RequestMapping(value="worklist/detail", produces="application/json;charset=UTF-8")
	@ResponseBody
	public Map worklist_detail(@RequestParam("wNo") int wNo, @RequestParam("wdEpisode") int wdEpisode) throws Exception{
		Map map1 = new HashMap();
		map1.put("wNo", wNo);
		map1.put("wdEpisode", wdEpisode);
		
		List<Work> cwe = listService.selectCProductListByEpisode(map1);
		List<Work> mwe = listService.selectMProductListByEpisode(map1);
		
		Map map2 = new HashMap();
		map2.put("cwe", cwe);
		map2.put("mwe", mwe);
		/*
		 {
			"cwe": [
					{
					"wNo": 4,
					"wdEpisode": 1,
					"product": [
							{
							"pNo": 2,
							"mNo": 2,
							"wNo": 4,
							"pName": "한정연게을러",
							"pScene": "/images/product/scene/3.jpg",
							"mId": "mint8711"
							}
						]
					},
					....
			],
			"mwe": [
					{
					"wNo": 4,
					"wdEpisode": 1,
					"product": [
							{
							"pNo": 1,
							"mNo": 4,
							"wNo": 4,
							"pName": "BLOOM*IZ",
							"pView": 345354,
							"pScene": "/images/product/scene/1.jpg",
							"mId": "koko97"
							}
						]
					}
					]
			}
		 */
		return map2;
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
