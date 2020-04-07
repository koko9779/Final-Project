<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/include_css.jsp" %>
<%@ include file="/WEB-INF/views/include/include_js.jsp" %>
<%@ include file="/WEB-INF/views/include/tags.jspf" %>
<html>
	<head>
	</head>
	<body>
		
		<!-- Wrapper -->
		<div class="wrapper">

			<!-- Hero -->
			<div id="content_hero" style="background-image: url(http://via.placeholder.com/1440x435)">
				
				<img src="${pageContext.request.contextPath}/images/scroll-arrow.svg" alt="Scroll down" class="scroll" />

				<!-- Content -->
				<div class="container">
					<div class="row blurb scrollme animateme" data-when="exit" data-from="0" data-to="1" data-opacity="0" data-translatey="100">
						<div class="col-md-9">
							<span class="title">The very latest</span>
							<h1>Cinema news</h1>
						</div>
					</div>
				</div>

			</div>

			<!-- Section -->
			<div class="container section news">
				<div class="row">
					<%@ include file="/WEB-INF/views/include/include_work_sidebar.jsp"%>
					<div class="col-sm-7 col-sm-push-1">
						<article>
							<img src="http://via.placeholder.com/750x350" class="news-single-img" alt="" />
							<span class="categories">New releases, What's hot</span>
							<h2 class="no-underline">15 Tips To Increase Your Adwords Profits</h2>

						</article>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>