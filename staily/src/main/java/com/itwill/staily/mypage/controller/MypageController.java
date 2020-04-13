package com.itwill.staily.mypage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	public String member_select(HttpSession session, Model model, HttpServletRequest request){
		Member member;
		try {
			Integer mNo = (Integer)session.getAttribute("userNo");
			if(mNo==null) {
				mNo = 7;
			}
			member = mypageService.selectOne(mNo);
			if(member.getmType().equals("M")) {
				model.addAttribute("member", member);
			}else if(member.getmType().equals("C")) {
				Member memberCompany = mypageService.selectMemberCompany(mNo);
				model.addAttribute("member", memberCompany);
				System.out.println(memberCompany);
			}
			session.setAttribute("mNo", mNo);
			return "mypage/member";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/main/index";
		}
		
		
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
		List<Bookmark> bookmarkList;
		try {
			Integer mNo = (Integer)session.getAttribute("userNo");
			if(mNo==null) {
				mNo = 7;
			}
			bookmarkList = bookmarkService.selectList(mNo);
			request.setAttribute("data", bookmarkList);
			return "mypage/bookmark";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/main/index";
		}
		//session.setAttribute("mNo", mNo);
		//return "mypage/bookmark";
	}
	
	//북마크삭제
	@RequestMapping(value = "/bookmark_delete")
	@ResponseBody
	public boolean bookmark_delete(@RequestParam int bmNo, HttpServletRequest request, Model model,
								  HttpSession session) throws Exception{
		boolean result = false;
		result = bookmarkService.deleteBookmark(bmNo);
		return result;
	}
	
	//친구리스트
	@RequestMapping("/friend_list")
	public String friend_list(HttpServletResponse response, 
							  HttpServletRequest request,
							  HttpSession session) {
		//int mNo = (Integer)request.getAttribute("mNo");
		List<Friend> friendList;
		try {
			Integer mNo = (Integer)session.getAttribute("userNo");
			System.out.println("@@@"+mNo);
			if(mNo==null) {
				mNo = 7;
			}
			friendList = friendService.selectList(mNo);
			request.setAttribute("data", friendList);
			//System.out.println("@@@"+friendList);
			return "mypage/friend_list";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/main/index";
		}
	}
	
	//친구추가
	@RequestMapping("/friend_create")
	@ResponseBody
	public boolean friend_create(HttpServletResponse response, 
								 HttpServletRequest request, 
								 HttpSession session,
								 @RequestParam int fNo) throws Exception{
		Integer mNo = (Integer)session.getAttribute("userNo");
		boolean result = false;
		result = friendService.createFriend(fNo,mNo);
		System.out.println("%%%"+result);
		return result;
	}
	
	//친구삭제
	@RequestMapping("/friend_delete")
	@ResponseBody
	public boolean friend_delete(@RequestParam int fPk, HttpServletResponse response, HttpServletRequest request) throws Exception{
		//int fPk = (Integer)request.getAttribute("fPk");
		boolean result = false;
		result = friendService.deleteFriend(fPk);
		//request.setAttribute("result", result);
		return result;
	}
	
	//친구찾기 -- RestController로 이동필요
	@RequestMapping(value="/friend_find")
	@ResponseBody
	public String friend_find(@RequestParam(name="mId", defaultValue = "") String mId, 
											HttpServletRequest request) throws Exception{
		String result = friendService.findFriend(mId);
		if(result==null) {
			return "";
		}
		return result;
	}
	
	//친구번호찾기
	@RequestMapping(value="/friend_findNo", produces="application/json;charset=UTF-8")
	@ResponseBody
	public int friend_findNo(@RequestParam String mId) {
		try {
			int mNo = friendService.findFriendNo(mId);
			return mNo;
		} catch (Exception e) {
			e.printStackTrace();
			return -999;
		}
		
	}
	
	//메시지보내기 창
	@RequestMapping("/message")
	public String message_selectOne(Model model, HttpSession session, @RequestParam("mNo") int mNo) throws Exception {
		//System.out.println("*******"+mNo);
		session.getAttribute("userNo");
		Member member = mypageService.selectOne(mNo);
		model.addAttribute("member", member);
		return "mypage/message";
	}
	
	//메시지리스트(멤버&메시지 조인)
	@RequestMapping("/message_list")
	public ModelAndView message_selectList(HttpSession session, Model model) {
		ModelAndView mv = new ModelAndView();
		List<Message> messageList;
		try {
			Integer mNo = (Integer)session.getAttribute("userNo");
			if(mNo==null) {
				mNo = 7;
			}
			messageList = messageService.selectMessageList(mNo);
			model.addAttribute("data", messageList);
			mv.setViewName("mypage/message_list");
			return mv;
		} catch (Exception e) {
			e.printStackTrace();
			mv.setViewName("redirect:/main/index");
			return mv;
		}
		
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
		List<Product> writeList;
		try {
			Integer mNo = (Integer)session.getAttribute("userNo");
			if(mNo==null) {
				mNo = 7;
			}
			writeList = mypageService.selectWriteList(mNo);
			request.setAttribute("data", writeList);
			return "mypage/member_write";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/main/index";
		}
		//model.addAttribute("writeList", writeList);
	}
	
	//내가쓴글삭제
	@RequestMapping("/member_write_delete")
	@ResponseBody
	public boolean member_write_delete(HttpServletRequest request, 
									  HttpServletResponse response,
									  @RequestParam int pNo) throws Exception{
		boolean result = false;
		result = mypageService.deleteWrite(pNo);
		//request.setAttribute("result", result);
		return result;
	}
	
	//결제리스트출력
	@RequestMapping("/payment_list")
	public String payment_list(HttpServletRequest request, 
							   HttpServletResponse response,
							   HttpSession session) {
		List<Payment> paymentList;
		try {
			Integer mNo = (Integer)session.getAttribute("userNo");
			if(mNo==null) {
				mNo = 7;
			}
			paymentList = paymentService.selectList(mNo);
			request.setAttribute("data", paymentList);
			return "mypage/payment_list";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/main/index";
		}
	}
	
	//결제화면
	@RequestMapping("/payment")
	public String payment() {
		return "mypage/payment";
	}
	
	//테스트화면
	@RequestMapping("/screen")
	public String test() {
		return "mypage/test2";
	}
	
	
	//@RequestMapping("/test4")
	public ModelAndView friend_find(Model model) throws Exception{
		ModelAndView mv = new ModelAndView();
		//String name = friendService.findFriend("hiphopmy");
		//model.addAttribute("name", name);
		mv.setViewName("test3");
		return mv;
	}
	
	
	
}
