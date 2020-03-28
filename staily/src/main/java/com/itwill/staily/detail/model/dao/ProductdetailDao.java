package com.itwill.staily.detail.model.dao;

import com.itwill.staily.util.Product;

public interface ProductdetailDao {
	Product selectProductOne(int pNo) throws Exception;
	
	boolean createProduct(Product product) throws Exception;
	
	boolean viewMap(int pNo) throws Exception;
}
