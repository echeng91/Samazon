<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Order Confirmation</title>
</head>
<body>
	Order Total: <c:out value="${checkouttotal}" />

	<form action="ListProducts" method="post">
		<input type="hidden" name="newmap" value="no"> <input
			type="submit" value="Go to product list">
	</form>
	<form action="ShoppingCart.jsp">
		<input type="submit" value="Return shopping cart">
	</form>
</body>
</html>