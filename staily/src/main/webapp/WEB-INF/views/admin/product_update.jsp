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
<form id="product_detail">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<h3 class="text-center"></h3>
				<div id="slider-div">
					<div>
						<img
							src="${pageContext.request.contextPath}${productList[0].pScene }">
					</div>
					<c:forEach var="product" items="${productList }">
						<div>
							<img src="${pageContext.request.contextPath}${product.pdImage }">
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
		<input type="hidden" name="pNo" id="pNo" value=""> <input
			type="hidden" name="pdNo" id="pdNo" value="">
		<table class="table table-hover">
			<colgroup>
				<col class="col_wp25">
				<col class="col_auto">
			</colgroup>
			<tbody>
				<tr>
					<th scope="row" class="bg-light essentia"><label for="pName">
							상품이름</label></th>
					<td class="text-left">
						<div class="col">
							<input type="text" name="pName" id="pName" class="form-control"
								value="${productList[0].pName }" maxlength="20">
						</div>
					</td>
				</tr>

				<tr>
					<th scope="row" class="bg-light essentia"><label for="pPrice">
							상품가격</label></th>
					<td class="text-left">
						<div class="col">
							<input type="text" name="pPrice" id="pPrice" class="form-control"
								value="${productList[0].pPrice }" maxlength="20">
						</div>
					</td>
				</tr>
				<tr>
					<th scope="row" class="bg-light essentia"><label for="mName">
							상품URL</label></th>
					<td class="text-left">
						<div class="col">
							<input type="text" name="pURL" id="pURL" class="form-control"
								value="${productList[0].pUrl }">
						</div>
					</td>
				</tr>
				<tr>
					<th scope="row" class="bg-light essentia"><label
						for="mAddress">오프라인주소</label></th>
					<td class="text-left">
						<div class="col">
							<input type="text" name="pAddress" id="pAddress"
								onclick="execDaumPostcode()" value="${productList[0].pAddress }" class="form-control">
						</div>
					</td>
				</tr>
				<tr>
					<th scope="row" class="bg-light essentia"><label
						for="daddress">상세주소</label></th>
					<td class="text-left">
						<div class="col">
							<input type="text" name="pDaddress" id="pDaddress"
								class="form-control" value="${productList[0].pDaddress }">
						</div>
					</td>
				</tr>
				<tr>
					<th scope="row" class="bg-light essentia"><label>
							상품조회수</label></th>
					<td class="text-left">
						<div class="col">${productList[0].pView }</div>
					</td>
				</tr>
				<tr>
					<th scope="row" class="bg-light essentia"><label> 대충
							파일업로드할자리?</label></th>
					<td class="text-left"></td>
				</tr>
			</tbody>
		</table>
		<div class="text-center">
			<button type="submit" value="submit"
				class="btn btn-default btn-lg io-data io-fn-nextStep" data-step="2">수정</button>
		</div>
</form>
<%@ include file="/WEB-INF/views/admin/include/include_bottom.jsp"%>
</body>
</html>
