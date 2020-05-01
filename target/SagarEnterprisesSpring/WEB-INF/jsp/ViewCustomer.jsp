<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Customer</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(function(){
	$("#Search").click(function() {
		
		var val = $("#customerId").val();
		
	    $.ajax({
	        url: 'getCustomerDataUsingId',
	        dataType: 'html',
	        data: {customerId : val},
	        success: function(data) {
	        	var obj = JSON.parse(data);
				var customertable = "<table border=1 align=center>";  
				customertable += "<tr><td>customerName</td><td>"+obj.customerName+"</td></tr>";
				customertable += "<tr><td>customerLastName</td><td>"+obj.customerLastName+"</td></tr>";
				customertable += "<tr><td>customerCity</td><td>"+obj.customerCity+"</td></tr>";
				customertable += "<tr><td>customerState</td><td>"+obj.customerState+"</td></tr>";
				customertable += "<tr><td>customerMob</td><td>"+obj.customerMob+"</td></tr>";
				customertable += "<tr><td>customerEmail</td><td>"+obj.customerEmail+"</td></tr>";
				customertable += "<tr><td colspan='2' align='center'><input type='submit' value='Done' id='Done'></td></tr>";
				customertable += "</table>";
	            $("#customerData").html(customertable);
	        }
	    });
	});
});

</script>
</head>
<body>
	<%-- <form action="getCustomerDataUsingId"> --%>
		<table border="0" align="center">
			<tr>
				<td>Customer Id</td>
				<td><input type="text" name="customerId" id="customerId"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Search" id="Search"></td>
			</tr>
		</table>
	<%-- </form> --%>
	<div id="customerData">
	
	</div>
	<div>
			<a href="gotoAdminMenuPage" style="bottom: 10">Main Page</a>
		</div>
</body>
</html>