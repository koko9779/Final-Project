package com.itwill.staily.mypage.model.dao;

import java.util.List;

import com.itwill.staily.mypage.model.dto.Bookmark;

public interface BookmarkDao {
	
	//북마크 리스트출력(회원)
	
	public List<Bookmark> selectList(int mNo) throws Exception;
		
	public int deleteBookmark(int bmNo) throws Exception;
}
