<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/css/admin/vendor/jquery/jquery.min.js"></script>
<script type="text/javascript">

	$(function() {
		$("#userId").keyup(function(e) {
			 $.ajax({
			        url: "signup_Id_check",
			       	data: {mId:e.target.value},
			       	type: "POST",
			        success: function(result){
				          if(result === 1){
				        	$("#testId").text("중복된 아이디가 있습니다");
				          }else {
				        	  $("#testId").text("");
						  }
			        }
			  });
		});
	});


</script>

</head>
<body>
	<h1>회원가입</h1>
	<form action="final_project/login/signup">
	타입<input type="hidden" value="M" name="mType"/><br>
	아이디<input type="text" id="userId" name="mId"/><br>
	패스워드<input type="text" name="mPw"/><br>
	이름<input type="text" name="mName"/><br>
	주소<input type="text" name="mAddress"/><br>
	상세주소<input type="text" name="mDaddress"/><br>
	이메일<input type="text" name="mEmail"/><br>
	폰번호<input type="text" name="mPhone"/><br>
	<!-- 
	기업번호<input type="text"/>
	 --> 
	<input type="submit" value="버튼">
	</form>
	<div id="testId">
		
	</div>
</body>
</html>