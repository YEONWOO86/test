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

$("#submit_write").click(function(){
	$.ajax({
		url : "board_write",
		type: "post", 
		data :{ "write_bName" : $("#bName").val(),
				"write_bTitle" : $("#bTitle").val(),
				"write_bContent" : $("#bContent").val(),
			  },
		success: function(data){
			alert("1");
			$("show").empty();
			$("#one").html(data);
		},
		error : function(data){
			alert('2');
		}
	});
});

</script>
<body>
<div><div>이름</div><div><input type="text" id="bName" name="write_bName"></div></div>
<div><div>제목</div><div><input type="text" id="bTitle" name="write_bTitle"></div></div>
<div><div>내용</div><div><input type="text" id="bContent" name="write_bContent"></div></div>
<input type="button" value="고고" id="submit_write">
</body>
</html>

	