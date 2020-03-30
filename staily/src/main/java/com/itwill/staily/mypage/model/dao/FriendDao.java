package com.itwill.staily.mypage.model.dao;

import java.util.List;

import com.itwill.staily.mypage.model.dto.Friend;

public interface FriendDao {
	
	public List<Friend> selectList(int mNo) throws Exception;
	
	public int createFriend(Friend friend) throws Exception;
	
	public int deleteFriend(int fNo) throws Exception;

}
