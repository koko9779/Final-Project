package com.itwill.staily.mypage.model.dao;

import java.util.List;

import com.itwill.staily.mypage.model.dto.Bookmark;

public interface BookmarkDao {
	
	public List<Bookmark> selectList(int mNo) throws Exception;
	
	public int createBookmark(Bookmark bookmark) throws Exception;
	
	public int deleteBookmark(int bmNo) throws Exception;
}
