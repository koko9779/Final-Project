package com.itwill.staily.login.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.staily.login.exception.FailSignException;
import com.itwill.staily.login.exception.FailUpdatePwException;
import com.itwill.staily.login.exception.NoSearchMemberException;
import com.itwill.staily.login.mapper.LoginCommonMapper;
import com.itwill.staily.login.mapper.LoginMapper;
import com.itwill.staily.login.mapper.SignUpMapper;
import com.itwill.staily.util.Member;

@Service
public class LoginServiceImpl {
	@Autowired
	private LoginMapper loginMapper;
	@Autowired
	private SignUpMapper signMapper;	
	@Autowired
	private LoginCommonMapper loginCommonMapper;
	
	public Member login(Member member) { 
		String pw;
		int isExisted = 0;
		
		isExisted = loginCommonMapper.isExistedId(member.getmId());
		if(isExisted == 1) {
			pw = loginMapper.selectMemberPw(member.getmId());
			if(pw.equals(member.getmPw())) {
				//기업회원인지 검사하는 메소드, 기업회원이면 상수오빠 메소드 실행하고 memberDTO 리턴, 아니면 바로 memberDTO 리턴
				return member;
			}else {
				throw new FailSignException("아이디가 존재하지 않거나 비밀번호가 일치하지 않습니다");
			}
 		}else {
			throw new FailSignException("아이디가 존재하지 않거나 비밀번호가 일치하지 않습니다");
		}
	}
	
	public String findId(String mPhone, String mName) {
		String id;
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("mPhone", mPhone);
		map.put("mName", mName);
		
		id = loginMapper.selectIdOne(map);
		if(id == null) {
			throw new NoSearchMemberException("일치하는 계정이 없습니다");
		}
		return id;
	}
	
	/************************** 비밀번호 찾기 **************************/
	public int isIdExist(String mId, String mPhone) {
		int count = -1;
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("mId", mId);
		map.put("mPhone", mPhone);
		
		int existCount = loginMapper.isExistedIdForPw(map);
		if(existCount != 1) {
			throw new NoSearchMemberException("일치하는 계정이 없습니다");
		}else {
			count = 1;
		}
		return count;
	}
	//맞으면 새비밀번호 입력창으로 이동 
	
	//새 비밀번호 입력창에서 입력된 비밀번호로 업데이트
	public int updatePw(Member updatePwMember) {
		int updateCount = 0;
		
		updateCount = loginMapper.updatePwOne(updatePwMember);
		if(updateCount != 1) {
			throw new FailUpdatePwException("비밀번호 변경에 실패하였습니다");
		}
		
		return updateCount;
	}
	/******************************************************************/
	
	public int signMember(Member member) {
		int signCount = 0;
	
		signCount = signMapper.createMember(member);
		if(signCount != 1) {
			throw new FailSignException("회원가입에 실패하였습니다");
		}
		
		return signCount;
	}
	
	public int signCompany(Member member) {
		int successCount = 0;
		int signCountM = 0;
		int signCountC = 0;
		
		signCountM = signMapper.createMember(member);
		if(signCountM == 1) {
			signCountC = signMapper.createCompany(member.getmCompany().getCoNo());
			if(signCountC != 1) {
				throw new FailSignException("회원가입에 실패하였습니다");
			}
		}else {
			throw new FailSignException("회원가입에 실패하였습니다");
		}
		successCount = 1;
		return successCount;
	}
	
	
	
	
	
	
	
	
	
}
