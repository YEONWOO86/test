<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page session="false" contentType="text/html; charset=UTF-8" %>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>

<html>
<head>
    <title>Home</title>
</head>

<script type="text/javascript">

	function goWriteForm(){
		$.ajax({
			url : "board_writeForm",
			type : "GET",
			dataType : "html",
			success : function(data){
				alert("1");
				$('#show').load(data);  
				
			},
			error: function(data){
				alert("2");
			}
			
		});
		
	}
	function godeleteForm(){
		
		$.ajax({
			url : "board_deleteForm",
			type : "GET",
			dataType : "html",
			success : function(data){
				alert("delete go");
				$('#show').html(data);  
			},
			error: function(data){
				alert("false");
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
				dataType : "html",
				data :{"bName" : bName},
				success : function(data){
					alert("update go");
					$('#show').html(data);  
				},
				error: function(data){
					alert("false");
				}
				
			});
		}
		

	}
</script>
<body>
<div id ="one">
<h1>
    Hello world!  
</h1>
 
<P>  The time on the server is ${serverTime}. </P>

<table>
<tr><td>이름</td><td>제목</td></tr>
<c:forEach var="vo" items="${list }" varStatus="i">
    <tr bordercolor="black">
    <td>${vo.bName }
<%-- <a href="board_selectOne?bName=${vo.bName}">${vo.bTitle }</a> --%>
		<td><div onclick="home_selectOne(${i.index},${vo.bName })" class="home_td">${vo.bTitle }</div></td>
	</td>
	</tr>
</c:forEach>

</table>

<div id="show"></div>
<input type="button" value="삽입" onclick="goWriteForm()">
<input type="button" value="삭제" onclick="godeleteForm()">
</div>
</body>
</html>
 