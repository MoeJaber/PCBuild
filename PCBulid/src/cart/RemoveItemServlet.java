package cart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RemoveItemServlet 
{
	public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession ();
	
		if (session.getAttribute ("cart") == null || request.getAttribute ("index") == null)
			return;
	
		final int itemIndex = (int) request.getAttribute ("index");
		
		((Cart) session.getAttribute ("cart")).removeItem (itemIndex);
		
		request.getRequestDispatcher ("cart.jsp").forward (request, response);
	}
}
