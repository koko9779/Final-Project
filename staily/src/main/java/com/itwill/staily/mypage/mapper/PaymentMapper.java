package com.itwill.staily.mypage.mapper;

import java.util.List;

import com.itwill.staily.mypage.model.dto.Payment;

public interface PaymentMapper {
	
	public Payment selectOne(int pyNo);
	
	public List<Payment> selectList(int mNo);
	
	public int createPayment(Payment payment);
	
	public int deletePayment(int py_no);
}
