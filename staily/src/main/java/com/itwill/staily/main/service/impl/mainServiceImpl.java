package com.itwill.staily.main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.staily.main.mapper.MainMapper;
import com.itwill.staily.main.service.MainService;
import com.itwill.staily.mypage.model.dto.Bookmark;
import com.itwill.staily.util.Product;
import com.itwill.staily.util.Work;

@Service
public class mainServiceImpl implements MainService{
	
	@Autowired
	private MainMapper mainMapper;
	
	public mainServiceImpl() {
	
	}
	
	public MainMapper getMainMapper() {
		return mainMapper;
	}

	public void setMainMapper(MainMapper mainMapper) {
		this.mainMapper = mainMapper;
	}

	@Override
	public List<Bookmark> selectByBookmark(int mNo) throws Exception {
		return mainMapper.selectByBookmark(mNo);
	}

	@Override
	public List<Product> selectByView() throws Exception {
		return mainMapper.selectByView();
	}

	@Override
	public List<Work> selectByCategory(String category) throws Exception {
		return mainMapper.selectByCategory(category);
	}

	@Override
	public List<Work> selectByWork(int wNo) throws Exception {
		return mainMapper.selectByWork(wNo);
	}

	@Override
	public List<Work> selectByEpisode(int wNo, int episode) throws Exception {
		return mainMapper.selectByEpisode(wNo, episode);
	}

	@Override
	public boolean createBookmark(int mNo,int pNo) throws Exception {
		return mainMapper.createBookmark(mNo, pNo);
	}

	@Override
	public boolean deleteBookmark(int mNo,int pNo) throws Exception {
		return mainMapper.deleteBookmark(mNo, pNo);
	}

	@Override
	public int selectTepisode(int wNo) {
		return mainMapper.selectTepisode(wNo);
	}
	
}