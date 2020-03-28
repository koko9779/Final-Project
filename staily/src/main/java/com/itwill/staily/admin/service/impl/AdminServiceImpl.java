package com.itwill.staily.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.staily.admin.mapper.AdminMapper;
import com.itwill.staily.admin.service.AdminService;
import com.itwill.staily.util.Member;
import com.itwill.staily.util.Product;
import com.itwill.staily.util.Work;

@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	private AdminMapper adminMapper;
	
	public AdminServiceImpl() {
	}
	

	public AdminServiceImpl(AdminMapper adminMapper) {
		super();
		this.adminMapper = adminMapper;
	}


	public AdminMapper getAdminMapper() {
		return adminMapper;
	}


	public void setAdminMapper(AdminMapper adminMapper) {
		this.adminMapper = adminMapper;
	}


	@Override
	public List<Member> selectMemberAll() {
		return adminMapper.selectMemberAll();
	}

	@Override
	public Member selectMemberOne(int mNo) throws Exception {
		return adminMapper.selectMemberOne(mNo);
	}

	@Override
	public int updateMember(Work work) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(int mNo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int createWork(Work work) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Work> selectWorkAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Work selectWorkOne(int wNo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateWork(Work work) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteWork(int wNo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Product> selectProductAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product selectProductOne(int pNo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateProduct(Product product) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteProduct(int pNo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
