<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Customer New</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	
	$(function() {
		$("#Enter")
				.click(
						function() {

							var val = $("#customerId").val();
							$
									.ajax({
										url : 'getCustomerDataForUpdate',
										dataType : 'html',
										data : {
											customerId : val
										},
										success : function(data) {
											var obj = JSON.parse(data);
											alert(obj);
											var customertable = "<table border=1 align=center>";
											customertable += "<tr><td>customerName</td><td><input type='text' name='customerName' value="+obj.customerName+"></td></tr>";
											customertable += "<tr><td>customerLastName</td><td><input type='text' name='customerLastName' value="+obj.customerLastName+"></td></tr>";
											customertable += "<tr><td>customerCity</td><td><input type='text' name='customerCity' value="+obj.customerCity+"></td></tr>";
											customertable += "<tr><td>customerState</td><td><input type='text' name='customerState' value="+obj.customerState+"></td></tr>";
											customertable += "<tr><td>customerMob</td><td><input type='text' name='customerMob' value="+obj.customerMob+"></td></tr>";
											customertable += "<tr><td>customerEmail</td><td><input type='text' name='customerEmail' value="+obj.customerEmail+"></td></tr>";
											customertable += "<tr><td colspan='2' align='center'><input type='submit' value='Done' id='Done'></td></tr>";
											customertable += "</table>";
											$("#customerData").html(
													customertable);
										}
									});
						});
	});
</script>
</head>
<body>
	<table border="0" align="center">
		<tr>
			<td>Customer Id</td>
			<td><input type="text" name="customerId" id="customerId"></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" id="Enter"
				value="Enter"></td>
		</tr>
	</table>
	<div id="customerData"></div>
	<div>
		<a href="gotoAdminMenuPage" style="bottom: 10">Main Page</a>
	</div>
</body>
</html>