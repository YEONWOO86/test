<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
	function write(){
		location.href="/board/write_view";
	}
	function listShow(){
		location.href="/board/list";
	}
	function remove(){
		location.href="/board/delete_view";
	}
	/* function update(){
		location.href="/board";
	} */
</script>
</head>
<body>
<div>처음나오는 리스트 페이지입니다. list_first</div>
<div>
	<div><input type="button" value="글쓰기" onclick="write()"></div>
	<div><input type="button" value="글삭제" onclick="remove()"></div>
	<!-- <div><input type="button" value="글수정" onclick="update()"></div> -->
	<div><input type="button" value="목록보기" onclick="listShow()"></div>
	
</div>
</body>
</html>