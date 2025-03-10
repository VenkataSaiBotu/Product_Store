<%@page import="test.AdminBean"%>
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
String msg = (String)session.getAttribute("msg");
AdminBean ab = (AdminBean)session.getAttribute("abean");
out.println("Page belongs to Admin  : "+ab.getfName()+" "+ab.getlName()+"<br>"+msg);
%>
<a href="Product.html">AddProduct</a>
<a href="viewAllProducts">ViewAllProducts</a>
<a href="logout">LogOut</a>
</body>
</html>