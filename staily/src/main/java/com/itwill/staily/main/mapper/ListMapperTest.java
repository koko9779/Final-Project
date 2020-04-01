package com.itwill.staily.main.mapper;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.staily.detail.mapper.ProductDetailMapper;

public class ListMapperTest {
	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/application-config.xml");
	ListMapper listM = applicationContext.getBean(ListMapper.class);
	ProductDetailMapper pdM = applicationContext.getBean(ProductDetailMapper.class);
	
	/*
	System.out.println("4.선택한 작품의 포스터,상품 출력하기(보류:결과값이 다르게 출력됨)");
	
	Work work = mainM.selectByWork(1);
	System.out.println(work);
	
//	List<Work> workList2 = mainM.selectByWork(1);
//	for (Work work : workList2) {
//		System.out.println("["+work.getwNo()+","+work.getwCategory()+","+work.getwPoster()+","+work.getwName()+","+work.getwTepisode()+"]");
//		
//	}
	List<Product> p = work.getProduct();
	for (Product product : p) {
		System.out.println(product.getpNo()+product.getpName());
	}
	System.out.println("----------------------------------------");
	
	
	System.out.println("5.선택한 작품의 포스터,해당 회차의 상품들 출력하기");
	Map map = new HashMap();
	map.put("w_no", 1);
	map.put("wd_episode",1);
	List<Work> w = mainM.selectByEpisode(map);
	
	for (int i = 0; i < w.size(); i++) {
		System.out.println(w.get(i).getWdNo()+","+w.get(i).getwTepisode());
		//System.out.println(w.get(i).getProduct());
	}
	System.out.println("Product Scene: "+w.get(1).getProduct().get(0).getPdScene());
	 */
	/*
		System.out.println("["+w.getWdNo()+","+w.getProduct().get(0).getpNo()+","+w.getwNo()+","+
							w.getwTepisode()+","+w.getWdEpisode()+","+w.getwPoster()+","+w.getwName()+","+
							w.getProduct().get(0).getpName()+","+w.getProduct().get(0).getPdScene()+"]");
	System.out.println("----------------------------------------");
	*/
	
	/*
	System.out.println("6.즐겨찾기 등록하기");
	Map map = new HashMap();
	map.put("mNo", 1);
	map.put("pNo", 1);
	int result = mainM.createBookmark(map);
	System.out.println(result);
	System.out.println("----------------------------------------");
	*/
	/*
	System.out.println("7.즐겨찾기 제거하기");
	int result1 = mainM.deleteBookmark(1);
	System.out.println(result1);
	System.out.println("----------------------------------------");

	System.out.println("8.총회차 찾기");
	int t = mainM.selectTepisode(1);
	System.out.println(t);
	System.out.println("----------------------------------------");
	*/
}
