package com.itwill.staily.stylecoodination.mapper.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.staily.stylecoodination.mapper.ViewMapper;
import com.itwill.staily.util.Board;

public class ViewMapperTestMain {

	public static void main(String[] args) throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/application-config.xml");
		ViewMapper view = applicationContext.getBean(ViewMapper.class);
		int count;
		
//		count = view.updateView(2);
//		System.out.println(count);
		
//		count = view.selectBoardReplyCount();
//		System.out.println(count);
		
//		count = view.selectBoardCount();
//		System.out.println(count);
		
//		List<Board> bList= view.selectBoardAll("S");
//		for (Board board : bList) {
//			System.out.println(board.toString());
//		}
		
		
		
		
		
		
		
		
		
		
	}
	
}
