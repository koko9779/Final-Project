package com.itwill.staily.login.mapper;

import com.itwill.staily.util.Member;

public interface LoginMapper {
	//로그인시 아이디, 비밀번호 일치 확인여부
	public Member selectMemberOne();
	// 아이디 찾기
	public String selectIdOne();
	// 비밀번호 찾기
	public int updatePwOne();
}
