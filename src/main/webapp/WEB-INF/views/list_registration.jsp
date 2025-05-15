<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.ResultSet"%>
<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Registration</title>
</head>
<body>
	<h2>All Registration</h2>
	<table border = '1'>
		<tr>
			<th>Name</th>
			<th>City</th>
			<th>Email</th>
			<th>Mobile</th>
			<th>Actions</th>
		</tr>
		<%
		ResultSet result = (ResultSet)request.getAttribute("res");
		while(result.next()){
		%>
		<tr>
		<td><%=result.getString(1)%></td>
		<td><%=result.getString(2)%></td>
		<td><%=result.getString(3)%></td>
		<td><%=result.getString(4)%></td>
		<td>
			<a href ="delete?email=<%=result.getString(3)%>">delete</a>
		</td>
		<td>
			<a href="update?email=<%=result.getString(3)%>&mobile=<%=result.getString(4)%>&name=
			<%=result.getString(1)%>&city=<%=result.getString(2)%>">update</a>
		</td>
		</tr>
		
		<%} %>
		</table>
</body>
</html>