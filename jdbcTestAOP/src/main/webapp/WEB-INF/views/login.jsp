<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>login page</title>
</head>
<body>
i am login
	
	
		<c:if test="${param.error == 'true'}">
		<strong>아이디와 암호가 일치하지 않습니다.</strong>
		</c:if>
		<form action="<c:url value='/user/login'/>" method="post">
		    <label for="name">사용자ID</label>:
		    <input type="text" name="userid" /> 
		    <br/>
		    
		    <label for="password">암호</label>:
		    <input type="password" name="password" /> 
		    <br/>
		    
		    <input type="submit" value="로그인" />
		</form>



<!--     <form action="j_spring_security_check" method="POST">
        11ID : <input type="text" name="j_username" size="20" maxlength="50" /><br />
        Password : <input type="password" name="j_password" size="20" maxlength="50" /><br /> 
        <input type="submit" value="Login" />
    </form> -->
</body>
</html>