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
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;

import dbconstants.DBConstants;
import user.User;  

/**
 * Servlet that validates a user in order to login
 * @author Kieran Gillibrand, Student 040-756-866
 * @see HttpServlet
 */
public class LoginServlet extends HttpServlet
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
        response.setContentType ("text/html");    
        PrintWriter out = response.getWriter ();    
          
        String email = request.getParameter ("email");    
        String password = request.getParameter ("password");   
          
        HttpSession session = request.getSession ();  
        if(session != null)  
        	session.setAttribute ("email", email);  
        
        if (session.getAttribute ("user") != null)
        	return;
          
        try
        {
        	Class.forName (DBConstants.DRIVER).newInstance ();
			Connection connection = DriverManager.getConnection (DBConstants.URL, DBConstants.DB_USER_NAME, DBConstants.DB_PASSWORD);  
            
            ResultSet results = Login.validate (email, password, connection);
        	//Correct username/password
        	if (results.next ())
        	{ 
        		long id = results.getLong ("id");
				String firstName = results.getString ("firstname");
				String lastName = results.getString ("lastname");
				boolean isAdmin = results.getBoolean ("isAdmin");
				
	        	session.setAttribute ("user", new User (id, email, firstName, lastName, isAdmin));
        	
	        	//System.out.println ("User Logged In: " + ((User) session.getAttribute ("user")).toString ());
	        	session.setAttribute("warning", null);
	        	RequestDispatcher dispatcher = request.getRequestDispatcher ("index.jsp");    
	        	dispatcher.forward (request, response);    
        	}    
        	//Incorrect username/password shitty markup right now
        	else
        	{    
        		session.setAttribute("warning","Invalid username or password.");
        		RequestDispatcher dispatcher = request.getRequestDispatcher ("index.jsp");    
        		dispatcher.include (request, response);    
        	}   
        	results.close();
        	connection.close ();
        	out.close();  
        }
        catch (SQLException e)
        {
        	e.printStackTrace ();
        }
        catch (ClassNotFoundException e) 
        {
			e.printStackTrace();
		} 
        catch (InstantiationException e) 
        {
			e.printStackTrace();
		} 
        catch (IllegalAccessException e) 
        {
			e.printStackTrace();
		}
    }    
}   