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
	1-1.작품상세페이지 작품정보(작품이름,작품 포스터) 출력 
	1-2.총회차 출력
	
	2.작품상세페이지 상품리스트 출력(기업)
	3.작품상세페이지 상품리스트 출력(일반)
	4.작품상세페이지 상품리스트 회차별 출력(기업)
	5.작품상세페이지 상품리스트 회차별 출력(일반)
			
	4.즐겨찾기 등록	
	5.즐겨찾기 제거
	6.게시물 총 건수
	 */

	public List<Work> selectCProductList(int wNo);
	public List<Work> selectMProductList(int wNo);
	public List<Work> selectCProductListByEpisode(Map map);
	public List<Work> selectMProductListByEpisode(Map map);
		
	public int createBookmark(Map map);
	public int deleteBookmark(int bmNo);
	public int selectProductCount();
}
