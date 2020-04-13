package com.itwill.staily.detail.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.staily.detail.mapper.ReplyMapper;
import com.itwill.staily.detail.model.dto.Reply;

@Service
public class ReplyServiceImpl implements ReplyService {
	@Autowired
	private ReplyMapper replyMapper;		

	public ReplyServiceImpl() {
		super();
	}

	public ReplyMapper getReplyMapper() {
		return replyMapper;
	}

	public void setReplyMapper(ReplyMapper replyMapper) {
		this.replyMapper = replyMapper;
	}

	@Override
	public List<Reply> selectReplyList(int pNo) throws Exception {
		return replyMapper.selectReplyList(pNo);
	}
	
	@Override
	public Reply selectReplyOne(int rNo) throws Exception {
		return replyMapper.selectReplyOne(rNo);
	}

	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED, propagation = Propagation.REQUIRED)
	public boolean createReply(Reply reply, int pNo) throws Exception {
		boolean check = false;
		
		if(replyMapper.createReply(reply)) {
			replyMapper.selectReplyList(pNo);
			
			check = true;			
		}
		else {
			check = false;
		}
		
		return check;
	}

	@Override
	public boolean deleteReply(@Param("rNo") int rNo, @Param("pNo") int pNo, @Param("mNo") int mNo) throws Exception {
		boolean check = false;
		
		if(replyMapper.deleteReply(rNo, pNo, mNo)) {
			check = true;			
		}
		else{
			check = false;
		}
		
		return check;
	}

	@Override
	public boolean increaseRecommend(int rNo) throws Exception {
		boolean check = false;
		
		if(replyMapper.increaseRecommend(rNo)) {
			check = true;			
		}
		else{
			check = false;
		}
		
		return check;
	}

	@Override
	public boolean increaseReport(int rNo) throws Exception {
		boolean check = false;
		
		if(replyMapper.increaseReport(rNo)) {
			check = true;			
		}
		else{
			check = false;
		}
		
		return check;
	}

	@Override
	public boolean createFriend(int mNo, int fNo) throws Exception {
		boolean check = false;
		
		if(replyMapper.createFriend(mNo, fNo)) {
			check = true;			
		}
		else{
			check = false;
		}
		
		return check;
	}

}
