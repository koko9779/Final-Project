<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include
	file="/WEB-INF/views/include/detail/include_css_product_detail.jsp"%>
<%@ include file="/WEB-INF/views/include/tags.jspf"%>
<%@ include file="/WEB-INF/views/include/include_navbar.jsp"%>



<!-- Hero -->
<div id="content_hero"
	style="background-image: url(http://via.placeholder.com/1440x435)">
	<a href="#afterHeader" class="anchor"> <img
		src="${pageContext.request.contextPath}/images/scroll-arrow.svg"
		alt="Scroll down" class="scroll" />
	</a>
	
	<iframe class="ww"
			src="https://www.youtube-nocookie.com/embed/isls26FGUaA?autoplay=1&amp;loop=1;&playlist=isls26FGUaA&controls=0&vq=hd1080"
			frameborder="0"	allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
			allowfullscreen style="position: absolute;left: -0%;width: 100%;height: 100%;top: 0%;"></iframe>

	<!-- Content -->
	<div class="container">
		<div class="row blurb scrollme animateme" data-when="exit"
			data-from="0" data-to="1" data-opacity="0" data-translatey="100">
			<div class="col-md-9">
				<span class="title"></span>
				<h1></h1>
			</div>
		</div>
	</div>
</div>

<!-- Section -->
<div class="container section news" id="afterHeader">
	<div class="row">
		<%@ include file="/WEB-INF/views/include/include_work_sidebar.jsp"%>
		<div class="col-sm-9 col-sm-push-1">
			<h2 style="margin-bottom: 0;">이 상품이 나온 장면</h2>
			<img
				src="${pageContext.request.contextPath}/images/product/scene/${productOne.get(0).getpScene()}.jpg"
				height="450px" width="850px" style="padding: 20px;">

			<!-- Section -->
			<h2>상품 사진</h2>
			<div class="slick-carousel news-carousel">
				<c:forEach var="product" items="${productOne}">
					<div>
						<img src="${pageContext.request.contextPath}${product.pdImage}">
					</div>
				</c:forEach>
			</div>

			<!-- Section -->
			<div class="row">
				<div class="tabs">
					<ul>
						<li><a href="#one">상품 정보</a></li>
						<c:if test="${not empty productOne.get(0).getpAddress()}">
							<li><a href="#two" id="maps">매장 지도</a></li>
						</c:if>
						<li><a href="#three" id="reply">댓글</a></li>
					</ul>
					<div id="one">
					<table class="table table=hover">
						<colgroup>
							<col class="col_wp25">
							<col class="col_auto">
						</colgroup>
						<tbody>
							<tr>
								<th scope="row" class="bg-light essentia"><label for="mId">작성자</label></th>
								<td class="text-left" style="text-align: left;">
									<div class="col">${productOne.get(0).getmId()}</div>
								</td>
							</tr>
							<tr>
								<th scope="row" class="bg-light essentia"><label for="pName">상품명</label></th>
								<td class="text-left" style="text-align: left;">
									<div class="col">${productOne.get(0).getpName()}</div>
								</td>
							</tr>
							<tr>
								<th scope="row" class="bg-light essentia"><label for="pPrice">가격</label></th>
								<td class="text-left" style="text-align: left;">
									<div class="col">${productOne.get(0).getpPrice()}</div>
								</td>
							</tr>
							<tr>
								<th scope="row" class="bg-light essentia"><label for="pUrl">쇼핑몰 URL</label></th>
								<td class="text-left" style="text-align: left;">
									<div class="col"><a href='${productOne.get(0).getpUrl()}' target="_blank">${productOne.get(0).getpUrl()}</a></div>
								</td>
							</tr>
							<c:if test="${not empty productOne.get(0).getpAddress()}">
								<tr>
									<th scope="row" class="bg-light essentia"><label for="pAddress">오프라인 주소</label></th>
									<td class="text-left" style="text-align: left;">
										<div class="col">${productOne.get(0).getpAddress()} ${productOne.get(0).getpDaddress()}</div>
									</td>
								</tr>
							</c:if>
						</tbody>
					</table>
					</div>
					<c:if test="${not empty productOne.get(0).getpAddress()}">
						<div id="two">
							<div id="map" style="width: 100%; height: 600px">
							
							</div>
						</div>
					</c:if>
					<div id="three">
						<div class="comments">
							<div class="col-sm-12">
								<form name="rpl">
									<c:choose>
										<c:when test="${not empty userNo}">
											<div class="form-group">
												<label>댓글 입력</label>
												<textarea rows="2" name="rContent" id="rContent"></textarea>
											</div>
											<div class="form-group right-align">
												<button type="button" class="btn btn-ghost" id="createreply">작성하기</button>
											</div>
										</c:when>
										<c:otherwise>
										</c:otherwise>
									</c:choose>
									<input type="hidden" name="mNo" id="mNo" value="${userNo}">
									<input type="hidden" name="pNoo" id="pNoo" value="${productOne.get(0).getpNo()}">
									<input type="hidden" name="wNo" id="wNo" value="${wNo}">
								</form>
								<div id="reply_space"></div>
							</div>
						</div>
					</div>
				</div>

				<form name="pNo_request" method="POST">
					<input type="hidden" id="pNo" name="pNo"
						value="${productOne.get(0).getpNo()}">
				</form>
			</div>
		</div>
	</div>
