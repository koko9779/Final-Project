<%@page import="com.itwill.staily.login.service.LoginServiceImpl"%>
<%@page import="com.itwill.staily.login.service.LoginService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	LoginService login = new LoginServiceImpl();
	



%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input id="id" type="text">
	<input id="pass" type="text">
</body>
</html>