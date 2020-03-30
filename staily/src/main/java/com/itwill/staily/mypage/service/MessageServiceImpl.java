package com.itwill.staily.mypage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.staily.mypage.mapper.MessageMapper;
import com.itwill.staily.mypage.model.dto.Message;

@Service
public class MessageServiceImpl implements MessageService {
	@Autowired
	private MessageMapper messageMapper;
	
	public MessageServiceImpl() {
		
	}
	
	public MessageMapper getMessageMapper() {
		return messageMapper;
	}

	public void setMessageMapper(MessageMapper messageMapper) {
		this.messageMapper = messageMapper;
	}


	@Override
	public Message selectOne(int msNo) throws Exception {
		return messageMapper.selectOne(msNo);
	}

	@Override
	public List<Message> selectList(int mNo) throws Exception {
		return messageMapper.selectList(mNo);
	}

	@Override
	public int createMessage(Message message) throws Exception {
		return messageMapper.createMessage(message);
	}

	@Override
	public int deleteMessage(int msNo) throws Exception {
		return messageMapper.deleteMessage(msNo);
	}

	@Override
	public int updateMessage(Message message) throws Exception {
		return messageMapper.updateMessage(message);
	}

}
