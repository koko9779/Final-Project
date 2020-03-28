package com.itwill.staily.detail.model.dao;

import java.util.List;

import com.itwill.staily.detail.model.dto.Reply;

public interface ReplyDao {
	List<Reply> selectReplyList(int pNo) throws Exception;
	
	boolean createReply(Reply reply) throws Exception;
	
	boolean deleteReply(Reply reply) throws Exception;
	
	boolean checkReplyUser(Reply reply, int mNo) throws Exception;
}
