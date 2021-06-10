<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}
</style>
</head>
<body>
	<a href="register">New Registration</a>
	<br>
	<a href="logout">Logout</a> <br>
	<font color="green" align="center"><h1>Hello ${msg}</h1></font>
	<br>
	<div align="center">
		<table style="width: 100%">
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Age</th>
				<th>Place</th>
			</tr>
			<c:forEach items="${list}" var="item">
				<tr>
					<td><c:out value="${item.id}" /></td>
					<td><c:out value="${item.name}" /></td>
					<td><c:out value="${item.age}" /></td>
					<td><c:out value="${item.place}" /></td>
				</tr>

			</c:forEach>
		</table>


	</div>
	<a href="addPet">Add Pet</a>
	<br>
	<br>
</body>
</html>