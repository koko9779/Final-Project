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
			List<Product> cp = new ArrayList<Product>();
			for (int i = 0; i < cw.size(); i++) {
				cp = cw.get(i).getProduct();				
			}
			request.setAttribute("cw", cw);
			request.setAttribute("cp", cp);
			
			List<Work> mw = listService.selectMProductList(4);
			List<Product> mp = new ArrayList<Product>();
			for (int i = 0; i < mw.size(); i++) {
				mp = mw.get(i).getProduct();
			}
			request.setAttribute("mw", mw);
			request.setAttribute("mp", mp);
			
			Map map1 = new HashMap();
			map1.put("wNo", 4);
			map1.put("wdEpisode", 1);
			List<Work> cwe = listService.selectCProductListByEpisode(map1);
			List<Product> cpe = new ArrayList<Product>();
			for (int i = 0; i < cwe.size(); i++) {
				cpe = cwe.get(i).getProduct();
			}
			request.setAttribute("cwe", cwe);
			request.setAttribute("cpe", cpe);
			
			List<Work> mwe = listService.selectCProductListByEpisode(map1);
			List<Product> mpe = new ArrayList<Product>();
			for (int i = 0; i < mwe.size(); i++) {
				mpe = mwe.get(i).getProduct();
			}
			request.setAttribute("mwe", mwe);
			request.setAttribute("mpe", mpe);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "maintest2";
	}
}
