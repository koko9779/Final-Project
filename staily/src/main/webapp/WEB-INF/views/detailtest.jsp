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


</script>
</head>
<body>
	<h3>${replyList}</h3>
	<h3>${replyOne}</h3>
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
		${reco }<br>
		${repo }<br>
		<input type="button" value="increaseReply" onClick="increaseReply()"> 
	</form>
	 -->
</body>
</html>