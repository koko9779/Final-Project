package com.itwill.staily.detail.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public boolean createReply(Reply reply) throws Exception {
		boolean check = false;
		
		if(replyMapper.createReply(reply)) {
			check = true;			
		}
		else {
			check = false;
		}
		
		return check;
	}

	@Override
	public boolean deleteReply(Reply reply) throws Exception {
		boolean check = false;
		
		if(replyMapper.deleteReply(reply)) {
			check = true;			
		}
		else{
			check = false;
		}
		
		return check;
	}

}
