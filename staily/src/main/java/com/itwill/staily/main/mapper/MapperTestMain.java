package com.itwill.staily.main.mapper;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.staily.main.service.impl.mainServiceImpl;
import com.itwill.staily.mypage.model.dto.Bookmark;
import com.itwill.staily.util.Member;
import com.itwill.staily.util.Product;
import com.itwill.staily.util.Work;

public class MapperTestMain {

	public static void main(String[] args) throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/application-config.xml");
		MainMapper mainM = applicationContext.getBean(MainMapper.class);
		
		System.out.println("1. 회원번호를 통해서 즐겨찾기한 목록 찾기");
		List<Bookmark> bmList = mainM.selectByBookmark(2);
		for (Bookmark bm : bmList) {
			System.out.println("["+bm.getBmNo()+","+bm.getMember().getmNo()+","+bm.getProduct().getpNo()+":"
								+bm.getProduct().getpName()+","+bm.getProduct().getPdScene()+"]");
		}
		System.out.println("----------------------------------------");	
		
		System.out.println("2. 인기많은(조회수 높은) 상품 출력");
		List<Product> productList = mainM.selectByView();
		for (Product product : productList) {
			System.out.println("["+product.getpNo()+":"+product.getpName()+","+product.getpView()+","+product.getPdScene()+"]");
		}
		System.out.println("----------------------------------------");
		
		System.out.println("3-1. 카테고리 = 드라마인 작품 출력하기");
		List<Work> workList = mainM.selectByCategory("d");
		for (Work work : workList) {
			System.out.println("["+work.getwNo()+":"+work.getwCategory()+","+work.getwPoster()+"]");
		}
		System.out.println("----------------------------------------");
		
		System.out.println("4.선택한 작품의 포스터,상품 출력하기(보류:결과값이 다르게 출력됨)");
		/*
		List<Work> workList2 = mainM.selectByWork(2);
		for (Work work : workList2) {
			System.out.println("["+work.getwNo()+","+work.getwCategory()+","+work.getwPoster()+","+work.getwName()+","+work.getwTepisode()
								+","+work.getProduct().getpNo()+","+work.getProduct().getpName()+","+work.getProduct().getPdScene()+"]");
		}
		System.out.println("----------------------------------------");
		*/
		System.out.println("5.선택한 작품의 포스터,해당 회차의 상품들 출력하기(보류)");
		/*
		List<Work> wE = mainM.selectByEpisode(3,10);
		for (Work w : wE) {
			System.out.println("["+w.getWdNo()+","+w.getProduct().getpNo()+","+w.getwNo()+","+
								w.getwTepisode()+","+w.getWdEpisode()+","+w.getwPoster()+","+w.getwName()+","+
								w.getProduct().getpName()+","+w.getProduct().getPdScene()+"]");
		}
		System.out.println("----------------------------------------");
		*/
		
		System.out.println("6.즐겨찾기 등록하기(보류)");
		Member m = new Member(10, "test", "test", "test", "test", "test", "test@email.com", "M", "01012341234", null);
		Product p = new Product(25, "이미이지", "명자앙면");
		int result = mainM.createBookmark(m.getmNo(),p.getpNo());
		System.out.println(result);
		System.out.println("----------------------------------------");
		
		System.out.println("7.즐겨찾기 제거하기");
		int result1 = mainM.deleteBookmark(2);
		System.out.println(result1);
		System.out.println("----------------------------------------");

		System.out.println("8.총회차 찾기");
		int t = mainM.selectTepisode(1);
		System.out.println(t);
		System.out.println("----------------------------------------");
		
		
		mainServiceImpl ms = applicationContext.getBean(mainServiceImpl.class);
		
		List<Bookmark> bmList1 = ms.selectByBookmark(2);
		for (Bookmark bm : bmList1) {
			System.out.println("["+bm.getBmNo()+","+bm.getMember().getmNo()+","+bm.getProduct().getpNo()+":"
								+bm.getProduct().getpName()+","+bm.getProduct().getPdScene()+"]");
		}

		
	}
	
}
