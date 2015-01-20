<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Past Activities</title>
</head>
<body>
<h2>Welcome ${username}</h2>
<a href ="/EbayClient/signout"><h3>sign out</h3></a>
<h3>past purchases</h3>
<table border="1" style="width:800px">
<tr>
<td><h2>productname</h2></td>
<td><h2>description</h2></td>
<td><h2>price</h2></td>

</tr>

<%String[] pproductname=(String[])request.getAttribute("pproductname"); %>
<%String[] pdiscription=(String[])request.getAttribute("pdiscription"); %>
<%String[] pprice=(String[])request.getAttribute("pprice"); %>
<%if (pproductname.length > 1){ %>
<%for(int i = 0 ; i <pproductname.length ; i++){ %>

<tr>
            <td><%= pproductname[i] %></td>
            <td><%= pdiscription[i] %></td>
            <td><%= pprice[i] %></td>
            
</tr>

<% } %>
<%} %>
</table>

<h3>past sold outs</h3>
<table border="1" style="width:800px">
<td><h2>productname</h2></td>
<td><h2>description</h2></td>
<td><h2>price</h2></td>
<%String sproductname[]=(String[])request.getAttribute("sproductname"); %>
<%String sdiscription[]=(String[])request.getAttribute("sdiscription"); %>
<%String sprice[]=(String[])request.getAttribute("sprice"); %>

<%for(int i = 0 ; i <sproductname.length ; i++){ %>

<tr>
            <td><%= sproductname[i] %></td>
            <td><%= sdiscription[i] %></td>
            <td><%= sprice[i] %></td>
            
</tr>
<% } %>

</table>
</body>
</html>