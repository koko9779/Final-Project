package com.itwill.staily.mypage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itwill.staily.mypage.model.dto.Message;
import com.itwill.staily.mypage.service.FriendService;
import com.itwill.staily.mypage.service.MessageService;

@Controller
public class MypageController {
	
	@Autowired
	private MessageService messageService;
	
	@Autowired
	private FriendService friendService;
	
	@RequestMapping("/test2")
	public ModelAndView message_selectOne(Model model) throws Exception {
		//@RequestParam(required = false, defaultValue = "") int msNo , 
		ModelAndView mv = new ModelAndView();
		Message message = messageService.selectOne(1);
		model.addAttribute("message", message);
		mv.setViewName("test2");
		return mv;
	}
	
	@RequestMapping("/test3")
	public ModelAndView message_selectList(Model model) throws Exception{
		ModelAndView mv = new ModelAndView();
		List<Message> messageList = messageService.selectMessageList(2);
		model.addAttribute("messageList", messageList);
		mv.setViewName("test3");
		return mv;
	}
	
	@RequestMapping("/test4")
	public ModelAndView friend_find(Model model) throws Exception{
		ModelAndView mv = new ModelAndView();
		String name = friendService.findFriend("hiphopmy");
		model.addAttribute("name", name);
		mv.setViewName("test3");
		return mv;
	}
	
}
