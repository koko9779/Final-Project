package com.itwill.staily.detail.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.itwill.staily.detail.model.dto.Reply;

public interface ReplyMapper {
	public List<Reply> selectReplyList(int pNo);
	
	public Reply selectReplyOne(int rNo);
	
	public boolean createReply(Reply reply);
	
	public boolean deleteReply(@Param("rNo") int rNo, @Param("pNo") int pNo, @Param("mNo") int mNo);
	
	public boolean increaseRecommend(int rNo);
	
	public boolean increaseReport(int rNo);
}
