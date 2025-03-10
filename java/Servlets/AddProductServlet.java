package test;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet("/addProduct")
public class AddProductServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		HttpSession hs = req.getSession(false);
		
		if(hs == null)
		{
			req.setAttribute("msg", "Session expired....<br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else
		{
			ProductBean pb = new ProductBean();
			pb.setCode(Integer.parseInt(req.getParameter("pcode")));
			pb.setName(req.getParameter("name"));
			pb.setPrice(Float.parseFloat(req.getParameter("price")));
			pb.setQty(Integer.parseInt(req.getParameter("qty")));
			
			int k = new AddProductDAO().addProduct(pb);
			
			if(k>0)
			{
				req.setAttribute("msg", "Product Added sucessfully...!!!<br>");
				req.getRequestDispatcher("AddProduct.jsp").forward(req, res);
			}
		}
	}
	

}
