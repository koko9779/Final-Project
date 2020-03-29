package com.itwill.staily.admin.mapper;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.staily.admin.service.AdminService;
import com.itwill.staily.admin.service.impl.AdminServiceImpl;
import com.itwill.staily.detail.service.ProductDetailServiceImpl;
import com.itwill.staily.util.Member;
import com.itwill.staily.util.Product;

public class ProductTestlMain {

	public static void main(String[] args) throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/application-config.xml");
		AdminMapper adm = applicationContext.getBean(AdminMapper.class);
		AdminServiceImpl as = applicationContext.getBean(AdminServiceImpl.class);
		Member member = as.selectMemberOne(1);
		System.out.println(member);
//		ProductDetailServiceImpl pd = applicationContext.getBean(ProductDetailServiceImpl.class);
//		boolean pdd = pd.createProduct(new Product(0, 1, 1, "test", 27000, "test", "test", "test", "N", 0, "TEST", "TEST"));
////		Product pdd = pd.selectProductOne(1);
//		System.out.println(pdd);
	}
	
}
