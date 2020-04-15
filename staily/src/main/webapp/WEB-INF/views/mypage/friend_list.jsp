<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/tags.jspf"%>
<%@ include file="/WEB-INF/views/mypage/include/include_top.jsp" %>



<script type="text/javascript">
	$(function(){
		
		/************************친구삭제 function 시작******************************/
		
		$('#deleteFriendBtn').click(function(e){
			//데이터를 받을 배열 선언
			var noArray = [];
			
			//배열에 데이터 넣기
			$('input[name="friend_check"]:checked').each(function(i){
				noArray.push($(this).val());
			})
			
			var params = {
				"fPk" : noArray
			}
			
			$.ajax({
				url : 'friend_delete',
				data : params,
				dataType : "text",
				success : function(result){
					if(result == 'true'){
						alert('삭제완료');
						location.reload();
					}else{
						location.href = '404';
					}
				},
				error : function(){
					location.href = '404';
				}
			});
			
			
		});

		
		/************************쪽지보내기 function 시작******************************/
		$('#friendDropdown a:nth-child(1)').click(function(e){
			e.preventDefault();
			var no = $(this).attr('value');	
			window.open("message?mNo="+no, "_blank","width=800, height=700, left=1000, toolbar=no, menubar=no, scrollbars=no, resizable=yes");
			
		});
		
		//메시지 보관함 열기
		$('#friendDropdown a:nth-child(2)').click(function(e){
			e.preventDefault();
			window.open("message_list", "_blank", "width=800, height=700, left=1000, toolbar=no, menubar=no, scrollbars=no, resizable=yes");
		})
		
		/************************친구검색 function 시작******************************/
		
		$('#searchword').focus(function(e){
			this.value="";
			$(".add").toggle();
			$(".add").text('');
		});

		$('#searchword').on({
			keyup : function(e){
				if(e.keyCode == 13){
					var mId = $('#searchword').val();
					confirm('찾으신 회원이 맞습니까?');
					if(mId != ""){
						$.ajax({
							url : "friend_find",
							method : "GET",
							data : "mId="+mId,
							dataType : "text",
							success : function(result){
								if(result!="N"){
									$('.add').text(result);
									friend_findNo_function(result);
									//alert(mId);
									//$('.add').text('없는 회원입니다');
								}else{
									$('.add').text('없는 회원입니다');
									$('#searchDropdwon').hide();
									//$('.add').text(result);
								}
							},
							error : function(e){
								//$('.add').text('없는 회원입니다');
							}
							
						})
					}
				}
			}
		});
		
		function friend_findNo_function(result){
			$('#searchDropdwon a:nth-child(1)').click(function(e){
				//alert("friend_findNo_function Id"+result);
				e.preventDefault();
				$.ajax({
					url : 'friend_findNo',
					method : 'GET',
					data : 'mId='+result,
					dataType : 'text',
					success : function(data){
						friend_create_function(data);
					}
				})
			})
		};
		function friend_create_function(data){
			//alert("friend_create_function mNo"+data);
			$.ajax({
				url : 'friend_create',
				method : 'GET',
				data : 'fNo='+data,
				dataType : 'text',
				success : function(result){				
					if(result == 'true'){					
						alert('친구추가완료');
						location.reload();
					}else{
						alert('이미 친구추가된 회원입니다');
					}
				},
				error : function(e){
					alert('이미 친구추가된 회원입니다');
				}
			})
		};
		/************************친구검색 function 끝******************************/
		
		/************************검색한 친구 쪽지보내기************************/
		$('#searchDropdwon a:nth-child(2)').click(function(e){
			e.preventDefault();
			//var noV = $(this).attr('value');
			window.open("message", "_blank","width=800, height=700, left=1000, toolbar=no, menubar=no, scrollbars=no, resizable=yes");
		})
		
	})
</script>


        <!-- End of Topbar -->

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <!-- 친구찾기 -->
          <h1 class="h3 mb-2 text-gray-800">친구찾기</h1>

			<div id="search" class="tab_content">
				<input type="text" id="searchword" style="width:300px;" value="아이디를 입력하세요" >
			</div>
			<div class="dropdown" id="results">
			   <!-- add -->
			   <span data-toggle='dropdown' class="add"></span>
				<div class="dropdown-menu" id='searchDropdwon'>
				  	<a class="dropdown-item" href="#">친구추가</a>
				  	<a class="dropdown-item" href="#">쪽지보내기</a>
				</div>
			</div>
			<!--
			<div class="dropdown" id="results">
			  <button class="dropbtn"></button>
			  <div class="dropdown-content">
			    <a href="#">홈</a>
			    <a href="#">회사소개</a>
			    <a href="#">제품소개</a>
			    <a href="#">오시는길</a>
			  </div>
			</div>
			-->
			<br>
			<br>	          
          <!-- 친구찾기 -->
          <h1 class="h3 mb-2 text-gray-800">친구리스트페이지</h1>
          <!-- DataTales Example -->
          <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">친구리스트</h6>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                      <th></th>
                      <th>친구</th>
                    </tr>
                  </thead>
                  <tbody>
                  	<c:forEach var="friend" items="${data}">
                  	 <tr>
                  	  <td><input type="checkbox" name="friend_check" value="${friend.fPk}"></td>
                      <td >
                      <div class="dropdown">
							<buttion class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
							 	${friend.mId}
							 </button>
							 <div class="dropdown-menu" id="friendDropdown">
							  	<a class="dropdown-item" href="#" value="${friend.fNo}">쪽지보내기</a>
							  	<a class="dropdown-item" href="#" value="${friend.mId}">쪽지보관함</a>
							</div>
					  </div>
	
                    </td>
                      
                    </tr>
                  	</c:forEach>
                  </tbody>
                </table>
                <input type="button" class="btn btn-outline btn-primary pull-right" value="삭제" id="deleteFriendBtn">
              </div>
            </div>
          </div>

        </div>
        <!-- /.container-fluid -->

      </div>
      
      <!-- End of Main Content -->

      <!-- Footer -->
      <%@ include file="/WEB-INF/views/mypage/include/include_footer.jsp" %>
