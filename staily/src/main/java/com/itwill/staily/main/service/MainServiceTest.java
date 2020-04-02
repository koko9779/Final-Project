package com.itwill.staily.main.service;

import static org.junit.Assert.*;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwill.staily.detail.mapper.WorkDetailMapper;
import com.itwill.staily.main.mapper.ListMapper;
import com.itwill.staily.main.mapper.MainMapper;
import com.itwill.staily.main.service.impl.ListServiceImpl;
import com.itwill.staily.main.service.impl.MainServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/application-config.xml")

public class MainServiceTest {

	@Autowired
	private ApplicationContext applicationContext;
	@Autowired
	private DataSource apacheDataSource;
	@Autowired
	private MainMapper mainMapper;
	@Autowired
	private ListMapper listMapper;
	@Autowired
	private WorkDetailMapper workDetailMapper;
	@Autowired
	private MainServiceImpl mainServiceImpl;
	@Autowired
	private ListServiceImpl listServiceImpl;
	
	@Test
	public void mainServiceTest() {
		assertNotNull(applicationContext);
		assertNotNull(apacheDataSource);
		assertNotNull(mainMapper);
		assertNotNull(listMapper);
		assertNotNull(workDetailMapper);
		assertNotNull(mainServiceImpl);
		assertNotNull(listServiceImpl);
	}
	
	@Test
	public void testSelectByBookmark() throws Exception {
		assertNotNull(mainServiceImpl.selectByBookmark(1));
		assertNotSame(0,mainServiceImpl.selectByBookmark(1).size());
	}

	@Test
	public void testSelectByView() throws Exception {
		assertNotNull(mainServiceImpl.selectByView());
		assertNotSame(0, mainServiceImpl.selectByView().size());
	}

	@Test
	public void testSelectByCategory() throws Exception {
		assertNotNull(mainServiceImpl.selectByCategory("D"));
		assertNotSame(0, mainServiceImpl.selectByCategory("D"));
	}

	@Test
	@Ignore
	public void testSelectTodayOfWork() {
		fail("Not yet implemented");
	}
	
	@Test
	@Ignore
	public void testListServiceImpl() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void testGetListMapper() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void testSetListMapper() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void testGetWorkDetailMapper() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void testSetWorkDetailMapper() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void testSelectCProductList() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void testSelectMProductList() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void testSelectCProductListByEpisode() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void testSelectMProductListByEpisode() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void testCreateBookmark() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void testDeleteBookmark() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void testSelectProductCount() {
		fail("Not yet implemented");
	}
}
