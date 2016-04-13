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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
 * Servlet that removes an item from the database and list of items on the admin page
 * @author Kieran Gillibrand, Student 040-756-866
 * @see HttpServlet
 */
public class AdminRemoveItemServlet extends HttpServlet
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
		if (session.getAttribute ("items") == null || request.getParameter ("categoryName") == null || request.getParameter ("imagePath") == null || request.getParameter ("removeIndex") == null || request.getParameter ("removeID") == null)
			request.getRequestDispatcher ("admin.jsp").forward (request, response);
		
		final ArrayList <Item> items = (ArrayList <Item>) session.getAttribute ("items");
		final String categoryName = request.getParameter ("categoryName");
		final String imagePath = request.getParameter ("imagePath");
		int removeIndex = 0;
		long removeID = 0L;
		
		try
		{
			removeIndex = Integer.parseInt(request.getParameter ("removeIndex"));
			removeID = Long.parseLong (request.getParameter ("removeID"));
		}
		catch (NumberFormatException format)
		{
			format.printStackTrace ();
		}
		
		try 
		{
			Class.forName (DBConstants.DRIVER).newInstance ();
			Connection connection = DriverManager.getConnection (DBConstants.URL, DBConstants.DB_USER_NAME, DBConstants.DB_PASSWORD);  

			PreparedStatement remove = null;
			
			//Create statement based on category name request parameter
			switch (categoryName)
			{
				case "Cases":
					remove = connection.prepareStatement ("delete from pc_cases where cases_ID = ?");
				break;
	
				case "CPU":
					remove = connection.prepareStatement ("delete from pc_cpu where cpu_ID = ?");
				break;
	
				case "GPU":
					remove = connection.prepareStatement ("delete from pc_gpu where gpu_ID = ?");
				break;
	
				case "Harddrive":
					remove = connection.prepareStatement ("delete from pc_harddrive where harddrive_ID = ?");
				break;
	
				case "Headset":
					remove = connection.prepareStatement ("delete from pc_headset where headset_ID = ?");
				break;
	
				case "Memory":
					remove = connection.prepareStatement ("delete from pc_memory where memory_ID = ?");
				break;
	
				case "Motherboard":
					remove = connection.prepareStatement ("delete from pc_motherboard where motherboard_ID = ?");
				break;
	
				case "PSU":
					remove = connection.prepareStatement ("delete from pc_psu where psu_ID = ?");
				break;
	
				case "SSD":
					remove = connection.prepareStatement ("delete from pc_ssd where ssd_ID = ?");
				break;
			}
			
			//Set id parameter
			remove.setLong (1, removeID);
			remove.execute ();
			
			remove.close ();
			connection.close ();
			
			items.remove (removeIndex);
			
			//Delete image
			Path path = Paths.get (imagePath);
			Files.deleteIfExists (path);
			
			request.getRequestDispatcher ("admin.jsp").forward (request, response);
		}
		catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException exception)
		{
			exception.printStackTrace ();
		}
    }
}