package com.itwill.staily.detail.mapper;

import java.util.List;

import com.itwill.staily.detail.model.dto.Reply;

public interface ReplyMapper {
	public List<Reply> selectReplyList(int pNo);
	
	public boolean createReply(Reply reply);
	
	public boolean deleteReply(Reply reply);
	
	public boolean checkReplyUser(Reply reply, int mNo);
}
