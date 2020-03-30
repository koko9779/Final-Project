package com.itwill.staily.mypage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.staily.mypage.mapper.FriendMapper;
import com.itwill.staily.mypage.model.dto.Friend;

public class FriendServiceImpl implements FriendService {
	@Autowired
	private FriendMapper friendMapper;
	
	@Override
	public List<Friend> selectList(int mNo) throws Exception {
		return friendMapper.selectList(mNo);
	}

	@Override
	public int createFriend(Friend friend) throws Exception {
		return friendMapper.createFriend(friend);
	}

	@Override
	public int deleteFriend(int fNo) throws Exception {
		return friendMapper.deleteFriend(fNo);
	}

}