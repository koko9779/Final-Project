package com.itwill.staily.admin.mapper;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.staily.admin.service.AdminService;
import com.itwill.staily.admin.service.impl.AdminServiceImpl;
import com.itwill.staily.detail.service.ProductDetailServiceImpl;
import com.itwill.staily.main.mapper.MainMapper;
import com.itwill.staily.util.Member;
import com.itwill.staily.util.Product;
import com.itwill.staily.util.Work;

public class ProductTestlMain {

	public static void main(String[] args) throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/application-config.xml");
		AdminMapper adm = applicationContext.getBean(AdminMapper.class);
		MainMapper mp =applicationContext.getBean(MainMapper.class);
		
		
		AdminServiceImpl as = applicationContext.getBean(AdminServiceImpl.class);
		// 1. 멤버한명 검색
//		Member member = as.selectMemberOne(1);
//		System.out.println(member.toString());
		
		//2. 멤버리스트 출력 
//		List<Member> memberList = as.selectMemberAll();
//		System.out.println(memberList.size());
		
//		//3. 회원수정
//		Member member = new Member(7, "상수변경", "1234", "상수수", "주소또변경", "또변경", "변경", "M", "112");
//		System.out.println(adm.updateMember(member));
		//4. 작품 입력
//		Work work = new Work(0, "작품입력테스트", "D", "날짜", "없어", 25, 0);
//		boolean ok = adm.createWork(work);
//		System.out.println(ok);
		//5. 작품 전체출력
//		List<Work> workList = adm.selectWorkAll();
//		System.out.println(workList.size());
		//6. 작품하나 출력
//		Work work = adm.selectWorkOne(1);
//		System.out.println(work);
		//7. 작품수정 
//		Work work = new Work(23, "작품수정테스트", "D", "날짜", "없어", 25, 0);
//		boolean ok = adm.updateWork(work);
//		System.out.println(ok);
		//8. 상품전체출력
//		List<Product> productList = adm.selectProductAll();
//		System.out.println(productList.size());
		//9. 상품하나 출력
//		Product product = adm.selectProductOne(1);
//		System.out.println(product);
		//10. 수정
		
	}
	
}
