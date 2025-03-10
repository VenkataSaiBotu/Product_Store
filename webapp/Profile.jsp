<%@page import="test.CustomerBean"%>
<%@page import="java.lang.classfile.CustomAttribute"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile</title>
</head>
<body>
<%
CustomerBean cb = (CustomerBean)session.getAttribute("cbean");
out.println("CID : "+cb.getCid()+"<br>");
out.println("Name : "+cb.getCname()+"<br>");
out.println("City : "+cb.getCity()+"<br>");
out.println("Phone number : "+cb.getPhno()+"<br>");
out.println("Mail id : "+cb.getMid()+"<br>");
%>
<a href="">View Products</a>
<a href="">Logout</a>
</body>
</html>