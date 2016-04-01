<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.text.NumberFormat"%>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map.Entry" %>
<%@ page import="model.Product"%>
<%@ page import="model.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Product List</title>
<% if(session.getAttribute("loggedin").equals("yes")) {%>
<style>
body {
background-color: turquoise
}
</style>
<% } %>
</head>
<body>
	<% if(session.getAttribute("loggedin").equals("yes")) {%>
	<strong>Welcome, <%= ((User)session.getAttribute("user")).getUsername() %></strong><br>
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

	<table>
		<tr>
			<th>Name</th>
			<th>Price</th>
			<th>Details</th>
			<% if(session.getAttribute("loggedin").equals("yes")) {%>
			<th>Add to Cart</th>
			<% }%>
		</tr>
		<c:forEach items="${productlist}" var="prod">
			<tr>
				<td><c:out value="${prod.pname}" /></td>

				<td><%= NumberFormat.getCurrencyInstance().format(((Product)pageContext.getAttribute("prod")).getPprice()) %></td>
				<td>
					<form action="DetailProduct" method="post">
						<input type="hidden" name="prodid" value="${prod.pid}"> <input
							type="submit" value="Details">
					</form>
				</td>
				<% if(session.getAttribute("loggedin").equals("yes")) {%>
				<td>
					<form action="CartProduct" method="post">
						<input type="hidden" name="prodid" value="${prod.pid}"> <input
							type="number" name="quantity" min="0" max="10"> <input
							type="submit" value="Add to Cart">
					</form>
				</td>
				<% }%>
			</tr>
		</c:forEach>
	</table>
</body>
</html>