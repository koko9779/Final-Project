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
	public String memberAdminDelete(HttpServletRequest request) {
		String [] arrayNo = request.getParameterValues("noArray");
		String result = "fail";
		try {
			for (String no : arrayNo) {
				String [] tempNo= no.split("-");
				int mNo = Integer.parseInt(tempNo[0]);
				adminService.deleteMember(mNo);
				result = "success";
			}
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
	
	@RequestMapping("/product")
	public String productAdminForm(HttpServletRequest request) {
		try {
			List<Product> productList= new ArrayList();
			productList = adminService.selectProductOnlyAll();
			request.setAttribute("data", productList);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "admin/product";
	}
	@RequestMapping("/product_select")
	public String productAdminUpdate(@RequestParam int pNo, HttpServletRequest request) {
		try {
			List<Product> productList= new ArrayList();
			productList = adminService.selectProductOne(pNo);
			request.setAttribute("productList", productList);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "admin/product_update";
	}
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
	public String workAdminCreate() {
		return"admin/work_create";
	}
	
	@RequestMapping("/work_create_action")
	@ResponseBody
	public String workAdminCreateAction(HttpServletRequest request, HttpServletResponse response) {
		Work work = (Work) request.getAttribute("work");
		try {
			adminService.createWork(work);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return"admin/work";
	}
	@RequestMapping("/work_update")
	public String workAdminUpdate() {
		return "admin/work_update";
	}
}
