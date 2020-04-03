package com.itwill.staily.main.controller;

import java.util.ArrayList;
import java.util.List;

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
			List<Work> cw = listService.selectCProductList(4);
			List<Product> cp = new ArrayList<Product>();
			for (int i = 0; i < cw.size(); i++) {
				cp = cw.get(i).getProduct();				
			}
			request.setAttribute("cw", cw);
			request.setAttribute("cp", cp);
			
			List<Work> mw = listService.selectMProductList(4);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "maintest2";
	}
}
