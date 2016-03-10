package cart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cart.Cart;

public class CreateCartServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession ();
		
		if (session.getAttribute ("cart") != null)
			return;
		
		session.setAttribute ("cart", new Cart ());
		
		request.getRequestDispatcher ("cart.jsp").forward (request, response);
	}
}
