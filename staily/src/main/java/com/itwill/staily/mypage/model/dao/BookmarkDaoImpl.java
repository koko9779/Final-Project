package com.itwill.staily.mypage.model.dao;

import java.util.List;



import com.itwill.staily.mypage.mapper.BookmarkMapper;
import com.itwill.staily.mypage.model.dto.Bookmark;

public class BookmarkDaoImpl implements BookmarkDao {
	
	private BookmarkMapper bookmarkMapper;
	
	public BookmarkDaoImpl() {
		
	}

	public BookmarkMapper getBookmarkMapper() {
		return bookmarkMapper;
	}

	public void setBookmarkMapper(BookmarkMapper bookmarkMapper) {
		this.bookmarkMapper = bookmarkMapper;
	}

	@Override
	public List<Bookmark> selectList(int mNo) throws Exception {
		List<Bookmark> bookmarkList = bookmarkMapper.selectList(mNo);
		return bookmarkList;
	}

	
	@Override
	public int deleteBookmark(int bmNo) throws Exception {
		int deleteRow = bookmarkMapper.deleteBookmark(bmNo);
		return deleteRow;
	}

}
