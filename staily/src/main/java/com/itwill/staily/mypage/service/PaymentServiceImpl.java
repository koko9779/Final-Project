package com.itwill.staily.mypage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.staily.mypage.mapper.PaymentMapper;
import com.itwill.staily.mypage.model.dto.Payment;

public class PaymentServiceImpl implements PaymentService {
	@Autowired
	private PaymentMapper paymentMapper;
	
	@Override
	public Payment selectOne(int pyNo) throws Exception {
		return paymentMapper.selectOne(pyNo);
	}

	@Override
	public List<Payment> selectList(int mNo) throws Exception {
		return paymentMapper.selectList(mNo);
	}

	@Override
	public int createPayment(Payment payment) throws Exception {
		return paymentMapper.createPayment(payment);
	}

	@Override
	public int deletePayment(int py_no) throws Exception {
		return paymentMapper.deletePayment(py_no);
	}

}
