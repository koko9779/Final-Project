package com.itwill.staily.admin.mapper;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.staily.admin.service.AdminService;
import com.itwill.staily.admin.service.AdminServiceImpl;
import com.itwill.staily.util.Member;

public class ProductTestlMain {

	public static void main(String[] args) throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/application-config.xml");
		AdminMapper adm = applicationContext.getBean(AdminMapper.class);
		
//		AdminServiceImpl as = applicationContext.getBean(AdminServiceImpl.class);
		//ProductDaoImpl ProductDaoImpl = (ProductDaoImpl)applicationContext.getBean(ProductDaoImpl.class);
		//ProductMapper ProductMapper = (ProductMapper)applicationContext.getBean(ProductMapper.class);
		Member member = adm.selectMemberOne(1);
		System.out.println(member);
		
		//2.한페이지에표시할 게시물수 
//		int rowCountPerPage = 5;
//		//3.한페이지에보여줄 페이지번호갯수(<< 1 2 3 4 5 >>)
//		int pageCountPerPage = 10;


		System.out.println("####");


//		Product updateProduct = new Product(80, "징징징징찡", null, "현기증", null, null, null);
//		System.out.println(ProductService.updateProduct(updateProduct));
//		
//		Product sProduct = ProductService.findOneProduct(80);
//		System.out.println(sProduct);
		
//		ProductService.deleteProduct(78);
//		
//		ProductService.createProduct(new Product(null, "신규회원", "경기도 팥죽시", "화이팅면 3302", "080-500-4949", "hero@naver.com", ""));
		
		
		/*
		 * 	@Update("UPDATE Product SET ANAME=#{aName},Product=#{Product},ProductDETAIL=#{ProductDetail},APHONE=#{aPhone}, AMEMO=#{aMemo} WHERE ANO =#{aNo}")
	public int update(Product Product);	// 주소록 업데이트
		 */
		
	}
	
}
