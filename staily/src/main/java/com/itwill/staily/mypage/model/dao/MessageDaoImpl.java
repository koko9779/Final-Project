package com.itwill.staily.mypage.model.dao;

import java.util.List;

import com.itwill.staily.mypage.mapper.MessageMapper;
import com.itwill.staily.mypage.model.dto.Message;

public class MessageDaoImpl implements MessageDao {
	
	private MessageMapper messageMapper;
	
	public MessageDaoImpl() {
		
	}
	

	public MessageMapper getMessageMapper() {
		return messageMapper;
	}


	public void setMessageMapper(MessageMapper messageMapper) {
		this.messageMapper = messageMapper;
	}


	@Override
	public List<Message> selectList(int mNo) throws Exception{
		List<Message> messageList = messageMapper.selectList(mNo);
		return messageList;
	}

	@Override
	public int createMessage(Message message) throws Exception {
		int insertRow = messageMapper.createMessage(message);
		return insertRow;
	}

	@Override
	public int deleteMessage(int msNo) throws Exception{
		int deleteRow = messageMapper.deleteMessage(msNo);
		return deleteRow;
	}

	@Override
	public int updateMessage(Message message) throws Exception{
		int updateRow = messageMapper.updateMessage(message);
		return updateRow;
	}


	@Override
	public Message selectOne(int msNo) throws Exception{
		// TODO Auto-generated method stub
		return null;
	}

}
