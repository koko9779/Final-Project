package com.itwill.staily.detail.service;

import java.util.List;

import com.itwill.staily.util.Work;

public interface WorkDetailService {
	Work selectWorkOne(int wNo) throws Exception;
	
	public List<Work> selectWorkAll() throws Exception;
	
	public boolean createWorkDetail(Work work) throws Exception;
}
