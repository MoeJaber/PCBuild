package login;  
  
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.sql.Connection;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import com.sun.org.apache.xml.internal.security.utils.Base64;  
  
public class Login 
{  
    public static ResultSet validate (String userEmail, String userPassword, Connection connection) 
    {          
        PreparedStatement select = null;  
        ResultSet results = null;
        
        SecureRandom random = new SecureRandom ();
        byte [] salt = new byte [16];
        
        random.nextBytes (salt);
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
		
        byte[] hash = null;
        
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