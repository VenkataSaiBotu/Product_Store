package test;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/payment")
public class PaymentServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
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
			int reqQty = (Integer)hs.getAttribute("reqQty");
			
			if(pb.getQty() < reqQty)
			{
				req.setAttribute("msg", "Required quantity not avaliable,Avaliable quantity : "+pb.getQty());
				req.getRequestDispatcher("Msg.jsp").forward(req, res);
			}
			else
			{
				pb.setQty(pb.getQty()-reqQty);
				int k = new UpdateProductDAO().updateProduct(pb);
				if(k > 0)
				{
					req.setAttribute("msg", "Payment Sucessfull");
					req.getRequestDispatcher("PaymentSucess.jsp").forward(req, res);
				}
			}
		}
	}
}
