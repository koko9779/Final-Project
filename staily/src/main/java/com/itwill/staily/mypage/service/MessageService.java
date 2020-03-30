package com.itwill.staily.mypage.service;

import java.util.List;

import com.itwill.staily.mypage.model.dto.Message;

public interface MessageService {
	//메시지 한개 출력
	public Message selectOne(int msNo) throws Exception;
	
	//메시지 리스트 출력
	public List<Message> selectList(int mNo) throws Exception;
	
	//메시지 생성
	public int createMessage(Message message) throws Exception;
	
	//메시지 삭제
	public int deleteMessage(int msNo) throws Exception;
	
	//메시지 수정
	public int updateMessage(Message message) throws Exception;
	
	//메시지 실제 화면 출력(멤버&메시지 조인)
	public List<Message> selectMessageList(int mNo) throws Exception;

}
