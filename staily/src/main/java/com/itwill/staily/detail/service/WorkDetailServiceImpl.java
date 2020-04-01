package com.itwill.staily.detail.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.staily.detail.mapper.WorkDetailMapper;
import com.itwill.staily.util.Work;

@Service
public class WorkDetailServiceImpl implements WorkDetailService {
	@Autowired
	private WorkDetailMapper workDetailMapper;
	
	public WorkDetailServiceImpl() {
		super();
	}	

	public WorkDetailMapper getWorkDetailMapper() {
		return workDetailMapper;
	}

	public void setWorkDetailMapper(WorkDetailMapper workDetailMapper) {
		this.workDetailMapper = workDetailMapper;
	}

	@Override
	public Work selectWorkOne(int wNo) throws Exception {
		return workDetailMapper.selectWorkOne(wNo);
	}

	@Override
	public List<Work> selectWorkAll() throws Exception {
		return workDetailMapper.selectWorkAll();
	}

	@Override
	public boolean createWorkDetail(@Param("pNo") int pNo, @Param("wNo") int wNo, @Param("wdEpisode") int wdEpisode) throws Exception {
		boolean check = false;
		
		if(workDetailMapper.createWorkDetail(pNo, wNo, wdEpisode)) {
			check = true;			
		}
		else{
			check = false;
		}
		
		return check;
	}

}
