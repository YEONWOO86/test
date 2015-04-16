<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>

</head>
<script type="text/javascript">
function doShow(){
	location.href("/test/studentForm");
}
</script>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<div><input type="button" value="goCreate" id="goCreate" onclick="doShow()"></div>
</body>
</html>
