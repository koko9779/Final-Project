package com.itwill.staily.main.mapper;

import java.util.List;

import com.itwill.staily.mypage.model.dto.Bookmark;
import com.itwill.staily.util.Member;
import com.itwill.staily.util.Product;
import com.itwill.staily.util.Work;

public interface MainMapper {
	/*
	 	1. 회원번호를 통해서 즐겨찾기한 목록 찾기	
		2. 인기많은(조회수 높은) 상품 출력	
		3-1. 카테고리 = 드라마인 작품 출력하기
		3-2. 카테고리 = 영화인 작품 출력하기
		
		4.선택한 작품의 포스터,상품 출력하기
		5.선택한 작품의 포스터,해당 회차의 상품들 출력하기
		6.즐겨찾기 등록하기	
		7.즐겨찾기 제거하기
		8.총회차 찾기
		
		9.작품 조회수 증가
		10.상품 조회수 증가
		11.게시물 총 건수
		
		- 상품들을 최신순으로 정렬하기
		- 상품들을 인기순으로 정렬하기
	 */
	public List<Bookmark> selectByBookmark(int mNo);
	public List<Product> selectByView();
	public List<Work> selectByCategory(String category);
	
	public List<Work> selectByWork(int wNo);
	public List<Work> selectByEpisode(int wNo, int episode);
	public int createBookmark(int mNo, int pNo);
	public int deleteBookmark(int bmNo);
	public int selectTepisode(int wNo);
	
	public void increaseWorkView(int wNo);
	public void increaseProductView(int pNo);
	public int selectProductCount();
}