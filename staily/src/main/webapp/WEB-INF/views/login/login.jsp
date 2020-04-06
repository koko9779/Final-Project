<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id="guest_login_form" method="get" action="vfbfcv">
		<fieldset>
			<legend>로그인</legend>
			<p>
				<label for="user_id">아이디:</label> 
				<input type="text" placeholder="아이디" id="user_id" name="user_id" />
				<label id='user_id-error' class='error' for='user_id'>"+msg+"</label>
			</p> 
			<p>  
				<label for="user_pass">패쓰워드:</label> 
				<input type="text" placeholder="패쓰워드" name="user_pw" id="user_pw" />
				<label id='user_pw-error' class='error' for='user_pw'>"+msg+"</label>
			</p>
			<p>
				<input type="submit" name="write" value="로그인" id="write" /> 
				<input type="reset" name="cancle" value="취소" id="cancle" />
			</p>
			<div id="msg"></div>
		</fieldset>
	</form>
</body>
</html>