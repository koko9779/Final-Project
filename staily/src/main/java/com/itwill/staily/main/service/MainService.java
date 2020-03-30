package com.itwill.staily.main.service;

import java.util.List;

import com.itwill.staily.mypage.model.dto.Bookmark;
import com.itwill.staily.util.Member;
import com.itwill.staily.util.Product;
import com.itwill.staily.util.Work;

public interface MainService {
 	//1. 회원번호를 통해서 즐겨찾기한 목록 찾기	
	public List<Bookmark> selectByBookmark(int mNo) throws Exception;
	//2. 인기많은(조회수 높은) 상품 출력	
	public List<Product> selectByView() throws Exception;
	//3. 카테고리별 작품 출력하기
	public List<Work> selectByCategory(String category) throws Exception;
	
	//4.선택한 작품의 포스터,상품 출력하기
	public List<Work> selectByWork(int wNo) throws Exception;
	//5.선택한 작품의 포스터,해당 회차의 상품들 출력하기
	public List<Work> selectByEpisode(int wNo, int episode) throws Exception;
	//6.즐겨찾기 등록하기	
	public int createBookmark(Member member, Product product) throws Exception;
	//7.즐겨찾기 제거하기
	public int deleteBookmark(int bmNo) throws Exception;
	//8.총회차 찾기
	public int selectTepisode(int wNo);
	
	//9.작품 조회수 증가
	public void increaseWorkView(int wNo);
	//10.상품 조회수 증가
	public void increaseProductView(int pNo);
	//11.게시물 총 건수
	public int selectProductCount();
}
