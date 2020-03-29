package com.itwill.staily.detail.mapper;

import java.util.List;

import com.itwill.staily.util.Work;

public interface WorkDetailMapper {
	public Work selectWorkOne(int wNo);
	
	public List<Work> selectWorkAll();
	
	public boolean createWorkDetail(Work work);
}
