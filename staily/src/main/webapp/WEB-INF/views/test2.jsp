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
	<h1>MypageTest</h1>
	<!-- 북마크 리스트 출력페이지 -->
	<h3>북마크 리스트 출력</h3>
		<c:choose>
			<c:when test="${bookmarkList.size() != 0}">
				<c:forEach var="book" items="${bookmarkList}">
					<div>
						북마크번호 :${book.bmNo}
						회원번호 :${book.member.mNo}
						상품번호 :${book.product.pNo}
						상품장면 :${book.product.pScene}
						회원아이디 :${book.member.mId}
					</div>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<div>
					즐겨찾기 목록이 없습니다
				</div>
			</c:otherwise>
		</c:choose>
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