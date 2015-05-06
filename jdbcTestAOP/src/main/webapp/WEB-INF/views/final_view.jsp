<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<%@ page session="false" contentType="text/html; charset=UTF-8" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<link rel="stylesheet" type="text/css" href="./resources/css/pyw.css"/>
<!-- <script src="resources/pyw.js"></script> -->
<head>
<meta http-equiv=”Content-Style-Type” content=”text/css”>
<meta http-equiv=”Content-Script-Type” content=”text/javascript”>

<title>final</title>
</head>
<script type="text/javascript">

	function logout_go() {
		$.ajax({
			url : "j_spring_security_logout",
			type : "GET",
			success : function(data){
				alert("1");
				$("#pyw_main").html(data);
			}
		
				
		});
	} 
	
	function list_go(){
		$.ajax({
			url : "final",
			type : "GET",
			data : "",
			dataType : "json", 
			success : function(data){
				alert("success")
				var content = "<table>";
				content += "<tr><td>이름</td><td>제목</td></tr>";
				
				for (var i = 0; i < data.row.length; i++) {
					/* alert(data.row[i].bName); */
					content += "<tr>";
					content += "<td>" + data.row[i].bName + "</td>";
					content += "<td><div onclick='home_selectOne("+[i]+","+data.row[i].bName+")'>" + data.row[i].bTitle + "</td>";
					/* content += "<td>" + data.row[i].bContent + "</td>"; */
					content += "</tr>";
				}
				
				content += "</table>";
				$("#show_list").html(content);
				
				/* content1 = "<input type='hidden' id='hid_chk' value='" +chk+ "'>"; */
				
				
				
				/* $("#hidden_show").html(content1); */
				
			},
			error : function(data){
				alert("false");
					
			} 
			
		});
	}
	
	function insert_go(){
		/* var content1 ='<form:form commandName="bDto">';
		content1 += "<div>이름</div><div><input type='text' id='bName' name='bName'/><form:errors path='bName'/></div>";
		content1 += "<div>제목</div><div><input type='text' id='bTitle' name='bTitle'><form:errors path='bTitle'/></div>";
		content1 += "<div>내용</div><div><input type='text' id='bContent' name='bContent'><form:errors path='bContent'/></div>";
		content1 += "<input type='button' value='고고' id='submit_write1' onclick='aa()'>";
		content1 += "</form:form>";
		$("#show_form").html(content1); */
		$("#hid_add").attr("style","display:''");
		
	}
	
	function aa(){
		$.ajax({
			url : "board_write",
			type: "post",
			/* dataType : "json", */
			data :{ "bName" : $("#bName").val(),
					"bTitle" : $("#bTitle").val(),
					"bContent" : $("#bContent").val(),
				  },
			success: function(data){
				alert("aa() success");
				
				/* $("#show_form").empty();  */
				$("#show_list").empty(); 
				list_go();
				alert(data);
				$("#pyw").html(data);
				
			}
		});
		
	}

	function home_selectOne(index_home,bName){
		alert(index_home+" "+bName);
		if(index_home==null || bName == null){
			alert("값이 비어잇음");
		}else{
			$.ajax({
				url : "board_selectOne",
				type : "GET",
				dataType : "json",
				data :{"bName" : bName},
				success : function(data){
					alert("suc");
					$("#show_form").empty();
					var content2 = "<div>이름 : "+ data.row.bName +"</div>";
					content2 += "<div>제목 : "+ data.row.bTitle +"</div>";
					content2 += "<div>내용 : "+ data.row.bContent +"</div>";
					content2 += "<input type='button' id='btn_remove' value='remove' onclick='btn_remove("+data.row.bName+")'>"
					content2 += "<input type='button' id='btn_update' value='update' onclick='btn_updateForm("+data.row.bName+")'>"
					
					$('#show_form').html(content2); 
				},
				error: function(data){
					alert("false");
				}
				
			});
		}
		

	}
	
function btn_remove(bName){
	alert(bName);
	$.ajax({
		url : "board_delete",
		type : "GET",
		data : { "bName" : bName },
		success : function(data){
			alert("remove success");
			$("#show_list").empty();
			list_go();
			$("#show_form").empty();
		},
		error : function(data){
			alert("remove error");
		}
		
	});
}
function btn_updateForm(bName){
	 alert(bName);
	 
	var content3 ='<form:form commandName="bDto1">';
	content3 += "<div>이름</div><div><input type='text' id='update_bName' name='bName' value='"+bName+"'readonly='readonly'/><form:errors path='bName'/></div>";
	content3 += "<div>제목</div><div><input type='text' id='update_bTitle' name='bTitle'></div>";
	content3 += "<div>내용</div><div><input type='text' id='update_bContent' name='bContent'></div>";
	content3 += "<input type='button' value='update' id='submit_update' onclick='btn_update()'>";
	content3 += "</form:form>";
	
	$("#show_form").empty();
	$("#show_form").html(content3);  
	
	
}

function btn_update(){
	$.ajax({
		url : "board_update",
		type : "POST",
		data :{ "bName" : $("#update_bName").val(),
			"bTitle" : $("#update_bTitle").val(),
			"bContent" : $("#update_bContent").val(),
		  },
		success : function(data){
			alert("update success");
			$("#show_list").empty();
			list_go();
			$("#show_form").empty();
		},
		error : function(data){
			alert("update error");
		}
		
	});
}
</script>

<body>
	<div id="pyw">
		<div id="pyw_main">
			<div id="show_list"></div>
			<div id="show_form"></div>
			
			<div id="hid_add" style="display:none">
			
			<form:form commandName="bDto">
			<div>이름</div><div><input type='text' id='bName' name='bName'/><form:errors path='bName'/></div>
			<div>제목</div><div><input type='text' id='bTitle' name='bTitle'><form:errors path='bTitle'/></div>
			<div>내용</div><div><input type='text' id='bContent' name='bContent'><form:errors path='bContent'/></div>
			<input type='button' value='고고' id='submit_write1' onclick='aa()'>
			</form:form>
			</div>
			
			<div id="hidden_show"></div>
			
			<div><input type="button" value="list" onclick="list_go()"/></div>
			<div><input type="button" value="insert" onclick="insert_go()"/></div>
			<div><input type="button" value="logout" onclick="logout_go()"/></div>
		</div>
	</div>
	 
</body>
</html>