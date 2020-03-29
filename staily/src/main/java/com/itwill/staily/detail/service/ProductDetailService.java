package com.itwill.staily.detail.service;

import com.itwill.staily.util.Product;

public interface ProductDetailService {
	public Product selectProductOne(int pNo) throws Exception;
	
	public boolean createProduct(Product product) throws Exception;
	
	public boolean createProductDetail(Product product) throws Exception;
	
	public boolean updateProduct(Product product) throws Exception;

	public boolean updateProductDetail(Product product) throws Exception;

	public boolean deleteProduct(int pNo) throws Exception;
	
	public boolean deleteProductDetail(int pdNo) throws Exception;
}
