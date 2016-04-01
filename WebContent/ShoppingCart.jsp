<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="model.Product" %>
<%@ page import="java.util.Map.Entry" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Shopping Cart</title>
</head>
<body>
	<table>
		<tr>
			<th>Name</th>
			<th>Quantity</th>
			<th>Unit Price</th>
			<th>Total Price</th>
		</tr>
		<c:forEach items="${cart}" var="prod">
			<tr>
				<td><c:out value="${prod.key.pname}" /></td>
				<td><c:out value="${prod.value}" /></td>
				<% 
					double price = ((Product)(((Entry<Product, Integer>)pageContext.getAttribute("prod")).getKey())).getPprice().doubleValue();
					int quantity = ((Entry<Product, Integer>)pageContext.getAttribute("prod")).getValue(); 
				%>
				<td><%= NumberFormat.getCurrencyInstance().format(price) %></td>
				<td><%= NumberFormat.getCurrencyInstance().format(price * quantity) %></td>
				<td><fmt:formatNumber type="currency" value="${prod.key.pprice * prod.value}" /></td>
			</tr>
		</c:forEach>
	</table>
	<form action="ListProducts" method="post">
		<input type="hidden" name="newmap" value="no"> <input
			type="submit" value="Go to product list">
	</form>
	<form action="Checkout" method="post">
		<input type="submit" value="Checkout">
	</form>
</body>
</html>