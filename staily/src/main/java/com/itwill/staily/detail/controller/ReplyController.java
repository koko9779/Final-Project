package com.itwill.staily.detail.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.itwill.staily.detail.model.dto.Reply;
import com.itwill.staily.detail.service.ReplyService;
import com.itwill.staily.mypage.mapper.FriendMapper;
import com.itwill.staily.mypage.model.dto.Friend;
import com.itwill.staily.mypage.service.FriendService;

@SuppressWarnings("unused")
@RequestMapping("/detail")
@RestController
public class ReplyController {
	@Autowired
	private ReplyService replyService;
	
	@Autowired
	private FriendService friendService;
	
	public ReplyController() {
		
	}
	
	@RequestMapping("/reply_list")
	public List<Reply> selectReplyList(HttpServletRequest request, HttpServletResponse response, String pNo) throws Exception {
		
		List<Reply> rL = replyService.selectReplyList(Integer.parseInt(pNo));
		request.setAttribute("replyList", rL);
				
		return rL;			
	}
		
	
	@RequestMapping("/reply_create")
	public Reply replyCreate(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		try {			
			String pNo = request.getParameter("pNo");
			String wNo = request.getParameter("wNo");
			Integer mNo = (Integer)session.getAttribute("userNo");
			String rContent = request.getParameter("rContent");
						
			request.setAttribute("pNo", pNo);
			Reply reply = new Reply(Integer.parseInt(pNo), mNo, rContent);
			request.setAttribute("reply", reply);
			request.setAttribute("wNo", wNo);
			replyService.createReply(reply);
			
			return reply;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}		
	}
	
	
	
	@RequestMapping("/reply_delete")
	public int deleteReply(HttpServletRequest request, HttpServletResponse response) {
		try {
			String rNo = request.getParameter("rNo");
			String pNo = request.getParameter("pNo");
			String mNo = request.getParameter("mNo");
			
			boolean delete = replyService.deleteReply(Integer.parseInt(rNo), Integer.parseInt(pNo), Integer.parseInt(mNo));
			
			if(delete) {
				return 1;
			}
			else {
				return 0;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	
	@RequestMapping("/reply_increasereport")
	public int increaseReport(HttpServletRequest request, HttpServletResponse response) {
		try {
			String rNo = request.getParameter("rNo");
			
			
			
			boolean inc = replyService.increaseReport(Integer.parseInt(rNo));
			
			if(inc) {
				return 1;
			}
			else {
				return 0;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/*
	@RequestMapping("/detailtest")
	public ModelAndView createFriend(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		
		try {
			List<Friend> fL = friendService.selectList(1);
			request.setAttribute("friendList", fL);
			
			String m_no = request.getParameter("mNo");
			String f_no = request.getParameter("fNo");
			
			boolean create = replyService.createFriend(Integer.parseInt(m_no), Integer.parseInt(f_no));
			
			if(create) {
				mv.setViewName("detailtest");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return mv;
	}
	*/
	
}
