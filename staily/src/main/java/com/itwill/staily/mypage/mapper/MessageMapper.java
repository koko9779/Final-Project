package com.itwill.staily.mypage.mapper;

import java.util.List;

import com.itwill.staily.mypage.model.dto.Message;

public interface MessageMapper {
	
	//메시지 하나 선택
	public Message selectOne(int msNo) throws Exception;
	
	//메시지 리스트 
	public List<Message> selectList(int mNo) throws Exception;
	
	//메시지 추가
	public boolean createMessage(Message message) throws Exception;
	
	//메시지 삭제
	public boolean deleteMessage(int msNo) throws Exception;
	
	//메시지 화면 출력(멤버 & 메시지 조인)
	public List<Message> selectMessageList(int mNo) throws Exception;
}
