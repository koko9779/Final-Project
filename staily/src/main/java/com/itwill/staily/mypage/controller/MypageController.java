package com.itwill.staily.mypage.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itwill.staily.mypage.model.dto.Bookmark;
import com.itwill.staily.mypage.model.dto.Message;
import com.itwill.staily.mypage.service.BookmarkService;
import com.itwill.staily.mypage.service.FriendService;
import com.itwill.staily.mypage.service.MessageService;
import com.itwill.staily.mypage.service.MypageService;
import com.itwill.staily.util.Member;

@Controller
public class MypageController {
	
	@Autowired
	private MessageService messageService;
	
	@Autowired
	private FriendService friendService;
	@Autowired
	private MypageService mypageService;
	@Autowired
	private BookmarkService bookmarkService;
	
	@RequestMapping("/bookmarkList")
	public ModelAndView bookmark_list(HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		List<Bookmark> bookmarkList = bookmarkService.selectList(5);
		session.setAttribute("bookmarkList", bookmarkList);
		mv.setViewName("test2");
		return mv;
	}
	
	@RequestMapping("/memberSelect")
	public ModelAndView member_select(@RequestParam int mNo, Model model)throws Exception{
		ModelAndView mv = new ModelAndView();
		Member member = new Member();
		member = mypageService.selectOne(mNo);
		if(member.getmType().equals("M")) {
			model.addAttribute("member", member);
		}else if(member.getmType().equals("C")) {
			//mypageService
		}
		mv.setViewName("test2");
		return mv;
	}
	
	
	
	@RequestMapping("/test2")
	public ModelAndView message_selectOne(Model model) throws Exception {
		//@RequestParam(required = false, defaultValue = "") int msNo , 
		ModelAndView mv = new ModelAndView();
		Message message = messageService.selectOne(1);
		model.addAttribute("message", message);
		mv.setViewName("test2");
		return mv;
	}
	
	//@RequestMapping("/test3")
	public ModelAndView message_selectList(Model model) throws Exception{
		ModelAndView mv = new ModelAndView();
		List<Message> messageList = messageService.selectMessageList(2);
		model.addAttribute("messageList", messageList);
		mv.setViewName("test3");
		return mv;
	}
	
	//@RequestMapping("/test4")
	public ModelAndView friend_find(Model model) throws Exception{
		ModelAndView mv = new ModelAndView();
		String name = friendService.findFriend("hiphopmy");
		model.addAttribute("name", name);
		mv.setViewName("test3");
		return mv;
	}
	
	
	
}
