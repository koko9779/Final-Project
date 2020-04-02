package com.itwill.staily.stylecoodination.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.staily.stylecoodination.service.StyleCoodinationService;
import com.itwill.staily.util.Board;

@Controller
public class StyleCoodinationController {
	@Autowired
	 private StyleCoodinationService styleCoodinationService;
	
	@RequestMapping("/styleCoodination_main")
	public String styleCoodinationMain(Model model) {
		List<Board> boardTop10;
		List<Board> boardList;
		
		boardTop10 = styleCoodinationService.findBoardTop10();
		boardList = styleCoodinationService.findBoardAll();
		
		model.addAttribute("boardTop10", boardTop10);
		model.addAttribute("boardList", boardList);
		
		return "";
	}
	
	
}
