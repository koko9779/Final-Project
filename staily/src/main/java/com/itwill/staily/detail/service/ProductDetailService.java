package com.itwill.staily.detail.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.itwill.staily.detail.model.dto.ProductEx;

public interface ProductDetailService {
	public List<ProductEx> selectProductOne(int pNo) throws Exception;
	
	public boolean createProduct(ProductEx product, @Param("wdEpisode") int wdEpisode, @Param("pNo") int pNo) throws Exception;
	
	public boolean createProductDetail(ProductEx product) throws Exception;
	
	public boolean updateProduct(ProductEx product) throws Exception;

	public boolean updateProductDetail(ProductEx product) throws Exception;

	public boolean deleteProduct(int pNo) throws Exception;
	
	public boolean deleteProductDetail(int pdNo) throws Exception;
	
	public int checkCompany(int mNo) throws Exception;
	
	public boolean increaseProductView(int pNo) throws Exception;
	
	public int pNo_currval() throws Exception;
	
	public int pNo_nextval() throws Exception;
}
