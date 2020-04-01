package com.itwill.staily.main.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.staily.detail.mapper.ProductDetailMapper;
import com.itwill.staily.detail.mapper.WorkDetailMapper;
import com.itwill.staily.util.Product;
import com.itwill.staily.util.Work;

public class ListMapperTest {

	public static void main(String[] args) throws Exception {
	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/application-config.xml");
	ListMapper listM = applicationContext.getBean(ListMapper.class);
	WorkDetailMapper wdM = applicationContext.getBean(WorkDetailMapper.class);
	
	System.out.println("1.작품상세페이지 작품정보(작품이름,작품 포스터) 출력 ");
	
	Work work = wdM.selectWorkOne(1);
	System.out.println(work.getwPoster()+":"+work.getwName());
	System.out.println("----------------------------------------");
	
	System.out.println("2.작품상세페이지 상품정보(상품이름, 상품에피소드,상품씬,작성자) 출력");
	
	List<Work> w = listM.selectProductList(1);
	List<Product> p = new ArrayList<Product>();
	
	for (int i = 0; i < w.size(); i++) {
		System.out.println("에피소드:"+w.get(i).getWdEpisode());
		p = w.get(i).getProduct();
		for (int j = 0; j < p.size(); j++) {
			System.out.println("product이름:"+p.get(j).getpName());
			System.out.println("product이름:"+p.get(j).getpName());
			System.out.println("장면(이미지):"+p.get(j).getPdScene());
			System.out.println("작성자:"+p.get(j).getmId());
			System.out.println("조회수:"+p.get(j).getpView());
			System.out.println("관리자승인여부:"+p.get(j).getpCheck());
		}
	}
	System.out.println("----------------------------------------");
	
	
	System.out.println("3.작품상세페이지 상품정보 회차별 출력");
	Map map2 = new HashMap();
	map2.put("wNo", 1);
	map2.put("wdEpisode", 1);
	List<Work> w1 = listM.selectProductListByEpisode(map2);
	List<Product> p2 = new ArrayList<Product>();
	
	for (int i = 0; i < w1.size(); i++) {
		System.out.println("에피소드:"+w1.get(i).getWdEpisode());
		p2 = w1.get(i).getProduct();
		for (int j = 0; j < p2.size(); j++) {
			System.out.println("product이름:"+p2.get(j).getpName());
			System.out.println("product이름:"+p2.get(j).getpName());
			System.out.println("장면(이미지):"+p2.get(j).getPdScene());
			System.out.println("작성자:"+p2.get(j).getmId());
			System.out.println("조회수:"+p2.get(j).getpView());
			System.out.println("관리자승인여부:"+p2.get(j).getpCheck());
			System.out.println();
		}
	}
	System.out.println("----------------------------------------");
	
	/*
	System.out.println("4.즐겨찾기 등록");
	Map map = new HashMap();
	map.put("mNo", 1);
	map.put("pNo", 1);
	int result = listM.createBookmark(map);
	System.out.println(result);
	System.out.println("----------------------------------------");
	
	
	System.out.println("5.즐겨찾기 제거");
	int result1 = listM.deleteBookmark(1);
	System.out.println(result1);
	System.out.println("----------------------------------------");
	*/
	
	System.out.println("6.게시물 총 건수");
	int cnt = listM.selectProductCount();
	System.out.println(cnt);
	
	}
}
