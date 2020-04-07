<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

    <!-- Sidebar -->
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

      <!-- Sidebar - Brand -->
      <a class="sidebar-brand d-flex align-items-center justify-content-center" href="/staily">
        <div class="sidebar-brand-icon rotate-n-15">
          <i class="fas fa-laugh-wink"></i>
        </div>
        <div class="sidebar-brand-text mx-3">Mypage</div>
      </a>

      <!-- Divider -->
      <!-- Nav Item - Dashboard -->
      <!--  
      <li class="nav-item active">
        <a class="nav-link" href="admin.do">
          <i class="fas fa-fw fa-tachometer-alt"></i>
          <span>관리자메인</span></a>
      </li>
	  -->
      <!-- Divider -->
      <hr class="sidebar-divider">

      <!-- Nav Item - Pages Collapse Menu -->
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages" aria-expanded="true" aria-controls="collapsePages">
          <i class="fas fa-fw fa-folder"></i>
          <span>회원정보</span>
        </a>
        <div id="collapsePages" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
           <!-- <h6 class="collapse-header">Login Screens:</h6> -->
            <a class="collapse-item" href="member_select">정보수정</a>
            <a class="collapse-item" href="friend_list">친구리스트</a>
            <a class="collapse-item" href="message_list">메시지보관</a>
            <div class="collapse-divider"></div>
           <!--   <h6 class="collapse-header">Other Pages:</h6> -->
            <a class="collapse-item" href="payment_list">결제내역</a>
            <!--  <a class="collapse-item" href="blank.html">Blank Page</a>-->
          </div>
        </div>
      </li>
      <!-- Nav Item - Tables -->
      <li class="nav-item">
        <a class="nav-link" href="bookmark_list">
          <i class="fas fa-fw fa-table"></i>
          <span>즐겨찾기</span></a>
      </li>
      <!-- Nav Item - Tables -->
      <li class="nav-item">
        <a class="nav-link" href="member_write">
          <i class="fas fa-fw fa-table"></i>
          <span>내가쓴글목록</span></a>
      </li>
      <!-- Nav Item - Tables -->
      <li class="nav-item">
        <a class="nav-link" href="payment">
          <i class="fas fa-fw fa-table"></i>
          <span>결제하기</span></a>
      </li>

      <!-- Divider -->
      <hr class="sidebar-divider d-none d-md-block">

      <!-- Sidebar Toggler (Sidebar) -->
      <div class="text-center d-none d-md-inline">
        <button class="rounded-circle border-0" id="sidebarToggle"></button>
      </div>

    </ul>
    <!-- End of Sidebar -->
</body>
</html>