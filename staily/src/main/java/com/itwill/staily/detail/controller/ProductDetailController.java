package com.itwill.staily.detail.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itwill.staily.detail.model.dto.ProductEx;
import com.itwill.staily.detail.service.ProductDetailService;
 
@Controller
@RequestMapping("/detail")
public class ProductDetailController {
	
	@Autowired
	private ProductDetailService productDetailService;
	
	@RequestMapping("/product_detail")
	public String selectProductOne(HttpServletRequest request, HttpServletResponse response) {
		
		try {			
			String pNo = request.getParameter("pNo");
			List<ProductEx> p = productDetailService.selectProductOne(Integer.parseInt(pNo));
			
			request.setAttribute("productOne", p);
			
			return "detail/product_detail";
		} catch (Exception e) {
			e.printStackTrace();
			
			return "redirect:../404.jsp";
		}
		
		
	}	
	
	
	@RequestMapping("/product_create_action")
	public ModelAndView createProduct(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		
		try {			
			String mNo = request.getParameter("mNo");
			String wNo = request.getParameter("wNo");
			String pName = request.getParameter("pName");
			String pPrice = request.getParameter("pPrice");
			String pUrl = request.getParameter("pUrl");
			String pAddress = request.getParameter("pAddress");
			String pDaddress = request.getParameter("pDaddress");
			String pCheck = request.getParameter("pCheck");
			String pView = request.getParameter("pView");
			String pScene = request.getParameter("pScene");
			ProductEx p = new ProductEx(Integer.parseInt(mNo), Integer.parseInt(wNo), 
					pName, Integer.parseInt(pPrice), pUrl, pAddress, pDaddress, pCheck,
					Integer.parseInt(pView), pScene);
			
			boolean create = productDetailService.createProduct(p);
			
			if(create) {
				request.setAttribute("productEx", p);				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		mv.setViewName("/");
		
		return mv;		
	}	
	
	/*
	@RequestMapping("/detailtest")
	public ModelAndView createProductDetail(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		
		try {			
			String pNo = request.getParameter("pNo");
			String pdImage = request.getParameter("pdImage");
			
			ProductEx p = new ProductEx(Integer.parseInt(pNo), pdImage);
			
			boolean create = productDetailService.createProductDetail(p);
			
			if(create) {
				request.setAttribute("productOne", p);				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		mv.setViewName("detailtest");
		
		return mv;		
	}	
	*/
	/*
	@RequestMapping("/detailtest")
	public ModelAndView updateProduct(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		
		try {			
			String pName = request.getParameter("pName");
			String pPrice = request.getParameter("pPrice");
			String pUrl = request.getParameter("pUrl");
			String pAddress = request.getParameter("pAddress");
			String pDaddress = request.getParameter("pDaddress");
			String pCheck = request.getParameter("pCheck");
			String pView = request.getParameter("pView");
			String pScene = request.getParameter("pScene");
			String pNo = request.getParameter("pNo");
			ProductEx p = new ProductEx(pName, Integer.parseInt(pPrice), pUrl, 
					pAddress, pDaddress, pCheck, Integer.parseInt(pView),
					pScene, Integer.parseInt(pNo));
			
			boolean create = productDetailService.updateProduct(p);
			
			if(create) {
				request.setAttribute("productOne", p);				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		mv.setViewName("detailtest");
		
		return mv;		
	}	
	*/
	/*
	@RequestMapping("/detailtest")
	public ModelAndView updateProductDetail(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		
		try {			
			String pdImage = request.getParameter("pdImage");
			String pdNo = request.getParameter("pdNo");
			
			ProductEx p = new ProductEx(pdImage, Integer.parseInt(pdNo));
			
			boolean create = productDetailService.updateProductDetail(p);
			
			if(create) {
				request.setAttribute("productOne", p);				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		mv.setViewName("detailtest");
		
		return mv;		
	}
	*/
	/*
	@RequestMapping("/detailtest")
	public ModelAndView checkCompany(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		
		try {			
			String mNo = request.getParameter("mNo");
			
			int check = productDetailService.checkCompany(Integer.parseInt(mNo));
			
			request.setAttribute("check", check);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		mv.setViewName("detailtest");
		
		return mv;		
	}
	*/
	/*
	@RequestMapping("/detailtest")
	public ModelAndView increaseProductView(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		
		try {
			List<ProductEx> sR = productDetailService.selectProductOne(1);
			request.setAttribute("replyOne", sR);
			
			boolean inc = productDetailService.increaseProductView(1);
			
			for (int i = 0; i < sR.size(); i++) {
				request.setAttribute("view", sR.get(i).getpView());
				
			}
			
			if(inc) {
				mv.setViewName("detailtest");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return mv;
	}
	*/
	
	
	
}
