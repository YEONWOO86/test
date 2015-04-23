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
$("#btn_delete").click(function(){
	$.ajax({
		url : "board_delete",
		data :{
			"delete_bName" : $("#delete_bName").val()
		},
		type: "post",
		success : function(data){
			alert("1");
			$("#show").empty();
			$("#one").html(data);
		},
		error : function(data){
			alert("2");
		}
	})
	
});
</script>

<body>
<div><div>삭제할이름</div><div><input type="text" name="delete_bName"id="delete_bName"></div></div>
<div><input type="button" value="삭제" id="btn_delete"></div>
</body>
</html>