package com.itwill.staily.login.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.staily.login.exception.NoExistedIdException;
import com.itwill.staily.login.exception.PasswordMissmatchException;
import com.itwill.staily.login.service.LoginService;
import com.itwill.staily.mypage.service.PaymentService;
import com.itwill.staily.util.Member;

@RestController
@RequestMapping("/login")
public class LoginRestController {
	@Autowired
	private LoginService loginService;
	@Autowired
	private PaymentService paymentService;
	
	@PostMapping(value = "/login_action", produces = "application/json")
	public Map<String, Object> login_action_post(@RequestParam String userId, 
												  String userPw, 
												  HttpSession session, 
												  Model model) {
		int result = -999;
		Member member = new Member();
		Member successMember;
		member.setmId(userId);
		member.setmPw(userPw);
		Map<String, Object> map = new HashMap<String, Object>();
		
		try {
			successMember = loginService.login(member);
			int mNo = successMember.getmNo();
			session.setAttribute("userId", successMember.getmId());
			session.setAttribute("userNo", mNo);
			session.setAttribute("userType", successMember.getmType());
			
			if(successMember.getmType().equals("C")) {
				result = paymentService.checkN(mNo);
				map.put("success", "success");
				map.put("mType", successMember.getmType());
				map.put("result", result); // 1이면 기간만료 메세지 출력
			}else {
				map.put("success", "success");
				map.put("mType", successMember.getmType());
			}
		} catch (NoExistedIdException e) {
			e.printStackTrace();
			map.put("success", "fail");
			map.put("msg", e.getMessage());
		} catch (PasswordMissmatchException e) {
			map.put("success", "fail");
			map.put("msg", e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	@RequestMapping(value = "/Id_check", produces = "application/json", method = RequestMethod.POST)
	public int Id_check(@RequestParam String mId) throws Exception {
		return loginService.isExistedId(mId);
	}
	
	@RequestMapping(value = "/email_check", produces = "application/json")
	public int email_check(@RequestParam String mEmail) throws Exception {
		return loginService.isEmailExist(mEmail);
	}
	
	
}
