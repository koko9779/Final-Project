<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/tags.jspf" %>
<%@ include file="/WEB-INF/views/include/include_navbar.jsp"%>
<script src="${pageContext.request.contextPath}/css/admin/vendor/jquery/jquery.min.js"></script>

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

<!-- Section -->
<div class="container section news" style="padding:75px 10%;">
   <article style="width:100%">
      <c:forEach var="pList" items="${pList}">
         <form id="product_${pList.product[0].pNo}">
            <h2 value="상품이름" >${pList.product[0].pName}</h2>
            <input type="hidden" value="${userNo}" name="userNo">
            <input type="hidden" value="${pList.product[0].wNo}" name="wNo">
            <input type="hidden" value="${pList.product[0].pNo}" name="pNo">
            <div class="movie-poster2">
               <img onclick="productpage(${pList.product[0].pNo})"
                  src="${pageContext.request.contextPath}/images/product/scene/${pList.product[0].pScene}.jpg"
                  alt="${pList.product[0].pName}" style="width:850px; height:450px; margin: 0;cursor: pointer;"/>
            </div>
            <div style="height:100px;">
               <c:choose>
                  <c:when test="${!empty userNo}">
                     <c:set var="cnt" value="0"/>
                     <c:forEach var="bm" items="${bmList}">
                        <c:if test="${pList.product[0].pNo eq bm.product.pNo}">
                           <c:set var="cnt" value="1"/>
                        </c:if>
                     </c:forEach>
                     <c:choose>
                        <c:when test="${cnt==1}">
                           <input class="material-icons" type="image" 
                                 style="border: none; width: 4%; float:left; padding: 0px;" alt="즐겨찾기 제거"
                                 src="${pageContext.request.contextPath}/images/star.png"
                                 onclick="select_bookmark(${userNo},${pList.product[0].pNo});return false;">
                        </c:when>
                        <c:otherwise>
                           <input class="material-icons" type="image"
                           style="border: none; width: 4%; float:left; padding: 0px;" alt="즐겨찾기 등록"
                           src="${pageContext.request.contextPath}/images/emptystar.png"
                           onclick="create_bookmark(${userNo},${pList.product[0].pNo});return false;">   
                        </c:otherwise>
                     </c:choose>
                  </c:when>
                  <c:otherwise>
                     <input class="material-icons" type="image"
                     style="border: none; width: 4%; float:left; padding: 0px;" alt="즐겨찾기 등록"
                     src="${pageContext.request.contextPath}/images/emptystar.png"
                     onclick="login_advice(); return false;">                                       
                  </c:otherwise>
               </c:choose>
               <div style="float:right;">
                  <span value="작성자">작성자: ${pList.product[0].mId}</span>
                  <span class="categories tag" value="조회수">조회수: ${pList.product[0].pView}</span>
                  <span class="categories tag" value="에피소드">${pList.wdEpisode}회</span>
               </div>
            </div>
         </form>
      </c:forEach>
   </article>
</div>
<%@ include file="/WEB-INF/views/include/include_js.jsp" %>
</body>   
</html>