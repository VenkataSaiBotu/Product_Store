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
@WebServlet("/buy")

public class BuyServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		HttpSession hs = req.getSession();
		if(hs == null)
		{
			req.setAttribute("msg", "Session expired");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else
		{
			ArrayList<ProductBean> al = (ArrayList<ProductBean>)hs.getAttribute("al");
			String pc = (String)req.getAttribute("pcode");
			Iterator<ProductBean> itr = al.iterator();
			
			while (itr.hasNext())
			{
				ProductBean pb = (ProductBean) itr.next();
				if(Integer.toString(pb.getCode()).equals(pc));
				{
					hs.setAttribute("pb", pb);
					req.getRequestDispatcher("Buy.jsp").forward(req, res);
					break;
				}
				
			}
		}
	}

}
