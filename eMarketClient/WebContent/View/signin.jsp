<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign In</title>
</head>
<body>
${msg}

<form id="form1" method="post" action="http://localhost:8080/EbayClient/signin" >  
      Email Id<input type="text" name="emailid" /> 
      Password<input type="password" name="pass" />
      <input class="submit" type="submit" value="Submit">
      
</form> 
<h2>Please singup to use the web site</h2>
<input type = "button" value = "SignUp" onclick = "link()" >
</body>
<script type="text/javascript">
function link(){
	window.location.replace("/EbayClient/View/signup.jsp");
}
</script>
</html>