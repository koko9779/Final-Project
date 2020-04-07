<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/commons/tags.jspf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

function booklist(bmNo){
	var book_form = document.getElementById("f_"+bmNo);
	book_form.action = "bookmark_delete";
	book_form.submit();
};

function member_list(){
	document.getElementById("member_list").action = "bookmark_list";
	document.getElementById("member_list").submit();
}

function member_update(){
	alert("tt");
	document.member_up.action = "member_update";
	document.member_up.submit();
	
	//document.getElementById("member_u").action = "member_update";
	//document.getElementById("member_u").submit();
}



</script>
</head>
<body>
	<h1>MypageTest</h1>
	
	<!-- 회원정보 -> 북마크 리스트 -->
	<form id="member_list">
		<input type="hidden" name="mNo" value="${member.mNo}">
		<input type="button" value="북마크" onclick="member_list()">
	
	</form>
	
	<!-- 북마크 리스트 출력페이지 -->
	<h3>북마크 리스트 출력</h3>
	
	<c:forEach var="book" items="${bookmarkList}">
		<form id="f_${book.bmNo}" method="GET">
			bmNo<input type="text" name="bmNo" value="${book.bmNo}"><br>
			mNo<input type="text" name="mNo" value="${book.member.mNo}"><br>
			pNo<input type="text" name="pNo" value="${book.product.pNo}"><br>
			mId<input type="text" name="mId" value="${book.member.mId}"><br>
			pSence<input type="text" name="pSence" value="${book.product.pScene}"><br>
			<input type="button" value="delete" onClick="booklist(${book.bmNo})">
		</form>
	</c:forEach>
	
	<h3>회원정보출력</h3>
	<form id="member_u" name="member_up">
		mNo<input type="text" name="mNo" value="${member.mNo}"><br>
		mId<input type="text" name="mId" value="${member.mId}"><br>
		mPw<input type="text" name="mPw" value="${member.mPw}"><br>
		mName<input type="text" name="mName" value="${member.mName}"><br>
		mAddress<input type="text" name="mAddress" value="${member.mAddress}"><br>
		mDaddress<input type="text" name="mDaddress" value="${member.mDaddress}"><br>
		mEmail<input type="text" name="mEmail" value="${member.mEmail}"><br>
		mType<input type="text" name="mType" value="${member.mType}"><br>
		mPhone<input type="text" name="mPhone" value="${member.mPhone}"><br>
		<input type="button" value="멤버수정" onclick="member_update()">
	</form>
	
	
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
		
		
	<!-- 멤버 정보 출력 -->
	<h3>멤버 정보 출력</h3>
	<div>
		${member}
	</div>
	
	
	<div>
		${message.msNo}
		${message.mNo}
		${message.msTitle}
		${message.msContent}
		${message.msDate}
	</div>
	<!-- 내가 쓴글 목록 -->
	


	<!-- 
	<form name="f" method="get" action="test3">
		회원번호<input type="text" name="mNo"> 아이디 <input type="text"
			name="mId"> 비밀번호 <input type="text" name="mPw">
		사업자등록번호 <input type="text" name="coNo"> <input type="submit">

	</form>
 	-->

</body>
</html>