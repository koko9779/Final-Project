package com.itwill.staily.detail.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.staily.detail.mapper.ProductDetailMapper;
import com.itwill.staily.detail.mapper.WorkDetailMapper;
import com.itwill.staily.detail.model.dto.ProductEx;

@Service
public class ProductDetailServiceImpl implements ProductDetailService {
	@Autowired
	private ProductDetailMapper productDetailMapper;
	@Autowired
	private WorkDetailMapper workDetailMapper;
	
	public ProductDetailServiceImpl() {
		super();
	}

	public ProductDetailMapper getProductDetailMapper() {
		return productDetailMapper;
	}
	
	public void setProductDetailMapper(ProductDetailMapper productDetailMapper) {
		this.productDetailMapper = productDetailMapper;
	}

	@Override
	public List<ProductEx> selectProductOne(int pNo) throws Exception {
		return productDetailMapper.selectProductOne(pNo);
	}

	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED, propagation = Propagation.REQUIRED)
	public boolean createProduct(ProductEx product, @Param("wdEpisode") int wdEpisode, @Param("pNo") int pNo) throws Exception {
		boolean check = false;
		boolean p = productDetailMapper.createProduct(product);
		boolean wd = workDetailMapper.createWorkDetail(pNo, wdEpisode);
		
		
		if(p && wd) {
			check = true;			
		}
		else {
			check = false;
		}
		
		return check;
	}

	@Override
	public boolean createProductDetail(ProductEx product) throws Exception {
		boolean check = false;
		
		if(productDetailMapper.createProductDetail(product)) {
			check = true;			
		}
		else {
			check = false;
		}
		
		return check;
	}

	@Override
	public boolean updateProduct(ProductEx product) throws Exception {
		boolean check = false;
		
		if(productDetailMapper.updateProduct(product)) {
			check = true;			
		}
		else {
			check = false;
		}
		
		return check;
	}

	@Override
	public boolean updateProductDetail(ProductEx product) throws Exception {
		boolean check = false;
		
		if(productDetailMapper.updateProductDetail(product)) {
			check = true;			
		}
		else {
			check = false;
		}
		
		return check;
	}

	@Override
	public boolean deleteProduct(int pNo) throws Exception {
		boolean check = false;
		
		if(productDetailMapper.deleteProduct(pNo)) {
			check = true;			
		}
		else {
			check = false;
		}
		
		return check;
	}

	@Override
	public boolean deleteProductDetail(int pdNo) throws Exception {
		boolean check = false;
		
		if(productDetailMapper.deleteProductDetail(pdNo)) {
			check = true;			
		}
		else {
			check = false;
		}
		
		return check;
	}

	@Override
	public int checkCompany(int mNo) throws Exception {
		return productDetailMapper.checkCompany(mNo);
	}

	@Override
	public boolean increaseProductView(int pNo) throws Exception {
		boolean check = false;
		
		if(productDetailMapper.increaseProductView(pNo)) {
			check = true;			
		}
		else {
			check = false;
		}
		
		return check;
	}

	@Override
	public int pNo_currval() throws Exception {
		return productDetailMapper.pNo_currval();
	}

	@Override
	public int pNo_nextval() throws Exception {
		return 0;
	}
}
