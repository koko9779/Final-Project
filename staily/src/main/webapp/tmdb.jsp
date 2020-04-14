<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/tags.jspf"%>
<!DOCTYPE html>
<html>
<head>
	<title>Popular Movies MovieDB</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/tmdb/bower_components/bootstrap/dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/tmdb/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/tmdb/bower_components/lightbox2/dist/css/lightbox.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/tmdb/styles.css">
</head>
<body>
	<div id="app"></div>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/tmdb/bower_components/jquery/dist/jquery.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/tmdb/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/tmdb/bower_components/lightbox2/dist/js/lightbox.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/tmdb/build/bundle.js"></script>
</body>
</html>