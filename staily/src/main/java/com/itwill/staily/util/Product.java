package com.itwill.staily.util;

/*
		이름          널?       유형            
	----------- -------- ------------- 
	P_NO        NOT NULL NUMBER        
	M_NO        NOT NULL NUMBER        
	W_NO        NOT NULL NUMBER        
	P_NAME               VARCHAR2(200) 
	P_PRICE              NUMBER        
	P_URL                VARCHAR2(200) 
	P_ADDRESS            VARCHAR2(100) 
	P_DADDRRESS          VARCHAR2(50)  
	P_CHECK              CHAR(1)       
	P_VIEW               NUMBER        
	P_DATE               VARCHAR2(12)  
	이름       널?       유형            
	-------- -------- ------------- 
	P_NO     NOT NULL NUMBER        
	PD_IMAGE          VARCHAR2(200) 
	PD_SCENE          VARCHAR2(200) 
 */

public class Product {
	private int pNo; //상품 번호
	private int pMno; //회원 번호
	private int pWno; //작품 번호
	private String pName; //상품 이름
	private int pPrice; //상품 가격
	private String pUrl; //상품 url
	private String pAddress; //상품 주소
	private String pDaddress; //상품 상세 주소
	private String pCheck; //상품 승인 여부
	private int pView; //상품 조회 수
	
	private String pdImage; //상품 이미지
	private String pdScene; //상품 장면
	
	public Product() {
		super();
	}
	
	public Product(int pNo, int pMno, int pWno, String pName, int pPrice, String pUrl, String pAddress,
			String pDaddress, String pCheck, int pView, String pdImage, String pdScene) {
		super();
		this.pNo = pNo;
		this.pMno = pMno;
		this.pWno = pWno;
		this.pName = pName;
		this.pPrice = pPrice;
		this.pUrl = pUrl;
		this.pAddress = pAddress;
		this.pDaddress = pDaddress;
		this.pCheck = pCheck;
		this.pView = pView;
		this.pdImage = pdImage;
		this.pdScene = pdScene;
	}

	public int getpNo() {
		return pNo;
	}

	public void setpNo(int pNo) {
		this.pNo = pNo;
	}

	public int getpMno() {
		return pMno;
	}

	public void setpMno(int pMno) {
		this.pMno = pMno;
	}

	public int getpWno() {
		return pWno;
	}

	public void setpWno(int pWno) {
		this.pWno = pWno;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getpPrice() {
		return pPrice;
	}

	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}

	public String getpUrl() {
		return pUrl;
	}

	public void setpUrl(String pUrl) {
		this.pUrl = pUrl;
	}

	public String getpAddress() {
		return pAddress;
	}

	public void setpAddress(String pAddress) {
		this.pAddress = pAddress;
	}

	public String getpDaddress() {
		return pDaddress;
	}

	public void setpDaddress(String pDaddress) {
		this.pDaddress = pDaddress;
	}

	public String getpCheck() {
		return pCheck;
	}

	public void setpCheck(String pCheck) {
		this.pCheck = pCheck;
	}

	public int getpView() {
		return pView;
	}

	public void setpView(int pView) {
		this.pView = pView;
	}

	public String getPdImage() {
		return pdImage;
	}

	public void setPdImage(String pdImage) {
		this.pdImage = pdImage;
	}

	public String getPdScene() {
		return pdScene;
	}

	public void setPdScene(String pdScene) {
		this.pdScene = pdScene;
	} 
	
	
}
