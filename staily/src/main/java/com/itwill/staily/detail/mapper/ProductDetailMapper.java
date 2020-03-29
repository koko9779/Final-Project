package com.itwill.staily.detail.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.staily.util.Product;

@Mapper
public interface ProductDetailMapper {
	public Product selectProductOne(int pNo);
	
	public boolean createProduct(Product product);
	
	public boolean createProductDetail(Product product);
	
}
