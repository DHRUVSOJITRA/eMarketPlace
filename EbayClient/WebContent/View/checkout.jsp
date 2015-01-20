<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CheckOut</title>
</head>
<body>
<a href ="/EbayClient/signout"><h3>sign out</h3></a>
<h2>Enter your credit card details to check out</h2>
<h2>${msg }</h2>
<%String link = "/EbayClient/validatecardinfo";%>
<form action=<%= link%> method="post">
<table>
	
<tr>
	<td>Credit Card Number</td>
	<td><input type="text" name="creditcardnumber" id="creditcardnumber" lenght ="100px"></td>
</tr>	
<input type="submit" name="submit" lenght="100px" value="submit" >

</table>
</body>
</html>