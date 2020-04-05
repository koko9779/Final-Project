package com.itwill.staily.login.service;

import com.itwill.staily.util.Member;

public interface LoginService {

	Member login(Member member);

	String findId(String mPhone, String mName);

	/************************** 비밀번호 찾기 **************************/
	int isIdExist(String mId, String mPhone);
	//맞으면 새비밀번호 입력창으로 이동 

	//새 비밀번호 입력창에서 입력된 비밀번호로 업데이트 
	int updatePw(Member updatePwMember);

	/******************************************************************/
	int isEmailExist(String mEmail);
	
	int signUpMember(Member member) throws Exception;

	int signUpCompany(Member member) throws Exception;

}