package com.itwill.staily.mypage.mapper;

import java.util.List;

import com.itwill.staily.mypage.model.dto.Bookmark;

public interface BookmarkMapper {
	public List<Bookmark> selectList(int mNo);
	
	public int createBookmark(Bookmark bookmark);
	
	public int deleteBookmark(int bmNo);
	
	
}
