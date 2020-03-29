package com.itwill.staily.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.staily.util.Member;
import com.itwill.staily.util.Product;
import com.itwill.staily.util.Work;

@Mapper
public interface AdminMapper {
	/* 회원 */
	
	//회원 전체출력
	public List<Member> selectMemberAll();
	//회원 개별출력
	public Member selectMemberOne(int mNo);
	//회원 수정
	public boolean updateMember(Member member);
	//회원삭제
	public boolean deleteMember(int mNo);
	
	/* 작품 */
	//작품 입력
	public boolean createWork(Work work);
	//작품상세 입력
	public boolean createWorkDetail(Work work);
	//작품 전체 출력
	public List<Work>selectWorkAll();
	//작품 하나 출력
	public Work selectWorkOne(int wNo); 
	//작품수정
	public boolean updateWork(Work work);
	//작품삭제
	public boolean deleteWork(int wNo);
	
	
	/* 상품 */
	//상품 전체출력
	public List<Product> selectProductAll();
	//상품 하나출력
	public Product selectProductOne(int pNo);
	//상품 수정
	public boolean updateProduct(Product product);
	//상품상세 수정
	public boolean updateProductDetail(int pdNo);
	//상품 삭제
	public boolean deleteProduct(int pNo);
	
	/* 게시글승인 */
}
