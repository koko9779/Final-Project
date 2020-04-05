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
import com.itwill.staily.mypage.model.dto.Friend;
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
		return "test2";
	}
	
	//회원정보업데이트
	@RequestMapping("/member_update")
	public String member_update(HttpServletResponse response, HttpServletRequest request) throws Exception {
		Integer mNo =(Integer)request.getAttribute("mNo");
		Member member = new Member(mNo, 
									request.getParameter("mId"), 
									request.getParameter("mPw"), 
									request.getParameter("mName"), 
									request.getParameter("mAddress"), 
									request.getParameter("mDaddress"), 
									request.getParameter("mEmail"), 
									request.getParameter("mType"), 
									request.getParameter("mPhone"));
		System.out.println(member);
		boolean result = mypageService.updateMember(member);
		System.out.println(result);
		request.setAttribute("mNo", mNo);
	
		return "forward:/mypage/member_select";
	}
	
	//북마크리스트
	@RequestMapping("/bookmark_list")
	public String bookmark_list(@RequestParam int mNo, HttpServletRequest request) throws Exception{
		//int mNo = (Integer)request.getAttribute("mNo");
		List<Bookmark> bookmarkList = bookmarkService.selectList(mNo);
		request.setAttribute("bookmarkList", bookmarkList);
		
		return "test2";
	}
	
	//북마크삭제
	@RequestMapping("/bookmark_delete")
	public String bookmark_delete(@RequestParam int bmNo, Model model) throws Exception{
		boolean result = bookmarkService.deleteBookmark(bmNo);
		model.addAttribute("result", result);
		return "forward:/mypage/bookmark_list";
	}
	
	//친구리스트
	@RequestMapping("/friend_list")
	public String friend_list(HttpServletResponse response, HttpServletRequest request) throws Exception{
		int mNo = (Integer)request.getAttribute("mNo");
		List<Friend> friendList = friendService.selectList(mNo);
		request.setAttribute("friendList", friendList);
		return "test2";
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
	public ModelAndView message_selectList(Model model) throws Exception{
		ModelAndView mv = new ModelAndView();
		List<Message> messageList = messageService.selectMessageList(2);
		model.addAttribute("messageList", messageList);
		mv.setViewName("test2");
		return mv;
	}
	
	//메시지 추가
	@RequestMapping("/message_create")
	public String message_create(HttpServletResponse response, HttpServletRequest request, Model model) throws Exception {
		
		return "";
	}
	
	//메시지 삭제
	@RequestMapping("/message_delete")
	public String message_delete(HttpServletResponse response, HttpServletRequest request) throws Exception{
		int msNo = (Integer)request.getAttribute("msNo");
		return "";
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
	
	//@RequestMapping("/test4")
	public ModelAndView friend_find(Model model) throws Exception{
		ModelAndView mv = new ModelAndView();
		String name = friendService.findFriend("hiphopmy");
		model.addAttribute("name", name);
		mv.setViewName("test3");
		return mv;
	}
	
	
	
}
