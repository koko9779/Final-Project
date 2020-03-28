package com.itwill.staily.mypage.model.dto;

public class Friend {
	private int fNo;	//친구번호
	private int mNo;	//회원번호
	
	public Friend() {
		
	}

	public Friend(int fNo, int mNo) {
		super();
		this.fNo = fNo;
		this.mNo = mNo;
	}

	public int getfNo() {
		return fNo;
	}

	public void setfNo(int fNo) {
		this.fNo = fNo;
	}

	public int getmNo() {
		return mNo;
	}

	public void setmNo(int mNo) {
		this.mNo = mNo;
	}
	
	
	
}
