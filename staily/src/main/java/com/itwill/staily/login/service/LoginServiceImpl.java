package com.itwill.staily.login.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.staily.login.exception.FailSignException;
import com.itwill.staily.login.exception.NoSearchMemberException;
import com.itwill.staily.login.mapper.LoginMapper;
import com.itwill.staily.login.mapper.SignUpMapper;
import com.itwill.staily.util.Member;

@Service
public class LoginServiceImpl {
	@Autowired
	private LoginMapper loginMapper;
	@Autowired
	private SignUpMapper signMapper;
	HashMap<String, Object> map;
	
	public String selectMemberIdAndPw(String mId) { 
		String pw;
		pw = loginMapper.selectMemberIdAndPw(mId);
		if(pw == null) {
			throw new NoSearchMemberException("아이디가 존재하지 않거나 비밀번호가 일치하지 않습니다");
		}
		return pw;
		//세션에 박는 작업은 controller에서 진행
	}
	
	public String findId(String mPhone, String mName) {
		map = new HashMap<String, Object>();
		
		map.put("mPhone", mPhone);
		map.put("mName", mName);
		
		String id = loginMapper.selectIdOne(map);
		return id;
	}
	
	/************************** 수정 필요 **************************/
	public int findPw(String mId, String mPhone, String mPw) {
		int count = 0;
		map = new HashMap<String, Object>();
		
		map.put("mId", mId);
		map.put("mPhone", mPhone);
		map.put("mPw", mPw);
		
		
		int existCount = loginMapper.isIdExist(map);
		if(existCount == 1) {
			count = loginMapper.updatePwOne(map);
		}
		return count;
	}
	/******************************************************************/
	
	public int signMember(Member member) {
		int count = 0;
		
		member = new Member();
		member.setmId(member.getmId());
		member.setmPw(member.getmPw());
		member.setmName(member.getmName());
		member.setmAddress(member.getmAddress());
		member.setmDaddress(member.getmDaddress());
		member.setmEmail(member.getmEmail());
		member.setmType("M");
		member.setmPhone(member.getmPhone());
	
		count = signMapper.createMember(member);
		
		return count;
	}
	
	public int signCompany(Member member, int coNo) {
		int count = 0;
		
		member = new Member();
		member.setmId(member.getmId());
		member.setmPw(member.getmPw());
		member.setmName(member.getmName());
		member.setmAddress(member.getmAddress());
		member.setmDaddress(member.getmDaddress());
		member.setmEmail(member.getmEmail());
		member.setmType("C");
		member.setmPhone(member.getmPhone());
	
		count = signMapper.createMember(member);
		
		if(count == 1) {
			count = signMapper.createCompany(coNo);
			if(count != 1) {
				throw new FailSignException("회원가입에 실패하였습니다");
			}
		}else {
			throw new FailSignException("회원가입에 실패하였습니다");
		}
		return 0; //리턴을 뭘 해줘야할까나
	}
	
	
	
	
	
	
	
	
	
}
