package com.itwill.staily.main.model.dao;

import java.util.List;

import com.itwill.staily.util.Product;
import com.itwill.staily.util.Work;

public interface MainDao{
	/*
	 * CREATE Bookmark
	 */
	public boolean createBookmark(int pNo) throws Exception;
	/*
	 * SELECT by Bookmark
	 */
	public List<Product> selectByBookmark(int mNo, int pNo) throws Exception;
	/*
	 * SELECT by View
	 */
	public List<Product> selectByView() throws Exception;
	/*
	 * SELECT by Category
	 */
	public List<Work> selectByCategory(String category) throws Exception;
	/*
	 * SELECT by Work
	 */
	public List selectByWork(int wNo) throws Exception;
	/*
	 * SELECT by Episode
	 */
	public List selectByEpisode(int episode) throws Exception;
	/*
	 * DELETE Bookmark
	 */
	public boolean deleteBookmark(int pNo) throws Exception;
}