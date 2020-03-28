package com.itwill.staily.mypage.mapper;

import java.util.List;

import com.itwill.staily.mypage.model.dto.Friend;

public interface FriendMapper {
	public List<Friend> selectList(int mNo);
	
	public int createFriend(Friend friend);
	
	public int deleteFriend(int fNo);

}
