<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=UTF-8" %>
<!-- <script src="resources/js/board_delete_pyw.js"></script> -->
<script src="resources/jquery-2.1.1.min.js"></script>
<html>
<head>
    <title>Home</title>
</head>

<script type="text/javascript">
	function goWriteForm(){
		location.href="board_writeForm";
	}
	function godeleteForm(){
		location.href="board_deleteForm";
	}
	
	function home_selectOne(index_home,bName){
		alert(index_home+" "+bName);
		if(index_home==null || bName == null){
			alert("값이 비어잇음");
		}else{
			location.href="board_selectOne?bName="+bName;
		}
		
		//alert($("#home_selectOne").val());
		/* location.href ="board_selectOne?bName=${vo.bName}"; */
	}
</script>
<body>
<h1>
    Hello world!  
</h1>
 
<P>  The time on the server is ${serverTime}. </P>
<div class="home_table">
<c:forEach var="vo" items="${list }" varStatus="i">
    <div class="home_tr">
    <div class="home_td">${vo.bName }
<%-- <a href="board_selectOne?bName=${vo.bName}">${vo.bTitle }</a> --%>
		<div onclick="home_selectOne(${i.index},${vo.bName })" class="home_td">${vo.bTitle }</div>
	</div>
	</div>
</c:forEach>
</div>
<input type="button" value="삽입" onclick="goWriteForm()">
<input type="button" value="삭제" onclick="godeleteForm()">
</body>
</html>
 