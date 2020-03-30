package com.itwill.staily.mypage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.staily.mypage.mapper.BookmarkMapper;
import com.itwill.staily.mypage.model.dto.Bookmark;

public class BookmarkServiceImpl implements BookmarkService {
	@Autowired
	private BookmarkMapper bookmarkMapper;
	
	@Override
	public List<Bookmark> selectList(int mNo) throws Exception {
		return bookmarkMapper.selectList(mNo);
	}

	@Override
	public int deleteBookmark(int bmNo) throws Exception {
		return bookmarkMapper.deleteBookmark(bmNo);
	}

}
