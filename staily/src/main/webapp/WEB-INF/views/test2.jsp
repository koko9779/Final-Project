<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
	<form name="f" method="get" action="test3">
		회원번호<input type="text" name ="mNo">
		아이디 <input type="text" name="mId">
		비밀번호 <input type="text" name="mPw">
		사업자등록번호 <input type="text" name="coNo">
		<input type="submit">
		
	</form>
</body>
</html>