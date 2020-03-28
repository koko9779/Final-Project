package com.itwill.staily.admin.model.dao;

import java.util.List;

import com.itwill.staily.util.Member;
import com.itwill.staily.util.Product;
import com.itwill.staily.util.Work;

public interface AdminDao {
	public List<Member> selectMemberAll();
	//회원 개별출력
	public Member selectMemberOne(int mNo) throws Exception;
	//회원 수정
	public int updateMember(Work work) throws Exception;
	//회원삭제
	public int deleteMember(int mNo) throws Exception;
	
	/* 작품 */
	//작품 입력
	public int createWork(Work work) throws Exception;
	//작품 전체 출력
	public List<Work>selectWorkAll() throws Exception;
	//작품 하나 출력
	public Work selectWorkOne(int wNo) throws Exception; 
	//작품수정
	public int updateWork(Work work) throws Exception;
	//작품삭제
	public int deleteWork(int wNo) throws Exception;
	/* 상품 */
	//상품 전체출력
	public List<Product> selectProductAll() throws Exception;
	//상품 하나출력
	public Product selectProductOne(int pNo) throws Exception;
	//상품 수정
	public int updateProduct(Product product) throws Exception;
	//상품 삭제
	public int deleteProduct(int pNo) throws Exception;
}
