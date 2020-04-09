/**
 * 
 */
$(window).on("load", function() {
	
	//버튼 클릭시 Row 값 가져오기
	$(".checkBtn").click(function(){ 
	    var str = ""
	    var tdArr = new Array();    
	    var checkBtn = $(this);
	    var tr = checkBtn.parent().parent();
	    var td = tr.children();
	    var no = td.eq(1).text(); 
	});
	$("#selectBtn").click(function(){ 
	    var checkbox = $("input[name=user_CheckBox]:checked");
	    // 체크된 체크박스 값을 가져온다
	    var tdArray = new Array();
	    checkbox.each(function(i) {
	        // checkbox.parent() : checkbox의 부모는 <td>이다.
	        // checkbox.parent().parent() : <td>의 부모이므로 <tr>이다.
	        var tr = checkbox.parent().parent().eq(i);
	        var td = tr.children();
	        var mNo = td.eq(1).text();
	        var noArray = 'noArray='+mNo+'-'
	        console.log(noArray);
	        console.log(mNo);
	        $.ajax({
	    		url:'member_delete',
	    		data:noArray,
	    		method:'POST',
	    		dataType: "text",
	    		success:function(){
	    			location.reload();
	    		},
	    		error: function(xhr, status, error) {alert(error);}
	    			
	    		});
	    	});
	    });
});