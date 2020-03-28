package com.itwill.staily.main.mapper;

import java.util.List;

import com.itwill.staily.util.Product;
import com.itwill.staily.util.Work;

public interface MainMapper {
	/*
	 	1. 즐겨찾기한 목록 찾기	
		2. 인기많은(조회수 높은) 상품 출력	
		3. 카테고리 = 드라마인 작품 출력하기
		4. 카테고리 = 영화인 작품 출력하기
		
		5.선택한 작품의 포스터,상품 출력하기
		6.선택한 작품의 포스터,해당 회차의 상품들 출력하기
		7. 상품들을 최신순으로 정렬하기
		8. 상품들을 인기순으로 정렬하기
		9.즐겨찾기 등록하기	
		10.즐겨찾기 제거하기
	 */
	public List<Product> selectByBookmark(int mNo, int pNo);
	public List<Product> selectByView();
	public List<Work> selectByCategory(String category);
	
	public List selectByWork(int wNo);
	public List selectByEpisode(int episode);
	public int createBookmark(int pNo);
	public int deleteBookmark(int pNo);
}