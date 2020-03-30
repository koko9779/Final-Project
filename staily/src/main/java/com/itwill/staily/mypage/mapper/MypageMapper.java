package com.itwill.staily.mypage.mapper;

import com.itwill.staily.util.Member;

public interface MypageMapper {
	
	//멤버 하나 선택
	public Member selectOne(int mNo) throws Exception;
	
	//멤버 삭제
	public int deleteMember(int mNo) throws Exception;
	
	//멤버 수정
	public int updateMember(Member member) throws Exception;

}
