<%@page import="com.itwill.staily.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/commons/tags.jspf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>테스트용이당</title>
<script type="text/javascript">

/*
function createReply() {
	document.f.action = 'createReply';
	document.f.submit();
	
}
*/
/*
function deleteReply() {
	document.r2.action = 'deleteReply';
	document.r2.submit();
}
*/
/*
function increaseReply() {
	document.r3.action = 'detailtest';
	document.r3.submit();
}
*/
/*
function createFriend() {
	document.r4.action = 'detailtest';
	document.r4.submit();
}
*/
/*
function createProduct() {
	document.r5.action = 'detailtest';
	document.r5.submit();
}
*/
/*
function createProductDetail() {
	document.r6.action = 'detailtest';
	document.r6.submit();	
}
*/
/*
function updateProduct() {
	document.r7.action = 'detailtest';
	document.r7.submit();
}
*/
/*
function updateProductDetail() {
	document.r8.action = 'detailtest';
	document.r8.submit();
}
*/
/*
function checkCompany() {
	document.r9.action = 'detailtest';
	document.r9.submit();	
}
*/
/*
function increaseProductView() {
	document.r10.action = 'detailtest';
	document.r10.submit();
}
*/
/*
function selectWorkOne() {
	document.r11.action = 'detailtest';
	document.r11.submit();
}
*/
/*
function createWorkDetail() {
	document.r12.action = 'detailtest';
	document.r12.submit();
}
*/
/*
function selectTepisode() {
	document.r13.action = 'detailtest';
	document.r13.submit();
}
*/

function increaseWorkView() {
	document.r14.action = 'detailtest';
	document.r14.submit();
}


</script>
</head>
<body>
	<h3>${replyList}</h3>
	<h3>${replyOne}</h3>
	<h3>${productOne}</h3>
	<h3>${check}</h3>
	<!-- 
	<form name="r" method="get">
		p_no <input type="text" name="p_no" maxlength="50"/><br>
		m_no <input type="text" name="m_no" maxlength="50"/><br>
		r_content <input type="text" name="r_content" maxlength="50"/><br>
		r_recommend <input type="text" name="r_recommend" maxlength="50"/><br>
		r_report <input type="text" name="r_report" maxlength="50"/><br>
		<input type="button" value="createReply" onClick="createReply()">
	</form>
	 -->
	<!--
	<form name="r2" method="get">
		r_no <input type="text" name="r_no" maxlength="50"/><br>
		p_no <input type="text" name="p_no" maxlength="50"/><br>
		m_no <input type="text" name="m_no" maxlength="50"/><br>
		<input type="button" value="deleteReply" onClick="deleteReply()">				
	</form>
	 -->
	<!--
	<form name="r3" method="get">
		${reco}<br>
		${repo}<br>
		<input type="button" value="increaseReply" onClick="increaseReply()"> 
	</form>
	 -->
	<!-- 
	<h3>${friendList}</h3>
	<form name="r4" method="get">
		mno <input type="text" name="mNo"><br>
		fno <input type="text" name="fNo"><br>
		<input type="button" value="createFriend" onClick="createFriend()">		
	</form>
	 -->
	<!--  
	<form name="r5" method="get">
		mNo <input type="text" name="mNo"><br>
		wNo <input type="text" name="wNo"><br>
		pName <input type="text" name="pName"><br>
		pPrice <input type="text" name="pPrice"><br>
		pUrl <input type="text" name="pUrl"><br>
		pAddress <input type="text" name="pAddress"><br>
		pDaddress <input type="text" name="pDaddress"><br>
		pCheck <input type="text" name="pCheck"><br>
		pView <input type="text" name="pView"><br>
		pScene <input type="text" name="pScene"><br>
		<input type="button" value="createProduct" onClick="createProduct()">
	</form>
	-->
	<!--  
	<form name="r6" method="get">
		pNo <input type="text" name="pNo"><br>
		pdImage <input type="text" name="pdImage"><br>
		<input type="button" value="createProductDetail" onClick="createProductDetail()">
	</form>
	-->
	<!--  
	<form name="r7" method="get">
		pName <input type="text" name="pName"><br>
		pPrice <input type="text" name="pPrice"><br>
		pUrl <input type="text" name="pUrl"><br>
		pAddress <input type="text" name="pAddress"><br>
		pDaddress <input type="text" name="pDaddress"><br>
		pCheck <input type="text" name="pCheck"><br>
		pView <input type="text" name="pView"><br>
		pScene <input type="text" name="pScene"><br>
		pNo <input type="text" name="pNo"><br>
		<input type="button" value="updateProduct" onClick="updateProduct()">
	</form>
	-->
	<!--  
	<form name="r8" method="get">
		pdImage <input type="text" name="pdImage"><br>
		pdNo <input type="text" name="pdNo"><br>
		<input type="button" value="updateProductDetail" onClick="updateProductDetail()">
	</form>
	-->
	<!--  
	<form name="r9" method="get">
		mNo(cNo) <input type="text" name="mNo"><br>
		<input type="button" value="checkCompany" onClick="checkCompany()">
	</form>
	-->
	<!--  
	<h3>${view}</h3>
	<form name="r10" method="get">
		<input type="button" value="increaseProductView" onClick="increaseProductView()">
	</form>
	-->
	<!--  
	<h3>${workOne}</h3>
	<form name="r11" method="get">
		wNo <input type="text" name="wNo"><br>
		<input type="button" value="selectWorkOne" onClick="selectWorkOne()">
	</form>
	-->
	
	<h3>${workList}</h3>
	<!--  
	<form name="r12" method="get">
		pNo <input type="text" name="pNo"><br>
		wNo <input type="text" name="wNo"><br>
		wdEpisode <input type="text" name="wdEpisode"><br>
		<input type="button" value="createWorkDetail" onClick="createWorkDetail()">
	</form>
	-->
	<!--  
	<h3>${te}</h3>
	<form name="r13" method="get">
		wNo <input type="text" name="wNo"><br>
		<input type="button" value="selectTepisode" onClick="selectTepisode()">
	</form>
	-->
	
	<h3>${iW}</h3>
	<form name="r14" method="get">	
		wNo <input type="text" name="wNo"><br>
		<input type="button" value="increaseWorkView" onClick="increaseWorkView()">
	</form>
</body>
</html>