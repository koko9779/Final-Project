package com.itwill.staily.stylecoodination.mapper;

import java.util.HashMap;
import java.util.List;

import com.itwill.staily.util.Board;

public interface ViewMapper {
	public List<Board> selectBoardAll(String bType);
	
	//bType과 bGroupNo 받아야함
	//public List<Board> selectBoardDetail(HashMap<String, Object> map);
	
	//누적 질문 수
	public int selectBoardCount();
	
	//누적 답변 수 
	public int selectBoardReplyCount();
	
	//조회수 올리기
	public int updateView(int bNo);
	
}
