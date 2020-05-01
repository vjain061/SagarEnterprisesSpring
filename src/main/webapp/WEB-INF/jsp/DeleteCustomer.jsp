<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Customer</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(function(){
	$("#Delete").click(function() {
		
		var val = $("#customerId").val();
		
	    $.ajax({
	        url: 'deleteCustomer',
	        dataType: 'html',
	        data: {customerId : val},
	        success: function(data) {
	        	var obj = JSON.parse(data);
	        	$("#customerData").html(obj);
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
				<td colspan="2" align="center"><input type="submit" value="Delete" id="Delete"></td>
			</tr>
			<tr>
				<td colspan="2" align="center" id="customerData"></td>
			</tr>
		</table>
<div>
			<a href="gotoAdminMenuPage" style="bottom: 10">Main Page</a>
		</div>
</body>
</html>