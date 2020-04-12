package com.itwill.staily.detail.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.itwill.staily.detail.model.dto.Reply;
import com.itwill.staily.detail.service.ReplyService;
import com.itwill.staily.mypage.mapper.FriendMapper;
import com.itwill.staily.mypage.model.dto.Friend;
import com.itwill.staily.mypage.service.FriendService;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/detail")
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
	
	/*
	@RequestMapping("/createReply")
	public ModelAndView selectReplyOne(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		
		try {			
			String p_no = request.getParameter("p_no");
			String m_no = request.getParameter("m_no");
			String r_content = request.getParameter("r_content");
			String r_recommend = request.getParameter("r_recommend");
			String r_report = request.getParameter("r_report");
			Reply reply = new Reply(Integer.parseInt(p_no), Integer.parseInt(m_no), 
					r_content, Integer.parseInt(r_recommend), Integer.parseInt(r_report));
			boolean create = replyService.createReply(reply);
			
			if(create) {
				mv.setViewName("detailtest");
				
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		return mv;
	}
	*/
	/*
	@RequestMapping("/deleteReply")
	public ModelAndView deleteReply(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		
		try {
			String r_no = request.getParameter("r_no");
			String p_no = request.getParameter("p_no");
			String m_no = request.getParameter("m_no");
			
			boolean delete = replyService.deleteReply(Integer.parseInt(r_no), Integer.parseInt(p_no), Integer.parseInt(m_no));
			
			if(delete) {
				mv.setViewName("detailtest");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mv;
	}
	*/
	/*
	@RequestMapping("/detailtest")
	public ModelAndView increaseReply(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		
		try {
			Reply sR = replyService.selectReplyOne(3);
			request.setAttribute("replyOne", sR);
			
			boolean inc = replyService.increaseRecommend(3);
			boolean inc2 = replyService.increaseReport(3);
			
			request.setAttribute("reco", sR.getrRecommend());
			request.setAttribute("repo", sR.getrReport());
			
			if(inc && inc2) {
				mv.setViewName("detailtest");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return mv;
	}
	*/
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
