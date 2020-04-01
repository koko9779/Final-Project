package com.itwill.staily.stylecoodination.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.staily.stylecoodination.mapper.BoardManageMapper;
import com.itwill.staily.stylecoodination.mapper.ReplyManageMapper;
import com.itwill.staily.stylecoodination.mapper.BoardCommonMapper;
import com.itwill.staily.stylecoodination.mapper.ViewMapper;
import com.itwill.staily.util.Board;
import com.itwill.staily.util.BoardDetail;

public class StyleCoodinationDaoImpl implements StyleCoodinationDao {
	private BoardManageMapper boardManageMapper;
	private ReplyManageMapper replyManageMapper;
	private BoardCommonMapper commonMapper;
	private ViewMapper viewMapper;
	
	public StyleCoodinationDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	public StyleCoodinationDaoImpl(BoardManageMapper boardManageMapper, ReplyManageMapper replyManageMapper,
			BoardCommonMapper commonMapper, ViewMapper viewMapper) {
		super();
		this.boardManageMapper = boardManageMapper;
		this.replyManageMapper = replyManageMapper;
		this.commonMapper = commonMapper;
		this.viewMapper = viewMapper;
	}



	public BoardManageMapper getBoardManageMapper() {
		return boardManageMapper;
	}

	public ReplyManageMapper getReplyManageMapper() {
		return replyManageMapper;
	}

	public BoardCommonMapper getUtilMapper() {
		return commonMapper;
	}

	public ViewMapper getViewMapper() {
		return viewMapper;
	}

	public void setBoardManageMapper(BoardManageMapper boardManageMapper) {
		this.boardManageMapper = boardManageMapper;
	}

	public void setReplyManageMapper(ReplyManageMapper replyManageMapper) {
		this.replyManageMapper = replyManageMapper;
	}

	public void setUtilMapper(BoardCommonMapper utilMapper) {
		this.commonMapper = utilMapper;
	}

	public void setViewMapper(ViewMapper viewMapper) {
		this.viewMapper = viewMapper;
	}

	@Override
	public List<Board> selectBoardAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectBoardCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int selectBoardReplyCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Board selectBoardOne(int bNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateBoard(Board board) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBoard(int groupNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBoardReply(int bNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateView(int bNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateChoice(int bNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateRecommend(int bNo) {
		int updateCount = replyManageMapper.updateRecommend(bNo);
		return updateCount;
	}

	@Override
	public int createBoard(Board b) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int createBoardDetail(BoardDetail bd) {
		// TODO Auto-generated method stub
		return 0;
	}

}
