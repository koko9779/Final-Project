package com.itwill.staily.login.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwill.staily.login.service.LoginService;
import com.itwill.staily.util.Company;
import com.itwill.staily.util.Member;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/application-config.xml")

public class LoginServiceTest {
	@Autowired
	private ApplicationContext applicationContext;
	@Autowired
	private LoginService loginService;
	@Test
	public void loginServiceTest() {
		assertNotNull(applicationContext);
		assertNotNull(loginService);
	}
	
	@Test
	public void loginTest() throws Exception { 
		Member member = new Member();
		member.setmId("hiphopmy");
		member.setmPw("1234");
		
		assertEquals(3, loginService.login(member).getmNo());
	}
	
	@Test
	public void findId() throws Exception {
		Assert.assertEquals("ehdanf91", loginService.findId("01091434908", "천영주"));
	}
	
	@Test
	public void isIdExist() throws Exception {
		assertEquals(1, loginService.isIdExist("ehdanf91", "01091434908"));
	}
	
	@Test
	public void updatePw() throws Exception {
		Member updateMember = new Member();
		updateMember.setmId("ehdanf91");
		updateMember.setmPw("1030");
		
		assertEquals(1, loginService.updatePw(updateMember));
	}
	
	@Test
	@Ignore
	public void signMember() throws Exception {
		Member member = new Member();
		member.setmId("제이유닛테스뚜아이디");
		member.setmPw("1111");
		member.setmAddress("주소없음");
		member.setmDaddress("디테일주소없음");
		member.setmEmail("sdfhjs@sdkjfhdsfj");
		member.setmName("이름짓기구찮");
		member.setmPhone("01011112222");
		member.setmType("M");
		assertEquals(1, loginService.signUpMember(member));
	}
	
	@Test
	@Ignore
	public void signCompany() throws Exception {
		Member member = new Member();
		member.setmId("제이유닛테스뚜기업");
		member.setmPw("1111");
		member.setmAddress("기업주소없음");
		member.setmDaddress("기업디테일주소없음");
		member.setmEmail("giup@sdkjfhdsfj");
		member.setmName("기업이름");
		member.setmPhone("01099998888");
		member.setmType("C");
		
		Company company = new Company();
		//company.setCoNo(12345678);
		
		member.setmCompany(company);
		assertEquals(1, loginService.signUpCompany(member));
	}
	
	@Test
	public void isEmailExist() throws Exception {
		assertEquals(1, loginService.isEmailExist("mint8711@naver.com"));
	}
	
	
	
	
	
	
	
	
}
