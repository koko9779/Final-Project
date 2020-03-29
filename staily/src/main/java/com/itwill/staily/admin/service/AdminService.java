package com.itwill.staily.admin.service;

import java.util.List;

import com.itwill.staily.util.Member;
import com.itwill.staily.util.Product;
import com.itwill.staily.util.Work;

public interface AdminService {
	public List<Member> selectMemberAll();
	//회원 개별출력
	public Member selectMemberOne(int mNo) throws Exception;
	//회원 수정
	public boolean updateMember(Member member) throws Exception;
	//회원삭제
	public boolean deleteMember(int mNo) throws Exception;
	
	/* 작품 */
	//작품 입력
	public boolean createWork(Work work) throws Exception;
	//작품상세 입력
	public boolean createWorkDetail(Work work) throws Exception;
	//작품 전체 출력
	public List<Work>selectWorkAll() throws Exception;
	//작품 하나 출력
	public Work selectWorkOne(int wNo) throws Exception; 
	//작품수정
	public boolean updateWork(Work work) throws Exception;
	//작품삭제
	public boolean deleteWork(int wNo) throws Exception;
	
	
	/* 상품 */
	//상품 전체출력
	public List<Product> selectProductAll() throws Exception;
	//상품 하나출력
	public Product selectProductOne(int pNo) throws Exception;
	//상품 수정
	public boolean updateProduct(Product product) throws Exception;
	//상품상세 수정
	public boolean updateProductDetail(int pdNo) throws Exception;
	//상품 삭제
	public boolean deleteProduct(int pNo) throws Exception;
}

