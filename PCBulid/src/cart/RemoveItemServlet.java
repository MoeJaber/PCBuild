package cart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RemoveItemServlet extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3065125857152934741L;

	public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession ();
	
		if (session.getAttribute ("cart") == null || request.getParameter ("index") == null)
			return;
	
		final int itemIndex = (int) Integer.parseInt(request.getParameter ("index"));
		
		((Cart) session.getAttribute ("cart")).removeItem (itemIndex);
		
		request.getRequestDispatcher ("cart.jsp").forward (request, response);
	}
}
