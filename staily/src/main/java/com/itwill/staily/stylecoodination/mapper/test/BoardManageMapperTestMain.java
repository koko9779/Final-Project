package com.itwill.staily.stylecoodination.mapper.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.staily.stylecoodination.mapper.BoardManageMapper;
import com.itwill.staily.util.Board;

public class BoardManageMapperTestMain {

	public static void main(String[] args) throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/application-config.xml");
		BoardManageMapper board = applicationContext.getBean(BoardManageMapper.class);
		int count;
		
		
//		Board b = new Board();
//		b.setmNo(5);
//		b.setbTitle("테스트용게시글이다");
//		b.setbContent("테스트용게시글 성공해라!");
//		count = board.createBoard(b);
//		System.out.println(count);
	
//		count = board.deleteBoard(35);
//		System.out.println(count);
		
		
		
		
		
		
		
		
		
		
	}
	
}
