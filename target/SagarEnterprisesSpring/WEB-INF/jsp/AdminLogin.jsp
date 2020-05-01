<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Login</title>
</head>
<body>
	<form:form action="processAdminLogin" modelAttribute="adminDto"
		method="get">
		<table border="0" align="center">

			<tr>
				<td>Admin Id</td>
				<td><form:input type="text" name="adminId" path="adminId" /></td>
			</tr>
			<tr>
				<td>Admin Password</td>
				<td><form:input type="password" name="adminPassword"
						path="adminPassword" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><form:button path="login" name="login" value="login">login</form:button></td>
			</tr>
			<tr>
				<td colspan="2" align="center" style="color: red">${message}</td>
			</tr>
		</table>
	</form:form>

</body>
</html>