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
@WebServlet("/edit")
public class EditProductServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		HttpSession hs = req.getSession(false);
		if(hs==null)
		{
			req.setAttribute("msg", "Session Expired");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else
		{
			ArrayList<ProductBean> al = new ViewAllProductsDAO().getProducts();
			String pc = req.getParameter("pcode");
			Iterator<ProductBean> iterator = al.iterator();
			
			while (iterator.hasNext()) 
			{
				ProductBean productBean = (ProductBean) iterator.next();
				if(Integer.toString(productBean.getCode()).equals(pc))
				{
					req.setAttribute("pbean", productBean);
					req.getRequestDispatcher("EditProduct.jsp").forward(req, res);
					break;
				}
				
			}
		}
	}

}
