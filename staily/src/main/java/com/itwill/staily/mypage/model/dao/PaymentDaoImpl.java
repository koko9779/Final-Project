package com.itwill.staily.mypage.model.dao;

import java.util.List;

import com.itwill.staily.mypage.mapper.PaymentMapper;
import com.itwill.staily.mypage.model.dto.Payment;

public class PaymentDaoImpl implements PaymentDao{
	private PaymentMapper paymentMapper;
	
	public PaymentDaoImpl() {
		
	}

	public PaymentMapper getPaymentMapper() {
		return paymentMapper;
	}

	public void setPaymentMapper(PaymentMapper paymentMapper) {
		this.paymentMapper = paymentMapper;
	}


	@Override
	public Payment selectOne(int pyNo) {
		Payment payment = paymentMapper.selectOne(pyNo);
		return payment;
	}

	@Override
	public List<Payment> selectList(int mNo) {
		List<Payment> paymentList = paymentMapper.selectList(mNo);
		return paymentList;
	}

	@Override
	public int createPayment(Payment payment) {
		int insertRow = paymentMapper.createPayment(payment);
		return insertRow;
	}

	@Override
	public int deletePayment(int py_no) {
		int deleteRow = paymentMapper.deletePayment(py_no);
		return deleteRow;
	}

}
