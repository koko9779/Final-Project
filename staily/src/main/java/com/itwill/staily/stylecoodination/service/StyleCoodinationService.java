package com.itwill.staily.stylecoodination.service;

import java.util.List;

import com.itwill.staily.util.Board;

public interface StyleCoodinationService {

	public int modifyBoardAndReply(Board updateBoard) throws Exception;

	public int writeBoard(Board board) throws Exception;
	
	public Board selectUpdateBoard(int bNo);

	public int removeBoard(int bNo) throws Exception;

	public int writeReply(Board replyBoard, String mId) throws Exception;

	public int removeReply(int bNo) throws Exception;

	public int checkChoice(int bNo) throws Exception;

	public int checkRecommend(int bNo) throws Exception;

	public List<Board> findBoardTop10();

	public List<Board> findBoardAll();
	
	public List<Board> findBoardOne(int bNo);

	public int findBoardCount();

	public int findBoardReplyCount();

	public int updateViewCount(int bNo) throws Exception;

}