<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "test.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Products</title>
</head>
<body>
<%
AdminBean ab = (AdminBean)session.getAttribute("abean");
ArrayList<ProductBean> al = (ArrayList<ProductBean>)session.getAttribute("al");
out.println("Page belongs to admin :"+ab.getfName()+"<br>");
if(al.size() == 0)
{
	out.println("Products not available");
}
else
{
	Iterator<ProductBean> itr = al.iterator();
	
	while(itr.hasNext())
	{
		ProductBean pb = (ProductBean)itr.next();
		out.println(pb.getCode()+"&nbsp&nbsp"+
					pb.getName()+"&nbsp&nbsp"+
					pb.getPrice()+"&nbsp&nbsp"+
					pb.getQty()+"&nbsp&nbsp"+
					"<a href='edit?pcode="+pb.getCode()+"'>Edit</a>"+"&nbsp&nbsp"+
					"<a href='delete?pcode="+pb.getCode()+"'>Delete</a>"+"<br>"	
				);
	}
}
%>
<a href = "Product.html">Add Product</a>
<a href="logout">Logout</a>
</body>
</html>