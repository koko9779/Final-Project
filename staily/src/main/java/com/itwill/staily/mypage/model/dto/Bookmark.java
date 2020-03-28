package com.itwill.staily.mypage.model.dto;

public class Bookmark {
	private int mNo;	//회원번호
	private int pNo;	//상품번호
	
	public Bookmark() {
		
	}
	

	public Bookmark(int mNo, int pNo) {
		super();
		this.mNo = mNo;
		this.pNo = pNo;
	}


	public int getmNo() {
		return mNo;
	}

	public void setmNo(int mNo) {
		this.mNo = mNo;
	}

	public int getpNo() {
		return pNo;
	}

	public void setpNo(int pNo) {
		this.pNo = pNo;
	} 
	
	
	
	
}
