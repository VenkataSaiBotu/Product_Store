package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/update")

public class UpdateProductServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		HttpSession hs = req.getSession(false);
		if(hs == null)
		{
			req.setAttribute("msg", "Session Expired");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else
		{
			ArrayList<ProductBean> al = (ArrayList<ProductBean>)hs.getAttribute("al");
			Iterator<ProductBean> iterator = al.iterator();
			String pc = req.getParameter("pcode");
		
			
			while(iterator.hasNext())
			{
				ProductBean pb = iterator.next();
				if(pc.equals(Integer.toString(pb.getCode())))
				{
					pb.setPrice(Float.parseFloat(req.getParameter("price")));
					pb.setQty(Integer.parseInt(req.getParameter("qty")));
					int k = new UpdateProductDAO().updateProduct(pb);
					
					if(k>0)
					{
						req.setAttribute("msg", "Product updated Sucessfully....");
						req.getRequestDispatcher("UpdatedProduct.jsp").forward(req, res);
					}
					break;
				}
				
			}
		}
	}

}
