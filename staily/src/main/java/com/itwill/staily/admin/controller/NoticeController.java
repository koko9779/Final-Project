package com.itwill.staily.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notice")
public class NoticeController {
	@RequestMapping("/main")
	public String noticeMain() {
		return "notice/notice_read";
	}
}
