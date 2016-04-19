/**
 * Web Application Programming 2016: Prestige Computers
 * Algonquin College
 * 
 * - Kieran Gillibrand
 * - Moe Jaber
 * - Nick Horlings
 */

package login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet that logs out a user
 * @author Kieran Gillibrand, Student 040-756-866
 * @see HttpServlet
 */
public class LogoutServlet extends HttpServlet
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
	@Override
	public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession ();
		
		session.setAttribute ("user", null);
		session.invalidate ();
		
		response.sendRedirect (request.getContextPath () + "/" + "index.jsp");
	}
	
	/**
	 * Handles an HTTP get request
	 * 
	 * @param request The HTTP request
	 * @param response The HTTP response
	 * 
	 * @exception ServletException Bad things might happen
	 * @exception IOException Bad things might happen
	 * @author Kieran Gillibrand, Student: 040-756-866
	 */
	@Override
	public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.sendRedirect (request.getContextPath () + "/" + "index.jsp"); //Not implemented, redirect
	}
}
