/**
 * Web Application Programming 2016: Prestige Computers
 * Algonquin College
 * 
 * - Kieran Gillibrand
 * - Moe Jaber
 * - Nick Horlings
 */

package search;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.lucene.document.Document;

import dbconstants.DBConstants;
import search.SearchSet;

/**
 * Servlet that registers a user
 * @author Kieran Gillibrand, Student 040-756-866
 * @see HttpServlet
 */
public class SearchServlet extends HttpServlet
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
		SearchSet searchSet = null;
		
		/**
		 * List of fields to search for now, implement checkboxes later
		 */
		final String [] FIELDS = {"model", "name", "price", "brand", "series", "modelnum", "type", "capacity", "interface"};
		
		if (request.getParameter ("search") == null)
			return;
		
		if (session.getAttribute ("searchSet") == null)
		{
			searchSet = new SearchSet (DBConstants.URL, DBConstants.DRIVER, DBConstants.DB_USER_NAME, DBConstants.DB_PASSWORD);
			session.setAttribute ("searchSet", searchSet);
		}
		else
		{
			searchSet = (SearchSet) session.getAttribute ("searchSet");
		}
		
		String searchText = (String) request.getParameter ("search");
		
		ArrayList <Document> results = null;
		
		results = searchSet.search (FIELDS, searchText);
		
		session.setAttribute ("searchResults", results);
		
		request.getRequestDispatcher ("search.jsp").forward (request, response);
	}
}
