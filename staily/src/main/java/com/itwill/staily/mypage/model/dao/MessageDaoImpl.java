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
	public Message selectOne(int msNo) {
		Message message = messageMapper.selectOne(msNo);
		return message;
	}

	@Override
	public List<Message> selectList(int mNo) {
		List<Message> messageList = messageMapper.selectList(mNo);
		return messageList;
	}

	@Override
	public int createMessage(Message message) {
		int insertRow = messageMapper.createMessage(message);
		return insertRow;
	}

	@Override
	public int deleteMessage(int msNo) {
		int deleteRow = messageMapper.deleteMessage(msNo);
		return deleteRow;
	}

	@Override
	public int updateMessage(Message message) {
		int updateRow = messageMapper.updateMessage(message);
		return updateRow;
	}

}
