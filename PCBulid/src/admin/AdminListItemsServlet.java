/**
 * Web Application Programming 2016: Prestige Computers
 * Algonquin College
 * 
 * - Kieran Gillibrand
 * - Moe Jaber
 * - Nick Horlings
 */

package admin;

import java.io.IOException;
import java.security.InvalidParameterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cart.Item;
import dbconstants.DBConstants;

/**
 * Servlet that adds all items to a list that is displayed on the admin page
 * @author Kieran Gillibrand, Student: 040-756-866
 */
public class AdminListItemsServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * Private method that adds all items to the list
	 * @param items The ArrayList <Item> to add to
	 * @param url The database url to use
	 * @param driver The database driver to use
	 * @param dbUserName The database username to use
	 * @param dbPassword The database password to use
	 * @throws InstantiationException Issue instantiating the database Driver
	 * @throws IllegalAccessException Issue instantiating the database Driver
	 * @throws ClassNotFoundException Issue instantiating the database Driver
	 * @throws SQLException SQL connection issue
	 * @author Kieran Gillibrand, Student: 040-756-866
	 */
	private void addItems (final ArrayList <Item> items, final String url, final String driver, final String dbUserName, final String dbPassword) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		if (url == null || driver == null || dbUserName == null || dbPassword == null)
			throw new InvalidParameterException ();
		
		//Get driver
		Class.forName (driver).newInstance ();  
        Connection dbConnection = DriverManager.getConnection (url, dbUserName, dbPassword);  
        
        //Cases
        PreparedStatement select = dbConnection.prepareStatement ("Select * from pc_cases");
        ResultSet results = select.executeQuery ();
        
        //Add all items in the ResultSet
        while (results.next ())
        	items.add (new Item (results.getLong ("cases_ID"), results.getString ("cases_name"), "Cases", results.getString ("cases_model"), results.getString ("cases_imagepath"), results.getDouble ("cases_price")));
        
        select.close ();
        results.close ();
        
        //CPUs
        select = dbConnection.prepareStatement ("Select * from pc_cpu");
        results = select.executeQuery ();
        
        while (results.next ())
        	items.add (new Item (results.getLong ("cpu_ID"), results.getString ("cpu_name"), "CPU", results.getString ("cpu_model"), results.getString ("cpu_imagepath"), results.getDouble ("cpu_price")));
        
        select.close ();
        results.close ();
        
        //GPUs
        select = dbConnection.prepareStatement ("Select * from pc_gpu");
        results = select.executeQuery ();
        
        while (results.next ())
        	items.add (new Item (results.getLong ("gpu_ID"), results.getString ("gpu_name"), "GPU", results.getString ("gpu_model"), results.getString ("gpu_imagepath"), results.getDouble ("gpu_price")));
        
        select.close ();
        results.close ();
        
        //HDD
        select = dbConnection.prepareStatement ("Select * from pc_harddrive");
        results = select.executeQuery ();
        
        while (results.next ())
        	items.add (new Item (results.getLong ("harddrive_ID"), results.getString ("harddrive_name"), "Harddrive", results.getString ("harddrive_model"), results.getString ("harddrive_imagepath"), results.getDouble ("harddrive_price")));
        
        select.close ();
        results.close ();
        
        //Headset
        select = dbConnection.prepareStatement ("Select * from pc_headset");
        results = select.executeQuery ();
        
        while (results.next ())
        	items.add (new Item (results.getLong ("headset_ID"), results.getString ("headset_name"), "Headset", results.getString ("headset_model"), results.getString ("headset_imagepath"), results.getDouble ("headset_price")));
        
        select.close ();
        results.close ();
        
        //Memory
        select = dbConnection.prepareStatement ("Select * from pc_memory");
        results = select.executeQuery ();
        
        while (results.next ())
        	items.add (new Item (results.getLong ("memory_ID"), results.getString ("memory_name"), "Memory", results.getString ("memory_model"), results.getString ("memory_imagepath"), results.getDouble ("memory_price")));
        
        select.close ();
        results.close ();
        
        //Motherboard
        select = dbConnection.prepareStatement ("Select * from pc_motherboard");
        results = select.executeQuery ();
        
        while (results.next ())
        	items.add (new Item (results.getLong ("motherboard_ID"), results.getString ("motherboard_name"), "Motherboard", results.getString ("motherboard_model"), results.getString ("motherboard_imagepath"), results.getDouble ("motherboard_price")));
        
        select.close ();
        results.close ();
        
        //PSU
        select = dbConnection.prepareStatement ("Select * from pc_psu");
        results = select.executeQuery ();
        
        while (results.next ())
        	items.add (new Item (results.getLong ("psu_ID"), results.getString ("psu_name"), "PSU", results.getString ("psu_model"), results.getString ("psu_imagepath"), results.getDouble ("psu_price")));
        
        select.close ();
        results.close ();
        
        //SSD
        select = dbConnection.prepareStatement ("Select * from pc_ssd");
        results = select.executeQuery ();
        
        while (results.next ())
        	items.add (new Item (results.getLong ("ssd_ID"), results.getString ("ssd_name"), "SSD", results.getString ("ssd_model"), results.getString ("ssd_imagepath"), results.getDouble ("ssd_price")));
        
        select.close ();
        results.close ();
        
        dbConnection.close ();
	}
	
	/**
	 * Handles an HTTP post request
	 * 
	 * @param request The HTTP request
	 * @param response The HTTP response
	 * 
	 * @exception ServletException Bad things might happen
	 * @exception IOException Bad things might happen
	 * @author Kieran Gillibrand, Student: 040-756-866
	 */
    @Override
    public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	HttpSession session = request.getSession ();
    	ArrayList <Item> items = null;
    	
    	//Create the list and add all items if it does not exist, otherwise return
    	if (session.getAttribute ("items") == null)
    	{
    		items =  new ArrayList <Item> ();
    		session.setAttribute ("items", items);
    		
    		//Add all database items
    		try 
    		{
    			addItems (items, DBConstants.URL, DBConstants.DRIVER, DBConstants.DB_USER_NAME, DBConstants.DB_PASSWORD);
    		} 
    		catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException exception) 
    		{
    			exception.printStackTrace ();
    		}
    	}
    	else
    		return;
    }
}