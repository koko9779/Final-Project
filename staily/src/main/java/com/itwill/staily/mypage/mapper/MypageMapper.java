package com.itwill.staily.mypage.mapper;

import com.itwill.staily.util.Member;

public interface MypageMapper {
	
	public int deleteMember(int mNo);
	
	public int updateMember(Member member);

}
