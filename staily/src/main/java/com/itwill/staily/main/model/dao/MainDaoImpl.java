package com.itwill.staily.main.model.dao;

import java.util.List;

import com.itwill.staily.main.mapper.MainMapper;
import com.itwill.staily.util.Product;
import com.itwill.staily.util.Work;

public class MainDaoImpl implements MainDao{
	
	private MainMapper mainMapper;
	public MainDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	public MainDaoImpl(MainMapper mainMapper) throws Exception {
		this.mainMapper = mainMapper;
	}
	public MainMapper getMainMapper() {
		return mainMapper;
	}
	public void setMainMapper(MainMapper mainMapper) {
		this.mainMapper = mainMapper;
	}
	@Override
	public boolean createBookmark(int pNo) throws Exception {
		// TODO Auto-generated method stub
		return false;
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
	public boolean deleteBookmark(int pNo) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}