package com.itwill.staily.mypage.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@RequestMapping("404")
	public String error() {
		return "redirect:/404.jsp";
	}
	
	//�쉶�썝�젙蹂댁텧�젰
	@RequestMapping("/member_select")
	public String member_select(HttpSession session, Model model, HttpServletRequest request){
		Member member;
		try {
			Integer mNo = (Integer)session.getAttribute("userNo");
			member = mypageService.selectOne(mNo);
			String phn = member.getmPhone();
			String phn1 = phn.substring(0,3);
			String phn2 = phn.substring(3,7);
			String phn3 = phn.substring(7);
			if(member.getmType().equals("M")) {
				model.addAttribute("member", member);
				model.addAttribute("phn1", phn1);
				model.addAttribute("phn2", phn2);
				model.addAttribute("phn3", phn3);
				
			}else if(member.getmType().equals("C")) {
				Member memberCompany = mypageService.selectMemberCompany(mNo);
				model.addAttribute("member", memberCompany);
				model.addAttribute("phn1", phn1);
				model.addAttribute("phn2", phn2);
				model.addAttribute("phn3", phn3);
			}
			return "mypage/member";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/main/index";
		}
		
		
	}
	
	//�쉶�썝�젙蹂댁뾽�뜲�씠�듃[validator]
	@RequestMapping("/member_update")
	@ResponseBody
	public String member_update(HttpSession session,
							   @RequestParam String phn1,
							   @RequestParam String phn2,
							   @RequestParam String phn3,
							   @RequestParam String mId,
							   @RequestParam String mPw,
							   @RequestParam String mName,
							   @RequestParam String mAddress,
							   @RequestParam String mDaddress,
							   @RequestParam String mEmail,
							   @RequestParam String mType) throws Exception {
		
		int mNo = (Integer)session.getAttribute("userNo");
		String mPhone = phn1 + phn2 + phn3; 
		boolean result = false;
		Member member = new Member(mNo,mId,mPw,mName,mAddress,mDaddress,mEmail,mType,mPhone); 
		result = mypageService.updateMember(member);
		return result+"";
	}
	/*
	//�쉶�썝�젙蹂댁뾽�뜲�씠�듃
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
	*/
	
	
	//�쉶�썝�깉�눜
	@RequestMapping("member_delete")
	@ResponseBody
	public String member_delete(@RequestParam("mNo") int mNo, HttpSession session) {
		boolean result = false;
		try {
			result = mypageService.deleteMember(mNo);
			session.invalidate();
			return result+"";
		} catch (Exception e) {
			e.printStackTrace();
			return "N";
		}
	}
	
	
	//遺곷쭏�겕由ъ뒪�듃
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
	}
	
	//遺곷쭏�겕�궘�젣[諛곗뿴]
	@RequestMapping("/bookmark_delete")
	@ResponseBody
	public String bookmark_delete(@RequestParam(value="bmNo[]") List<Integer> bmNoList) {
		boolean result = false;
		for (Integer bmNo : bmNoList) {
			try {
				result = bookmarkService.deleteBookmark(bmNo);
			} catch (Exception e) {
				e.printStackTrace();
				return "N";
			}
		}
		return result+"";
	}
	
	//移쒓뎄由ъ뒪�듃
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
	
	//移쒓뎄異붽�
	@RequestMapping("/friend_create")
	@ResponseBody
	public Object friend_create(HttpSession session,
								@RequestParam("mNo") int fNo,
								@RequestParam("mId") String mId) throws Exception{
		Map<String,Object> result = new HashMap<String,Object>();
		int mNo = (Integer)session.getAttribute("userNo");
		String checkMid = (String)session.getAttribute("userId");
		Friend friend;
		if(checkMid.equals(mId)) {
			result.put("status", "M");
			return result;
			
		}else {
			int check = friendService.duplicateFriendNo(mNo,fNo);
			if(check == 0) {
				friendService.createFriend(fNo,mNo);
				friend =friendService.selectFriendPk(mNo, fNo);
				
				result.put("status","success");
				result.put("fPk",friend.getfPk());
				return result;
			}else {
				result.put("status","D");
				return result;
			}
			
		}
		
	}
	
	
	//移쒓뎄異붽�
	/*
	@RequestMapping("/friend_create")
	@ResponseBody
	public String friend_create( HttpSession session,
								 @RequestParam("mNo") int fNo,
								 @RequestParam("mId") String mId) throws Exception {
		Integer mNo = (Integer)session.getAttribute("userNo");
		String checkMid = (String)session.getAttribute("userId");
		boolean result = false;
		if(checkMid.equals(mId)) {
			return "D";
			
		}else {
			int check = friendService.duplicateFriendNo(mNo,fNo);
			if(check == 0) {
				result = friendService.createFriend(fNo,mNo);
			}else {
				return result+"";
			}
			return result+"";
			
		}
	}
	*/
	//移쒓뎄�궘�젣
	@RequestMapping("/friend_delete")
	@ResponseBody
	public String friend_delete(@RequestParam(value="fPk[]") List<Integer> fPkList) {
		boolean result = false;
		for (Integer fPk : fPkList) {
			try {
				result = friendService.deleteFriend(fPk);
			} catch (Exception e) {
				e.printStackTrace();
				return "N";
			}
		}
		return result+"";
	}
	
	//移쒓뎄李얘린
	@RequestMapping("/friend_find")
	@ResponseBody
	public Object friend_find(@RequestParam(value="mId") String mId) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		int memberCheck = friendService.duplicateFriend(mId);
		if(memberCheck != 0) {
			int mNo = friendService.findFriendNo(mId);
			result.put("status","success");
			result.put("mId", mId);
			result.put("mNo", mNo);
			return result;
		}else {
			result.put("status","fail");
			return result;
		}
	}
	
	/*********************************** 硫붿떆吏� 硫붿냼�뱶 ***********************************/
	
	//硫붿떆吏�蹂대궡湲� 李�
	@RequestMapping("/message")
	public String message_selectOne(Model model, HttpSession session, @RequestParam(value= "mNo", defaultValue = "") Integer mNo) throws Exception {
		//System.out.println("*******"+mNo);
		session.getAttribute("userNo");
		//�쉶�썝李얘린
		if(mNo == null) {
			return "mypage/message";
		}
		Member member = mypageService.selectOne(mNo);
		model.addAttribute("member", member);
		return "mypage/message";
	}
	
	
	//硫붿떆吏� �깮�꽦
	@RequestMapping("/message_create")
	@ResponseBody
	public String message_create(HttpSession session,
								@RequestParam(value="mId", defaultValue = "") String mId,
								@RequestParam String msTitle,
								@RequestParam String msContent,
								@RequestParam(name="rNo", defaultValue = "-999") int rNo) {
		int mNo = (Integer)session.getAttribute("userNo");
		boolean result;
		Message message;
		
		if(rNo == -999) {
			try {
				rNo = friendService.findFriendNo(mId);
				message = new Message(mNo,msTitle,msContent,rNo);
				result = messageService.createMessage(message);
				return result+"";
			} catch (Exception e) {
				e.printStackTrace();
				return "N";
			}
		}else {
			try {
				message = new Message(mNo,msTitle,msContent,rNo);
				result = messageService.createMessage(message);
				return result+"";
			} catch (Exception e) {
				e.printStackTrace();
				return "N";
			}
		}
		
	}
	
	
	//硫붿떆吏� 由ъ뒪�듃
	@RequestMapping("/message_list")
	public String message_list(HttpSession session, HttpServletRequest request) {
		int rNo = (Integer)session.getAttribute("userNo");
		List<Message> messageList;
		try {
			messageList = messageService.selectList(rNo);
			request.setAttribute("messageList", messageList);
			return "mypage/message_receive";
		} catch (Exception e) {
			e.printStackTrace();
			return "404";
		}
		
	}
	
	//硫붿떆吏� �븯�굹 蹂댁뿬二쇨린
	@RequestMapping("/message_view")
	public String message_view(@RequestParam int msNo, HttpServletRequest request, HttpSession session) {
		int rNo = (Integer)session.getAttribute("userNo");
		Message message;
		try {
			message = messageService.selectOne(rNo,msNo);
			request.setAttribute("message", message);
			return "mypage/message_view";
		} catch (Exception e) {
			e.printStackTrace();
			return "404";
		}
	}
	
	//硫붿떆吏��궘�젣
	@RequestMapping(value="/message_delete")
	@ResponseBody
	public String message_delete(@RequestParam(value="msNo[]") List<Integer> msNoList){
		boolean result = false;
		for (Integer msNo : msNoList) {
			try {
				result = messageService.deleteMessage(msNo);
			} catch (Exception e) {
				e.printStackTrace();
				return "N";
			}
			
		}
		return result+"";
	}
	
	/*********************************** 硫붿떆吏� 硫붿냼�뱶 ***********************************/
	
	//�궡媛��벖湲�由ъ뒪�듃
	@RequestMapping("/member_write")
	public String member_write(HttpServletRequest request, 
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
	}
	
	//�궡媛��벖湲��궘�젣
	@RequestMapping("/member_write_delete")
	@ResponseBody
	public String member_write_delete(@RequestParam(value="pNo[]") List<Integer> pNoList){
		boolean result = false;
		for (Integer pNo : pNoList) {
			try {
				result = mypageService.deleteWrite(pNo);
			} catch (Exception e) {
				e.printStackTrace();
				return "N";
			}
			
		}
		return result+"";
	}
	
	//寃곗젣由ъ뒪�듃異쒕젰
	@RequestMapping("/payment_list")
	public String payment_list(HttpServletRequest request, 
							   HttpServletResponse response,
							   HttpSession session) {
		List<Payment> paymentList;
		try {
			Integer mNo = (Integer)session.getAttribute("userNo");
			paymentList = paymentService.selectList(mNo);
			int count = paymentList.size()-1;
			if(count == -1) {
				return "mypage/payment_list";
			}
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date day1 = new Date();				
			Date day2 = null;
			String endDate1 = paymentList.get(count).getEndDate();
			String endDate = endDate1.substring(0, 10);
			day2 = dateFormat.parse(endDate);
			int compare = day2.compareTo(day1);
			if(compare >= 0) {
				request.setAttribute("endDate", endDate);
				System.out.println("$$$$"+endDate);
			}
			request.setAttribute("data", paymentList);
			return "mypage/payment_list";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/main/index";
		}
	}
	
	//寃곗젣�솕硫�
	@RequestMapping("/payment")
	public String payment(HttpSession session, HttpServletRequest request) {
		int mNo = (Integer)session.getAttribute("userNo");
		try {
			Member member = mypageService.selectOne(mNo);
			request.setAttribute("member", member);
		} catch (Exception e) {
			e.printStackTrace();
			return "404";
		}
		return "mypage/payment";
	}
	
	/*
	 * SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date day1 = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(day1);
		cal.add(Calendar.DATE, 2);
		System.out.println(cal.getTime());
		
		String endDate = dateFormat.format(cal.getTime());
	 */
	
	//결제완료
	@RequestMapping("/payment_complete")
	@ResponseBody
	public String payment_complete(HttpSession session,
								   @RequestParam int pyPrice,
								   @RequestParam String pyName,
								   @RequestParam int pyPeriod,
								   @RequestParam String pyType) {
		int mNo = (Integer)session.getAttribute("userNo");
		boolean result = false;
		List<Payment> paymentList;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date day1 = new Date();				// 오늘날짜(결제당일 날짜)
		Date day2 = null;					
		Calendar cal = Calendar.getInstance();
		Payment payment = new Payment(mNo, pyPrice, pyName, pyPeriod, pyType);
		try {
			paymentList = paymentService.selectList(mNo);
			int count = paymentList.size()-1;
			System.out.println("$$$$$"+1);
			if(paymentList.size() == 0) {
				System.out.println("$$$$$"+0);
				cal.setTime(day1);
				cal.add(Calendar.DATE, pyPeriod);
				payment.setEndDate(dateFormat.format(cal.getTime()));
				result = paymentService.createPayment(payment);
				paymentService.updateCompanyY(mNo);
				paymentService.updateProductY(mNo);
				return result+"";
			}
			System.out.println("$$$$$"+2);
			day2 = dateFormat.parse(paymentList.get(count).getEndDate());
			if(day2==null) {
				day2=day1;
				System.out.println("$$$$$"+3);
			}
			cal.setTime(day2);
			int compare = day2.compareTo(day1);				//결제일 당일(오늘날짜)와 결제리스트의 결제종료일을 비교
			if(compare >= 0) {								//결제 종료일이 더 클 경우 새로 만들어지는 
				System.out.println("$$$$$"+4);
				cal.add(Calendar.DATE, pyPeriod);			//결제종료일은 기존 결제종료일에 기간을 더한 날짜가 된다
				payment.setEndDate(dateFormat.format(cal.getTime()));
				result = paymentService.createPayment(payment);
				paymentService.updateCompanyY(mNo);
				paymentService.updateProductY(mNo);
				return result+"";
				
			}else {											//결제종료일보다 오늘 날짜가 더 큰 경우
				System.out.println("$$$$$"+5);
				cal.setTime(day1);
				cal.add(Calendar.DATE, pyPeriod);
				payment.setEndDate(dateFormat.format(cal.getTime()));
				result = paymentService.createPayment(payment);
				paymentService.updateCompanyY(mNo);
				paymentService.updateProductY(mNo);
				return result+"";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return "N";
		}
		
	}
	
	//�뀒�뒪�듃�솕硫�
	@RequestMapping("/screen")
	public String test() {
		return "mypage/test2";
	}
		
}
