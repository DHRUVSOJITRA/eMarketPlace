<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Up</title>
</head>
<body>
<form id="form1" method="post" action="http://localhost:8080/EbayClient/signup" > 

<table>

      <tr>First Name<input type="text" name="firstname" /></tr>   
      <tr>Last Name<input type="text" name="lastname" /></tr>    
      <tr>Email Id<input type="text" name="emailid" /></tr>    
      <tr>Password<input type="password" name="password" /></tr>   
      <tr><input class="submit" type="submit" value="Submit"></tr>   

</table> 
    <h2>${msg}</h2>  
</form> 
</body>
</html>