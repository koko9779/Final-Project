<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/commons/tags.jspf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>안녕</h1>
<ul>
	<li>${message.msNo}</li>
	<li>${message.mNo}</li>
	<li>${message.msTitle}</li>
	<li>${message.msContent}</li>
	<li>${message.msDate}</li>
</ul>
</body>
</html>