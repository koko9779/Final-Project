package com.itwill.staily.stylecoodination.service;

import java.util.List;

import com.itwill.staily.util.Board;

public interface StyleCoodinationService {

	public int modifyBoardAndReply(Board updateBoard);

	public int writeBoard(Board board);
	
	public Board selectUpdateBoard(int bNo);

	public int removeBoard(int bNo);

	public int writeReply(Board replyBoard, String mId);

	public int removeReply(int bNo);

	public int checkChoice(int bNo);

	public int checkRecommend(int bNo);

	public List<Board> findBoardTop10();

	public List<Board> findBoardAll();
	
	public List<Board> findBoardOne(int bNo);

	public int findBoardCount();

	public int findBoardReplyCount();

	public int updateViewCount(int bNo);

}