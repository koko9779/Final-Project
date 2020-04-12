<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/tags.jspf" %>
<%@ include file="/WEB-INF/views/admin/include/include_top.jsp" %>
          <!-- Page Heading -->
          <h1 class="h3 mb-2 text-gray-800">상품관리페이지</h1>
          <!-- DataTales Example -->
          <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">전체상품수 : ${data.size() }</h6>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                      <th></th>
                      <th hidden="pNo1"></th>
                      <th>상품이름</th>
                      <th>상품가격</th>
                      <th>상품URL</th>
                      <th>상품주소</th>
                      <th>상품상세주소</th>
                      <th>상품조회수</th>
                      <th>상품등록일</th>
                      <th>상품정보</th>
                    </tr>
                  </thead>
                  <tbody>
                  	<c:forEach var="product" items="${data }">
                  	 <tr>
                  	  <td><input type="checkbox" name="product_CheckBox"></td>
                      <td hidden="pNo2">${product.pNo}</td>
                      <td>${product.pName}</td>
                      <td>${product.pPrice}</td>
                      <td style = "cursor:pointer;" onclick="location.href='${product.pUrl}'">${product.pUrl}</td>
                      <td>${product.pAddress}</td>
                      <td>${product.pDaddress}</td>
                      <td>${product.pView}</td>
                      <td>${product.pDate}</td>
                      <td><input type="button" class="pCheckBtn" value="클릭" /></td>
                    </tr>
                  	</c:forEach>
                  </tbody>
                </table>
                <button type="button" class="btn btn-outline btn-primary pull-right"
				id="pSelectBtn">삭제</button>
              </div>
            </div>
          </div>

        </div>
        <!-- /.container-fluid -->

      </div>
      <!-- End of Main Content -->
<%@ include file="/WEB-INF/views/admin/include/include_bottom.jsp"%>
<script type="text/javascript">
function pCheckBtn(pNo) {
	console.log(pNo);
	window.open("","상품정보수정",
			"width=870, height=800, toolbar=no, menubar=no, scrollbars=no, resizable=yes")
}
</script>
</body>

</html>
