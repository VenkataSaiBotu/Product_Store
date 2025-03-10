<%@page import="test.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Payment</title>
</head>
<body>
<%
CustomerBean cb = (CustomerBean)session.getAttribute("cbean");
ProductBean pb = (ProductBean)session.getAttribute("pb");
Float amt = (Float)session.getAttribute("amt");
Integer reqQty = (Integer)session.getAttribute("reqQty");
out.println("Page belongs to Customer : "+cb.getCname()+"<br>");
out.println("Name : "+pb.getName()+"<br>");
out.println("Required quantity : "+reqQty+"<br>");
out.println("Amount to be paid : "+amt+"<br>");
%>
<button><a href="payment">Pay</a></button>
</body>
</html>