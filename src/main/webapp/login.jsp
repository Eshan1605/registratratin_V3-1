<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
</head>
<body>
<h2>Login here....</h2>
	<form action ="login" method = "post">
		<pre>
		Email<input type = "text" name = "email">
		Password<input type = "password" name = "password">
		<input type = "submit" value = "login">
		</pre>
	</form>
	
	<%
	if(request.getAttribute("error")!= null){
		out.println(request.getAttribute("error"));
	}
	
	%>
</body>
</html>