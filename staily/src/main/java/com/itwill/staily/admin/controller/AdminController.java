package com.itwill.staily.admin.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.itwill.staily.admin.service.AdminService;
import com.itwill.staily.util.Member;
import com.itwill.staily.util.Product;
import com.itwill.staily.util.Work;


@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	public AdminController() {
	}
	/*
	@RequestMapping("/test")
	public ModelAndView test(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv =new ModelAndView();
		try {
			Member member = adminService.selectMemberOne(1);
			List<Product>productList = adminService.selectProductAll();
			request.setAttribute("productList", productList);
			request.setAttribute("member", member);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("/admin/register");
		return mv;
	}
	*/
	/*
	 만들어야할거...
	 회원 ,작품, 상품 수정 form(아에 form.jsp도 만들어야함) action  
	 삭제 action들
	   
	 */
	@RequestMapping("/main")
	public String adminTest() {
		return "admin/index";
	}
	//회원
	@RequestMapping("/member")
	public String memberAdminForm(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<Member> memberList = new ArrayList();
			memberList = adminService.selectMemberAll();
			request.setAttribute("data", memberList);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		return "admin/member";
	}
	@RequestMapping("/member_delete")
	public String memberAdminDelete(@RequestParam("mNo") int mNo, HttpServletRequest request) {
		String result = "fail";
		try {
				adminService.deleteMember(mNo);
				result = "success";
		} catch (Exception e) {
			e.printStackTrace();
			result = "fail";
		}
		return result;
	}
	
	@RequestMapping("/member_select")
	public String memberAdminUpdate(HttpServletRequest request) {
		int mNo = Integer.parseInt(request.getParameter("mNo"));
		Member member = null;
		try {
			member = adminService.selectMemberOne(mNo);
			request.setAttribute("member", member);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "admin/member_update";
	}
	@RequestMapping(value= "/member_update", method = {RequestMethod.POST,RequestMethod.GET},produces="text/plain; charset=UTF-8")
	@ResponseBody
	public String memberAdminUpdateA(@RequestParam("mNo")int mNo,
			 						 @RequestParam("mId")String mId, @RequestParam("mPw")String mPw
			 					   , @RequestParam("mName")String mName, @RequestParam("mAddress")String mAddress
			 					   , @RequestParam("mDaddress")String mDaddress, @RequestParam("mEmail")String mEmail
			 					   , @RequestParam("mType")String mType,HttpServletRequest request) {
		String phn1 = request.getParameter("phn1");
		String phn2 = request.getParameter("phn2");
		String phn3 = request.getParameter("phn3");
		String mPhone = phn1 + phn2 + phn3;
		Member member = new Member(mNo, mId, mPw, mName, mAddress, mDaddress, mEmail, mType, mPhone);
		System.out.println(member+"널싫어해~");
		String result = "";
		try {
			boolean updateOk = adminService.updateMember(member);
			if (updateOk) {
				result = "success";
			}else {
				result="fail";
			}
		}catch (Exception e) {
			e.printStackTrace();
			result = "fail";
		}
		return result;
	}
	//상품
	@RequestMapping("/product")
	public String productAdminForm(HttpServletRequest request) {
		try {
			List<Product> productList= new ArrayList();
			productList = adminService.selectProductAll();
			request.setAttribute("data", productList);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "admin/product";
	}
	@RequestMapping("/product_select")
	public String productAdminSelect(@RequestParam int pNo, HttpServletRequest request) {
		try {
			List<Product> productList= new ArrayList();
			productList = adminService.selectProductOne(pNo);
			request.setAttribute("productList", productList);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "admin/product_update";
	}
	@RequestMapping("/product_update")
	public String productAdminUpdate(@RequestParam("pNo") int pNo,@RequestParam("mNo") int mNo,@RequestParam("wNo") int wNo
									, @RequestParam("pName") String pName,@RequestParam("pPrice") int pPrice,@RequestParam("pURL") String pUrl
									,@RequestParam("pAddress") String pAddress,@RequestParam("pDaddress") String pDaddress
									,@RequestParam("pCheck") String pCheck,@RequestParam("pView") int pView
									,@RequestParam("pDate") String pDate,@RequestParam("pScene") String pScene) {
		Product product = new Product(pNo, mNo, wNo, pName, pPrice, pUrl, pAddress, pDaddress, pCheck, pView, pDate, pScene);
		String result = "";
		try {
			adminService.updateProduct(product);
			result="success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	@RequestMapping(value = "/product_confirm", method = {RequestMethod.POST,RequestMethod.GET},produces="text/plain; charset=UTF-8")
	public String productAdminConfirm(@RequestParam ("pNo")int pNo,HttpServletRequest request) {
		String result = "";
		try {
			boolean confirmOk = adminService.productConfirm(pNo);
			if (confirmOk) {
				result = "success";
			}else {
				result= "fail";
			}
		} catch (Exception e) {
			e.printStackTrace();
			result= "fail";
		}
		return result;
	}
	@RequestMapping("/product_delete")
	public String productAdminDelete(@RequestParam("pNo") int pNo, HttpServletRequest request) {
		String result = "fail";
		try {
				adminService.deleteProduct(pNo);
				result = "success";
		} catch (Exception e) {
			e.printStackTrace();
			result = "fail";
		}
		return result;
	}
	//작품
	@RequestMapping("/work")
	public String workAdminForm(HttpServletRequest request) {
		try {
			List<Work> workList= new ArrayList();
			workList = adminService.selectWorkAll();
			request.setAttribute("data", workList);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "admin/work";
	}
	@RequestMapping(value= "/work_create")
	public String workAdminCreate(@RequestParam("wName") String wName,@RequestParam("wCategory") String wCategory,
								  @RequestParam("wDate") String wDate, @RequestParam("wPoster") String wPoster,
								  @RequestParam("wOverview") String wOverview,HttpServletRequest request) {
		Work work = new Work(0, wName, wCategory, wDate, wPoster, 0, 0);
		request.setAttribute("work", work);
		request.setAttribute("wOverview", wOverview);
		return"admin/work_create";
	}
	
	@RequestMapping("/work_create_action")
	@ResponseBody
	public String workAdminCreateAction(@RequestParam("wName") String wName,@RequestParam("wCategory") String wCategory,
			  							@RequestParam("wDate") String wDate, @RequestParam("wPoster") String wPoster,
			  							@RequestParam("wTepisode") int wTepisode, HttpServletRequest request) {
		Work work = new Work(0, wName, wCategory, wDate, wPoster, wTepisode, 0);
		String result = "";
		try {
			adminService.createWork(work);
			result = "success";
		}catch (Exception e) {
			e.printStackTrace();
			result = "fail";
		}
		return result;
	}
	@RequestMapping("/work_select")
	public String workAdminSelect(@RequestParam("wNo") int wNo,HttpServletRequest request) {
		Work work = null;
		try {
			work = adminService.selectWorkOne(wNo);
			request.setAttribute("work", work);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "admin/work_update";
	}
	// TMDB API 검색창 
	@RequestMapping("/work_seach")
	public String workAPISeacher() {
		return "admin/work_search";
	}
}
