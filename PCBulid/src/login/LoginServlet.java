package login;  
  
import java.io.IOException;  
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.DriverManager;  

import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;


import user.User;  
  
public class LoginServlet extends HttpServlet
{  
    private static final long serialVersionUID = 1L;  
  
    public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {    
        response.setContentType ("text/html");    
        PrintWriter out = response.getWriter ();    
          
        String email = request.getParameter ("email");    
        String password = request.getParameter ("password");   
          
        HttpSession session = request.getSession ();  
        if(session != null)  
        	session.setAttribute ("email", email);  
  
        System.out.println ("In LoginServlet, Email: " + email + ", Password: " + password);
        
        try
        {
        	String url = "jdbc:mysql://localhost:3306/";  
            String dbName = "PrestigeComputers"; 
            String driver = "com.mysql.jdbc.Driver";  
            String dbUserName = "root";  
            String dbPassword = "";  
            
        	Class.forName (driver).newInstance ();  
            Connection connection = DriverManager.getConnection (url + dbName, dbUserName, dbPassword);  
            
            ResultSet results = Login.validate (email, password, connection);
        	//Correct username/password
        	if (results.next ())
        	{ 
				String firstName = results.getString ("firstname");
				String lastName = results.getString ("lastname");
	        	Timestamp created = results.getTimestamp ("created");
			
	        	session.setAttribute ("user", new User (email, firstName, lastName, created));
        	
	        	System.out.println ("User Logged In: " + ((User) session.getAttribute ("user")).toString ());
	        	
	        	RequestDispatcher dispatcher = request.getRequestDispatcher ("welcome.jsp");    
	        	dispatcher.forward (request, response);    
        	}    
        	//Incorrect username/password shitty markup right now
        	else
        	{    
        		out.print ("<p style=\"color:red\">Sorry username or password error</p>");    
        		RequestDispatcher dispatcher = request.getRequestDispatcher ("index.jsp");    
        		dispatcher.include (request, response);    
        	}   
        	results.close();
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