<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/commons/tags.jspf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function updateBoard(bNo) {
		document.f1.action="style_update?bNo="+bNo;
		document.f1.method="POST";
		document.f1.submit();
	}
</script>
</head>
<body>
	<h1>스타일코디 상세보기</h1>
		<c:forEach var="b" items="${boardOneList}" varStatus="status">
			<div>
				<form name="f${status.count}">
					<c:out value="${b.bNo}"/>
					<c:out value="${b.mNo}"/>
					<c:out value="${b.bTitle}"/>
					<c:out value="${b.bContent}"/>
					<c:out value="${b.bView}"/>
					<c:out value="${b.bRecommend}"/>
					<c:out value="${b.bDate}"/>
					<c:out value="${b.mId}"/>
					<c:if test="${b.bStep == 1}">
						<input type="button" value="수정" onclick="updateBoard(${b.bNo});"/>
					</c:if>
				</form>
			</div>
		</c:forEach>
</body>
</html>