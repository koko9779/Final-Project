package com.itwill.staily.admin.model;

public class Stats {
	//����ȣ
	private int stNo;
	//�湮����
	private String stDate;
	//�湮�ð�
	private String stTime;
	//�湮�ο�
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
