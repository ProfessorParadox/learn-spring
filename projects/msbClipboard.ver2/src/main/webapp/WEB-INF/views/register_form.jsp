<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Page</title>
</head>
<body>
	<br>
	<h1>MSB Clipboard Web App</h1><br>
	<h2>New User Register Here</h2><br><br>
	
	<form action="register" method="post">
		<!-- Enter userID : <input type="text" name="uid" >  -->
		Enter email : <input type="email" name="umail" ><br>
		Enter username : <input type="text" name="uname" ><br>
		Enter password : <input type="password" name="pass" ><br>
		<input type="submit" value=" Sign Up Now ">
	</form>
	
	<!-- code to index -->
	<a href="index.jsp">--> Back To Index</a>
	
</body>
</html>