package com.itwill.staily.admin.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.staily.admin.service.AdminService;
import com.itwill.staily.util.Board;

@Controller
@RequestMapping("/notice")
public class NoticeController {
	@Autowired
	private AdminService adminService;
	@RequestMapping("/main")
	public String noticeMain(HttpServletRequest request) throws Exception {
		List<Board>noticeList = new ArrayList();
		noticeList = adminService.selectBoardAll();
		request.setAttribute("data", noticeList);
		return "notice/notice_read";
	}
	@RequestMapping("/detail")
	public String noticeDetail(HttpServletRequest request,@RequestParam("bNo")int bNo) throws Exception {
		Board board = adminService.selectBoardOne(bNo);
		request.setAttribute("board", board);
		return"notice/notice_detail";
	}
}
