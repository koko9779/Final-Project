<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="wrapper">

		<!-- Navigation -->
		<div class="navbar" role="navigation">
			<!-- Heading -->
			<div class="heading">
				<div class="container">
					<div class="row">
						<div class="col-sm-12">
							<div class="tel">
								<a href="/staily/admin"> <i class="material-icons"></i> 관리자페이지
								</a>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="container">
				<div class="navbar-header">
					<a href="index.jsp" class="logo" title="Craft beer landing page">
						<img src="${pageContext.request.contextPath}/images/staily-logo.png" alt="Craft Beer HTML Template">
					</a>
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-collapse">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar top-bar"></span> <span
							class="icon-bar middle-bar"></span> <span
							class="icon-bar bottom-bar"></span>
					</button>
				</div>
				<div class="navbar-collapse collapse">
					<ul id="menu-primary" class="nav navbar-nav">
						<li class="active"><a href="/staily">메인페이지</a></li>
						<li><a href=#>상품목록</a></li>
						<li><a href="/staily/detail/detail_main">상품상세</a></li>
						<li class="dropdown"><a href="/staily/style/style_main">게시판</a>
							<ul class="dropdown-menu">
								<li><a href="/staily/style/style_main">스타일제안</a></li>
								<li><a href="/staily/style/style_main">질문답변</a></li>
								<li><a href="/staily/style/style_main">영주괴롭히기</a></li>
								<li><a href="/staily/style/style_main">영주괴롭히기</a></li>
							</ul></li>
						<li><a href="/staily/mypage/member_select">마이페이지</a></li>
					</ul>
				</div>
			</div>
		</div>
</body>
</html>