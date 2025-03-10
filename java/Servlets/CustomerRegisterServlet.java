package test;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/register")

public class CustomerRegisterServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		CustomerBean cb = new CustomerBean();
		String phno = req.getParameter("phno");
		String name = req.getParameter("name");
		String city = req.getParameter("city");
		String mid = req.getParameter("mid");
		String cid = name.substring(0, 3).concat(phno.substring(6, 9));
		cb.setPhno(Long.parseLong(phno));
		cb.setCid(cid);
		cb.setCname(name);
		cb.setCity(city);
		cb.setMid(mid);
		int k = new CustomerRegisterDAO().registerCustomer(cb);
		if(k > 0)
		{
			req.setAttribute("msg", "Customer registered successfully");
			req.getRequestDispatcher("CustomerRegitered.jsp").forward(req, res);
		}
		else
		{
			req.setAttribute("msg", "Failed to register customer");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
	}
}
