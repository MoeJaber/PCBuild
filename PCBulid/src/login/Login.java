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

  
public class Login 
{  
    public static ResultSet validate (String userEmail, String userPassword, Connection connection) 
    {          
        PreparedStatement select = null;  
        ResultSet results = null;
        byte [] salt = null;
        
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
        
        try 
        {  
            select = connection.prepareStatement ("select * from users where email = ? and password = ?");  
            select.setString (1, userEmail);  
            select.setBytes (2, hash);
  
            results = select.executeQuery ();  
        } 
        catch (Exception e) 
        {  
            System.out.println (e);  
        } 
        return results;  
    }  
} 