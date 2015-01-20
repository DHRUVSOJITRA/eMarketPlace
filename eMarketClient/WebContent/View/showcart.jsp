<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>${name}' Shopping cart</h2>
<table border="1" style="width:800px">
<tr>


<td><h2>productname</h2></td>
<td><h2>discription</h2></td>
<td><h2>price</h2></td>
<td><h2>seller's id</h2></td>
<td><h2>seller's address</h2></td>
<td><h2>seller's emailid</h2></td>
</tr>
<%String productname[]= (String[])request.getAttribute("productname"); %>
<%String discription[]= (String[])request.getAttribute("discription");  %>
<%String price[]= (String[])request.getAttribute("price"); %>
<%String sellername[]=(String[])request.getAttribute("sellerid"); %>
<%String selleraddress[]=(String[])request.getAttribute("selleraddress"); %>
<%String selleremailid[]=(String[])request.getAttribute("selleremailid"); %>


<%for(int i = 0 ; i <productname.length ; i++){ %>

<tr>
            <td><%= productname[i] %></td>
            <td><%= discription[i] %></td>
            <td><%= price[i] %></td>
            <td><%= sellername[i] %></td>
            <td><%= selleraddress[i] %></td>
            <td><%= selleremailid[i]%></td>
            <% String deleteFromCart = "/EbayClient/deletefromcart?"+productname[i]; %>
            <td><a href=<%=deleteFromCart %>>Delete this item from cart</a></td>
            
         
</tr>

<% } %>
</table>
<form action="checkout" method="post">
<input type="submit" value="CheckOut">
</body>
</html>