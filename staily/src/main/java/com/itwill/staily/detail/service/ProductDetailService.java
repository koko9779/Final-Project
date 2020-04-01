package com.itwill.staily.detail.service;

import com.itwill.staily.detail.model.dto.ProductEx;

public interface ProductDetailService {
	public ProductEx selectProductOne(int pNo) throws Exception;
	
	public boolean createProduct(ProductEx product) throws Exception;
	
	public boolean createProductDetail(ProductEx product) throws Exception;
	
	public boolean updateProduct(ProductEx product) throws Exception;

	public boolean updateProductDetail(ProductEx product) throws Exception;

	public boolean deleteProduct(int pNo) throws Exception;
	
	public boolean deleteProductDetail(int pdNo) throws Exception;
	
	public int checkCompany(int mNo) throws Exception;
}
