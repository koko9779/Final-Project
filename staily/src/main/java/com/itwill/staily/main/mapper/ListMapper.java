package com.itwill.staily.main.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.staily.util.Product;
import com.itwill.staily.util.Work;

@Mapper
public interface ListMapper {
	/*
 		//WorkDetailMapper
 		1.작품상세페이지 작품정보(작품이름,작품 포스터) 출력 
 		
		2.작품상세페이지 상품정보(상품이름, 상품에피소드,상품씬,작성자) 출력
		3.작품상세페이지 상품정보 회차별 출력
				
		4.즐겨찾기 등록	
		5.즐겨찾기 제거
		6.게시물 총 건수
		
		- 상품들을 최신순으로 정렬하기
		- 상품들을 인기순으로 정렬하기
	 */

	public List<Work> selectProductList(int wNo);
	public List<Work> selectProductListByEpisode(Map map);
		
	public int createBookmark(Map map);
	public int deleteBookmark(int bmNo);
	public int selectProductCount();
}
