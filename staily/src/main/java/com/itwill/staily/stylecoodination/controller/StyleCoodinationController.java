package com.itwill.staily.stylecoodination.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.staily.stylecoodination.service.StyleCoodinationService;
import com.itwill.staily.util.Board;

@Controller
@RequestMapping("/style")
public class StyleCoodinationController {
	@Autowired
	 private StyleCoodinationService styleCoodinationService;
	
	@RequestMapping("/style_main")
	public String style_main(Model model) {
		List<Board> boardTop10 = new ArrayList<Board>();
		List<Board> data = new ArrayList<Board>();;
		int boardCount = 0;
		int replyCount = 0;
		
		boardTop10 = styleCoodinationService.findBoardTop10();
		data = styleCoodinationService.findBoardAll();
		boardCount = styleCoodinationService.findBoardCount();
		replyCount = styleCoodinationService.findBoardReplyCount();
		
		model.addAttribute("boardTop10", boardTop10);
		model.addAttribute("data", data);
		model.addAttribute("boardCount", boardCount);
		model.addAttribute("replyCount", replyCount);
		
		return "style/style_main";
	}
	
	// 구현 차분히 생각해보고 나머지 작업하기
	@RequestMapping("/style_view")
	public String style_view(@RequestParam int bNo, Model model) {
		List<Board> boardOneList = new ArrayList<Board>();
		
		boardOneList = styleCoodinationService.findBoardOne(bNo);
		model.addAttribute("boardOneList", boardOneList);
		
		return "forward:WEB-INF/views/style/style_view.jsp?bNo="+bNo;
	}
	
	
	
	
	
	
}
