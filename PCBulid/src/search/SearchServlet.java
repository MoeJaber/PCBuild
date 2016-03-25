package search;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.lucene.document.Document;

import search.SearchSet;

public class SearchServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
    	final String url = "jdbc:mysql://us-cdbr-azure-east-a.cloudapp.net/";  
        final String dbName = "web app testing"; 
        final String driver = "com.mysql.jdbc.Driver";  
        final String dbUserName = "b8ebfad0623483";  
        final String dbPassword = "b8df9f4f";  
        
		HttpSession session = request.getSession ();
		SearchSet searchSet = null;
		
		/**
		 * List of fields to search for now, implement checkboxes later
		 */
		final String [] FIELDS = {"model", "name"};
		
		if (request.getParameter ("search") == null)
			return;
		
		if (session.getAttribute ("searchSet") == null)
		{
			searchSet = new SearchSet (url, dbName, driver, dbUserName, dbPassword);
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
