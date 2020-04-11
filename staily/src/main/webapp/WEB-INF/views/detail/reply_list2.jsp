<%@ include file="/WEB-INF/views/include/tags.jspf"%>
<c:forEach var="replyList" items="${replyList}">
	<c:out value="${replyList.getmName()}"></c:out><br>
	<c:out value="${replyList.getrContent()}"></c:out><br>
	<c:out value="${replyList.getrRecommend()}"></c:out><br>
	<c:out value="${replyList.getrReport()}"></c:out><br>
</c:forEach>
