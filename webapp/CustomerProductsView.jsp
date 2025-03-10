<%@page import="test.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Products</title>
</head>
<body>
<%
CustomerBean cb = (CustomerBean)session.getAttribute("cbean");
ArrayList<ProductBean> al = (ArrayList<ProductBean>)session.getAttribute("al");
out.println("Page belongs to Customer : "+cb.getCname()+"<br>");

if(al.size()==0)
{
	out.println("Products not avaliable");
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
					"<a href='buy?pcode="+pb.getCode()+"'>Buy</a>"+"<br>"
				);
	}
}
%>
</body>
</html>