<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

<script type="text/javascript">
function aa(){
	$.ajax({
		url : "board_write",
		type: "post", 
		data :{ "bName" : $("#bName").val(),
				"bTitle" : $("#bTitle").val(),
				"bContent" : $("#bContent").val(),
			  },
		success: function(data){
			alert("1");
			$("show").empty();
			$("#one").html(data);
		}
	});
	
}

$("#submit_write1").click(function(){
	alert("3");
	
});
</script>
</head>



<body>
<form:form commandName="bDto">


<div><div>이름</div><div><input type="text" id="bName" name="bName"></div></div><form:errors path="bDto.bName"/> 
<div><div>제목</div><div><input type="text" id="bTitle" name="bTitle"><form:errors path="bTitle"/> </div></div>
<div><div>내용</div><div><input type="text" id="bContent" name="bContent"><form:errors path="bContent"/> </div></div>
<input type="button" value="고고" id="submit_write1" onclick="aa()">
</form:form>

</body>

</html>