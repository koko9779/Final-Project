<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/commons/tags.jspf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function memberUpdate(){
		ㅇ
	}
</script>
</head>
<body>
<h1>MypageTest</h1>
	<ul>
		<li>${member}<li>
	</ul>
	
	
	
	<form name="r" method="get">
		m_no <input type="text" name="mNo" maxlength="50"/><br>
		m_no <input type="text" name="m_no" maxlength="50"/><br>
		r_content <input type="text" name="r_content" maxlength="50"/><br>
		r_recommend <input type="text" name="r_recommend" maxlength="50"/><br>
		r_report <input type="text" name="r_report" maxlength="50"/><br>
		<input type="button" value="수정" onClick="memberUpdate()">
	</form>
	 
</body>
</html>