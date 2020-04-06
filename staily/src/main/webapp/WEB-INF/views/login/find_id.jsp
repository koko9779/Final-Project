<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function findId() {
		window.open("", "PopupWin", "width=500,height=600");
		/*
		document.f.action = "find_id_show";
		document.f.method = "POST";
		document.f.submit();
		*/
	}
</script>
</head>
<body>
	<h1>아이디 찾기 화면</h1>
	<form name="f">
	이름: <input type="text" ><br>
	핸드폰번호: <input type="text"/><br>
	<input type="button" value="버튼" onclick="findId();"/>
	</form>
</body>
</html>