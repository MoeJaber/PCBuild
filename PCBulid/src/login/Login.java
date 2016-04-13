/**
 * Web Application Programming 2016: Prestige Computers
 * Algonquin College
 * 
 * - Kieran Gillibrand
 * - Moe Jaber
 * - Nick Horlings
 */

package login;  
  
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.sql.Connection;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 * Static class that contains the login method
 * @author Kieran Gillibrand, Student 040-756-866
 * @see Login.validate
 */
public class Login 
{  
	/**
	 * Static method that validates a user
	 * @author Kieran Gillibrand, Student 040-756-866
	 * @param userEmail The given email from the user
	 * @param userPassword The given password from the user
	 * @param connection The open database connection to use
	 * @return The ResultSet of any results from the database query
	 * @exception SQLException If an sql error occurs
	 * @exception IllegalArgumentException If any parameters are null or the database connection is not open
	 */
    public static ResultSet validate (String userEmail, String userPassword, Connection connection) throws SQLException, IllegalArgumentException
    {          
    	if (userEmail == null || userPassword == null || connection == null)
    		throw new IllegalArgumentException ();
    	
    	if (connection.isClosed ())
    		throw new IllegalArgumentException ();
    	
        PreparedStatement select = null;  
        ResultSet results = null;
        byte [] salt = null;
        
        
        //Get salt
        try 
        {
			PreparedStatement selectSalt = connection.prepareStatement ("Select salt from users where email = ?");
			selectSalt.setString (1, userEmail);
			ResultSet saltResults = selectSalt.executeQuery ();
			
			if (!saltResults.next ())
				return saltResults;
			
			salt = saltResults.getBytes ("salt");
		} 
        catch (SQLException e2) 
        {
			e2.printStackTrace();
		}
        
        //Hash with salt
        KeySpec spec = new PBEKeySpec (userPassword.toCharArray (), salt, 65536, 128);
        SecretKeyFactory factory = null;
        
		try 
		{
			factory = SecretKeyFactory.getInstance ("PBEWithSHA1AndDESede");
		} 
		catch (NoSuchAlgorithmException e1) 
		{
			e1.printStackTrace ();
		}
		
        byte [] hash = null;
        
		try 
		{
			hash = factory.generateSecret (spec).getEncoded ();
		} 
		catch (InvalidKeySpecException e1) 
		{
			e1.printStackTrace ();
		}
        
		//Get any users which match
        try 
        {  
            select = connection.prepareStatement ("select * from users where email = ? and password = ?");  
            select.setString (1, userEmail);  
            select.setBytes (2, hash);
  
            results = select.executeQuery ();  
            select.close ();
        } 
        catch (Exception e) 
        {  
            System.out.println (e);  
        } 
        return results;  
    }  
} 