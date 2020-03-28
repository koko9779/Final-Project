package com.itwill.staily.login.mapper;

import com.itwill.staily.util.Member;

public interface SignUpMapper {
	//일반회원, 기업회원 공통
	public int createMember(Member member);
	
	//기업회원만
	public int createCompany(int coNo);
}
