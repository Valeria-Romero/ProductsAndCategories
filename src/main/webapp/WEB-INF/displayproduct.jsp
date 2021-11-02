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
	<h1>${product.getName()}</h1>
	<h2>Categories</h2>
	<ul>
		<c:forEach items="${present}" var="category">
			<li>
				${category.getName()}
			</li>
		</c:forEach>
	</ul>
	<form action="/add/product/category/${product.getId()}" method="POST">
		<label for="add_category">Add category</label>
		<select name="category">
			<c:forEach items="${different}" var="categoryInfo">
				<option value="${categoryInfo.getId()}">
					${categoryInfo.getName()}
				</option>
			</c:forEach>
		</select>		

		<button type="submit">Add</button>
	</form>
</body>
</html>