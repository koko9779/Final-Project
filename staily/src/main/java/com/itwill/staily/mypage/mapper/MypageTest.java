package com.itwill.staily.mypage.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.staily.detail.mapper.WorkDetailMapper;
import com.itwill.staily.main.mapper.ListMapper;
import com.itwill.staily.mypage.model.dto.Bookmark;
import com.itwill.staily.mypage.model.dto.Friend;
import com.itwill.staily.mypage.model.dto.Message;
import com.itwill.staily.util.Company;
import com.itwill.staily.util.Member;
import com.itwill.staily.util.Product;
import com.itwill.staily.util.Work;

public class MypageTest {
	public static void main(String[] args) throws Exception{
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/application-config.xml");
		BookmarkMapper bk = applicationContext.getBean(BookmarkMapper.class);
		MypageMapper mp = applicationContext.getBean(MypageMapper.class);
		MessageMapper ms = applicationContext.getBean(MessageMapper.class);
		FriendMapper fm = applicationContext.getBean(FriendMapper.class);
		
		
		System.out.println(fm.findFriend("hiphopmy"));
		
		System.out.println(fm.deleteFriend(9));
		
		
		
		
		
		
		
		
		
		/*
		List<Message> messageList = ms.selectMessageList(2);
		for (Message message : messageList) {
			System.out.println(message.getMsNo()+","+message.getmNo()+","+message.getMsTitle()+","+message.getmId());
		}
		//insert into message (ms_no, m_no, ms_title, ms_content, ms_date) 
		//values (MESSAGE_NO_SEQ.nextval,#{mNo},#{msTitle},#{msContent},sysdate)	
		Message m = new Message(0,2,"제목4","안녕4",null);
		//ms.createMessage(m);
		System.out.println(ms.deleteMessage(6));
		*/
		  
		
		
		
		/*
		List<Friend> friendList = fm.selectList(1);
		for (Friend friend : friendList) {
			System.out.println(friend.getfPk()+","+friend.getmName()+","+friend.getmNo()+","+friend.getfNo()+","+friend.getmName());
		}
		*/
		
		
		
		
		/******************Bookmark***********************************
		List<Bookmark> bookmarkList1 = bk.selectList(1);
		for (Bookmark bookmark : bookmarkList1) {
			System.out.println(bookmark.getBmNo()+","+bookmark.getMember().getmId()+","+
						 	   bookmark.getProduct().getPdScene()+","+bookmark.getProduct().getpName());
		}
		System.out.println(bk.deleteBookmark(3));
		
		List<Bookmark> bookmarkList2 = bk.selectList(1);
		for (Bookmark bookmark : bookmarkList2) {
			System.out.println(bookmark.getBmNo()+","+bookmark.getMember().getmId()+","+
						 	   bookmark.getProduct().getPdScene()+","+bookmark.getProduct().getpName());
		}
		*****************************************************************/
		
		
		
		
		
	}

}
