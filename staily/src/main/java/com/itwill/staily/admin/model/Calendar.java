package com.itwill.staily.admin.model;


public class Calendar {
	private int eventId;
	private String editTitle;
	private String editStart;
	private String editEnd;
	private String editDesc;
	private String editType;
	private String userName;
	private String editColor;
	private String textColor;
	private String allDay;
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public String getEditTitle() {
		return editTitle;
	}
	public void setEditTitle(String editTitle) {
		this.editTitle = editTitle;
	}
	public String getEditStart() {
		return editStart;
	}
	public void setEditStart(String editStart) {
		this.editStart = editStart;
	}
	public String getEditEnd() {
		return editEnd;
	}
	public void setEditEnd(String editEnd) {
		this.editEnd = editEnd;
	}
	public String getEditDesc() {
		return editDesc;
	}
	public void setEditDesc(String editDesc) {
		this.editDesc = editDesc;
	}
	public String getEditType() {
		return editType;
	}
	public void setEditType(String editType) {
		this.editType = editType;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEditColor() {
		return editColor;
	}
	public void setEditColor(String editColor) {
		this.editColor = editColor;
	}
	public String getTextColor() {
		return textColor;
	}
	public void setTextColor(String textColor) {
		this.textColor = textColor;
	}
	public String getAllDay() {
		return allDay;
	}
	public void setAllDay(String allDay) {
		this.allDay = allDay;
	}
	public Calendar(int eventId, String editTitle, String editStart, String editEnd, String editDesc, String editType,
			String userName, String editColor, String textColor, String allDay) {
		super();
		this.eventId = eventId;
		this.editTitle = editTitle;
		this.editStart = editStart;
		this.editEnd = editEnd;
		this.editDesc = editDesc;
		this.editType = editType;
		this.userName = userName;
		this.editColor = editColor;
		this.textColor = textColor;
		this.allDay = allDay;
	}
	@Override
	public String toString() {
		return "Calendar [eventId=" + eventId + ", editTitle=" + editTitle + ", editStart=" + editStart + ", editEnd="
				+ editEnd + ", editDesc=" + editDesc + ", editType=" + editType + ", userName=" + userName
				+ ", editColor=" + editColor + ", textColor=" + textColor + ", allDay=" + allDay + "]";
	}
	public Calendar() {
		// TODO Auto-generated constructor stub
	}
	

}