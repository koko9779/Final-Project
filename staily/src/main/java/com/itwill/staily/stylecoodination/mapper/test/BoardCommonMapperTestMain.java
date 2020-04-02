package com.itwill.staily.stylecoodination.mapper.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.staily.stylecoodination.mapper.BoardCommonMapper;
import com.itwill.staily.util.Board;

public class BoardCommonMapperTestMain {

	public static void main(String[] args) throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/application-config.xml");
		BoardCommonMapper common = applicationContext.getBean(BoardCommonMapper.class);
		int count;
		
//		int mNo = common.selectMNo("koko97");
//		System.out.println(mNo);
		
//		Board b = new Board();
//		b.setbTitle("테스트게시글수정");
//		b.setbContent("테스트게시글수정했다요~");
//		b.setbNo(34);
//		count = common.updateBoardAndReply(b);
//		System.out.println(count);
		
//		Board b = new Board();
//		b.setbTitle("테스트댓글수정");
//		b.setbContent("테스트댓글수정했다요~");
//		b.setbNo(33);
//		count = common.updateBoardAndReply(b);
//		System.out.println(count);
		
//		String id = common.selectId(1);
//		System.out.println(id);
		
		
		
		
		
		
		
		
		
	}
	
}
