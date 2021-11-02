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
	<h1>${category.getName()}</h1>
	<h2>Products</h2>
	<ul>
		<c:forEach items="${present}" var="product">
			<li>
				${product.getName()}
			</li>
		</c:forEach>
	</ul>
	<form action="/add/category/product/${category.getId()}" method="POST">
		<label for="add_product">Add product</label>
		<select name="product">
			<c:forEach items="${different}" var="productInfo">
				<option value="${productInfo.getId()}">
					${productInfo.getName()}
				</option>
			</c:forEach>
		</select>		

		<button type="submit">Add</button>
	</form>
</body>
</html>