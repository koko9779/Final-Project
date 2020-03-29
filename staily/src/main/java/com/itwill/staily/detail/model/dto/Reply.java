package com.itwill.staily.detail.model.dto;

public class Reply {
	private int rRno; //댓글 번호
	private int rPno; //상품 번호
	private int rMno; //회원 번호
	private String rContent; //댓글 내용
	private int rRecommend; //추천 수
	private int rReport; //신고 수
	
	public Reply() {
		super();
	}

	public Reply(int rRno, int rPno, int rMno, String rContent, int rRecommend, int rReport) {
		super();
		this.rRno = rRno;
		this.rPno = rPno;
		this.rMno = rMno;
		this.rContent = rContent;
		this.rRecommend = rRecommend;
		this.rReport = rReport;
	}
	
	public Reply(int rPno, int rMno, String rContent, int rRecommend, int rReport) {
		super();
		this.rPno = rPno;
		this.rMno = rMno;
		this.rContent = rContent;
		this.rRecommend = rRecommend;
		this.rReport = rReport;
	}

	public Reply(int rRno, int rPno, int rMno) {
		super();
		this.rMno = rMno;
		this.rPno = rPno;
		this.rRno = rRno;
	}
	
	public int getrMno() {
		return rMno;
	}

	public void setrMno(int rMno) {
		this.rMno = rMno;
	}

	public int getrPno() {
		return rPno;
	}

	public void setrPno(int rPno) {
		this.rPno = rPno;
	}

	public int getrRno() {
		return rRno;
	}

	public void setrRno(int rRno) {
		this.rRno = rRno;
	}

	public String getrContent() {
		return rContent;
	}

	public void setrContent(String rContent) {
		this.rContent = rContent;
	}

	public int getrRecommend() {
		return rRecommend;
	}

	public void setrRecommend(int rRecommend) {
		this.rRecommend = rRecommend;
	}

	public int getrReport() {
		return rReport;
	}

	public void setrReport(int rReport) {
		this.rReport = rReport;
	} 
}