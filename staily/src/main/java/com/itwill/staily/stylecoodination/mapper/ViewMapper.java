package com.itwill.staily.stylecoodination.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.staily.util.Board;
@Mapper
public interface ViewMapper {
	public List<Board> selectBoardTop10();
	
	public List<Board> selectBoardAll();
	
	//bType과 bGroupNo 받아야함
	public List<Board> selectBoardOne(int bNo);
	
	//누적 질문 수
	public int selectBoardCount();
	
	//누적 답변 수 
	public int selectBoardReplyCount();
	
	//조회수 올리기
	public int updateView(int bNo);
	
}
