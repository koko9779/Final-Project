package com.itwill.staily.mypage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import com.itwill.staily.util.Product;

@Controller
@RequestMapping("/mypage")
public class MypageController {
	
	@Autowired
	private MessageService messageService;
	
	@Autowired
	private FriendService friendService;
	@Autowired
	private MypageService mypageService;
	@Autowired
	private BookmarkService bookmarkService;
	
	
	//회원정보출력
	@RequestMapping("/member_select")
	public String member_select(HttpSession session, Model model)throws Exception{
		//int mNo = (Integer)session.getAttribute("mNo");
		int mNo = 7;
		Member member = mypageService.selectOne(mNo);
		
		if(member.getmType().equals("M")) {
			model.addAttribute("member", member);
		}else if(member.getmType().equals("C")) {
			Member memberCompany = mypageService.selectMemberCompany(mNo);
			model.addAttribute("member", memberCompany);
		}
		return "test2";
	}
	
	//회원정보업데이트
	@RequestMapping("/member_update")
	public String member_update(HttpServletResponse response, HttpServletRequest request) {
		request.getParameter("mNo");
		request.getParameter("mId");
		request.getParameter("mPw");
		request.getParameter("mName");
		return "test2";
	}
	
	//북마크리스트
	@RequestMapping("/bookmark_list")
	public ModelAndView bookmark_list(HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		List<Bookmark> bookmarkList = bookmarkService.selectList(1);
		session.setAttribute("bookmarkList", bookmarkList);
		mv.setViewName("test2");
		return mv;
	}
	
	//내가쓴글리스트
	@RequestMapping("/member_write")
	public String member_write(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		int mNo = (Integer)request.getAttribute("mNo");
		List<Product> writeList = mypageService.selectWriteList(mNo);
		//model.addAttribute("writeList", writeList);
		request.setAttribute("writeList", writeList);
		return "test2";
	}
	
	//메시지한개출력
	@RequestMapping("/message")
	public ModelAndView message_selectOne(Model model) throws Exception {
		//@RequestParam(required = false, defaultValue = "") int msNo , 
		ModelAndView mv = new ModelAndView();
		Message message = messageService.selectOne(1);
		model.addAttribute("message", message);
		mv.setViewName("test2");
		return mv;
	}
	
	//메시지리스트
	@RequestMapping("/message_list")
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
