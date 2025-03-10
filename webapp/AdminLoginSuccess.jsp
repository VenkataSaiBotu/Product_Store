<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="test.AdminBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
AdminBean ab = (AdminBean)session.getAttribute("abean");
out.println("Welcom Admin, "+ab.getfName()+" "+ab.getlName()+"<br>");
%>
<a href="Product.html">Add Product</a>
<a href="viewAllProducts">View all products</a>
<a href="logout">Log out</a>
</body>
</html>