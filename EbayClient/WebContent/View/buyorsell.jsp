<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>welcome page</title>
</head>
<body>
<h2>Welcome ${username}</h2>
<h3>Last time logged in ${date}</h3>
<a href ="/EbayClient/signout"><h3>sign out</h3></a>
<h3>you want to buy or sell</h3>
<input type="button" value="I want to buy" onclick="buyingportal()">
<input type="button" value="I want to sell" onclick="sellingingportal()">
<script type="text/javascript">
function buyingportal(){
  window.location.replace("/EbayClient/categories");
}

function sellingingportal(){
	  window.location.replace("/EbayClient/sellingportal");
	}

</script>
</body>
</html>