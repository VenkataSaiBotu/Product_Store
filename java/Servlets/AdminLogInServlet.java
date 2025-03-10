package test;
import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/adminLogIn")

public class AdminLogInServlet extends HttpServlet
{
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		String uN = req.getParameter("uname");
		String pW = req.getParameter("pw");
		
		AdminBean ab = new AdminLoginDAO().logIn(uN, pW);
		
		if(ab==null)
		{
			
		}
		else
		{
			HttpSession hs = req.getSession();
			hs.setAttribute("abean", ab);
			RequestDispatcher rd = req.getRequestDispatcher("AdminLoginSuccess.jsp");
			rd.forward(req, res);
		}
	}

}
