package com.itwill.staily.admin.service.impl;

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

import com.itwill.staily.admin.mapper.AdminMapper;
import com.itwill.staily.admin.service.AdminService;
import com.itwill.staily.login.mapper.LoginCommonMapper;
import com.itwill.staily.login.mapper.LoginMapper;
import com.itwill.staily.login.mapper.SignUpMapper;
import com.itwill.staily.login.service.LoginService;
import com.itwill.staily.util.Member;
import com.itwill.staily.util.Product;
import com.itwill.staily.util.Work;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/application-config.xml")

public class AdminServiceTest {
	@Autowired
	private ApplicationContext applicationContext;
	@Autowired
	private DataSource apacheDataSource;
	@Autowired
	private LoginCommonMapper loginCommonMapper;
	@Autowired
	private LoginService loginService;
	@Autowired
	private AdminMapper adminMapper;
	@Autowired
	private AdminService adminService;
	
	@Test
	public void adminServiceTest() {
		assertNotNull(applicationContext);
		assertNotNull(apacheDataSource);
		assertNotNull(adminMapper);
		assertNotNull(adminService);
		
		
	}
	@Test
	@Ignore
	public void updateTest() throws Exception {
		Product product = new Product(10,4,21,"test이름",19871101,"http://naver.com","태양계","지구별","N",3,null,"권은비 오렌지 scene",46,"바뀌냐");
		assertEquals(true, adminService.updateProduct(product));
	}
	@Test
	@Ignore
	public void createTest() throws Exception{
		Work work = new Work(0, "그남자의 기억법", "D", null, "무슨무슨포스터", 20, 15);
		assertEquals(true, adminService.createWork(work));
	}
	
	@Test
	@Ignore
	public void loginTest() throws Exception { 
		Member member = new Member();
		member.setmId("hiphopmy");
		member.setmPw("1234");
		
		assertEquals("hiphopmy", loginService.login(member));
	}
	
	@Test
	@Ignore
	public void findId() {
		assertEquals(0,loginCommonMapper.isExistedId("hiphopmydsfadf"));
	}
	
	
	
	
	
	
	
	
	
}
