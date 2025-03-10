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
@WebServlet("/delete")

public class DeleteProductServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		HttpSession hs = req.getSession(false);
		if(hs == null)
		{
			req.setAttribute("msg", "Session Expired");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else
		{
			String pc = req.getParameter("pcode");
			ArrayList<ProductBean> al = (ArrayList<ProductBean>)hs.getAttribute("al");
			Iterator<ProductBean> iterator = al.iterator();
			
			while (iterator.hasNext()) 
			{
				ProductBean productBean = (ProductBean) iterator.next();
				if(pc.equals(Integer.toString(productBean.getCode())))
				{
					al.remove(productBean);
					int k = new DeleteProductDAO().deleteProduct(productBean);
					if(k>0)
					{
						req.setAttribute("msg", "Product deleted Sucessfully");
						req.getRequestDispatcher("ProductDeleted.jsp").forward(req, res);
					}
					
					break;
				}
				
			}
			
		}
	}

}
