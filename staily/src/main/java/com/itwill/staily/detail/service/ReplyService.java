package com.itwill.staily.detail.service;

import java.util.List;

import com.itwill.staily.detail.model.dto.Reply;

public interface ReplyService {
	List<Reply> selectReplyList(int pNo) throws Exception;
	
	boolean createReply(Reply reply) throws Exception;
	
	boolean deleteReply(Reply reply) throws Exception;
	
	boolean increaseRecommend(int rNo) throws Exception;
	
	boolean increaseReport(int rNo) throws Exception;	
}
