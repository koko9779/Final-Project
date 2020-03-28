package com.itwill.staily.admin.mapper;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.staily.admin.service.AdminService;
import com.itwill.staily.admin.service.impl.AdminServiceImpl;
import com.itwill.staily.util.Member;

public class ProductTestlMain {

	public static void main(String[] args) throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/application-config.xml");
		AdminMapper adm = applicationContext.getBean(AdminMapper.class);
		AdminServiceImpl as = applicationContext.getBean(AdminServiceImpl.class);
		Member member = as.selectMemberOne(1);
		System.out.println(member);
		
	}
	
}
