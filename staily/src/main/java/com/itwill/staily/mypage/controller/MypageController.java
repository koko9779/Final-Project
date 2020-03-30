package com.itwill.staily.mypage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itwill.staily.mypage.model.dto.Message;
import com.itwill.staily.mypage.service.MessageService;

@Controller
public class MypageController {
	
	@Autowired
	private MessageService messageService;
	
	@RequestMapping("/test2")
	public ModelAndView message_selectOne(Model model) throws Exception {
		//@RequestParam(required = false, defaultValue = "") int msNo , 
		ModelAndView mv = new ModelAndView();
		Message message = messageService.selectOne(1);
		model.addAttribute("message", message);
		mv.setViewName("test2");
		return mv;
	}
	
}
