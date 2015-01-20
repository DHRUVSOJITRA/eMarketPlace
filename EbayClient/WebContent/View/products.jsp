<%@page import="connection.ServicesProxy"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>product's page'</title>
</head>
<body>
<a href ="/EbayClient/signout"><h3>sign out</h3></a>
<% String linkTocart = "/EbayClient/showcart"; %>
<a href = <%=linkTocart %> >Show My Cart</a>

<h2>Welcome ${name}</h2>
<table border="1" style="width:800px">
<tr>

<td><h2>productname</h2></td>
<td><h2>description</h2></td>
<td><h2>price</h2></td>
<td><h2>quantity</h2></td>
<td><h2>seller's id</h2></td>
<td><h2>seller's address</h2></td>
<td><h2>seller's emailid</h2></td>
</tr>
<%String productname[]=(String[])request.getAttribute("productname"); %>
<%String discription[]=(String[])request.getAttribute("discription"); %>
<%String price[]=(String[])request.getAttribute("price"); %>
<%String quantity[]=(String[])request.getAttribute("quantity"); %>
<%String sellername[]=(String[])request.getAttribute("sellername"); %>
<%String selleraddress[]=(String[])request.getAttribute("selleraddress"); %>
<%String selleremailid[]=(String[])request.getAttribute("selleremailid"); %>

<%for(int i = 0 ; i <productname.length ; i++){ %>
<%if(quantity[i].equals("0")){continue;} %>
<tr>
            <td><%= productname[i] %></td>
            <td><%= discription[i] %></td>
            <td><%= price[i] %></td>
            <td><%= quantity[i] %></td>
            <td><%= sellername[i] %></td>
            <td><%= selleraddress[i] %></td>
            <td><%= selleremailid[i] %></td> 
            <% String linkToAddToCart = "/EbayClient/addtocart?"+productname[i]; %>
            <%if (Integer.parseInt(quantity[i]) > 0){%>
            	<td><a href = <%=linkToAddToCart  %>>Add to Cart</a></td>	
            <% }else{ %>
   <!--          <%ServicesProxy proxy = new ServicesProxy(); %>
            <% String result = proxy.deleteproduct(productname[i]);%>
            --> 
            <%} %>
            
</tr>

<% } %>
</table>
</body>
</html>