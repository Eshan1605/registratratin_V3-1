<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>update Reg</title>
</head>
<body>
	<h2>Update Registration</h2>
		<form action ="update" method ="post">
			<pre>
			Name<input type="text" name = "name" value=<%=request.getAttribute("name") %>>
			City<input type="text" name = "city" value=<%=request.getAttribute("city") %>>
			Email<input type="text" name = "email" value=<%=request.getAttribute("email") %> readonly>
			Mobile<input type="text" name = "mobile" value=<%=request.getAttribute("mobile") %>>
			<input type ="submit" value ="update">
			</pre>
		</form>

</body>
</html>