package com.itwill.staily.mypage.mapper;

import java.util.List;

import com.itwill.staily.mypage.model.dto.Payment;

public interface PaymentMapper {
	
	//결제 하나 선택
	public Payment selectOne(int pyNo) throws Exception;
	
	//결제 리스트 출력
	public List<Payment> selectList(int mNo) throws Exception;
	
	//결제 추가
	public boolean createPayment(Payment payment) throws Exception;
	
	//결제 삭제
	public boolean deletePayment(int py_no) throws Exception;
}
