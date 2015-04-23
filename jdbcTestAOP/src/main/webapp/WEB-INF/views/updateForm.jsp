<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<script type="text/javascript">
$("#btn_update").click(function(){
	$.ajax({
		url : "board_update",
		type: "post", 
		data :{ "update_bName" : $("#update_bName").val(),
				"update_bTitle" : $("#update_bTitle").val(),
				"update_bContent" : $("#update_bContent").val(),
			  },
			  
		success: function(data){
			alert("1");
			$("#show").empty();
			$("#one").html(data);
		},
		error : function(data){
			alert('2');
		}
	});
});
</script>
<body>
<div><div>이름</div><div><input name="update_bName" value="${bDto.bName}" id="update_bName"></div></div>
<div><div>제목</div><div><input name="update_bTitle" type="text" placeholder="${bDto.bTitle}" id="update_bTitle"></div></div>
<div><div>내용</div><div><input name="update_bContent" type="text" placeholder="${bDto.bContent}" id="update_bContent"></div></div>
<input type="button" value="고고" id="btn_update">
</body>
</html>

	