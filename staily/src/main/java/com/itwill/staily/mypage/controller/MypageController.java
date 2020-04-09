package com.itwill.staily.mypage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.itwill.staily.mypage.model.dto.Bookmark;
import com.itwill.staily.mypage.model.dto.Friend;
import com.itwill.staily.mypage.model.dto.Message;
import com.itwill.staily.mypage.model.dto.Payment;
import com.itwill.staily.mypage.service.BookmarkService;
import com.itwill.staily.mypage.service.FriendService;
import com.itwill.staily.mypage.service.MessageService;
import com.itwill.staily.mypage.service.MypageService;
import com.itwill.staily.mypage.service.PaymentService;
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
	@Autowired
	private PaymentService paymentService;
	
	
	@RequestMapping("/mypage")
	public String mypageTest() {
		return "mypage/index";
	}
	
	//회원정보출력
	@RequestMapping("/member_select")
	public String member_select(HttpSession session, Model model, HttpServletRequest request)throws Exception{
		//int mNo = (Integer)session.getAttribute("mNo");
		Integer mNo = (Integer)request.getAttribute("mNo");
		if(mNo==null) {
			mNo = 7;
		}
		Member member = mypageService.selectOne(mNo);
		
		if(member.getmType().equals("M")) {
			model.addAttribute("member", member);
		}else if(member.getmType().equals("C")) {
			Member memberCompany = mypageService.selectMemberCompany(mNo);
			model.addAttribute("member", memberCompany);
			System.out.println(memberCompany);
		}
		session.setAttribute("mNo", mNo);
		return "mypage/member";
	}
	
	//회원정보업데이트
	@RequestMapping("/member_update")
	public String member_update(HttpServletResponse response, 
								HttpServletRequest request, 
								Model model,
								HttpSession session) throws Exception {
		//Integer mNo =(Integer)request.getAttribute("mNo");
		String mNoStr = request.getParameter("mNo");
		
		String phn1 = request.getParameter("phn1");
		String phn2 = request.getParameter("phn2");
		String phn3 = request.getParameter("phn3");
		String mPhone = phn1 + phn2 + phn3;
		Integer mNo = Integer.parseInt(mNoStr);
		System.out.println(mNo);
		Member member = new Member(mNo, 
									request.getParameter("mId"), 
									request.getParameter("mPw"), 
									request.getParameter("mName"), 
									request.getParameter("mAddress"), 
									request.getParameter("mDaddress"), 
									request.getParameter("mEmail"), 
									request.getParameter("mType"), 
									mPhone);
		
		boolean result = mypageService.updateMember(member);
		request.setAttribute("result", result);
		request.setAttribute("phn1", phn1);
		request.setAttribute("phn2", phn2);
		request.setAttribute("phn3", phn3);
		request.setAttribute("mNo", mNo);
		session.setAttribute("mNo", mNo);
		return "forward:/mypage/member_select";
	}
	
	//북마크리스트
	@RequestMapping("/bookmark_list")
	public String bookmark_list(HttpSession session, HttpServletRequest request) {
		//int mNo = (Integer)request.getAttribute("mNo");
		int mNo = (Integer)session.getAttribute("mNo");
		List<Bookmark> bookmarkList;
		try {
			bookmarkList = bookmarkService.selectList(mNo);
			request.setAttribute("data", bookmarkList);
			return "mypage/bookmark";
		} catch (Exception e) {
			e.printStackTrace();
			return "main/index";
		}
		//session.setAttribute("mNo", mNo);
		//return "mypage/bookmark";
	}
	
	//북마크삭제
	@RequestMapping("/bookmark_delete")
	@ResponseBody
	public List<Bookmark> bookmark_delete(@RequestParam int bmNo, Model model,
								  HttpSession session) throws Exception{
		int mNo = (Integer)session.getAttribute("mNo");
		boolean result = bookmarkService.deleteBookmark(bmNo);
		model.addAttribute("result", result);
		List<Bookmark> bookmarkList;
		bookmarkList = bookmarkService.selectList(mNo);
		return bookmarkList;
	}
	
	//친구리스트
	@RequestMapping("/friend_list")
	public String friend_list(HttpServletResponse response, 
							  HttpServletRequest request,
							  HttpSession session) {
		//int mNo = (Integer)request.getAttribute("mNo");
		int mNo = (Integer)session.getAttribute("mNo");
		List<Friend> friendList;
		try {
			friendList = friendService.selectList(mNo);
			request.setAttribute("data", friendList);
			return "mypage/friend_list";
		} catch (Exception e) {
			e.printStackTrace();
			return "main/index";
		}
	}
	
	//친구추가
	@RequestMapping("/friend_create")
	public String friend_create(HttpServletResponse response, HttpServletRequest request) throws Exception{
		int fNo = (Integer)request.getAttribute("fNo");
		int mNo = (Integer)request.getAttribute("mNo");
		boolean result = friendService.createFriend(mNo, fNo);
		request.setAttribute("result", result);
		return "test2";
	}
	
	//친구삭제
	@RequestMapping("/friend_delete") 
	public String friend_delete(HttpServletResponse response, HttpServletRequest request) throws Exception{
		int fPk = (Integer)request.getAttribute("fPk");
		boolean result = friendService.deleteFriend(fPk);
		request.setAttribute("result", result);
		return "test2";
	}
	
	//친구찾기 -- RestController로 이동필요
	@RequestMapping("/friend_find")
	public String friend_find(HttpServletResponse response, HttpServletRequest request) throws Exception{
		String mId = request.getParameter("mId");
		String result = friendService.findFriend(mId);
		request.setAttribute("result", result);
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
	
	//메시지리스트(멤버&메시지 조인)
	@RequestMapping("/message_list")
	public ModelAndView message_selectList(HttpSession session, Model model) {
		ModelAndView mv = new ModelAndView();
		int mNo = (Integer)session.getAttribute("mNo");
		List<Message> messageList;
		try {
			messageList = messageService.selectMessageList(mNo);
			model.addAttribute("messageList", messageList);
		} catch (Exception e) {
			e.printStackTrace();
			mv.setViewName("main/index");
			return mv;
		}
		mv.setViewName("mypage/message_list");
		return mv;
	}
	
	//메시지 추가
	@RequestMapping("/message_create")
	public String message_create(HttpServletResponse response, 
								 HttpServletRequest request, 
								 Model model,
								 @ModelAttribute Message message) throws Exception {
		
		boolean result = messageService.createMessage(message);
		request.setAttribute("result", result);
		return "test2";
	}
	
	//메시지 삭제
	@RequestMapping("/message_delete")
	public String message_delete(HttpServletResponse response, HttpServletRequest request) throws Exception{
		String msNoStr = request.getParameter("msNo");
		Integer msNo = Integer.parseInt(msNoStr);
		boolean result = messageService.deleteMessage(msNo);
		request.setAttribute("result", result);
		return "test2";
	}
	
	//내가쓴글리스트
	@RequestMapping("/member_write")
	public String member_write(HttpServletRequest request, 
							   HttpServletResponse response, 
							   Model model,
							   HttpSession session) {
		//int mNo = (Integer)request.getAttribute("mNo");
		int mNo = (Integer)session.getAttribute("mNo");
		List<Product> writeList;
		try {
			writeList = mypageService.selectWriteList(mNo);
			request.setAttribute("data", writeList);
		} catch (Exception e) {
			e.printStackTrace();
			return "main/index";
		}
		//model.addAttribute("writeList", writeList);
		return "mypage/member_write";
	}
	
	//내가쓴글삭제
	@RequestMapping("/member_write_delete")
	public String member_write_delete(HttpServletRequest request, 
									  HttpServletResponse response,
									  @RequestParam int pNo) throws Exception{
		
		boolean result = mypageService.deleteWrite(pNo);
		request.setAttribute("result", result);
		return "test2";
	}
	
	//결제리스트출력
	@RequestMapping("/payment_list")
	public String payment_list(HttpServletRequest request, 
							   HttpServletResponse response,
							   HttpSession session) {
		int mNo = (Integer)session.getAttribute("mNo");
		List<Payment> paymentList;
		try {
			paymentList = paymentService.selectList(mNo);
			request.setAttribute("paymentList", paymentList);
		} catch (Exception e) {
			e.printStackTrace();
			return "main/index";
		}
		return "mypage/payment_list";
	}
	
	//결제화면
	@RequestMapping("/payment")
	public String payment() {
		return "mypage/payment";
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