</div>
<%@ include
	file="/WEB-INF/views/detail/include/include_product_detail_js.jsp"%>
<%@ include file="/WEB-INF/views/include/include_footer.jsp"%>
<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=01fy3qpy1m&submodules=geocoder"></script>
<style>
.iw_inner {
	padding:10px
}

.iw_inner h3 {
	font-size: 18px; 
	padding-bottom: 7px
}
</style>
<script>

var mapOptions = {
	center : new naver.maps.LatLng(37.3595704, 127.105399),
	zoomControl : true,
	zoomControlOptions : {
		style : naver.maps.ZoomControlStyle.SMALL,
		position : naver.maps.Position.TOP_RIGHT
	},
	tileSpare : 2,
	disableDoubleClickZoom : true
}
//var address1 = "${productOne.get(0).getpAddress()} ${productOne.get(0).getpDaddress()}";
var mapdiv = document.getElementById('map');
var map = new naver.maps.Map(mapdiv, mapOptions);

var markerOptions = {
	position : new naver.maps.LatLng(37.3595704, 127.105399),
	map : map
}

var marker = new naver.maps.Marker(markerOptions);

var address1 = "${productOne.get(0).getpAddress()}";
/*
$("#maps").on("click", function(e) {
	get_pointer(address1, 'map');
});

function get_pointer(adress, getid) {
    naver.maps.Service.geocode({
        address: adress
    }, function(status, response) {
        if (status !== naver.maps.Service.Status.OK) {
            //return alert('Something wrong!');
            console.log('주소에러');
        }

        var result = response.result, // 검색 결과의 컨테이너
            items = result.items; // 검색 결과의 배열

        // do Something
        var x = eval(items[0].point.x);
        var y = eval(items[0].point.y);

        var HOME_PATH = window.HOME_PATH || '.';

        var cityhall = new naver.maps.LatLng(y, x),
            map = new naver.maps.Map('map', {
                center: cityhall.destinationPoint(0, 500),
                zoom: 10
            }),
            marker = new naver.maps.Marker({
                map: map,
                position: cityhall
            });

        var contentString = [
            '<div class="iw_inner">',
            '   <p>'+adress+'</p>',
            '</div>'
        ].join('');

        var infowindow = new naver.maps.InfoWindow({
            content: contentString
        });

        naver.maps.Event.addListener(marker, "click", function(e) {
            if (infowindow.getMap()) {
                infowindow.close();
            } else {
                infowindow.open(map, marker);
            }
        });

        infowindow.open(map, marker);
    });
}
*/



</script>
</body>
</html>