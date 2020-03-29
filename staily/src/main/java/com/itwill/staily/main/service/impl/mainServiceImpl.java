package com.itwill.staily.main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.staily.main.mapper.MainMapper;
import com.itwill.staily.main.service.MainService;
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
	public List<Product> selectByBookmark(int mNo, int pNo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> selectByView() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Work> selectByCategory(String category) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List selectByWork(int wNo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List selectByEpisode(int episode) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean createBookmark(int pNo) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteBookmark(int pNo) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int selectTepisode(int wNo) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}