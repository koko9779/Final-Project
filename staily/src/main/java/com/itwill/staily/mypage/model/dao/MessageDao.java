package com.itwill.staily.mypage.model.dao;

import java.util.List;

import com.itwill.staily.mypage.model.dto.Message;

public interface MessageDao {
	
	public Message selectOne(int msNo) throws Exception;
	
	public List<Message> selectList(int mNo) throws Exception;
	
	public int createMessage(Message message) throws Exception;
	
	public int deleteMessage(int msNo) throws Exception;
	
	public int updateMessage(Message message) throws Exception;

}
