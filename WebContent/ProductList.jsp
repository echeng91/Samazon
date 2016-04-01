<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="model.Product" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Product List</title>
</head>
<body>
	<table>
		<tr>
			<th>Name</th>
			<th>Price</th>
			<th>Details</th>
			<th>Add to Cart</th>
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
				<td>
					<form action="CartProduct" method="post">
						<input type="hidden" name="prodid" value="${prod.pid}">
						<input type="number" name="quantity" min="0" max="10">
						<input type="submit" value="Add to Cart">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
	<form action="ShoppingCart.jsp">
		<input type="submit" value="View shopping cart">
	</form>
</body>
</html>