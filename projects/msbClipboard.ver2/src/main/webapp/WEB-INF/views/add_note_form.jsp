<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./basebootstrap40.jsp" %>
</head>
<body>
	<!-- 
	<h1>Create A New Note Here</h1><br><br>
	<form action="add_note" method="post">
		<!-- Enter userID : <input type="text" name="uid" > 		
		Enter username : <input type="text" name="uname" ><br>		
		Enter note title : <input type="text" name="noteTitle" ><br>		
		Enter note text : <input type="text" name="noteBody" ><br>
		
		<input type="submit" value=" (+) Create Note Now ">
	</form>
	
	<!-- code to index 
	<a href="dashboard.jsp">-> Back To Dashboard</a>
	 -->
	 
	<div class="container mt-3">
    <div class="row">
        <div class="col-md-6 offset-md-3">
             <h1 class="text-center mb-3">Fill the product detail</h1>
             <form action="handle-note" method="post">
                 <div class="form-group">
                     <label for="name">Product Name</label> <input type="text"
                          class="form-control" id="name" aria-describedby="emailHelp"
                          name="name" placeholder="Enter the product name here">
                 </div>
                 <div class="form-group">
                     <label for="description">Product Description</label>
                     <textarea class="form-control" name="description" id="description"
                          rows="5" placeholder="Enter the product description"></textarea>
                 </div>
                 
                 <div class="form-group">
    				<label for="price">Product Price</label> <input type="text"
        				placeholder="Enter Product Price" name="price"
        				class="form-control" id="price">
				</div>
				
				<div class="container text-center">
    				<a href="${pageContext.request.contextPath }/"
        				class="btn btn-outline-danger">Back</a>
    				<button type="submit" class="btn btn-primary">Add</button>
				</div>
			</form>
	 
</body>
</html>