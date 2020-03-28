package com.itwill.staily.admin.model.dto;

public class Stats {
	//통계번호
	private int stNo;
	//방문요일
	private String stDate;
	//방문시간
	private String stTime;
	//방문인원
	private String stVisit;
	
	public int getStNo() {
		return stNo;
	}
	public void setStNo(int stNo) {
		this.stNo = stNo;
	}
	public String getStDate() {
		return stDate;
	}
	public void setStDate(String stDate) {
		this.stDate = stDate;
	}
	public String getStTime() {
		return stTime;
	}
	public void setStTime(String stTime) {
		this.stTime = stTime;
	}
	public String getStVisit() {
		return stVisit;
	}
	public void setStVisit(String stVisit) {
		this.stVisit = stVisit;
	}
	public Stats(int stNo, String stDate, String stTime, String stVisit) {
		super();
		this.stNo = stNo;
		this.stDate = stDate;
		this.stTime = stTime;
		this.stVisit = stVisit;
	}
	
}
