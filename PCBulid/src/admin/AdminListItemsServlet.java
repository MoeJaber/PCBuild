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
        PreparedStatement select = dbConnection.prepareStatement ("Select * from cases");
        ResultSet results = select.executeQuery ();
        
        //Add all items in the ResultSet
        while (results.next ())
        	items.add (new Item (results.getLong ("casesID"), results.getString ("casesName"), "Cases", results.getString ("casesModel"), results.getString ("casesImagePath"), results.getDouble ("casesPrice")));
        
        select.close ();
        results.close ();
        
        //CPUs
        select = dbConnection.prepareStatement ("Select * from cpu");
        results = select.executeQuery ();
        
        while (results.next ())
        	items.add (new Item (results.getLong ("cpuID"), results.getString ("cpuName"), "CPU", results.getString ("cpuModel"), results.getString ("cpuImagePath"), results.getDouble ("cpuPrice")));
        
        select.close ();
        results.close ();
        
        //GPUs
        select = dbConnection.prepareStatement ("Select * from gpu");
        results = select.executeQuery ();
        
        while (results.next ())
        	items.add (new Item (results.getLong ("gpuID"), results.getString ("gpuNaame"), "GPU", results.getString ("gpuModel"), results.getString ("gpuImagePath"), results.getDouble ("gpuPrice")));
        
        select.close ();
        results.close ();
        
        //HDD
        select = dbConnection.prepareStatement ("Select * from hdd");
        results = select.executeQuery ();
        
        while (results.next ())
        	items.add (new Item (results.getLong ("hddID"), results.getString ("hddName"), "Harddrive", results.getString ("hddModel"), results.getString ("hddImagePath"), results.getDouble ("hddPrice")));
        
        select.close ();
        results.close ();
        
        //Headset
        select = dbConnection.prepareStatement ("Select * from headset");
        results = select.executeQuery ();
        
        while (results.next ())
        	items.add (new Item (results.getLong ("headsetID"), results.getString ("headsetName"), "Headset", results.getString ("headsetModel"), results.getString ("headsetImagePath"), results.getDouble ("headsetPrice")));
        
        select.close ();
        results.close ();
        
        //Memory
        select = dbConnection.prepareStatement ("Select * from memory");
        results = select.executeQuery ();
        
        while (results.next ())
        	items.add (new Item (results.getLong ("memoryID"), results.getString ("memoryName"), "Memory", results.getString ("memoryModel"), results.getString ("memoryImagePath"), results.getDouble ("memoryPrice")));
        
        select.close ();
        results.close ();
        
        //Motherboard
        select = dbConnection.prepareStatement ("Select * from motherboard");
        results = select.executeQuery ();
        
        while (results.next ())
        	items.add (new Item (results.getLong ("motherboardID"), results.getString ("motherboardName"), "Motherboard", results.getString ("motherboardModel"), results.getString ("motherboardImagePath"), results.getDouble ("motherboardPrice")));
        
        select.close ();
        results.close ();
        
        //PSU
        select = dbConnection.prepareStatement ("Select * from psu");
        results = select.executeQuery ();
        
        while (results.next ())
        	items.add (new Item (results.getLong ("psuID"), results.getString ("psuName"), "PSU", results.getString ("psuModel"), results.getString ("psuImagePath"), results.getDouble ("psuPrice")));
        
        select.close ();
        results.close ();
        
        //SSD
        select = dbConnection.prepareStatement ("Select * from ssd");
        results = select.executeQuery ();
        
        while (results.next ())
        	items.add (new Item (results.getLong ("ssdID"), results.getString ("ssdName"), "SSD", results.getString ("ssdModel"), results.getString ("ssdImagePath"), results.getDouble ("ssdPrice")));
        
        select.close ();
        results.close ();
        
        dbConnection.close ();
	}
	
	/**
	 * Handles an HTTP get request
	 * 
	 * @param request The HTTP request
	 * @param response The HTTP response
	 * 
	 * @exception ServletException Bad things might happen
	 * @exception IOException Bad things might happen
	 * @author Kieran Gillibrand, Student: 040-756-866
	 */
    @Override
    public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
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