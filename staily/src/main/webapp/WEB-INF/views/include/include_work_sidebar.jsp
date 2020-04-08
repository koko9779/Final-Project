<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<aside class="col-sm-3 col-sm-pull-1 sidebar">
	<div class="widget">
		<img src="${pageContext.request.contextPath}${w.wPoster}" alt="${w.wName}" />
		<h3 style="margin:50px auto;">${w.wName}</h3>
	</div>
	<div class="widget">
		총회차: ${tepisode} 회
	</div>	
	<div class="widget">
		<form>
			<input type="text" placeholder="Search..." class="search" />
			<i class="material-icons">search</i>
		</form>
	</div>
</aside>
