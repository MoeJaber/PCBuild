package search;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.ScoreDoc;

import search.SearchSet;

public class SearchServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		final String url = "jdbc:mysql://us-cdbr-azure-east-a.cloudapp.net:3306/";  
        final String dbName = "web app testing"; 
        final String driver = "com.mysql.jdbc.Driver";  
        final String dbUserName = "b8ebfad0623483";  
        final String dbPassword = "b8df9f4f";  
        
		HttpSession session = request.getSession ();
		SearchSet search = null;
		
		/**
		 * List of fields to search for now, TODO: implement checkboxes later
		 */
		final String [] FIELDS = {"model", "name"};
		
		if (request.getAttribute ("search") == null)
			return;
		
		if (session.getAttribute ("searchSet") == null)
		{
			search = new SearchSet (url, dbName, driver, dbUserName, dbPassword);
			session.setAttribute ("searchSet", search);
		}
		else
		{
			search = (SearchSet) session.getAttribute ("search");
		}
		
		String searchText = (String) request.getAttribute ("search");
		
		ScoreDoc [] results = null;
		try 
		{
			results = search.search (FIELDS, searchText);
		} 
		catch (ParseException e) 
		{
			e.printStackTrace ();
		}
		session.setAttribute ("searchResults", results);
		
		request.getRequestDispatcher ("search.jsp").forward (request, response);
	}
}
