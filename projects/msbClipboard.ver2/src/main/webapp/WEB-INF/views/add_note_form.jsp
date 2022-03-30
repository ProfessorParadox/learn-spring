<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create A New Note</title>
</head>
<body>
	<h1>Create A New Note Here</h1><br><br>
	<form action="add_note" method="post">
		<!-- Enter userID : <input type="text" name="uid" >  -->		
		Enter username : <input type="text" name="uname" ><br>		
		Enter note title : <input type="text" name="noteTitle" ><br>		
		Enter note text : <input type="text" name="noteBody" ><br>
		
		<input type="submit" value=" (+) Create Note Now ">
	</form>
	
	<!-- code to index -->
	<a href="dashboard.jsp">--> Back To Dashboard</a>
</body>
</html>