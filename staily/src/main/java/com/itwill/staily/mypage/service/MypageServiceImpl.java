package com.itwill.staily.mypage.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.staily.mypage.mapper.MypageMapper;
import com.itwill.staily.util.Member;

public class MypageServiceImpl implements MypageService {
	@Autowired
	private MypageMapper mypageMapper;
	
	@Override
	public Member selectOne(int mNo) throws Exception {
		return mypageMapper.selectOne(mNo);
	}

	@Override
	public boolean deleteMember(int mNo) throws Exception {
		return mypageMapper.deleteMember(mNo);
	}

	@Override
	public boolean updateMember(Member member) throws Exception {
		return mypageMapper.updateMember(member);
	}

}
