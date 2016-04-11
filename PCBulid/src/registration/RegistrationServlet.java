/**
 * Web Application Programming 2016: Prestige Computers
 * Algonquin College
 * 
 * - Kieran Gillibrand
 * - Moe Jaber
 * - Nick Horlings
 */

package registration;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbconstants.DBConstants;
import user.User;

/**
 * Servlet that registers a user
 * @author Kieran Gillibrand, Student 040-756-866
 * @see HttpServlet
 */
public class RegistrationServlet extends HttpServlet
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
		if (request.getParameter ("first_name") == null || request.getParameter ("last_name") == null || request.getParameter ("email") == null || request.getParameter ("password") == null || request.getParameter ("password_confirm") == null)
			return;
		
		final String firstName = request.getParameter ("first_name");
		final String lastName = request.getParameter ("last_name");
		final String email = request.getParameter ("email");
		final String password = request.getParameter ("password");
		final String passwordConfirm = request.getParameter ("password_confirmation");
		
		//Check password confirmation match
		if (!password.equals (passwordConfirm))
			return;
		
		HttpSession session = request.getSession ();
		
		//Check if user is already logged in
		if (session.getAttribute ("user") != null)
        	return;
		
		try
        {
			Class.forName (DBConstants.DRIVER).newInstance ();
			Connection connection = DriverManager.getConnection (DBConstants.URL, DBConstants.DB_USER_NAME, DBConstants.DB_PASSWORD);  
            
            SecureRandom random = new SecureRandom ();
            byte [] salt = new byte [16];
            
            random.nextBytes (salt);
            KeySpec spec = new PBEKeySpec (password.toCharArray (), salt, 65536, 128);
            
            SecretKeyFactory factory = SecretKeyFactory.getInstance ("PBEWithSHA1AndDESede");
    		
    		byte [] hash = factory.generateSecret (spec).getEncoded ();
    		
    		//Insert new user
    		PreparedStatement insert = connection.prepareStatement ("Insert into users (firstname, lastname, email, password, salt, isAdmin) values (?, ?, ?, ?, ?, ?)");  
            insert.setString (1, firstName);  
            insert.setString (2, lastName);  
            insert.setString (3, email);  
            insert.setBytes (4, hash);
            insert.setBytes (5, salt);
            insert.setBoolean (6, false); //Not admin by default
  
            insert.execute ();  
            
            session.setAttribute ("user", new User (email, firstName, lastName));
            
            RequestDispatcher dispatcher = request.getRequestDispatcher ("index.jsp");    
    		dispatcher.include (request, response);    
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
		catch (NoSuchAlgorithmException e1) 
		{
			e1.printStackTrace ();
		}
		catch (InvalidKeySpecException e1) 
		{
			e1.printStackTrace ();
		}
	}
}
