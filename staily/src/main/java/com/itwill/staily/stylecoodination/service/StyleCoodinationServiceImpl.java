package com.itwill.staily.stylecoodination.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.staily.stylecoodination.mapper.BoardCommonMapper;
import com.itwill.staily.stylecoodination.mapper.BoardManageMapper;
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
	
	public int modifyBoardAndReply(Board updateBoard) {
		return boardCommonMapper.updateBoardAndReply(updateBoard);
	}
	
	public int writeBoard(Board board) {
		return boardManageMapper.createBoard(board);
	}
	
	public int removeBoard(int bNo) {
		return boardManageMapper.deleteBoard(bNo);
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
		return replyManageMapper.createReply(replyBoard);
	}
	
	public int removeReply(int bNo) {
		return replyManageMapper.deleteReply(bNo);
	}
	
	public int checkChoice(int bNo) {
		//업데이트 안되면 0인 상태로 controller에서 
		//ui에 영향을 미칠 데이터를 작업하자
		return replyManageMapper.updateChoice(bNo);
	}
	
	public int checkRecommend(int bNo) {
		//업데이트 안되면 0인 상태로 controller에서 
		//ui에 영향을 미칠 데이터 작업
		return replyManageMapper.updateRecommend(bNo);
	}

	public List<Board> findBoardTop10() {
		return viewMapper.selectBoardTop10();
	}
	
	public List<Board> findBoardAll() {
		return viewMapper.selectBoardAll();
	}
	
	public int findBoardCount() {
		return viewMapper.selectBoardCount();
	}
	
	public int findBoardReplyCount() {
		return viewMapper.selectBoardReplyCount();
	}
	
	public int updateViewCount(int bNo) {
		return viewMapper.updateView(bNo);
	}
	
}
