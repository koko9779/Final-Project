package com.itwill.staily.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.staily.admin.model.dao.AdminDao;
import com.itwill.staily.util.Member;
import com.itwill.staily.util.Product;
import com.itwill.staily.util.Work;

@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	private AdminDao adminDao;
	public AdminServiceImpl() {
	}
	
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	@Override
	public List<Member> selectMemberAll() {
		return adminDao.selectMemberAll();
	}

	@Override
	public Member selectMemberOne(int mNo) throws Exception {
		return adminDao.selectMemberOne(mNo);
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
