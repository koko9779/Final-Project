package com.itwill.staily.main.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itwill.staily.main.service.ListService;
import com.itwill.staily.util.Product;
import com.itwill.staily.util.Work;

@Controller
public class ListController {
	@Autowired
	private ListService listService;

	public ListController() {
		
	}
	@RequestMapping("/maintest2")
	public String test2(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			
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
		return "maintest2";
	}
}
