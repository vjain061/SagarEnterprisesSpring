<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Generate Bill</title>
</head>
<body>
	<form action="generateBill" modelAttribute="billingDto">
		<table border="0" align="center">
			<tr>
				<td>Customer Id</td>
				<td><input type="text" name="customerId" id="customerId"></td>
			</tr>
			<tr>
				<td>Amount</td>
				<td><input type="text" name="billAmount" id="billAmount"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Enter"></td>
			</tr>
		</table>
	</form>
	<div>
			<a href="gotoAdminMenuPage" style="bottom: 10">Main Page</a>
		</div>
</body>
</html>