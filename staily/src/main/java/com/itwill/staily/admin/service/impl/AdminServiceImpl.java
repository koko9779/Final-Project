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
	public boolean updateMember(Member member) throws Exception {
		return adminMapper.updateMember(member);
	}

	@Override
	public boolean deleteMember(int mNo) throws Exception {
		return adminMapper.deleteMember(mNo);
	}

	@Override
	public boolean createWork(Work work) throws Exception {
		boolean create = false;
		adminMapper.createWork(work);
		return create;
	}
	
	@Override
	public boolean createWorkDetail(Work work) throws Exception {
		return createWorkDetail(work);
	}
	
	@Override
	public List<Work> selectWorkAll() throws Exception {
		return adminMapper.selectWorkAll();
	}

	@Override
	public Work selectWorkOne(int wNo) throws Exception {
		return adminMapper.selectWorkOne(wNo);
	}

	@Override
	public boolean updateWork(Work work) throws Exception {
		return adminMapper.updateWork(work);
	}
	@Override
	public boolean deleteWork(int wNo) throws Exception {
		return adminMapper.deleteWork(wNo);
	}

	@Override
	public List<Product> selectProductAll() throws Exception {
		return adminMapper.selectProductAll();
	}

	@Override
	public Product selectProductOne(int pNo) throws Exception {
		return adminMapper.selectProductOne(pNo);
	}

	@Override
	public boolean updateProduct(Product product) throws Exception {
		return adminMapper.updateProduct(product);
	}

	@Override
	public boolean updateProductDetail(int pdNo) throws Exception {
		return adminMapper.updateProductDetail(pdNo);
	}
	
	@Override
	public boolean deleteProduct(int pNo) throws Exception {
		return adminMapper.deleteProduct(pNo);
	}






}
