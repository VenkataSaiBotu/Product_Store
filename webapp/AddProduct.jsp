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
out.println("Page belongs to Admin : "+ab.getfName()+" "+ab.getlName()+"<br>");
String msg = (String)request.getAttribute("msg");
out.println(msg);
%>
<a href="Product.html">Add Product</a>
<a href="viewAllProducts">View all products</a>
<a>Log out</a>
</body>
</html>