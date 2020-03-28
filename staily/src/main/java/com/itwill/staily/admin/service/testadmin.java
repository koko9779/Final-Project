package com.itwill.staily.admin.service;

public class testadmin {

	public static void main(String[] args) throws Exception {
		AdminService ad = new  AdminServiceImpl();   
		System.out.println(ad.selectMemberAll());
		
//		System.out.println(ad.selectMemberOne(1));
		
	}

}
