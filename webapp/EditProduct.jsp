<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "test.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UpdateProduct</title>
</head>
<body>
<%
AdminBean ab = (AdminBean)session.getAttribute("abean");
ProductBean pb = (ProductBean)request.getAttribute("pbean");
out.println("Page belongs to admin : "+ab.getfName()+"<br>");
%>
<form action="update" method="post">
<input type="hidden" name="pcode" value=<%=pb.getCode() %>>
<label>Product Price : </label>
<input type="text" name="price" value="<%=pb.getPrice() %>"><br>
<label>Product Quantity : </label>
<input type="text" name="qty" value="<%=pb.getQty() %>"><br>
<input type="submit" value="UpdateProduct">
</form>
</body>
</html>