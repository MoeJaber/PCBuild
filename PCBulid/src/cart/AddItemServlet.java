/**
 * Web Application Programming 2016: Prestige Computers
 * Algonquin College
 * 
 * - Kieran Gillibrand
 * - Moe Jaber
 * - Nick Horlings
 */

package cart;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cart.Cart;
import dbconstants.DBConstants;

/**
 * Servlet that adds an item to the database and list of items on the admin page
 * @author Kieran Gillibrand, Student 040-756-866
 * @see HttpServlet
 */
public class AddItemServlet extends HttpServlet
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
		HttpSession session = request.getSession ();
		
		if (session.getAttribute ("cart") == null || request.getAttribute ("category") == null || request.getAttribute ("id") == null)
			return;
		
		final String categoryName = (String) request.getAttribute ("category");
		final int itemID = (int) request.getAttribute ("id");
        
    	try 
    	{
    		Class.forName (DBConstants.DRIVER).newInstance ();
			Connection connection = DriverManager.getConnection (DBConstants.URL, DBConstants.DB_USER_NAME, DBConstants.DB_PASSWORD);  
			
			PreparedStatement select = null;
			ResultSet item = null;
			
			//Select based on the category name request parameter and add the cart item
			switch (categoryName)
			{
				case "Cases":
					select = connection.prepareStatement ("Select * from cases where casesID = ?");
					select.setInt (1, itemID);

					item = select.executeQuery ();
					item.next ();
					
					((Cart) session.getAttribute ("cart")).addItem (new Item (item.getLong ("casesID"), item.getString ("casesName"), categoryName, item.getString ("casesModel"), item.getString ("casesImagePath"), item.getDouble ("casesPrice")));
				break;
				
				case "CPU":
					select = connection.prepareStatement ("Select * from cpu where cpuID = ?");
					select.setInt (1, itemID);
					
					item = select.executeQuery ();
					item.next ();
					
					((Cart) session.getAttribute ("cart")).addItem (new Item (item.getLong ("cpuID"), item.getString ("cpuName"), categoryName, item.getString ("cpuModel"), item.getString ("cpuImagePath"), item.getDouble ("cpuPrice")));
				break;
					
				case "GPU":
					select = connection.prepareStatement ("Select * from gpu where gpuID = ?");
					select.setInt (1, itemID);
					
					item = select.executeQuery ();
					item.next ();
					
				((Cart) session.getAttribute ("cart")).addItem (new Item (item.getLong ("gpuID"), item.getString ("gpuName"), categoryName, item.getString ("gpuModel"), item.getString ("gpuImagePath"), item.getDouble ("gpuPrice")));
				break;
					
				case "Harddrive":
					select = connection.prepareStatement ("Select * from hdd where hddID = ?");
					select.setInt (1, itemID);
					
					item = select.executeQuery ();
					item.next ();
					
					((Cart) session.getAttribute ("cart")).addItem (new Item (item.getLong ("hddID"), item.getString ("hddName"), categoryName, item.getString ("hddModel"), item.getString ("hddImagePath"), item.getDouble ("hddPrice")));
				break;
					
				case "Headset":
					select = connection.prepareStatement ("Select * from headset where headsetID = ?");
					select.setInt (1, itemID);
					
					item = select.executeQuery ();
					item.next ();
					
					((Cart) session.getAttribute ("cart")).addItem (new Item (item.getLong ("headsetID"), item.getString ("headsetName"), categoryName, item.getString ("headsetModel"), item.getString ("headsetImagePath"), item.getDouble ("headsetPrice")));
				break;
					
				case "Memory":
					select = connection.prepareStatement ("Select * from memory where memoryID = ?");
					select.setInt (1, itemID);
					
					item = select.executeQuery ();
					item.next ();
					
					((Cart) session.getAttribute ("cart")).addItem (new Item (item.getLong ("memoryID"), item.getString ("memoryName"), categoryName, item.getString ("memoryModel"), item.getString ("memoryImagePath"), item.getDouble ("memoryPrice")));
				break;
					
				case "Motherboard":
					select = connection.prepareStatement ("Select * from motherboard where motherboardID = ?");
					select.setInt (1, itemID);
					
					item = select.executeQuery ();
					item.next ();
					
					((Cart) session.getAttribute ("cart")).addItem (new Item (item.getLong ("motherboardID"), item.getString ("motherboardName"), categoryName, item.getString ("motherboardModel"), item.getString ("motherboardImagePath"), item.getDouble ("motherboardPrice")));
				break;
				
				case "PSU":
					select = connection.prepareStatement ("Select * from psu where psuID = ?");
					select.setInt (1, itemID);
					
					item = select.executeQuery ();
					item.next ();
					
					((Cart) session.getAttribute ("cart")).addItem (new Item (item.getLong ("psuID"), item.getString ("psuName"), categoryName, item.getString ("psuModel"), item.getString ("psuImagePath"), item.getDouble ("psuPrice")));
				break;
					
				case "SSD":
					select = connection.prepareStatement ("Select * from ssd where ssdID = ?");
					select.setInt (1, itemID);
					
					item = select.executeQuery ();
					item.next ();
					
					((Cart) session.getAttribute ("cart")).addItem (new Item (item.getLong ("ssdID"), item.getString ("ssdName"), categoryName, item.getString ("ssdModel"), item.getString ("ssdImagePath"), item.getDouble ("ssdPrice")));
				break;
			}
			
			select.close ();
			connection.close ();
			item.close ();
			
			request.getRequestDispatcher ("cart.jsp").forward (request, response);
		} 
    	catch (InstantiationException e) 
    	{
			e.printStackTrace ();
		} 
    	catch (IllegalAccessException e) 
    	{
			e.printStackTrace ();
		} 
    	catch (ClassNotFoundException e) 
    	{
			e.printStackTrace ();
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace ();
		}  
	}
}
