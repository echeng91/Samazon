<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="model.Product" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Product Details</title>
<style>
table, tr, td {
	border: 1px solid black
}
</style>
</head>
<body>
	<img src="${detailedproduct.pimgurl}" height="400">
	<table>
		<tr>
			<td>Product ID</td>
			<td><c:out value="${detailedproduct.pid}" /></td>
		</tr>
		<tr>
			<td>Product Name</td>
			<td><c:out value="${detailedproduct.pname}" /></td>
		</tr>
		<tr>
			<td>Product Description</td>
			<td><c:out value="${detailedproduct.pdescription}" /></td>
		</tr>
		<tr>
			<td>Price</td>
			<td><%= NumberFormat.getCurrencyInstance().format(((Product)request.getAttribute("detailedproduct")).getPprice()) %></td>
		</tr>
	</table>
	<form action="CartProduct" method="post">
		<input type="hidden" name="prodid" value="${detailedproduct.pid}">
		<input type="number" name="quantity" min="0" max="10"> <input
			type="submit" value="Add to Cart">
	</form>
	<form action="ListProducts" method="post">
		<input type="hidden" name="newmap" value="no"> <input
			type="submit" value="Return to product list">
	</form>
	<form action="ShoppingCart.jsp">
		<input type="submit" value="View shopping cart">
	</form>
</body>
</html>