/**
 * Web Application Programming 2016: Prestige Computers
 * Algonquin College
 * 
 * - Kieran Gillibrand
 * - Moe Jaber
 * - Nick Horlings
 */

package cart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cart.Cart;

/**
 * Servlet that creates the cart in the session
 * @author Kieran Gillibrand, Student 040-756-866
 */
public class CreateCartServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	/**
	 * Handles an HTTP post request
	 * 
	 * @param request The HTTP request
	 * @param response The HTTP response
	 * 
	 * @exception ServletException Bad things might happen
	 * @exception IOException Bad things might happen
	 * @author Kieran Gillibrand, Student 040-756-866
	 */
	public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession ();
		
		if (session.getAttribute ("cart") != null)
			return;
		
		//Create the cart in the session
		session.setAttribute ("cart", new Cart ());
		
		request.getRequestDispatcher ("cart.jsp").forward (request, response);
	}
}
