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
public class StyleCoodinationServiceImpl implements StyleCoodinationService {
	@Autowired
	private BoardManageMapper boardManageMapper;
	@Autowired
	private BoardCommonMapper boardCommonMapper;
	@Autowired
	private ReplyManageMapper replyManageMapper;
	@Autowired
	private ViewMapper viewMapper;
	
	@Override
	public int modifyBoardAndReply(Board updateBoard) {
		return boardCommonMapper.updateBoardAndReply(updateBoard);
	}
	
	@Override
	public int writeBoard(Board board) {
		return boardManageMapper.createBoard(board);
	}
	
	@Override
	public int removeBoard(int bNo) {
		return boardManageMapper.deleteBoard(bNo);
	}
	
	@Override
	public Board selectUpdateBoard(int bNo) {
		return boardManageMapper.selectUpdateBoard(bNo); 
	}
	
	@Override
	public int writeReply(Board replyBoard, String mId) {
		int mNo = 0;
		
		// 1. 기존 댓글들의 step 1씩 증가
		replyManageMapper.updateStep(replyBoard.getbGroupNo());
		// 2. mNo를 구하기 위한 작업
		mNo = boardCommonMapper.selectMNo(mId);
		replyBoard.setmNo(mNo);
		// 3. 댓글 작성
		return replyManageMapper.createReply(replyBoard);
	}
	
	@Override
	public int removeReply(int bNo) {
		return replyManageMapper.deleteReply(bNo);
	}
	
	@Override
	public int checkChoice(int bNo) {
		//업데이트 안되면 0인 상태로 controller에서 
		//ui에 영향을 미칠 데이터를 작업하자
		return replyManageMapper.updateChoice(bNo);
	}
	
	@Override
	public int checkRecommend(int bNo) {
		//업데이트 안되면 0인 상태로 controller에서 
		//ui에 영향을 미칠 데이터 작업
		return replyManageMapper.updateRecommend(bNo);
	}

	@Override
	public List<Board> findBoardTop10() {
		return viewMapper.selectBoardTop10();
	}
	
	@Override
	public List<Board> findBoardAll() {
		return viewMapper.selectBoardAll();
	}
	
	@Override
	public List<Board> findBoardOne(int bNo) {
		return viewMapper.selectBoardOne(bNo);
	}

	
	@Override
	public int findBoardCount() {
		return viewMapper.selectBoardCount();
	}
	
	@Override
	public int findBoardReplyCount() {
		return viewMapper.selectBoardReplyCount();
	}
	
	@Override
	public int updateViewCount(int bNo) {
		return viewMapper.updateView(bNo);
	}
	
}
