package com.itwill.staily.detail.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.staily.detail.model.dto.ProductEx;

@Mapper
public interface ProductDetailMapper {
	public ProductEx selectProductOne(int pNo);
	
	public boolean createProduct(ProductEx product);
	
	public boolean createProductDetail(ProductEx product);
	
	public boolean updateProduct(ProductEx product);
	
	public boolean updateProductDetail(ProductEx product);
	
	public boolean deleteProduct(int pNo);
	
	public boolean deleteProductDetail(int pdNo);
	
	public int checkCompany(int mNo);
}
