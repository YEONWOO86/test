<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page session="false" contentType="text/html; charset=UTF-8" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<head>
<meta http-equiv=”Content-Type” content=”text/html; charset=utf-8″>
<meta http-equiv=”Content-Style-Type” content=”text/css”>
<meta http-equiv=”Content-Script-Type” content=”text/javascript”>

<title>final</title>
</head>
<script type="text/javascript">
	
	function logout() {
		$.ajax({
			url : "j_spring_security_logout",
			type : "GET",
			success : function(data){
				alert("1");
				$("#one").html(data);
			}
		
				
		});
	} 
	
	function list_go(){
		$.ajax({
			url : "final_view",
			type : "GET",
			data : "",
			dataType : "json", 
			success : function(data){
				slert("success")
				alert(data);
				
			/* 	 $.each(list , function(key){
					var list = list[key];
					for( i =0 ; i <list.length ; i++){
						alert(list[i].bName);
					}
				});  */
			},
			error : function(data){
				alert("false");
					
			}
			
		});
	}
	
	function insert_go(){
		
	}
</script>
<body>
	<div id="pyw">
		<div id="pyw_main">
			<div id="show"></div>
			<div><input type="button" value="list" onclick="list_go()"/></div>
			<div><input type="button" value="insert" onclick="insert_go()"/></div>
			<div><input type="button" value="logout" onclick="logout_go()"/></div>
		</div>
	</div>
</body>
</html>