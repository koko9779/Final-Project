package com.itwill.staily.main.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.plugins.bmp.BMPImageWriteParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.rules.Stopwatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StopWatch;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.itwill.staily.main.model.dto.Pagination;
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
	/************Controller index*******************/
	@RequestMapping("/index")
	public String index(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
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
	/************Controller worklist_select*******************/
	@RequestMapping("/worklist_select")
	public String workList(@RequestParam int wNo, @RequestParam(defaultValue="1") int curPage, HttpServletRequest request, HttpSession session) throws Exception {
		try {
						
			//작품 조회수 증가
			listService.increaseWorkView(wNo);
	        
	        /*****************로그인 여부********************/
	        //사용자 정보 session을 통해서 가져오기
	        Integer userNo = (Integer)session.getAttribute("userNo");
	        request.setAttribute("userNo", userNo);	
	        
			if(userNo!=null) {
				List<Bookmark> bmList = mainService.selectByBookmark(userNo);
				request.setAttribute("bmList", bmList);	
			}
			
			/*******************sidebar***********************/
			Work w = listService.selectWorkOne(wNo);
			request.setAttribute("w", w);
			
			int tepisode = listService.selectTepisode(wNo);
			request.setAttribute("tepisode", tepisode);
			
			/********************detail***********************/
			List<Work> cw = listService.selectCProductList(wNo);
			request.setAttribute("cw", cw);
			
	        // 전체리스트 개수
	        int listCnt = listService.selectProductCount(wNo);
			
	        System.out.println("총 게시물건수:"+listCnt);
	        
	        Pagination pagination = new Pagination(listCnt, curPage);
	        
	        System.out.println(pagination.getStartIndex()+"~"+pagination.getCurEndIndex());
	        
	        List<Work> mw = listService.selectMProductList(wNo,pagination.getStartIndex(),pagination.getCurEndIndex());
	        
			request.setAttribute("mw", mw);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "main/worklist";
	}
	
	/************Controller productlist_select*******************/
	@RequestMapping("/productlist_select")
	public String productlist(HttpServletRequest request, HttpSession session) throws Exception {
		try {
	        /*****************로그인 여부********************/
	        //사용자 정보 session을 통해서 가져오기
	        Integer userNo = (Integer)session.getAttribute("userNo");
	        request.setAttribute("userNo", userNo);	
	        
			if(userNo!=null) {
				List<Bookmark> bmList = mainService.selectByBookmark(userNo);
				request.setAttribute("bmList", bmList);	
			}
			
			List<Work> productList = listService.selectProductList();
			request.setAttribute("pList", productList);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "main/productlist";
	}
	@RequestMapping(value="/worklist_select/detail", produces="application/json;charset=UTF-8")
	@ResponseBody 
	public String getList(@RequestParam(name="nextPage",defaultValue = "2") int nextPage, @RequestParam int wNo, HttpServletRequest request, HttpSession session) throws Exception{
	    Gson gson = new Gson();
	    Map map = new HashMap();
		try {
			Integer userNo = (Integer)session.getAttribute("userNo");
			List<Bookmark> bmList = null ;

			if(userNo!=null) {
				bmList = mainService.selectByBookmark(userNo);
			}		
			
	        // 전체리스트 개수
	        int listCnt = listService.selectProductCount(wNo);

	        //페이지 구하기
		    Pagination pagination = new Pagination(listCnt, nextPage);
		    
		    System.out.println(nextPage+"페이지로 넘어갑니다.");
		    System.out.println(pagination.getStartIndex()+"~"+pagination.getCurEndIndex());
		    System.out.println();
		    
		    //조회한 데이터를 가져온다.
		    //list = listService.selectMProductList(wNo,1,2);  
		    List<Work> list = listService.selectMProductList(wNo,pagination.getStartIndex(),pagination.getCurEndIndex());  
		    int endPage = pagination.getEndPage();
		    
			map.put("list", list);
			map.put("endPage",endPage);
			map.put("userNo",userNo);
			map.put("bmList",bmList);
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return gson.toJson(map);
	}
	/************RestController worklist_select/detail*******************/
	
	@RequestMapping(value="worklist_select/detail/episode", produces="application/json;charset=UTF-8")
	@ResponseBody
	public String worklist_detail(@RequestParam(name="nextPage",defaultValue = "2") int nextPage,@RequestParam int wNo, @RequestParam int wdEpisode,HttpSession session, HttpServletRequest request) throws Exception{

	    Gson gson = new Gson();
	    Map map = new HashMap();
		try {
			Integer userNo = (Integer)session.getAttribute("userNo");
			List<Bookmark> bmList = null ;
			
			if(userNo!=null) {
				bmList = mainService.selectByBookmark(userNo);
			}
			
			// 리스트 개수
			int listCnt = listService.selectProductCountByEpisode(wNo, wdEpisode);
			
			//페이지 구하기
			Pagination pagination = new Pagination(listCnt, nextPage);
	
			Map map1 = new HashMap();
			map1.put("wNo", wNo);
			map1.put("wdEpisode", wdEpisode);
			map1.put("start",pagination.getStartIndex());
			map1.put("end",pagination.getCurEndIndex());
			    
		    List<Work> mwe = listService.selectMProductListByEpisode(map1);
		    
		    System.out.println(nextPage+"페이지로 넘어갑니다.");
		    System.out.println(pagination.getStartIndex()+"~"+pagination.getCurEndIndex());
	
		    int endPage = pagination.getEndPage();
		    
			map.put("mwe", mwe);
			map.put("endPage",endPage);
			map.put("userNo",userNo);
			map.put("bmList",bmList);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return gson.toJson(map);
	}
	
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
	public String deleteBookmark(@RequestParam int bmNo,@RequestParam int userNo, @RequestParam int pNo, HttpServletRequest request) throws Exception{
		String result = "";
		try {
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
	/************RestController select_bookmark*******************/
	@RequestMapping("/select_bookmark")
	@ResponseBody
	public String selectBookmarkNo(@RequestParam int userNo, @RequestParam int pNo, HttpServletRequest request) throws Exception{
		String bmNo = "";
		try {
			bmNo = String.valueOf(listService.selectBookmarkNo(userNo, pNo));
			request.setAttribute("bmNo", bmNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bmNo+","+userNo+","+pNo;
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
	/************Controller select_bookmark*******************/
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
}
	
