<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "test.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
AdminBean ab = (AdminBean)session.getAttribute("abean");
String msg = (String)request.getAttribute("msg");
out.println("Page belongs to admin : "+ab.getfName()+"<br>"+msg+"<br>");
%>
<a href="Product.html">AddProduct</a>
<a href="viewAllProducts">ViewAllProducts</a>
<a href="logout">LogOut</a>

</body>
</html>


