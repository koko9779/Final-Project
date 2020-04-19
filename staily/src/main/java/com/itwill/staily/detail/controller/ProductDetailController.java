package com.itwill.staily.detail.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.itwill.staily.detail.model.dto.ProductEx;
import com.itwill.staily.detail.service.ProductDetailService;
import com.itwill.staily.detail.service.WorkDetailService;
import com.itwill.staily.util.Work;
 
@Controller
@RequestMapping("/detail")
public class ProductDetailController {
	@Autowired
	private WorkDetailService workDetailService;
	@Autowired
	private ProductDetailService productDetailService;
	
	@RequestMapping("/product_detail")
	public String selectProductOne(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		
		try {			
			Integer userNo = (Integer)session.getAttribute("userNo");
			request.setAttribute("userNo", userNo);
			
			String userId = (String)session.getAttribute("userId");
			request.setAttribute("userId", userId);
			
			String pNo = request.getParameter("pNo");
			String wNo = request.getParameter("wNo");
					    
			List<ProductEx> p = productDetailService.selectProductOne(Integer.parseInt(pNo));
			Work w = workDetailService.selectWorkOne(Integer.parseInt(wNo));
			productDetailService.increaseProductView(Integer.parseInt(pNo));
			workDetailService.increaseWorkView(Integer.parseInt(wNo));
			
			request.setAttribute("productOne", p);
			request.setAttribute("w", w);
			request.setAttribute("tepisode", w.getwTepisode());
			
			
			return "detail/product_detail";
		} catch (Exception e) {
			e.printStackTrace();
			
			return "redirect:../404";
		}
		
		
	}	

	@RequestMapping("/product_create")
	public ModelAndView product_create(HttpServletResponse response, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		
		try {			
			String wNo = request.getParameter("wNo");

			Work w = workDetailService.selectWorkOne(Integer.parseInt(wNo));
			
			request.setAttribute("workOne", w);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		mv.setViewName("detail/product_create");
		
		return mv;		
	}
	
	@RequestMapping("/product_create_action")
	public ModelAndView createProduct(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		
		try {			
			
			Integer mNo = (Integer)session.getAttribute("userNo");
			String wNo = request.getParameter("wNo");
			String wdEpisode = request.getParameter("wdEpisode");
			String pName = request.getParameter("pName");
			String pPrice = request.getParameter("pPrice");
			String pUrl = request.getParameter("pUrl");
			String pAddress = request.getParameter("pAddress");
			String pDaddress = request.getParameter("pDaddress");
			String pScene = request.getParameter("filesize");
			
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		    String pDate = df.format(new Date());
						
			String[] pdImage = request.getParameterValues("filesize2");
					
			ProductEx p = new ProductEx(mNo, Integer.parseInt(wNo), 
					pName, Integer.parseInt(pPrice), pUrl, pAddress, pDaddress, pScene, pDate);
			
			int companyChk = productDetailService.checkCompany(mNo);
			
			if(companyChk == 1) {
				productDetailService.createProductCompany(p, Integer.parseInt(wNo), Integer.parseInt(wdEpisode));
			}
			else {
				productDetailService.createProduct(p, Integer.parseInt(wNo), Integer.parseInt(wdEpisode));
			}
				
			productDetailService.createProductDetail(pdImage);				

			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//mv.setViewName("work_request");
		mv.setViewName("redirect:..");
		
		return mv;		
	}	
	
	@RequestMapping("/upload")
	public void upload(HttpServletResponse response, HttpServletRequest request, 
			@RequestParam("Filedata") MultipartFile Filedata) { 
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS"); 
		String newfilename = df.format(new Date()) + Integer.toString((int) (Math.random()*10));
		File f = new File("C:\\Users\\STU\\git\\Final-Project\\staily\\src\\main\\webapp\\images\\product\\scene\\" + newfilename + ".jpg"); 
		//File f = new File("C:\\Users\\Home\\git\\Final-Project\\staily\\src\\main\\webapp\\images\\product\\scene\\" + newfilename + ".jpg"); 
		
		try {
			
			Filedata.transferTo(f); 
			response.getWriter().write(newfilename);
			
		} 
		catch (IllegalStateException | IOException e) { 
			e.printStackTrace(); 
		}
	}
	
	@RequestMapping("/upload2")
	public void upload2(HttpServletResponse response, HttpServletRequest request, 
			@RequestParam("Filedata") MultipartFile Filedata) { 
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS"); 
		String newfilename = df.format(new Date()) + Integer.toString((int) (Math.random()*10));
		File f = new File("C:\\Users\\STU\\git\\Final-Project\\staily\\src\\main\\webapp\\images\\product\\image\\" + newfilename + ".jpg"); 
		//File f = new File("C:\\Users\\Home\\git\\Final-Project\\staily\\src\\main\\webapp\\images\\product\\image\\" + newfilename + ".jpg"); 
		
		try {
			
			Filedata.transferTo(f); 
			response.getWriter().write(newfilename);
		} 
		catch (IllegalStateException | IOException e) { 
			e.printStackTrace(); 
		}
	}
	
	
	
	
	@RequestMapping("/pdImage_create_action")
	public ModelAndView createProductDetail(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		
		try {		
			String wNo = request.getParameter("wNo");
			String pdImage = request.getParameter("filesize2");
			Pattern p = Pattern.compile(",");
			Matcher m = p.matcher(pdImage);
			int cnt = 0;
			
			for (int i = 0; m.find(i); i = m.end()) {
				cnt++;
			}
			request.setAttribute("cnt", cnt + 1);
			
			for(int i = 0; i < cnt + 1; i++) {
				String[] filesize2 = pdImage.split(",");
				String Image = filesize2[i];
				request.setAttribute("Image" + (i + 1), Image);
			}
			
			Work w = workDetailService.selectWorkOne(Integer.parseInt(wNo));
			request.setAttribute("workOne", w);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		mv.setViewName("detail/product_create");
		
		return mv;		
	}	
	
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
			
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		    String pDate = df.format(new Date());
		    
			ProductEx p = new ProductEx(pName, Integer.parseInt(pPrice), pUrl, 
					pAddress, pDaddress, pCheck, Integer.parseInt(pView), pDate,
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
