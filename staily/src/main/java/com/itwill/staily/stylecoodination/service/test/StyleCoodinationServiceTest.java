package com.itwill.staily.stylecoodination.service.test;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwill.staily.stylecoodination.service.StyleCoodinationService;
import com.itwill.staily.util.Board;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/application-config.xml")
public class StyleCoodinationServiceTest {
	@Autowired
	private ApplicationContext applicationContext;
	@Autowired
	private StyleCoodinationService styleCoodinationService;
	
	@Test
	public void styleCoodinationServiceTest() {
		assertNotNull(applicationContext);
		assertNotNull(styleCoodinationService);
	}
	
	
	@Test
	@Ignore
	public void testModifyBoardAndReply() throws Exception {
		Board updateBoard = new Board();
		updateBoard.setbTitle("제이유닛바꾸기");
		updateBoard.setbContent("바꾸기성공?");
		updateBoard.setbNo(100);
		styleCoodinationService.modifyBoardAndReply(updateBoard);
	}
	
	
	@Test
	@Ignore
	public void testWriteBoard() throws Exception {
		Board board = new Board();
		board.setbTitle("글쓰기");
		board.setbContent("글쓰기에용");
		board.setmNo(3);
		
		styleCoodinationService.writeBoard(board);
	}
	
	
	@Test
	@Ignore
	public void testRemoveBoard() throws Exception {
		styleCoodinationService.removeBoard(62);
	}
	
	@Test
	@Ignore
	public void testWriteReply() throws Exception {
		Board board = new Board();
		board.setbTitle("글쓰기");
		board.setbContent("글쓰기에용");
		board.setmNo(3);
		board.setbGroupNo(31);
		
		styleCoodinationService.writeReply(board, "ehdanf91");
		
	}
	
	
	@Test
	@Ignore
	public void testRemoveReply() throws Exception {
		styleCoodinationService.removeReply(64);
	}
	
	@Test
	@Ignore
	public void testCheckChoice() throws Exception {
		styleCoodinationService.checkChoice(23);
	}
	
	@Test
	@Ignore
	public void testCheckRecommend() throws Exception {
		styleCoodinationService.checkRecommend(32);
	}
	
	@Test
	@Ignore
	public void testFindBoardTop10() {
		List<Board> boardList = styleCoodinationService.findBoardTop10();
		for (Board board : boardList) {
			System.out.println(board);
		}
	}
	
	@Test
	@Ignore
	public void testFindBoardAll() {
		List<Board> boardList = styleCoodinationService.findBoardAll();
		for (Board board : boardList) {
			System.out.println(board);
		}
	}
	
	@Test
	@Ignore
	public void testFindBoardCount() {
		int count = styleCoodinationService.findBoardCount();
		System.out.println(count);
	}
	
	@Test
	@Ignore
	public void testFindBoardReplyCount() {
		int count = styleCoodinationService.findBoardReplyCount();
		System.out.println(count);
	}
	
	@Test
	public void testUpdateViewCount() throws Exception {
		int count = styleCoodinationService.updateViewCount(22);
		System.out.println(count);
	}
}
