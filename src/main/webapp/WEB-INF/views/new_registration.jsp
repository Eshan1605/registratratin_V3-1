<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file ="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>new registration</title>
</head>
<body>
	<h2>New Registration</h2>
		<form action = "saveReg" method = "post">
			Name<input type = "text" name = "name">
			City<input type = "text" name = "city">
			Email<input type = "text" name = "email">
			Mobile<input type = "text" name = "mobile">
			<input type = "submit" value = "save">
		</form>
</body>
</html>