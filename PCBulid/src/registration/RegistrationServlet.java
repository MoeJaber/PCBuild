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

import user.User;

public class RegistrationServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		final String firstName = request.getParameter ("first_name");
		final String lastName = request.getParameter ("last_name");
		final String email = request.getParameter ("email");
		final String emailConfirm = request.getParameter ("email");
		final String password = request.getParameter ("password");
		final String passwordConfirm = request.getParameter ("password_confirmation");
		
		/**
		 * TODO: Implement validator instead
		 */
		if (!email.equals (emailConfirm))
			return;
		
		if (!password.equals (passwordConfirm))
			return;
		
		HttpSession session = request.getSession ();
		
		if (session.getAttribute ("user") != null)
        	return;
		
		try
        {
			final String url = "jdbc:mysql://us-cdbr-azure-east-a.cloudapp.net:3306/";  
	        final String dbName = "web app testing"; 
	        final String driver = "com.mysql.jdbc.Driver";  
	        final String dbUserName = "b8ebfad0623483";  
	        final String dbPassword = "b8df9f4f";  
            
        	Class.forName (driver).newInstance ();  
            Connection connection = DriverManager.getConnection (url + dbName, dbUserName, dbPassword);  
            
            SecureRandom random = new SecureRandom ();
            byte [] salt = new byte [16];
            
            random.nextBytes (salt);
            KeySpec spec = new PBEKeySpec (password.toCharArray (), salt, 65536, 128);
            
            SecretKeyFactory factory = SecretKeyFactory.getInstance ("PBEWithSHA1AndDESede");
    		
    		byte [] hash = factory.generateSecret (spec).getEncoded ();
    		
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
