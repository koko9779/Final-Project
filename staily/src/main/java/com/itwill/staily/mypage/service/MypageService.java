package com.itwill.staily.mypage.service;

import com.itwill.staily.util.Member;

public interface MypageService {
	//멤버 하나 선택
	public Member selectOne(int mNo) throws Exception;
	
	//멤버 삭제
	public boolean deleteMember(int mNo) throws Exception;
	
	//멤버 수정
	public boolean updateMember(Member member) throws Exception;
	
	//멤버 선택 (회사정보포함)
	public Member selectMemberCompany(int mNo) throws Exception;

}
