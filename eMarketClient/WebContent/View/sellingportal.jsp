<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>sellin portal</title>
</head>
<body>
<h2>Welcome ${username}</h2>
<a href ="/EbayClient/signout"><h3>sign out</h3></a>
<h3>please add precise adds to sell you product quickly</h3>
<table>
<form action="/EbayClient/View/addcategory.jsp" method = "get"> 
<input type="submit" value="addcategory" /> 
</form>
<form action="addproduct" method="post">
<h4>you can choose category from list...If its not there add a new one</h4>
<tr><td>item's category</td>


<td>
<%String categoryname[]=(String[])request.getAttribute("categoriesToSend"); %>
<select name="categories">
<%for(int i = 0 ; i <categoryname.length ; i++){ %>
  <option value=<%= categoryname[i] %>><%= categoryname[i] %></option>
<% } %>
</select></td>
<td></td>
</tr>
<tr><td>item's name</td><td><input type ="text" name="itemname" /></td></tr>
<tr><td>item's discription</td><td><input type ="text" name="itemdiscription" /></td></tr>
<tr><td>item's price</td><td><input type ="text" name="itemprice" /></td></tr>
<tr><td>item's quantity</td><td><input type ="text" name="itemquantity" /></td></tr>
<tr><td><h3>seller's information</h3></td></tr>
<tr><td>seller's ID</td><td><input type = "text" name="name" /></td></tr>
<tr><td>seller's address</td><td><input type = "text" name="address" /></td></tr>
<tr><td>seller's emailid</td><td><input type = "text" name="emailid" /></td></tr>
<tr><td><input type="submit" value="submit" /></td></tr>
</table>
</form>
<script type="text/javascript">
function addcategory(){
	window.location.replace("/EbayClient/View/addcategory.jsp");
}
</script>
</body>
</html>