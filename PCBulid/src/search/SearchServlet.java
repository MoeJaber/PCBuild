package search;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SearchServlet extends HttpServlet
{
private static final long serialVersionUID = 1L;
	
	public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession ();
		
		if (request.getAttribute ("") == null)
			return;
		
		String searchText = (String) request.getAttribute ("search");
		
		/**
		 * TODO: Get search results from database, build a SearchResultSet and put it in the session. Forward to search.jsp (new page?) and display the results. Maybe use Apache Lucene library for search https://lucene.apache.org/core/
		 */
		request.getRequestDispatcher ("search.jsp").forward (request, response);
	}
}
