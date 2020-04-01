package com.itwill.staily.mypage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.staily.mypage.mapper.MypageMapper;
import com.itwill.staily.util.Company;
import com.itwill.staily.util.Member;
import com.itwill.staily.util.Product;

public class MypageServiceImpl implements MypageService {
	@Autowired
	private MypageMapper mypageMapper;
	
	@Override
	public Member selectOne(int mNo) throws Exception {
		return mypageMapper.selectOne(mNo);
	}

	@Override
	public boolean deleteMember(int mNo) throws Exception {
		return mypageMapper.deleteMember(mNo);
	}

	@Override
	public boolean updateMember(Member member) throws Exception {
		return mypageMapper.updateMember(member);
	}

	@Override
	public Member selectMemberCompany(int mNo) throws Exception {
		return mypageMapper.selectMemberCompany(mNo);
	}

	@Override
	public boolean updateCompanyNo(Company company) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Product> selectWriteList(int mNo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteWrite(int pNo) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
