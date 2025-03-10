package test;

import java.io.IOException;
import java.util.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/generateBill")

public class GenerateBillServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		HttpSession hs = req.getSession(false);
		if(hs == null)
		{
			req.setAttribute("msg", "Session expired");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else
		{
			ProductBean pb = (ProductBean)hs.getAttribute("pb");
			int reqQty = Integer.parseInt(req.getParameter("reqQty"));
			float amt = pb.getPrice() * reqQty;
			hs.setAttribute("amt", amt);
			hs.setAttribute("reqQty", reqQty);
			req.getRequestDispatcher("Payment.jsp").forward(req, res);
		}
	}
}
