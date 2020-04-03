package com.itwill.staily.login.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.staily.login.exception.FailSignException;
import com.itwill.staily.login.exception.NoSearchMemberException;
import com.itwill.staily.login.mapper.LoginCommonMapper;
import com.itwill.staily.login.mapper.LoginMapper;
import com.itwill.staily.login.mapper.SignUpMapper;
import com.itwill.staily.util.Member;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
	@Autowired
	private LoginMapper loginMapper;
	@Autowired
	private SignUpMapper signMapper;	
	@Autowired
	private LoginCommonMapper loginCommonMapper;
	
	public LoginServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Member login(Member member) { 
		String pw;
		int isExisted = 0;
		int mNo = 0;
		
		isExisted = loginCommonMapper.isExistedId(member.getmId());
		if(isExisted == 1) {
			pw = loginMapper.selectMemberPw(member.getmId());
			if(pw.equals(member.getmPw())) {
				//기업회원인지 검사하는 메소드, 기업회원이면 상수오빠 메소드 실행하고 memberDTO 리턴, 아니면 바로 memberDTO 리턴
				mNo = loginCommonMapper.selectMNo(member.getmId());
				member.setmNo(mNo);
				return member;
			}else {
				throw new FailSignException("아이디가 존재하지 않거나 비밀번호가 일치하지 않습니다");
			}
 		}else {
			throw new FailSignException("아이디가 존재하지 않거나 비밀번호가 일치하지 않습니다");
		}
	}
	
	@Override
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
	@Override
	public int isIdExist(String mId, String mPhone) {
		int count = 0;
		int existCount = 0;
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("mId", mId);
		map.put("mPhone", mPhone);
		
		existCount = loginMapper.isExistedIdForPw(map);
		if(existCount != 1) {
			throw new NoSearchMemberException("일치하는 계정이 없습니다");
		}else {
			count = 1;
		}
		return count; 
	}
	//맞으면 새비밀번호 입력창으로 이동 
	
	//새 비밀번호 입력창에서 입력된 비밀번호로 업데이트
	@Override
	public int updatePw(Member updatePwMember) {
		return loginMapper.updatePwOne(updatePwMember);
	}
	/******************************************************************/
	@Override
	public int isEmailExist(String mEmail) {
		return loginCommonMapper.isExistedEmail(mEmail);
	}
	
	@Override
	public int signUpMember(Member member) {
		int successCount = 0;
		
		successCount = signMapper.createMember(member);
		if(successCount != 1) {
			throw new FailSignException("회원가입에 실패하였습니다");
		}
 		return successCount;
	}
	
	@Override
	public int signUpCompany(Member member) {
		int signUpCountM = 0;
		int signUpCountC = 0;
		
		if(member.getmCompany().getCoNo() == 0) {
			throw new FailSignException("회원가입에 실패하였습니다");
		}
		
		signUpCountM = signMapper.createMember(member);
		if(signUpCountM == 1) {
			signUpCountC = signMapper.createCompany(member.getmCompany().getCoNo());
			if(signUpCountC != 1) {
				throw new FailSignException("회원가입에 실패하였습니다");
			}
		}else {
			throw new FailSignException("회원가입에 실패하였습니다");
		}
		return signUpCountC;
	}
	
	
	
	
	
	
	
	
	
}
