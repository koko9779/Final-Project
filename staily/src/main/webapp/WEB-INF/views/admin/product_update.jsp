<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/tags.jspf"%>
<%@ include
	file="/WEB-INF/views/admin/include/include_top_without_sidebar.jsp"%>
<style>
.text-left {
	text-align: left;
}
</style>
<div class="modal fade" id="guUpload" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true" style="width: auto">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title" id="myModalLabel">작품 상세</h4>
			</div>
			<div class="modal-body" id="body"></div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary"
					onClick="modal_click()">선택</button>
				<button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
			</div>
		</div>
	</div>
</div>
<form id="product_detail" name="product_detail" method="post">
	<div class="container-fluid">
		<!--  
		<div class="row">
			<div class="col-md-12">
				<div id="slider-div">
					<div>
						<img width="400" height="250"
							src="${pageContext.request.contextPath}${productList[0].pScene }">
					</div>
					<c:forEach var="product" items="${productList }">
						<div>
							<img width="400" height="250"
								src="${pageContext.request.contextPath}${product.pdImage }">
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
		-->
		<input type="hidden" name="pNo" id="pNo" value="${productList[0].pNo}">
		<input type="hidden" name="mNo" id="mNo" value="${productList[0].mNo}">
		<input type="hidden" name="wNo" id="wNo" value="${productList[0].wNo}">
		<input type="hidden" name="pView" id="pView"
			value="${productList[0].pView}"> <input type="hidden"
			name="pScene" id="pScene" value="${productList[0].pScene}"> <input
			type="hidden" name="pDate" id="pDate" value="${productList[0].pDate}">
		<input type="hidden" name="pCheck" id="pCheck"
			value="${productList[0].pCheck}">
		<c:forEach var="product" items="${productList }">
			<input type="hidden" name="pdNo" id="pdNo" value="${product.pdNo }">
		</c:forEach>
		<table class="table table-hover">
			<colgroup>
				<col class="col_wp25">
				<col class="col_auto">
			</colgroup>
			<tbody>
				<tr>
					<th scope="row" class="bg-light essentia" colspan="2"><label
						for="pName"> 상품이름</label></th>
					<td class="text-left" colspan="2">
						<div class="col">
							<input type="text" name="pName" id="pName" class="form-control"
								value="${productList[0].pName }" maxlength="20">
						</div>
					</td>
				</tr>
				<tr>
					<th scope="row" class="bg-light essentia" colspan="2"><label
						for="pPrice"> 상품가격</label></th>
					<td class="text-left" colspan="2">
						<div class="col">
							<input type="text" name="pPrice" id="pPrice" class="form-control"
								value="${productList[0].pPrice }" maxlength="20">
						</div>
					</td>
				</tr>
				<tr>
					<th scope="row" class="bg-light essentia" colspan="2"><label
						for="pUrl"> 상품URL</label></th>
					<td class="text-left">
						<div class="col" colspan="2">
							<input type="text" name="pURL" id="pURL" class="form-control"
								value="${productList[0].pUrl }">
						</div>
					</td>
				</tr>
				<tr>
					<th scope="row" class="bg-light essentia" colspan="2"><label
						for="mAddress">오프라인주소</label></th>
					<td class="text-left" colspan="2">
						<div class="col">
							<input type="text" name="pAddress" id="pAddress"
								onclick="execDaumPostcode()" value="${productList[0].pAddress }"
								readonly="readonly" class="form-control">
						</div>
					</td>
				</tr>
				<tr>
					<th scope="row" class="bg-light essentia" colspan="2"><label
						for="daddress">상세주소</label></th>
					<td class="text-left" colspan="2">
						<div class="col">
							<input type="text" name="pDaddress" id="pDaddress"
								class="form-control" value="${productList[0].pDaddress }">
						</div>
					</td>
				</tr>
				<tr>
					<th scope="row" class="bg-light essentia" colspan="2"><label>
							상품조회수</label></th>
					<td class="text-left" colspan="2" align="left">
						<div class="col">${productList[0].pView }</div>
					</td>
				</tr>
				<tr>
					<th scope="row" class="bg-light essentia" colspan="2"><label
						for="pCheck">장면이미지변경</label></th>
					<td class="text-left"><img width="auto" height="auto"
						src="${pageContext.request.contextPath}/images/product/scene/${productList[0].pScene }.jpg"
						alt="${productList[0].pScene }"> <input type="hidden"
						value="${productList[0].pScene }"></td>
					<td class="text-left"><button type="button" name="modalBtn"
							class="modalBtn" onclick="sceneUpdate(${productList[0].pScene })">수정하기</button></td>
				</tr>
				<c:forEach var="product" items="${productList }">
					<tr>
						<th scope="row" class="bg-light essentia" colspan="2"><label
							for="pCheck">상품이미지변경</label></th>
						<td class="text-left">
							<div class="col" align="center">
								<img width="auto" height="auto"
									src="${pageContext.request.contextPath}/images/product/image/${product.pdImage}.jpg">
							</div>
						</td>
						<td class="text-left"><button type="button" name="modalBtn"
								class="modalBtn" onclick="imageUpdate(${product.pdImage})">수정하기</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="text-center">
			<button type="button"
				class="btn btn-default btn-lg io-data io-fn-nextStep" data-step="2"
				id="pUpdate">수정</button>
			<button type="button"
				class="btn btn-default btn-lg io-data io-fn-nextStep" data-step="2"
				onclick="product_confirm(${productList[0].pNo})">승인</button>
		</div>
</form>
<%@ include file="/WEB-INF/views/admin/include/include_bottom.jsp"%>
</body>
<script>
function sceneUpdate(img) {
	var scene= img;
	window.open("product_update_scene?" + "pScene="+ scene,"이미지정보수정",
	"width=500, height=300, toolbar=no, menubar=no, scrollbars=no, resizable=no ,status=no")
};
function imageUpdate(img) {
	var image= img;
	alert(img);
	window.open("product_update_img?" + "pdImage="+ image,"이미지정보수정",
	"width=500, height=300, toolbar=no, menubar=no, scrollbars=no, resizable=no ,status=no")
};

</script>
</html>
