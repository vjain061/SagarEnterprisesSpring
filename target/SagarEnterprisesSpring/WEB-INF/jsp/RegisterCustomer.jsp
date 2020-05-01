<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Customer</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(function(){
	$("#customerState").change(function() {
		
		var val = $("#customerState").val();
		
		var comboBox = "<option value=>Select City</option>";
		
	    $.ajax({
	        url: 'getCityUsingStateId',
	        dataType: 'html',
	        data: {stateId : val},
	        success: function(data) {
	        	var obj = JSON.parse(data);
	        	for(i=0;i<obj.length;i++){
	        		comboBox += "<option value="+(obj[i].cityName)+">"+(obj[i].cityName)+"</option>"
	        	}
	        	
	            $("#customerCity").html(comboBox);
	        }
	    });
	});
});

</script>
</head>
<body>
	<form:form action="registerCustomer" modelAttribute="customerDto"
		method="get">
		<table border="0" align="center">
			<tr>
				<td colspan="2" align="center">Register Customer</td>
			</tr>
			<tr>
				<td>Customer Name</td>
				<td><form:input type="text" name="customerName"
						path="customerName" /></td>
			</tr>
			<tr>
				<td>Customer LastName</td>
				<td><form:input type="text" name="customerLastName"
						path="customerLastName" /></td>
			</tr>
			<tr>
				<td>Customer Email</td>
				<td><form:input type="text" name="customerEmail"
						path="customerEmail" /></td>
			</tr>
			<tr>
				<td>Customer Mob</td>
				<td><form:input type="text" name="customerMob"
						path="customerMob" /></td>
			</tr>
			<tr>
				<td>Customer State</td>
				<td><form:select name="customerState" path="customerState">
					<c:forEach items="${customerStateList }" var="stateDto">
						<option value="${stateDto.stateId }">${stateDto.stateName }</option>
					</c:forEach>
				</form:select></td>
			</tr>
			<tr>
				<td>Customer City</td>
				<td><form:select name="customerCity" path="customerCity"></form:select></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><form:button path="register" name="register" value="register">Register</form:button></td>
			</tr>

		</table>
	</form:form>
<div>
			<a href="gotoAdminMenuPage" style="bottom: 10">Main Page</a>
		</div>
</body>
</html>