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
							<div class="search">
								<a href="#"> <i class="material-icons">search</i>
								</a>
							</div>
							<div class="tel">
								<a href="tel:03301234567"> <i class="material-icons">phone
										in talk</i> 0330 123 4567
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
						<li class="active"><a href="index.html">Home</a></li>
						<li><a href="whats-on.html">What's on</a></li>
						<li><a href="shortcodes.html">Shortcodes</a></li>
						<li class="dropdown"><a href="news.html">News</a>
							<ul class="dropdown-menu">
								<li><a href="news-single.html">News single</a></li>
							</ul></li>
						<li><a href="contact.html">Contact</a></li>
					</ul>
				</div>
			</div>
		</div>
</body>
</html>