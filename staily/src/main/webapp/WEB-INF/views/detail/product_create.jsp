<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/tags.jspf" %>
<%@ include
	file="/WEB-INF/views/admin/include/include_top_without_sidebar.jsp"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/product_create.css"/>
<script src="${pageContext.request.contextPath}/css/admin/vendor/jquery/jquery.min.js"></script>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/gu-upload/css/guupload.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/gu-upload/css/guupload2.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/gu-upload/guuploadManager.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/gu-upload/guuploadManager2.js"></script>

<div class="left">
	<div class="wrap">
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
					<td class="text-left">
						<div class="col">
							${workOne.getwName()}
						</div>
					</td>
				</tr>
				<tr>
					<th scope="row" class="bg-light essentia"><label for="wCategory">
							카테고리</label></th>
					<td class="text-left">
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
					<td class="text-left">
						<div class="col">
							<fmt:parseDate value="${workOne.getwDate()}" var="dateFormat" pattern="yyyy-MM-dd"/>
							<fmt:formatDate value="${dateFormat}" pattern="yyyy-MM-dd(E)" type="both"/>
						</div>
					</td>
				</tr>
				<tr>
					<th scope="row" class="bg-light essentia"><label for="wTepisode">
							전체 회차</label></th>
					<td class="text-left">
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
	<form name="ff" method="post">
		<table class="table table=hover">
			<colgroup>
				<col class="col_wp25">
				<col class="col_auto">
			</colgroup>
			<tbody>
				<tr>
					<th scope="row" class="bg-light essentia"><label for="wdEpisode">
							상품이 나온 회차</label></th>
					<td class="text-left">
						<div class="col">
							<select id="wdEpisode">
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
					<td class="text-left">
						<div class="col">
							<input type="text" name="pName" id="pName" class="form-control"
								maxlength="20">
						</div>
					</td>
				</tr>
				<tr>
					<th scope="row" class="bg-light essentia"><label for="pPrice">
							가격</label></th>
					<td class="text-left">
						<div class="col">
							<input type="text" name="pPrice" id="pPrice" class="form-control"
								maxlength="20">
						</div>
					</td>
				</tr>
				<tr>
					<th scope="row" class="bg-light essentia"><label for="pUrl">
							쇼핑몰 URL</label></th>
					<td class="text-left">
						<div class="col">
							<input type="text" name="pUrl" id="pUrl" class="form-control"
								maxlength="20">
						</div>
					</td>
				</tr>
				
				
				<tr>
					<th scope="row" class="bg-light essentia"><label for="pAddress">
							주소</label></th>
					<td class="text-left">
						<div class="col">
							<input type="text" name="pAddress" id="pAddress"
								onclick="execDaumPostcode()" placeholder="이 곳을 클릭하세요" class="form-control" readonly>
						</div>
					</td>
				</tr>
				<tr>
					<th scope="row" class="bg-light essentia"><label for="pDaddress">
							상세 주소</label></th>
					<td class="text-left">
						<div class="col">
							<input type="text" name="pDaddress" id="pDaddress" class="form-control"
								maxlength="20">
						</div>
					</td>
				</tr>
				
				<tr>
					<th scope="row" class="bg-light essentia"><label for="pScene">
							상품이 나온 장면<br>(최대 1장)</label></th>
					<td class="text-left">
						<div class="col">
							<div id="uploadScene" style="width: 100%;"></div>
							<input type="hidden" id="realname" name="realname"/>
							<input type="hidden" id="filename" name="filename"/>
							<input type="hidden" id="filesize" name="filesize"/>									
						</div>
					</td>
				</tr>
				<!--  
				<tr>
					<th scope="row" class="bg-light essentia"><label for="pdImage">
							상품 이미지<br>(최대 10장)</label></th>
					<td class="text-left">
						<div class="col">
							<div id="uploadScene2" style="width: 100%;"></div>
							<input type="hidden" id="realname2" name="realname2"/>
							<input type="hidden" id="filename2" name="filename2"/>
							<input type="hidden" id="filesize2" name="filesize2"/>
						</div>
					</td>
				</tr>
				-->
				<tr>
				</tr>				
			</tbody>		
		</table>
		
		<button class="button_css" type="button" onClick="pdImageCreate()" >상품 이미지 등록</button>
		<div class="wrap">
			<button class="button_css" type="button" onClick="productCreate()">작성하기</button>
			<button class="button_css" type="reset">다시 쓰기</button>
		</div>
		
	</form>
	<!--  
	<form name="fff" method="post">
		<table class="table table=hover">
			<colgroup>
				<col class="col_wp25">
				<col class="col_auto">
			</colgroup>
			<tbody>
			
			</tbody>
		</table>
	</form>
	-->
</div>

</body>
<script src="${pageContext.request.contextPath}/js/custom_js/detail.js"></script>
</html>