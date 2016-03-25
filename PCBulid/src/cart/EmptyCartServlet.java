package cart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EmptyCartServlet extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7238864826840412472L;

	public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession ();
	
		if (session.getAttribute ("cart") == null)
			return;
		
		((Cart) session.getAttribute ("cart")).removeAllItems ();
		
		request.getRequestDispatcher ("cart.jsp").forward (request, response);
	}
}
