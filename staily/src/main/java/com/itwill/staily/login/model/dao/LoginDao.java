package com.itwill.staily.login.model.dao;

import com.itwill.staily.util.Company;
import com.itwill.staily.util.Member;

public interface LoginDao {
	/*
	 * 로그인
	 */
	public Member selectMemberOne();
	
	/*
	 * 회원가입
	 */
	public int createMember(Member member);
	
	public int createCompany(Company company);
	
	//아이디 중복여부
	public String selectIdOne(int mId);
	
}
