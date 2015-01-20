<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>categories</title>
</head>
<body>
<% String linkTocart = "/EbayClient/showcart"; %>
<a href = <%=linkTocart %> >Show My Cart</a>
<h2>Welcome ${username}</h2>
<h3>Last time logged in ${date}</h3>
<a href ="/EbayClient/signout"><h3>sign out</h3></a>
<a href ="/EbayClient/showpastactivities"><h3>show past activities</h3></a>
<table border="1" style="width:800px">

<%String categoryname[]=(String[])request.getAttribute("categoriesToSend"); %>


<%for(int i = 0 ; i <categoryname.length ; i++){ %>
<% String linkToProducts = "/EbayClient/products?"+categoryname[i]; %>

<tr><a href = <%=linkToProducts %> ><%= categoryname[i] %></a></tr>
<% } %>

</table>
</body>
</html>