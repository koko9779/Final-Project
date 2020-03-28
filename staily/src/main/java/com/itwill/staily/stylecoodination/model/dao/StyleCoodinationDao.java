package com.itwill.staily.stylecoodination.model.dao;

import java.util.List;

import com.itwill.staily.util.Board;
import com.itwill.staily.util.BoardDetail;

public interface StyleCoodinationDao {
	/*
	 * 메인화면
	 */
	public List<Board> selectBoardAll();
	
	//누적 질문 수
	public int selectBoardCount();
	//누적 답변 수 
	public int selectBoardReplyCount();
	
	/*
	 * 상세보기
	 */
	public Board selectBoardOne(int bNo);
	
	//원글, 답글 수정
	public int updateBoard(Board board);

	//원글 삭제
	public int deleteBoard(int groupNo);
	
	//답글 삭제
	public int deleteBoardReply(int bNo);
	
	//조회수 올리기
	public int updateView(int bNo);
	
	//답글채택
	public int updateChoice(int bNo);
	
	//추천수 올리기
	public int updateRecommend(int bNo);
	
	/*
	 * 질문작성
	 */
	public int createBoard(Board b);
	
	//이미지 insert
	public int createBoardDetail(BoardDetail bd);
	
	
	
	
	
}
