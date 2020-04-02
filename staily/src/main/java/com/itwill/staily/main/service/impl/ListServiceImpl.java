package com.itwill.staily.main.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.staily.detail.mapper.WorkDetailMapper;
import com.itwill.staily.main.mapper.ListMapper;
import com.itwill.staily.main.service.ListService;
import com.itwill.staily.util.Work;

@Service
public class ListServiceImpl implements ListService{
	
	@Autowired
	private ListMapper listMapper;
	@Autowired
	private WorkDetailMapper workDetailMapper;
	
	public ListServiceImpl() {
	
	}
	
	public ListMapper getListMapper() {
		return listMapper;
	}

	public void setListMapper(ListMapper listMapper) {
		this.listMapper = listMapper;
	}

	public WorkDetailMapper getWorkDetailMapper() {
		return workDetailMapper;
	}

	public void setWorkDetailMapper(WorkDetailMapper workDetailMapper) {
		this.workDetailMapper = workDetailMapper;
	}

	@Override
	public List<Work> selectCProductList(int wNo) {
		return listMapper.selectCProductList(wNo);
	}

	@Override
	public List<Work> selectMProductList(int wNo) {
		return listMapper.selectMProductList(wNo);
	}

	@Override
	public List<Work> selectCProductListByEpisode(Map map) {
		return listMapper.selectCProductListByEpisode(map);
	}

	@Override
	public List<Work> selectMProductListByEpisode(Map map) {
		return listMapper.selectMProductListByEpisode(map);
	}

	@Override
	public int createBookmark(Map map) {
		return listMapper.createBookmark(map);
	}

	@Override
	public int deleteBookmark(int bmNo) {
		return listMapper.deleteBookmark(bmNo);
	}

	@Override
	public int selectProductCount() {
		return listMapper.selectProductCount();
	}




	
}