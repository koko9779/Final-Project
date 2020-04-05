package com.itwill.staily.stylecoodination.controller;

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
		List<Board> boardTop10;
		List<Board> boardList;
		int boardCount = 0;
		int replyCount = 0;
		
		boardTop10 = styleCoodinationService.findBoardTop10();
		boardList = styleCoodinationService.findBoardAll();
		boardCount = styleCoodinationService.findBoardCount();
		replyCount = styleCoodinationService.findBoardReplyCount();
		
		model.addAttribute("boardTop10", boardTop10);
		model.addAttribute("boardList", boardList);
		model.addAttribute("boardCount", boardCount);
		model.addAttribute("replyCount", replyCount);
		
		return "style/style_main";
	}
	
	@RequestMapping("style_view")
	public String style_view(@RequestParam int bNo) {
		styleCoodinationService.findBoardOne(bNo);
		return "";
	}
	
	
}
