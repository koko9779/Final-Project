package com.itwill.staily.login.mapper.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.staily.login.mapper.LoginCommonMapper;
import com.itwill.staily.login.mapper.SignUpMapper;
import com.itwill.staily.util.Member;

public class LoginCommonMapperTestMain {

	public static void main(String[] args) throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/application-config.xml");
		LoginCommonMapper common = applicationContext.getBean(LoginCommonMapper.class);
		int count;

//		count = common.isExistedId("ehdanf91");
//		System.out.println(count);
		
//		count = common.isExistedEmail("mint8711@naver.com");
//		System.out.println(count);
		
	}
	
}
