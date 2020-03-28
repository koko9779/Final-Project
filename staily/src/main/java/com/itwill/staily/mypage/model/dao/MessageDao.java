package com.itwill.staily.mypage.model.dao;

import java.util.List;

import com.itwill.staily.mypage.model.dto.Message;

public interface MessageDao {
	
public Message selectOne(int msNo);
	
	public List<Message> selectList(int mNo);
	
	public int createMessage(Message message);
	
	public int deleteMessage(int msNo);
	
	public int updateMessage(Message message);

}
