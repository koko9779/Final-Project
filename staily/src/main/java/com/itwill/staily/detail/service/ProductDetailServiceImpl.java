package com.itwill.staily.detail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.staily.detail.mapper.ProductDetailMapper;
import com.itwill.staily.detail.model.dto.ProductEx;

@Service
public class ProductDetailServiceImpl implements ProductDetailService {
	@Autowired
	private ProductDetailMapper productDetailMapper;
	
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
	public ProductEx selectProductOne(int pNo) throws Exception {
		return productDetailMapper.selectProductOne(pNo);
	}

	@Override
	public boolean createProduct(ProductEx product) throws Exception {
		boolean check = false;
		
		if(productDetailMapper.createProduct(product)) {
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

}
