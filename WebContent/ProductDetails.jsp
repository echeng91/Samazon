<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="model.Product" %>
<%@ page import="model.User" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map.Entry" %>
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
<% if(session.getAttribute("loggedin").equals("yes")) {%>
body {
background-color: turquoise
}
<% } %>
</style>
</head>
<body>
<% if(session.getAttribute("loggedin").equals("yes")) {%>
	<strong>Hello, <%= ((User)session.getAttribute("user")).getUsername() %></strong><br>
	<% HashMap<Product, Integer> checkCart = (HashMap<Product, Integer>) session.getAttribute("cart");
		int numberOfItems = 0;
		for(Entry<Product, Integer> entry : checkCart.entrySet()) {
			numberOfItems += entry.getValue();
		}%>
	<form action="ShoppingCart.jsp">
		<input type="submit" value="View shopping cart (<%=numberOfItems %>)">
	</form>
	<% } else {%>
	<form action="index.html">
		<input type="submit" value="Login">
	</form>
	<% } %>

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
	<% if(session.getAttribute("loggedin").equals("yes")) {%>
	<form action="CartProduct" method="post">
		<input type="hidden" name="prodid" value="${detailedproduct.pid}">
		<input type="number" name="quantity" min="0" max="10"> <input
			type="submit" value="Add to Cart">
	</form>
	<% } %>
	<form action="ListProducts" method="post">
		<input type="hidden" name="newmap" value="no"> <input
			type="submit" value="Return to product list">
	</form>
	<% if(session.getAttribute("loggedin").equals("yes")) {%>
	<form action="ShoppingCart.jsp">
		<input type="submit" value="View shopping cart">
	</form>
	<% } else {%>
	<form action="index.html">
		<input type="submit" value="Login">
	</form>
	<% } %>
</body>
</html>