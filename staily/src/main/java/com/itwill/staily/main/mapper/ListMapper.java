package com.itwill.staily.main.mapper;

import java.util.List;
import java.util.Map;

import com.itwill.staily.util.Work;


public interface ListMapper {
	/*
 		1.선택한 작품의 포스터,상품 출력하기
		2.선택한 작품의 포스터,해당 회차의 상품들 출력하기
		3.즐겨찾기 등록하기	
		4.즐겨찾기 제거하기	
		5.게시물 총 건수
		
		- 상품들을 최신순으로 정렬하기
		- 상품들을 인기순으로 정렬하기
	 */

	public Work selectByWork(int wNo);
	public List<Work> selectByEpisode(Map map);
	public int createBookmark(Map map);
	public int deleteBookmark(int bmNo);
	public int selectProductCount();
}
