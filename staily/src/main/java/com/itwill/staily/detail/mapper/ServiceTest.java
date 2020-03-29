package com.itwill.staily.detail.mapper;

import com.itwill.staily.detail.service.ProductDetailService;
import com.itwill.staily.detail.service.ProductDetailServiceImpl;

public class ServiceTest {

	public static void main(String[] args) throws Exception {
		ProductDetailService pd = new ProductDetailServiceImpl();
		System.out.println(pd.selectProductOne(1));

	}

}
