<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Movie Star - Cinema HTML Template</title>
		<link rel="icon" type="image/png" href="images/favicon.png" />
		<link href="css/slick.css" rel="stylesheet">
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<link href="css/venobox.css" rel="stylesheet">
		<link href="css/style/board.css" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css?family=Roboto+Condensed:300,400,700" rel="stylesheet">
		<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
		<link href="css/style.css" rel="stylesheet">
		<!--[if IE 9]>
			<link href="css/ie9.css" rel="stylesheet">
		<![endif]-->
		<!--[if lt IE 9]>
			<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
			<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->
	</head>
	<body>
		
		<!-- Wrapper -->
		<div class="wrapper">

			<!-- Navigation -->
			<div class="navbar" role="navigation">
				<!-- Heading -->
				<div class="heading">
					<div class="container">
						<div class="row">
							<div class="col-sm-12">
								<div class="search">
									<a href="#">
										<i class="material-icons">search</i>
									</a>
								</div>
								<div class="tel">
									<a href="tel:0330 123 4567">
										<i class="material-icons">phone in talk</i> 0330  123 4567
									</a>
								</div>
							</div>
						</div>
					</div>
				</div>

				<div class="container">
					<div class="navbar-header">
						<a href="index.html" class="logo" title="Movie star landing page">
							<img src="images/logo.svg" alt="Movie star HTML Template">
						</a>
						<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
							<span class="sr-only">Toggle navigation</span>
							<span class="icon-bar top-bar"></span>
							<span class="icon-bar middle-bar"></span>
							<span class="icon-bar bottom-bar"></span>
						</button>
					</div>  
					<div class="navbar-collapse collapse">
						<ul id="menu-primary" class="nav navbar-nav">
							<li>
								<a href="index.html">Home</a>
							</li>
							<li>
								<a href="whats-on.html">What's on</a>
							</li>
							<li>
								<a href="shortcodes.html">Shortcodes</a>
							</li>
							<li class="dropdown active">
								<a href="news.html">News</a>
								<ul class="dropdown-menu">
									<li><a href="news-single.html">News single</a></li>
								</ul>
							</li>
							<li>
								<a href="contact.html">Contact</a>
							</li>
						</ul>
					</div>
				</div>
			</div>

			<!-- Hero -->
			<div id="content_hero" style="background-image: url(http://via.placeholder.com/1440x435)">
				
				<img src="images/scroll-arrow.svg" alt="Scroll down" class="scroll" />

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
					<div class="col-sm-7">
						<article style="border-bottom: none;">
						<h3 class="board-top">스타일 질문</h3>
							<div class="categories col-md-6 board-title">${boardOneList[0].bTitle}</div>
							<div class="col-md-6 text-left"><span class="font-small">${boardOneList[0].mId}.${boardOneList[0].bDate}.조회수: ${boardOneList[0].bView}</span></div>
							<p>Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum. Mirum est notare quam littera gothica, quam nunc putamus parum claram, anteposuerit litterarum formas humanitatis per seacula quarta decima et quinta decima. Eodem modo typi, qui nunc nobis videntur parum clari, fiant sollemnes in futurum.</p>
						</article>
						<article>
							<h3 class="board-top">스타일 답변</h3>
							<div></div>
							<div class="categories col-md-6 board-title">New releases, What's hot</div>
							<div class="col-md-6 text-left"><span class="font-small">글쓴이.작성날짜</span></div>
							<p>Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum. Mirum est notare quam littera gothica, quam nunc putamus parum claram, anteposuerit litterarum formas humanitatis per seacula quarta decima et quinta decima. Eodem modo typi, qui nunc nobis videntur parum clari, fiant sollemnes in futurum.</p>
							<a href="news-single.html" class="btn btn-ghost">
								<span>추천하기</span>
							</a>
						</article>
						<article>
							<div class="categories col-md-6 board-title">New releases, What's hot</div>
							<div class="col-md-6 text-left"><span class="font-small">글쓴이.작성날짜</span></div>
							<p>Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum. Mirum est notare quam littera gothica, quam nunc putamus parum claram, anteposuerit litterarum formas humanitatis per seacula quarta decima et quinta decima. Eodem modo typi, qui nunc nobis videntur parum clari, fiant sollemnes in futurum.</p>
							<a href="news-single.html" class="btn btn-ghost">
								<span>추천하기</span>
							</a>
						</article>
					</div>
					<aside class="col-sm-3 col-sm-push-1 sidebar">
						<div class="widget">
							<form>
								<input type="text" placeholder="Search..." class="search" />
								<i class="material-icons">search</i>
							</form>
						</div>
						<div class="widget">
							<h3>Categories</h3>
							<ul>
								<li><a href="#">Coming soon</a></li>
								<li><a href="#">New releases</a></li>
								<li><a href="#">What's hot</a></li>
								<li><a href="#">Events</a></li>
							</ul>
						</div>
						<div class="widget">
							<h3>Archives</h3>
							<ul>
								<li><a href="#">July 2017</a></li>
								<li><a href="#">June 2017</a></li>
								<li><a href="#">May 2017</a></li>
								<li><a href="#">April 2017</a></li>
							</ul>
						</div>
						<div class="widget">
							<h3>Tags</h3>
							<a href="#" class="tag">Thriller</a>
							<a href="#" class="tag">Kids</a>
							<a href="#" class="tag">Offers</a>
							<a href="#" class="tag">Movie nights</a>
							<a href="#" class="tag">Premiere</a>
							<a href="#" class="tag">Animation</a>
							<a href="#" class="tag">Comedy</a>
							<a href="#" class="tag">New</a>
							</ul>
						</div>
					</aside>
				</div>
			</div>

			<!-- Pagination -->
			<div class="section small-padding border-top">
				<div class="container">
					<div class="row">
						<div class="col-sm-12">
							<ul class="pagination">
								<li><a href="#">Prev</a></li>
								<li><a href="#">1</a></li>
								<li><a href="#" class="active">2</a></li>
								<li><span>&hellip;</span></li>
								<li><a href="#">7</a></li>
								<li><a href="#">8</a></li>
								<li><a href="#">Next</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
	<%@ include file="/WEB-INF/views/include/include_footer.jsp"%>
	</body>
</html>