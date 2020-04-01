package com.itwill.staily.stylecoodination.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.staily.stylecoodination.exception.FailRemoveBoardException;
import com.itwill.staily.stylecoodination.exception.FailWriteBoardException;
import com.itwill.staily.stylecoodination.mapper.BoardManageMapper;
import com.itwill.staily.stylecoodination.mapper.BoardCommonMapper;
import com.itwill.staily.stylecoodination.mapper.ReplyManageMapper;
import com.itwill.staily.stylecoodination.mapper.ViewMapper;
import com.itwill.staily.util.Board;

@Service
public class StyleCoodinationServiceImpl {
	@Autowired
	private BoardManageMapper boardManageMapper;
	@Autowired
	private BoardCommonMapper boardCommonMapper;
	@Autowired
	private ReplyManageMapper replyManageMapper;
	@Autowired
	private ViewMapper viewMapper;
	
	public int modifyBoardAndReply() {
		
		return 0;
	}
	
	public int writeBoard(Board board) {
		int writeCount = 0;
		
		writeCount = boardManageMapper.createBoard(board);
		if(writeCount != 1) {
			throw new FailWriteBoardException("게시글 작성에 실패하였습니다");
		}
		return writeCount;
	}
	
	public int removeBoard(int groupNo) {
		int removeCount = 0;
		
		removeCount = boardManageMapper.deleteBoard(groupNo);
		if(removeCount != 1) {
			throw new FailRemoveBoardException("게시글 삭제에 실패하였습니다");
		}
		return removeCount;
	}
	
	public int writeReply(Board replyBoard, String mId) {
		int writeCount = 0;
		int mNo = 0;
		
		// 1. 기존 댓글들의 step 1씩 증가
		replyManageMapper.updateStep(replyBoard.getbGroupNo());
		// 2. mNo를 구하기 위한 작업
		mNo = boardCommonMapper.selectMNo(mId);
		replyBoard.setmNo(mNo);
		// 3. 댓글 작성
		writeCount = replyManageMapper.createReply(replyBoard);
		if(writeCount != 1) {
			throw new FailWriteBoardException("댓글 작성에 실패하였습니다");
		}
		return writeCount;
	}
	
	public int removeReply(int bNo) {
		int removeCount = 0;
		
		removeCount = replyManageMapper.deleteReply(bNo);
		if(removeCount != 1) {
			throw new FailRemoveBoardException("게시글 삭제에 실패하였습니다");
		}
		return removeCount;
	}
	
	public int checkChoice(int bNo) {
		int updateCount = 0;
		
		updateCount = replyManageMapper.updateChoice(bNo);
		//업데이트 안되면 0인 상태로 controller에서 
		//ui에 영향을 미칠 데이터 작업
		return updateCount;
	}
	
	public int checkRecommend(int bNo) {
		int updateCount = 0;
		
		updateCount= replyManageMapper.updateRecommend(bNo);
		//업데이트 안되면 0인 상태로 controller에서 
		//ui에 영향을 미칠 데이터 작업
		return 0;
	}
	
	
}
