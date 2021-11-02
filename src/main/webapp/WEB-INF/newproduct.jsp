<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products and categories</title>
</head>
<body>
	<h1>New Product</h1>
	<form action="/add" method="POST">
		<label for="product">Product</label>
		<input type="text" name="product" id="product" />
		
		<label for="description">Description</label>
		<textarea name="description" id="description"></textarea>
		
		<label for="price">Price</label>
		<input type=number step=0.01 name="price" id="price"/>
		<button type="submit">Create</button>
	</form>
</body>
</html>