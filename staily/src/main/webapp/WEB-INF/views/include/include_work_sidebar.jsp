<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<aside class="col-sm-3 col-sm-pull-2 sidebar">
	<div class="widget">
		<img src="${pageContext.request.contextPath}${w.wPoster}" alt="${w.wName}" />
		<h3 style="margin:50px auto;">${w.wName}</h3>
	</div>
	<div class="widget">
		<c:forEach var="episode" items="${tepisode}" begin="1" end="${tepisode}" step="1" varStatus="status">
			<p>총회차: ${status.current}회</p>
		</c:forEach>
	</div>	
	<div class="widget">
		<form>
			<input type="text" placeholder="Search..." class="search" />
			<i class="material-icons">search</i>
		</form>
	</div>
</aside>
