package com.itwill.staily.mypage.model.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.staily.mypage.mapper.BookmarkMapper;

public class Test {
	public static void main(String[] args) throws Exception{
		BookmarkDao bk = new BookmarkDaoImpl();
		System.out.println(bk.deleteBookmark(2));
		
		
		
		
	}

}
