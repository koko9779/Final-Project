package com.itwill.staily.login.mapper;

import java.util.HashMap;

import com.itwill.staily.util.Member;

public interface LoginMapper {
	//로그인시 아이디, 비밀번호 일치 확인여부
	public Member selectMemberIdAndPw(String mId);
	// 아이디 찾기(mPhone, mName)
	public String selectIdOne(HashMap<String, Object> map);
	/************ 비밀번호 찾기 ****************/
	public int isIdExist(HashMap<String, Object> map);
	
	public int updatePwOne(HashMap<String, Object> map);
}
