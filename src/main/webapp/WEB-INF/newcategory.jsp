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
	<h1>New Category</h1>
	<form action="/add/category" method="POST">
		<label for="category">Category</label>
		<input type="text" name="name" id="name" />
		
		<button type="submit">Create</button>
	</form>
</body>
</html>