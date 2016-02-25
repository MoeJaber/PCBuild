package login;  
  
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException;
import java.util.Random;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;  
  
public class Login 
{  
    public static ResultSet validate (String userEmail, String userPassword) 
    {          
        Connection connection = null;  
        PreparedStatement select = null;  
        ResultSet results = null;  
  
        String url = "jdbc:mysql://localhost:3306/";  
        String dbName = "Prestige Computers";  
        String driver = "com.mysql.jdbc.Driver";  
        String userName = "root";  
        String password = "admin";  
        
        Random random = new Random ();
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
            Class.forName (driver).newInstance ();  
            connection = DriverManager.getConnection (url + dbName, userName, password);  
  
            select = connection.prepareStatement ("select * from login where user=? and password=?");  
            select.setString (1, userEmail);  
            select.setBytes (2, hash);
  
            results = select.executeQuery ();  
        } 
        catch (Exception e) 
        {  
            System.out.println (e);  
        } 
        finally 
        {  
            if (connection != null) 
            {  
                try 
                {  
                    connection.close ();  
                } 
                catch (SQLException e) 
                {  
                    e.printStackTrace ();  
                }  
            }  
            if (select != null) 
            {  
                try 
                {  
                    select.close ();  
                } catch (SQLException e) 
                {  
                    e.printStackTrace ();  
                }  
            }  
            if (results != null) 
            {  
                try 
                {  
                    results.close ();  
                } 
                catch (SQLException e) 
                {  
                    e.printStackTrace ();  
                }  
            }  
        }  
        return results;  
    }  
} 