package com.itwill.staily.detail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.staily.detail.mapper.ProductDetailMapper;
import com.itwill.staily.util.Product;

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
	public Product selectProductOne(int pNo) throws Exception {
		return productDetailMapper.selectProductOne(pNo);
	}

	@Override
	public boolean createProduct(Product product) throws Exception {
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
	public boolean createProductDetail(Product product) throws Exception {
		boolean check = false;
		
		if(productDetailMapper.createProductDetail(product)) {
			check = true;			
		}
		else {
			check = false;
		}
		
		return check;
	}

}
