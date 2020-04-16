<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/tags.jspf"%>
<%@ include
	file="/WEB-INF/views/admin/include/include_top_without_sidebar.jsp"%>
<style>
image {
	margin: auto;
}

.w-100 {
	width: 400px;
	height: 300px;
}
</style>
<form id="product_detail" name="product_detail" method="post">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<h3 class="text-center"></h3>
				<div id="slider-div">
					<div>
						<img
							src="https://image.tmdb.org/t/p/w600_and_h900_bestv2/"++"" height="300px" >
					</div>
				</div>
			</div>
		</div>
		<table class="table table-hover">
			<colgroup>
				<col class="col_wp25">
				<col class="col_auto">
			</colgroup>
			<tbody>
				<tr>
					<th scope="row" class="bg-light essentia"><label for="pName">
							작품이름</label></th>
					<td class="text-left">
						<div class="col">
							<input type="text" name="pName" id="pName" class="form-control"
								value="${work.wName}" maxlength="20">
						</div>
					</td>
				</tr>

				<tr>
					<th scope="row" class="bg-light essentia"><label for="pPrice">
							카테고리</label></th>
					<td class="text-left">
						<div class="col">
							<input type="text" name="pPrice" id="pPrice" class="form-control"
								value="${work.wCategory}" maxlength="20">
						</div>
					</td>
				</tr>
				<tr>
					<th scope="row" class="bg-light essentia"><label for="mName">
							상영일</label></th>
					<td class="text-left">
						<div class="col">
							<input type="text" name="pURL" id="pURL" class="form-control"
								value="${work.wDate}">
						</div>
					</td>
				</tr>
				<tr>
					<th scope="row" class="bg-light essentia"><label>
							총회차</label></th>
					<td class="text-left">
						<div class="col"></div>
					</td>
				</tr>
				<tr>
					<th scope="row" class="bg-light essentia"><label>
							설명</label></th>
					<td class="text-left">
						<div class="col">${work.wView}</div>
					</td>
				</tr>
			</tbody>
		</table>
		<div class="text-center">
			<button type="submit" value="submit"
				class="btn btn-default btn-lg io-data io-fn-nextStep" data-step="2">수정</button>
			<button type="button" 
				class="btn btn-default btn-lg io-data io-fn-nextStep" data-step="2" onclick="product_confirm(${productList[0].pNo})">승인</button>
		</div>
</form>

<%@ include file="/WEB-INF/views/admin/include/include_bottom.jsp"%>
</body>
</html>
