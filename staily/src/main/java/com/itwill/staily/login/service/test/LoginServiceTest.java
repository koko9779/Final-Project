package com.itwill.staily.login.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import java.util.HashMap;

import javax.sql.DataSource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwill.staily.login.mapper.LoginCommonMapper;
import com.itwill.staily.login.mapper.LoginMapper;
import com.itwill.staily.login.mapper.SignUpMapper;
import com.itwill.staily.login.service.LoginService;
import com.itwill.staily.util.Member;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/application-config.xml")

public class LoginServiceTest {
	@Autowired
	private ApplicationContext applicationContext;
	@Autowired
	private DataSource apacheDataSource;
	@Autowired
	private LoginMapper loginMapper;
	@Autowired
	private SignUpMapper signMapper;	
	@Autowired
	private LoginCommonMapper loginCommonMapper;
	@Autowired
	private LoginService loginService;
	@Test
	public void loginServiceTest() {
		assertNotNull(applicationContext);
		assertNotNull(apacheDataSource);
		assertNotNull(loginService);
	}
	
	@Test
	public void loginTest() { 
		Member member = new Member();
		member.setmId("hiphopmy");
		member.setmPw("1234");
		
		assertEquals("hiphopmy", loginService.login(member));
	}
	
	@Test
	
	public void findId() {
		assertEquals(0,loginCommonMapper.isExistedId("hiphopmydsfadf"));
	}
	
	@Test
	@Ignore
	public void isIdExist() {

	}
	
	@Test
	@Ignore
	public void updatePw() {
		
	}
	
	@Test
	@Ignore
	public void signMember() {
		
	}
	
	@Test
	@Ignore
	public void signCompany() {
		
	}
	
	
	
	
	
	
	
	
	
}
