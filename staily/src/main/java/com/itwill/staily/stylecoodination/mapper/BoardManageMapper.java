package com.itwill.staily.stylecoodination.mapper;

import com.itwill.staily.util.Board;

public interface BoardManageMapper {
	public int createBoard(Board b);

	//원글 수정은 CommonMapper에 있음
	
	public int deleteBoard(int groupNo);
	
}
