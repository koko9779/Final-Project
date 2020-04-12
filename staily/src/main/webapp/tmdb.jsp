<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/themoviedb.js">
	
</script>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="${pageContext.request.contextPath}/css/admin/vendor/jquery/jquery.min.js"></script>
<script
	src="${pageContext.request.contextPath}/css/admin/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<body>
	<div id="app">
		<div class="container" data-reactid=".0">
			<h1 class="text-success" data-reactid=".0.0">
				<span data-reactid=".0.0.0">Most popular movies </span><small
					class="text-info" data-reactid=".0.0.1">Look through the
					most popular movies</small>
			</h1>
			<div class="form-group" data-reactid=".0.1">
				<label class="control-label" data-reactid=".0.1.$label"><span
					data-reactid=".0.1.$label.1">Movie search</span></label><input type="text"
					value="" placeholder="Enter your search term here"
					label="Movie search" class="form-control"
					data-reactid=".0.1.1:$input">
			</div>
			<div class="PopularMovies" data-reactid=".0.2">
				<div class="list-group" data-reactid=".0.2.0">
					<a href="#/movies/419704" class="list-group-item"
						data-reactid=".0.2.0.$419704/=1$419704">Ad Astra</a><a
						href="#/movies/38700" class="list-group-item"
						data-reactid=".0.2.0.$38700/=1$38700">Bad Boys for Life</a><a
						href="#/movies/454626" class="list-group-item"
						data-reactid=".0.2.0.$454626/=1$454626">Sonic the Hedgehog</a><a
						href="#/movies/446893" class="list-group-item"
						data-reactid=".0.2.0.$446893/=1$446893">Trolls World Tour</a><a
						href="#/movies/181812" class="list-group-item"
						data-reactid=".0.2.0.$181812/=1$181812">Star Wars: The Rise of
						Skywalker</a><a href="#/movies/338762" class="list-group-item"
						data-reactid=".0.2.0.$338762/=1$338762">Bloodshot</a><a
						href="#/movies/495764" class="list-group-item"
						data-reactid=".0.2.0.$495764/=1$495764">Birds of Prey (and the
						Fantabulous Emancipation of One Harley Quinn)</a><a
						href="#/movies/522627" class="list-group-item"
						data-reactid=".0.2.0.$522627/=1$522627">The Gentlemen</a><a
						href="#/movies/772" class="list-group-item"
						data-reactid=".0.2.0.$772/=1$772">Home Alone 2: Lost in New
						York</a><a href="#/movies/19543" class="list-group-item"
						data-reactid=".0.2.0.$19543/=1$19543">Anacondas: Trail of
						Blood</a><a href="#/movies/16119" class="list-group-item"
						data-reactid=".0.2.0.$16119/=1$16119">Cinderella III: A Twist
						in Time</a><a href="#/movies/475303" class="list-group-item"
						data-reactid=".0.2.0.$475303/=1$475303">A Rainy Day in New
						York</a><a href="#/movies/619264" class="list-group-item"
						data-reactid=".0.2.0.$619264/=1$619264">The Platform</a><a
						href="#/movies/508439" class="list-group-item"
						data-reactid=".0.2.0.$508439/=1$508439">Onward</a><a
						href="#/movies/570670" class="list-group-item"
						data-reactid=".0.2.0.$570670/=1$570670">The Invisible Man</a><a
						href="#/movies/512200" class="list-group-item"
						data-reactid=".0.2.0.$512200/=1$512200">Jumanji: The Next
						Level</a><a href="#/movies/614375" class="list-group-item"
						data-reactid=".0.2.0.$614375/=1$614375">F#*@BOIS</a><a
						href="#/movies/475557" class="list-group-item"
						data-reactid=".0.2.0.$475557/=1$475557">Joker</a><a
						href="#/movies/920" class="list-group-item"
						data-reactid=".0.2.0.$920/=1$920">Cars</a><a
						href="#/movies/496243" class="list-group-item"
						data-reactid=".0.2.0.$496243/=1$496243">Parasite</a>
				</div>
				<noscript data-reactid=".0.2.1"></noscript>
			</div>
		</div>
	</div>

	<div id="lightboxOverlay" class="lightboxOverlay"
		style="display: none;"></div>
	<div id="lightbox" class="lightbox" style="display: none;">
		<div class="lb-outerContainer">
			<div class="lb-container">
				<img class="lb-image"
					src="data:image/gif;base64,R0lGODlhAQABAIAAAP///wAAACH5BAEAAAAALAAAAAABAAEAAAICRAEAOw==">
				<div class="lb-nav">
					<a class="lb-prev" href=""></a><a class="lb-next" href=""></a>
				</div>
				<div class="lb-loader">
					<a class="lb-cancel"></a>
				</div>
			</div>
		</div>
		<div class="lb-dataContainer">
			<div class="lb-data">
				<div class="lb-details">
					<span class="lb-caption"></span><span class="lb-number"></span>
				</div>
				<div class="lb-closeContainer">
					<a class="lb-close"></a>
				</div>
			</div>
		</div>
	</div>

	<div id="fatkun-drop-panel">
		<a id="fatkun-drop-panel-close-btn">×</a>
		<div id="fatkun-drop-panel-inner">
			<div class="fatkun-content">
				<svg class="fatkun-icon" viewBox="0 0 1024 1024" version="1.1"
					xmlns="http://www.w3.org/2000/svg" p-id="5892">
					<path
						d="M494.933333 782.933333c2.133333 2.133333 4.266667 4.266667 8.533334 6.4h8.533333c6.4 0 10.666667-2.133333 14.933333-6.4l2.133334-2.133333 275.2-275.2c8.533333-8.533333 8.533333-21.333333 0-29.866667-8.533333-8.533333-21.333333-8.533333-29.866667 0L533.333333 716.8V128c0-12.8-8.533333-21.333333-21.333333-21.333333s-21.333333 8.533333-21.333333 21.333333v588.8L249.6 475.733333c-8.533333-8.533333-21.333333-8.533333-29.866667 0-8.533333 8.533333-8.533333 21.333333 0 29.866667l275.2 277.333333zM853.333333 874.666667H172.8c-12.8 0-21.333333 8.533333-21.333333 21.333333s8.533333 21.333333 21.333333 21.333333H853.333333c12.8 0 21.333333-8.533333 21.333334-21.333333s-10.666667-21.333333-21.333334-21.333333z"
						p-id="5893"></path></svg>
				<div class="fatkun-title">Drag and Drop</div>
				<div class="fatkun-desc">The image will be downloaded</div>
			</div>
		</div>
	</div>
</body>
</body>

</html>