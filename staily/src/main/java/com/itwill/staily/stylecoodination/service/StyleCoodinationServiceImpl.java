package com.itwill.staily.stylecoodination.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.staily.stylecoodination.exception.FailWriteBoardException;
import com.itwill.staily.stylecoodination.mapper.BoardManageMapper;
import com.itwill.staily.stylecoodination.mapper.CommonMapper;
import com.itwill.staily.stylecoodination.mapper.ReplyManageMapper;
import com.itwill.staily.stylecoodination.mapper.ViewMapper;
import com.itwill.staily.util.Board;

@Service
public class StyleCoodinationServiceImpl {
	@Autowired
	private BoardManageMapper boardManageMapper;
	@Autowired
	private CommonMapper commonMapper;
	@Autowired
	private ReplyManageMapper replyManageMapper;
	@Autowired
	private ViewMapper viewMapper;
	
	public int writeBoard(Board board) {
		int writeCount = 0;
		
		writeCount = boardManageMapper.createBoard(board);
		if(writeCount != 1) {
			throw new FailWriteBoardException("게시글 작성에 실패하였습니다");
		}
		return writeCount;
	}
	
	public int removeBoard() {
		return 0;
	}
	
	
	
	
}
