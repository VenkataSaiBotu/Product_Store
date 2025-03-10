<%@page import="test.CustomerBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Success</title>
</head>
<body>
<%
CustomerBean cb = (CustomerBean)session.getAttribute("cbean");
String msg = (String)request.getAttribute("msg");
out.println("Page belongs to Customer : "+cb.getCname()+"<br>");
out.println(msg+"<br>");
%>
<a href="Profile.jsp">View Profile</a>
<a href="">View All Products</a>
<a href="">LogOut</a>
</body>
</html>
