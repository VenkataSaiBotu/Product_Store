<%@page import="test.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Buy</title>
</head>
<body>
<%
CustomerBean cb = (CustomerBean)session.getAttribute("cbean");
ProductBean pb = (ProductBean)session.getAttribute("pb");
out.println("Page belongs to Customer : "+cb.getCname()+"<br>");
%>
<form action="generateBill" method="post">
<label>Product details :</label><br>
<input type="hidden" name="pcode" value="<%=pb.getCode()%>">
<input type="hidden" name="avlQty" value="<%=pb.getQty()%>">
<label>Name : </label>
<input type="text" readonly="readonly" name="name" value="<%=pb.getName()%>"><br>
<label>Price : </label>
<input type="text" readonly="readonly" name="price" value="<%=pb.getPrice()%>"><br>
<label>Required quantity : </label>
<input type="number" name="reqQty"><br>
<input type="submit" value="Genrate Bill">
</form>
</body>
</html>