<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	
</script>
<body>
<form action="board_update" method="post">
<div><div>이름</div><div><input name="update_bName" value="${bDto.bName}"></div></div>
<div><div>제목</div><div><input name="update_bTitle" type="text" placeholder="${bDto.bTitle}"></div></div>
<div><div>내용</div><div><input name="update_bContent" type="text" placeholder="${bDto.bContent}"></div></div>
<input type="submit" value="고고" >
</form>
</body>
</html>

	