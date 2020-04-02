package com.itwill.staily.main.service;

import java.util.List;
import java.util.Map;

import com.itwill.staily.mypage.model.dto.Bookmark;
import com.itwill.staily.util.Member;
import com.itwill.staily.util.Product;
import com.itwill.staily.util.Work;

public interface ListService {
	
	//작품상세페이지 상품리스트 출력(기업)
	public List<Work> selectCProductList(int wNo);
	//작품상세페이지 상품리스트 출력(일반)
	public List<Work> selectMProductList(int wNo);
	//작품상세페이지 상품리스트 회차별 출력(기업)
	public List<Work> selectCProductListByEpisode(Map map);
	//작품상세페이지 상품리스트 회차별 출력(일반)
	public List<Work> selectMProductListByEpisode(Map map);
			
	//즐겨찾기 등록	
	public int createBookmark(Map map);
	//즐겨찾기 제거
	public int deleteBookmark(int bmNo);
	//게시물 총 건수
	public int selectProductCount();		

}
