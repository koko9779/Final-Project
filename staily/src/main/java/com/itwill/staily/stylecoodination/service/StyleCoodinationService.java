package com.itwill.staily.stylecoodination.service;

import java.util.List;

import com.itwill.staily.util.Board;

public interface StyleCoodinationService {

	int modifyBoardAndReply(Board updateBoard);

	int writeBoard(Board board);

	int removeBoard(int bNo);

	int writeReply(Board replyBoard, String mId);

	int removeReply(int bNo);

	int checkChoice(int bNo);

	int checkRecommend(int bNo);

	List<Board> findBoardTop10();

	List<Board> findBoardAll();
	
	List<Board> findBoardOne(int bNo);

	int findBoardCount();

	int findBoardReplyCount();

	int updateViewCount(int bNo);

}