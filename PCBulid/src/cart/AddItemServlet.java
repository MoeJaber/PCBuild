package cart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cart.Cart;

public class AddItemServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession ();
		
		if (session.getAttribute ("cart") == null)
			return;
		
		/**
		 * TODO: Get the database id and item type (tablename) from the request
		 */
		int itemID = 0;
		String tableName = null;
		
		/**
		 * TODO: Get the item from the db, check the right table and create an Item object for it. Add it to the cart
		 */
		
		request.getRequestDispatcher ("cart.jsp").forward (request, response);
	}
}
