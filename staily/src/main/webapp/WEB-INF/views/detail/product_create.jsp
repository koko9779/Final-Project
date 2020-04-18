<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/tags.jspf" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/product_create.css"/>
<script src="${pageContext.request.contextPath}/css/admin/vendor/jquery/jquery.min.js"></script>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/gu-upload/css/guupload.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/gu-upload/css/guupload2.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/gu-upload/guuploadManager.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/gu-upload/guuploadManager2.js"></script>
<%@ include file="/WEB-INF/views/include/include_navbar.jsp"%>

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
<div style="margin:5%;">
	<div class="left">
		<div class="wrap" style="height: auto;">
			<input type="button" class="button_css2" value="작품 검색" onClick="work_search()">
		</div>
		<form name="f" method="post">
			<table class="table table=hover">
				<colgroup>
					<col class="col_wp25">
					<col class="col_auto">
				</colgroup>
				<tbody>
					<tr>
						<th scope="row" class="bg-light essentia"><label for="wName">
								작품명</label></th>
						<td class="text-left" style="text-align: left;">
							<div class="col">
								${workOne.getwName()}
							</div>
						</td>
					</tr>
					<tr>
						<th scope="row" class="bg-light essentia"><label for="wCategory">
								카테고리</label></th>
						<td class="text-left" style="text-align: left;">
							<div class="col">
								<c:choose>
									<c:when test="${workOne.getwCategory() eq 'D'}">
										드라마
									</c:when>
									<c:otherwise>
										영화
									</c:otherwise>
								</c:choose>						
							</div>
						</td>
					</tr>
					<tr>
						<th scope="row" class="bg-light essentia"><label for="wDate">
								처음 방영(개봉)일</label></th>
						<td class="text-left" style="text-align: left;">
							<div class="col">
								<fmt:parseDate value="${workOne.getwDate()}" var="dateFormat" pattern="yyyy-MM-dd"/>
								<fmt:formatDate value="${dateFormat}" pattern="yyyy-MM-dd(E)" type="both"/>
							</div>
						</td>
					</tr>
					<tr>
						<th scope="row" class="bg-light essentia"><label for="wTepisode">
								전체 회차</label></th>
						<td class="text-left" style="text-align: left;">
							<div class="col">
								${workOne.getwTepisode()}부작
							</div>
						</td>
					</tr>
					<tr>
						<th colspan="2" class="bg-light essentia" style="text-align: center;"><label for="wPoster">
								작품 포스터</label></th>
					</tr>
					<tr>
						<th colspan="2" style="text-align: center;">
						<img src="${pageContext.request.contextPath}${workOne.getwPoster()}" width='280px' height='400px'></th>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
	
	<div class="right">
		<form name="createP" method="post">
			<input type="hidden" id="wNo" name="wNo" value="${workOne.wNo}">
			<table class="table table=hover">
				<colgroup>
					<col class="col_wp25">
					<col class="col_auto">
				</colgroup>
				<tbody>
					<tr>
						<th scope="row" class="bg-light essentia"><label for="wdEpisode">
								상품이 나온 회차</label></th>
						<td class="text-left" style="text-align: left;">
							<div class="col">
								<select id="wdEpisode" name="wdEpisode">
									<c:forEach var="i" begin="1" end="${workOne.wTepisode}">
										<option value="${i}">${i}화</option>
									</c:forEach>
								</select>
							</div>
						</td>
					</tr>
					<tr>
						<th scope="row" class="bg-light essentia"><label for="pName">
								상품명</label></th>
						<td class="text-left" style="text-align: left;">
							<div class="col">
								<input type="text" name="pName" id="pName" class="form-control"
									maxlength="20">
							</div>
						</td>
					</tr>
					<tr>
						<th scope="row" class="bg-light essentia"><label for="pPrice">
								가격</label></th>
						<td class="text-left" style="text-align: left;">
							<div class="col">
								<input type="text" name="pPrice" id="pPrice" class="form-control"
									maxlength="20">
							</div>
						</td>
					</tr>
					<tr>
						<th scope="row" class="bg-light essentia"><label for="pUrl">
								쇼핑몰 URL</label></th>
						<td class="text-left" style="text-align: left;">
							<div class="col">
								<input type="text" name="pUrl" id="pUrl" class="form-control"
									maxlength="20">
							</div>
						</td>
					</tr>
					
					
					<tr>
						<th scope="row" class="bg-light essentia"><label for="pAddress">
								주소</label></th>
						<td class="text-left" style="text-align: left;">
							<div class="col">
								<input type="text" name="pAddress" id="pAddress"
									onclick="execDaumPostcode()" placeholder="이 곳을 클릭하세요" class="form-control" readonly>
							</div>
						</td>
					</tr>
					<tr>
						<th scope="row" class="bg-light essentia"><label for="pDaddress">
								상세 주소</label></th>
						<td class="text-left" style="text-align: left;">
							<div class="col">
								<input type="text" name="pDaddress" id="pDaddress" class="form-control"
									maxlength="20">
							</div>
						</td>
					</tr>
					
					<tr>
						<th scope="row" class="bg-light essentia"><label for="pScene">
								상품이 나온 장면<br>(최대 1장)</label></th>
						<td class="text-left" style="text-align: left;">
							<div class="col">
								<div id="uploadScene" style="width: 100%;"></div>
								<input type="hidden" id="realname" name="realname"/>
								<input type="hidden" id="filename" name="filename"/>
								<input type="hidden" id="filesize" name="filesize"/>									
							</div>
						</td>
					</tr>
					<tr>
					</tr>				
				</tbody>		
			</table>
			<c:forEach var="i" begin="1" end="${cnt}" varStatus="status">
				<c:set var="a" value="Image${i}"/>
				<input type="hidden" id="filesize2${i}" name="filesize2" value="${requestScope[a]}"/>
			</c:forEach>
			<div class="wrap" style="height:auto;">
				<button class="button_css" type="button" onClick="productCreate()">작성하기</button>
				<button class="button_css" type="reset">다시 쓰기</button>
			</div>
			
		</form>
	</div>
</div>
</body>
<script src="${pageContext.request.contextPath}/js/custom_js/detail.js"></script>
</html>