<%@page import="test.CustomerBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
CustomerBean cb = (CustomerBean)session.getAttribute("cbean");
out.println("Page belongs to Customer  : "+cb.getCname());
%>
<br>
<a href="Profile.jsp">View Profile</a>
<a href="customerViewProducts">View Products</a>
<a href="">Logout</a>
</body>
</html>
