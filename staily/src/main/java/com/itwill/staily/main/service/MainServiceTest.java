package com.itwill.staily.main.service;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

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
	@Ignore
	public void testSelectByBookmark() throws Exception {
		assertNotNull(mainServiceImpl.selectByBookmark(2));
		assertSame(1,mainServiceImpl.selectByBookmark(2).size());
	}

	@Test
	@Ignore
	public void testSelectByView() throws Exception {
		assertNotNull(mainServiceImpl.selectByView());
		assertNotSame(0, mainServiceImpl.selectByView().size());
	}

	@Test
	@Ignore
	public void testSelectByCategory() throws Exception {
		assertNotNull(mainServiceImpl.selectByCategory("D"));
		assertNotSame(0, mainServiceImpl.selectByCategory("D"));
	}

	@Test
	@Ignore
	public void testSelectTodayOfWork() throws Exception {
		assertNotNull(mainServiceImpl.selectTodayOfWork());
		assertNotSame(0,mainServiceImpl.selectTodayOfWork());
	}

	@Test
	@Ignore
	public void testSelectCProductList() throws Exception{
		assertNotNull(listServiceImpl.selectCProductList(4));
		assertNotSame(0, listServiceImpl.selectCProductList(4));
	}

	@Test
	public void testSelectMProductList() throws Exception{
		assertNotNull(listServiceImpl.selectMProductList(1));
		//assertSame(1, listServiceImpl.selectMProductList(1,1,2));
	}

	@Test
	@Ignore
	public void testSelectCProductListByEpisode() throws Exception{
		Map map2 = new HashMap();
		map2.put("wNo", 1);
		map2.put("wdEpisode", 1);
		assertNotNull(listServiceImpl.selectCProductListByEpisode(map2));
		assertNotSame(0, listServiceImpl.selectCProductListByEpisode(map2));
	}

	@Test
	@Ignore
	public void testSelectMProductListByEpisode() throws Exception{
		Map map3 = new HashMap();
		map3.put("wNo", 1);
		map3.put("wdEpisode", 1);
		assertNotNull(listServiceImpl.selectMProductListByEpisode(map3));
	}

	@Test
	@Ignore
	public void testCreateBookmark() throws Exception{
		Map map = new HashMap();
		map.put("mNo", 2);
		map.put("pNo", 2);
		assertNotNull(listServiceImpl.createBookmark(map));
	}

	@Test
	@Ignore
	public void testDeleteBookmark() throws Exception{
		assertNotNull(listServiceImpl.deleteBookmark(2));
	}

	@Test
	@Ignore
	public void testSelectProductCount() throws Exception{
		assertSame(5, listServiceImpl.selectProductCount(1));
	}
}
