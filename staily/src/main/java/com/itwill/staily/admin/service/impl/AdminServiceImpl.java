package com.itwill.staily.admin.service.impl;

import java.util.List;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.staily.admin.mapper.AdminMapper;
import com.itwill.staily.admin.service.AdminService;
import com.itwill.staily.util.Member;
import com.itwill.staily.util.Product;
import com.itwill.staily.util.Work;
import com.itwill.staily.util.exception.FailCreateException;

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
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public boolean deleteMember(int mNo) throws Exception {
		return adminMapper.deleteMember(mNo);
	}

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public boolean createWork(Work work) throws Exception {
		boolean create = adminMapper.createWork(work);
		return create;
	}
	
//	@Override
//	public boolean createWorkDetail(Work work) throws Exception {
//		return createWorkDetail(work); 
//	}
	
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
	public List<Product> selectProductOne(int pNo) throws Exception {
		return adminMapper.selectProductOne(pNo);
	}

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public boolean updateProduct(Product product) throws Exception {
		boolean update = false ; 
		update = adminMapper.updateProduct(product);
//		if (updateOk) {
//			adminMapper.updateProductDetail(product);
//		}else {
//			throw new FailCreateException("업데이트에 실패하였습니다.");
//		}
		return update;
	}

//	@Override
//	public boolean updateProductDetail(Product product) throws Exception {
//		return adminMapper.updateProductDetail(product);
//	}
	
	@Override
	public boolean deleteProduct(int pNo) throws Exception {
		return adminMapper.deleteProduct(pNo);
	}

	@Override
	public boolean productConfirm(int pNo) {
		return adminMapper.productConfirm(pNo);
	}



	@Override
	public Product selectProductOnly(int pNo) throws Exception {
		return adminMapper.selectProductOnly(pNo);
	}


	@Override
	public List<Product> selectUnconfirmProduct() throws Exception {
		return adminMapper.selectUnconfirmProduct();
	}






}
