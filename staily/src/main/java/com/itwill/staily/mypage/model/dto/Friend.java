package com.itwill.staily.mypage.model.dto;

import com.itwill.staily.util.Member;

public class Friend {
	private int fPk;	//친구pk
	private int fNo;	//친구번호
	private int mNo;	//회원번호
	private String mName; //회원이름
		
	private Member member;
	
	public Friend() {
		
	}
	
	public Friend(int fNo, int mNo) {
		super();
		this.fNo = fNo;
		this.mNo = mNo;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}



	public Friend(int fPk, int fNo, int mNo) {
		super();
		this.fPk = fPk;
		this.fNo = fNo;
		this.mNo = mNo;
	}
	
	
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public int getfPk() {
		return fPk;
	}

	public void setfPk(int fPk) {
		this.fPk = fPk;
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

	@Override
	public String toString() {
		return "Friend [fPk=" + fPk + ", fNo=" + fNo + ", mNo=" + mNo + "]";
	}

	
	
}
