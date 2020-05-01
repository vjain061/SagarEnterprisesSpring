<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Customer Whom Billing Due</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(function(){
	$("#Enter").click(function() {
		
		var val = $("#customerId").val();
		if(val == ""){
			$.ajax({
		        url: 'searchBill',
		        dataType: 'html',
		        data: {customerId : val},
		        success: function(data) {
		        	var obj = JSON.parse(data);
					var Billtable = "<table border=1 align=center>";  
					Billtable += "<tr><td>customerId</td><td>customerName</td><td>billAmount</td><td>billDate</td><td>customerMob</td></tr>";
					for(i=0;i<obj.length;i++){
						for(j=0;j<obj[i].billingDtoList.length;j++){
							Billtable += "<tr><td>"+(obj[i].customerId)+"</td><td>"+(obj[i].customerName)+"</td>";
							Billtable += "<td>"+obj[i].billingDtoList[j].billAmount+"</td><td>"+obj[i].billingDtoList[j].billDate+"</td>";	
							Billtable += "<td>"+(obj[i].customerMob)+"</td></tr>";	
						}
					}
					
		        	Billtable += "</table>";
		            $("#Bill").html(Billtable);
		        }
		    });
		}else{
			$.ajax({
		        url: 'searchBill',
		        dataType: 'html',
		        data: {customerId : val},
		        success: function(data) {
		        	var obj = JSON.parse(data);
					var Billtable = "<table border=1 align=center>";  
					Billtable += "<tr><td>customerId</td><td>customerName</td><td>billAmount</td><td>billDate</td><td>customerMob</td></tr>";
					for(i=0;i<obj.billingDtoList.length;i++){
						Billtable += "<tr><td>"+(obj.customerId)+"</td><td>"+(obj.customerName)+"</td><td>"+(obj.billingDtoList[i].billAmount)+
						"</td><td>"+(obj.billingDtoList[i].billDate)+"</td><td>"+(obj.customerMob)+"</td></tr>";					
					}
		        	
		        	Billtable += "</table>";
		            $("#Bill").html(Billtable);
		        }
		    });
		}
			
	    
	});
});

</script>
</head>
<body>
	<!-- <form action="searchBill"> -->
		<table border="0" align="center">
			<tr>
				<td>Customer Id</td>
				<td><input type="text" name="customerId" id="customerId"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Enter" id="Enter"></td>
			</tr>
		</table>
		<div id="Bill">
		
		</div>
		
		<div>
			<a href="gotoAdminMenuPage" style="bottom: 10">Main Page</a>
		</div>
</body>
</html>