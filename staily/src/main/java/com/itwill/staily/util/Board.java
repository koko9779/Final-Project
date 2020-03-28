package com.itwill.staily.util;

public class Board {
	/*
	이름          널?       유형             
	----------- -------- -------------- 
	B_NO        NOT NULL NUMBER         
	M_NO        NOT NULL NUMBER         
	B_TITLE              VARCHAR2(50)   
	B_CONTENT            VARCHAR2(4000) 
	B_GROUPNO            NUMBER         
	B_STEP               NUMBER         
	B_VIEW               NUMBER         
	B_RECOMMEND          NUMBER         
	B_TYPE               CHAR(1)        
	B_DATE               VARCHAR2(12)   
	B_CHOICE             CHAR(1)        
	 */
	private int bNo; //게시물번호
	private int mNo; //회원번호
	private String bTitle; //제목
	private String bContent; //내용
	private int bGroupNo; // groupno
	private int bStep; //step
	private int bView; //조회수
	private int bRecommend; //추천수
	private String bType; //게시글타입 일대일문의 Q, 스타일코디 S
	private String bDate; //작성일
	private String bChoice; //답글타입, 선정되면 Y, 아니면 N
	private BoardDetail boardDetail; // 이미지가 들어있는 Dto
	
	public Board() {
		// TODO Auto-generated constructor stub
	}
	
	public Board(int bNo, int mNo, String bTitle, String bContent, int bGroupNo, int bStep, int bView,
			int bRecommend, String bType, String bDate, String bChoice, BoardDetail boardDetail) {
		super();
		this.bNo = bNo;
		this.mNo = mNo;
		this.bTitle = bTitle;
		this.bContent = bContent;
		this.bGroupNo = bGroupNo;
		this.bStep = bStep;
		this.bView = bView;
		this.bRecommend = bRecommend;
		this.bType = bType;
		this.bDate = bDate;
		this.bChoice = bChoice;
		this.boardDetail = boardDetail;
	}

	@Override
	public String toString() {
		return "Board [bNo=" + bNo + ", mNo=" + mNo + ", bTitle=" + bTitle + ", bContent=" + bContent
				+ ", bGroupNo=" + bGroupNo + ", bStep=" + bStep + ", bView=" + bView + ", bRecommend=" + bRecommend
				+ ", bType=" + bType + ", bDate=" + bDate + ", bChoice=" + bChoice + ", boardDetail=" + boardDetail
				+ "]";
	}
	
	public int getbNo() {
		return bNo;
	}
	public void setbNo(int bNo) {
		this.bNo = bNo;
	}
	public int getmNo() {
		return mNo;
	}
	public void setmNo(int mNo) {
		this.mNo = mNo;
	}
	
	public String getbTitle() {
		return bTitle;
	}
	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}
	public String getbContent() {
		return bContent;
	}
	public void setbContent(String bContent) {
		this.bContent = bContent;
	}
	public int getbGroupNo() {
		return bGroupNo;
	}
	public void setbGroupNo(int bGroupNo) {
		this.bGroupNo = bGroupNo;
	}
	public int getbStep() {
		return bStep;
	}
	public void setbStep(int bStep) {
		this.bStep = bStep;
	}
	public int getbView() {
		return bView;
	}
	public void setbView(int bView) {
		this.bView = bView;
	}
	public int getbRecommend() {
		return bRecommend;
	}
	public void setbRecommend(int bRecommend) {
		this.bRecommend = bRecommend;
	}
	public String getbType() {
		return bType;
	}
	public void setbType(String bType) {
		this.bType = bType;
	}
	public String getbDate() {
		return bDate;
	}
	public void setbDate(String bDate) {
		this.bDate = bDate;
	}
	public String getbChoice() {
		return bChoice;
	}
	public void setbChoice(String bChoice) {
		this.bChoice = bChoice;
	}
	public BoardDetail getBoardDetail() {
		return boardDetail;
	}
	public void setBoardDetail(BoardDetail boardDetail) {
		this.boardDetail = boardDetail;
	}
	

}
