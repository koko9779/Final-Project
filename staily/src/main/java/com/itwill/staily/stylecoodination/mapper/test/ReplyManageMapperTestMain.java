package com.itwill.staily.stylecoodination.mapper.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.staily.stylecoodination.mapper.ReplyManageMapper;
import com.itwill.staily.util.Board;

public class ReplyManageMapperTestMain {

	public static void main(String[] args) throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/application-config.xml");
		ReplyManageMapper reply = applicationContext.getBean(ReplyManageMapper.class);
		int count;
//		 count = reply.updateRecommend(2);
//		System.out.println(count);
		
//		count = reply.updateChoice(23);
//		System.out.println(count);
		
//		count = reply.deleteReply(29);
//		System.out.println(count);
		
//		count = reply.updateStep(2);
//		System.out.println(count);
		
//		Board b = new Board();
//		b.setmNo(3);
//		b.setbTitle("테스트용댓글");
//		b.setbContent("테스트용댓글이지요!~");
//		b.setbGroupNo(2);
//		count = reply.createReply(b);
//		System.out.println(count);
		
		
		
		
		
		
		
		
		
	}
	
}
