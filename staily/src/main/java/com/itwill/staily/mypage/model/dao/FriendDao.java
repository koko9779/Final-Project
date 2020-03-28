package com.itwill.staily.mypage.model.dao;

import java.util.List;

import com.itwill.staily.mypage.model.dto.Friend;

public interface FriendDao {
	
	public List<Friend> selectList(int mNo);
	
	public int createFriend(Friend friend);
	
	public int deleteFriend(int fNo);

}
