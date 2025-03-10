package test;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/login")
public class CustomerLoginServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		String phno = req.getParameter("phno");
		CustomerBean cb = new CustomerLoginDAO().customerLogin(phno);
		
			if(cb == null)
			{
				req.setAttribute("msg", "Session Expired");
				req.getRequestDispatcher("Msg.jsp").forward(req, res);
			}
			else
			{
				HttpSession hs = req.getSession();
				hs.setAttribute("cbean", cb);
				req.getRequestDispatcher("CustomerLoginSucess.jsp").forward(req, res);	
			}
	}
}
