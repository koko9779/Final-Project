package com.itwill.staily.detail.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itwill.staily.detail.model.dto.Reply;
import com.itwill.staily.detail.service.ReplyService;

@Controller
public class ReplyController {
	@Autowired
	private ReplyService replyService;
	
	public ReplyController() {
		
	}
	
	@RequestMapping("/detailtest")
	public ModelAndView selectReplyList(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		
		try {
			List<Reply> rL = replyService.selectReplyList(2);
			request.setAttribute("replyList", rL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		mv.setViewName("detailtest");
		
		return mv;		
	}
	
}
