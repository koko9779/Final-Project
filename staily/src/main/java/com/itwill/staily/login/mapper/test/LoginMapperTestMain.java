package com.itwill.staily.login.mapper.test;

import java.util.HashMap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.staily.login.mapper.LoginMapper;

public class LoginMapperTestMain {

	public static void main(String[] args) throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/application-config.xml");
		LoginMapper login = applicationContext.getBean(LoginMapper.class);
		int count;
		HashMap<String, Object> map = new HashMap<String, Object>();

//		String pw = login.selectMemberIdAndPw("시험용기업아이디");
//		System.out.println(pw);
		

//		map.put("mPhone", "01091434908");
//		map.put("mName", "천영주");
//		String id = login.selectIdOne(map);
//		System.out.println(id);
		
//		map.put("mPhone", "112");
//		map.put("mId", "hiphopmy");
//		count = login.isIdExist(map);
//		System.out.println(count);
		
//		map.put("mPw", "1234");
//		map.put("mId", "ehdanf91");
//		count = login.updatePwOne(map);
//		System.out.println(count);
		
		
		
	}
	
}
