package com.itwill.staily.detail.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.itwill.staily.util.Work;

public interface WorkDetailService {
	public Work selectWorkOne(int wNo) throws Exception;
	
	public List<Work> selectWorkAll() throws Exception;
	
	public boolean createWorkDetail(@Param("pNo") int pNo, @Param("wNo") int wNo, @Param("wdEpisode") int wdEpisode) throws Exception;
}
