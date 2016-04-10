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
        PreparedStatement selectCases = dbConnection.prepareStatement ("Select * from pc_cases");
        ResultSet casesResults = selectCases.executeQuery ();
        
        //Add all items in the ResultSet
        while (casesResults.next ())
        	items.add (new Item (casesResults.getLong ("cases_ID"), casesResults.getString ("cases_name"), "Cases", casesResults.getString ("cases_model"), casesResults.getString ("cases_imagepath"), casesResults.getDouble ("cases_price")));
        
        //CPUs
        PreparedStatement selectCPU = dbConnection.prepareStatement ("Select * from pc_cpu");
        ResultSet cpuResults = selectCPU.executeQuery ();
        
        while (cpuResults.next ())
        	items.add (new Item (cpuResults.getLong ("cpu_ID"), cpuResults.getString ("cpu_name"), "CPU", cpuResults.getString ("cpu_model"), cpuResults.getString ("cpu_imagepath"), cpuResults.getDouble ("cpu_price")));
        
        //GPUs
        PreparedStatement selectGPU = dbConnection.prepareStatement ("Select * from pc_gpu");
        ResultSet gpuResults = selectGPU.executeQuery ();
        
        while (gpuResults.next ())
        	items.add (new Item (gpuResults.getLong ("gpu_ID"), gpuResults.getString ("gpu_name"), "GPU", gpuResults.getString ("gpu_model"), gpuResults.getString ("gpu_imagepath"), gpuResults.getDouble ("gpu_price")));
        
        //HDD
        PreparedStatement selectHDD = dbConnection.prepareStatement ("Select * from pc_harddrive");
        ResultSet hddResults = selectHDD.executeQuery ();
        
        while (hddResults.next ())
        	items.add (new Item (hddResults.getLong ("harddrive_ID"), hddResults.getString ("harddrive_name"), "Harddrive", hddResults.getString ("harddrive_model"), hddResults.getString ("harddrive_imagepath"), hddResults.getDouble ("harddrive_price")));
        
        //Headset
        PreparedStatement selectHeadset = dbConnection.prepareStatement ("Select * from pc_headset");
        ResultSet headsetResults = selectHeadset.executeQuery ();
        
        while (headsetResults.next ())
        	items.add (new Item (headsetResults.getLong ("headset_ID"), headsetResults.getString ("headset_name"), "Headset", headsetResults.getString ("headset_model"), headsetResults.getString ("headset_imagepath"), headsetResults.getDouble ("headset_price")));
        
        //Memory
        PreparedStatement selectMemory = dbConnection.prepareStatement ("Select * from pc_memory");
        ResultSet memoryResults = selectMemory.executeQuery ();
        
        while (memoryResults.next ())
        	items.add (new Item (memoryResults.getLong ("memory_ID"), memoryResults.getString ("memory_name"), "Memory", memoryResults.getString ("memory_model"), memoryResults.getString ("memory_imagepath"), memoryResults.getDouble ("memory_price")));
        
        //Motherboard
        PreparedStatement selectMotherboard = dbConnection.prepareStatement ("Select * from pc_motherboard");
        ResultSet motherboardResults = selectMotherboard.executeQuery ();
        
        while (motherboardResults.next ())
        	items.add (new Item (motherboardResults.getLong ("motherboard_ID"), motherboardResults.getString ("motherboard_name"), "Motherboard", motherboardResults.getString ("motherboard_model"), motherboardResults.getString ("motherboard_imagepath"), motherboardResults.getDouble ("motherboard_price")));
        
        //PSU
        PreparedStatement selectPSU = dbConnection.prepareStatement ("Select * from pc_psu");
        ResultSet psuResults = selectPSU.executeQuery ();
        
        while (psuResults.next ())
        	items.add (new Item (psuResults.getLong ("psu_ID"), psuResults.getString ("psu_name"), "PSU", psuResults.getString ("psu_model"), psuResults.getString ("psu_imagepath"), psuResults.getDouble ("psu_price")));
        
        //SSD
        PreparedStatement selectSSD = dbConnection.prepareStatement ("Select * from pc_ssd");
        ResultSet ssdResults = selectSSD.executeQuery ();
        
        while (ssdResults.next ())
        	items.add (new Item (ssdResults.getLong ("ssd_ID"), ssdResults.getString ("ssd_name"), "SSD", ssdResults.getString ("ssd_model"), ssdResults.getString ("ssd_imagepath"), ssdResults.getDouble ("ssd_price")));
        
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
    	
    	//Create the list and add all items or get it if it exists
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
    		items = (ArrayList <Item>) session.getAttribute ("items");
    }
}