/**
 * Web Application Programming 2016: Prestige Computers
 * Algonquin College
 * 
 * - Kieran Gillibrand
 * - Moe Jaber
 * - Nick Horlings
 */

package admin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
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
import javax.servlet.http.Part;

import cart.Item;
import dbconstants.DBConstants;

/**
 * Servlet which adds an item to the store by adding it to the database and uploading it's image to the server.
 * Called by admin.jsp
 * 
 * @author Kieran Gillibrand, Student 040-756-866
 * @see HttpServlet
 * @see Item
 */
public class AdminAddItemServlet extends HttpServlet
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
	 * @author Kieran Gillibrand, Student: 040-756-866
	 */
	@Override
	public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession ();

		//Check session attributes and request parameters for null
		if (session.getAttribute ("items") == null || request.getParameter ("categoryName") == null || request.getParameter ("itemName") == null || request.getParameter ("itemModel") == null || request.getParameter ("itemImagePath") == null || request.getParameter ("itemPrice") == null || request.getAttribute ("image") == null)
			request.getRequestDispatcher ("addItem.jsp").forward (request, response);
		
		if (request.getParameter ("itemBrand") == null || request.getParameter ("itemSeries") == null || request.getParameter ("itemModelNumber") == null || request.getParameter ("itemType") == null || request.getParameter ("itemCapacity") == null || request.getAttribute ("itemInterface") == null || request.getAttribute ("itemDescription") == null || request.getParameter ("imageName") == null)
			request.getRequestDispatcher ("addItem.jsp").forward (request, response);
		
		//Session attributes and request parameters
		final ArrayList <Item> items = (ArrayList <Item>) session.getAttribute ("items");
		final String categoryName = request.getParameter ("categoryName");
		final String itemName = request.getParameter ("itemName");
		final String itemModel = request.getParameter ("itemModel");
		Double itemPrice = 0.0d;
		final String itemBrand = request.getParameter ("itemBrand");
		final String itemSeries = request.getParameter ("itemSeries");
		final String itemModelNumber = request.getParameter ("itemModelNumber");
		final String itemType = request.getParameter ("itemType");
		final String itemCapacity = request.getParameter ("itemCapacity");
		final String itemInterface = request.getParameter ("itemInterface");
		final String itemDescription = request.getParameter ("itemDescription");
		
		//Image file parameters
		final String IMAGE_PATH = "/PCBulid/public/img";
		final Part image = (Part) request.getAttribute ("image");
		final File uploadLocation = new File (IMAGE_PATH);
		final String imageName = image.getName ();
		final String itemImagePath = IMAGE_PATH + "/" + imageName;
		
		//Parse price String to double
		try 
		{
			itemPrice = Double.parseDouble (request.getParameter ("itemPrice"));
		}
		catch (NumberFormatException format)
		{
			request.getRequestDispatcher ("addItem.jsp").forward (request, response);
		}

		try 
		{
			Class.forName (DBConstants.DRIVER).newInstance ();
			Connection connection = DriverManager.getConnection (DBConstants.URL, DBConstants.DB_USER_NAME, DBConstants.DB_PASSWORD);  

			PreparedStatement insert = null;
			PreparedStatement select = null;
			ResultSet reader = null;
			
			//Insert to the correct table based on the categoryName request parameter
			switch (categoryName)
			{
				case "Cases":
					insert = connection.prepareStatement ("insert into pc_cases (cases_model, cases_name, cases_imagepath, cases_price) values (?, ?, ?, ?)");
					
					//Set parameters
					insert.setString (1, itemModel);
					insert.setString (2, itemName);
					insert.setString (3, itemImagePath);
					insert.setDouble (4, itemPrice);
				
					insert.execute ();
					
					//Get id
					select = connection.prepareStatement ("select * from pc_cases order by cases_ID limit 1");
					reader = select.executeQuery (); 
					reader.next ();
					
					//Add item to Admin page item list
					items.add (new Item (reader.getLong ("cases_ID"), itemName, categoryName, itemModel, itemImagePath, itemPrice));
					
					select.close ();
					insert.close ();
					reader.close ();
				break;
	
				case "CPU":
					insert = connection.prepareStatement ("insert into pc_cpu (cpu_model, cpu_name, cpu_imagepath, cpu_price) values (?, ?, ?, ?)");

					insert.setString (1, itemModel);
					insert.setString (2, itemName);
					insert.setString (3, itemImagePath);
					insert.setDouble (4, itemPrice);
				
					insert.execute ();
					
					select = connection.prepareStatement ("select * from pc_cpu order by cpu_ID limit 1");
					reader = select.executeQuery (); 
					reader.next ();
					
					items.add (new Item (reader.getLong ("cpu_ID"), itemName, categoryName, itemModel, itemImagePath, itemPrice));
					
					select.close ();
					insert.close ();
					reader.close ();
				break;
	
				case "GPU":
					insert = connection.prepareStatement ("insert into pc_gpu (gpu_model, gpu_name, gpu_imagepath, cases_price) values (?, ?, ?, ?)");

					insert.setString (1, itemModel);
					insert.setString (2, itemName);
					insert.setString (3, itemImagePath);
					insert.setDouble (4, itemPrice);
				
					insert.execute ();
					
					select = connection.prepareStatement ("select * from pc_gpu order by gpu_ID limit 1");
					reader = select.executeQuery (); 
					reader.next ();
					
					items.add (new Item (reader.getLong ("gpu_ID"), itemName, categoryName, itemModel, itemImagePath, itemPrice));	
					
					select.close ();
					insert.close ();
					reader.close ();
				break;
	
				case "Harddrive":
					insert = connection.prepareStatement ("insert into pc_harddrives (harddrive_model, harddrive_name, harddrive_imagepath, harddrive_price, harddrive_brand, harddrive_series, harddrive_modelnum, harddrive_type, harddrive_capacity, harddrive_interface, description) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

					insert.setString (1, itemModel);
					insert.setString (2, itemName);
					insert.setString (3, itemImagePath);
					insert.setDouble (4, itemPrice);
					insert.setString (5, itemBrand);
					insert.setString (6, itemSeries);
					insert.setString (7, itemModelNumber);
					insert.setString (8, itemType);
					insert.setString (9, itemCapacity);
					insert.setString (10, itemInterface);
					insert.setString (11, itemDescription);

					insert.execute ();
					
					select = connection.prepareStatement ("select * from pc_harddrives order by harddrive_ID limit 1");
					reader = select.executeQuery (); 
					reader.next ();
					
					items.add (new Item (reader.getLong ("harddrive_ID"), itemName, categoryName, itemModel, itemImagePath, itemPrice));				
					
					select.close ();
					insert.close ();
					reader.close ();
				break;
	
				case "Headset":
					insert = connection.prepareStatement ("insert into pc_headset (headset_model, headset_name, headset_imagepath, headset_price) values (?, ?, ?, ?)");

					insert.setString (1, itemModel);
					insert.setString (2, itemName);
					insert.setString (3, itemImagePath);
					insert.setDouble (4, itemPrice);
				
					insert.execute ();
					
					select = connection.prepareStatement ("select * from pc_headset order by headset_ID limit 1");
					reader = select.executeQuery (); 
					reader.next ();
					
					items.add (new Item (reader.getLong ("headset_ID"), itemName, categoryName, itemModel, itemImagePath, itemPrice));		
					
					select.close ();
					insert.close ();
					reader.close ();
				break;
	
				case "Memory":
					insert = connection.prepareStatement ("insert into pc_memory (memory_model, memory_name, memory_imagepath, memory_price) values (?, ?, ?, ?)");

					insert.setString (1, itemModel);
					insert.setString (2, itemName);
					insert.setString (3, itemImagePath);
					insert.setDouble (4, itemPrice);
				
					insert.execute ();
					
					select = connection.prepareStatement ("select * from pc_memory order by memory_ID limit 1");
					reader = select.executeQuery (); 
					reader.next ();
					
					items.add (new Item (reader.getLong ("memory_ID"), itemName, categoryName, itemModel, itemImagePath, itemPrice));			
					
					select.close ();
					insert.close ();
					reader.close ();
				break;
	
				case "Motherboard":
					insert = connection.prepareStatement ("insert into pc_motherboard (motherboard_model, motherboard_name, motherboard_imagepath, motherboard_price) values (?, ?, ?, ?)");

					insert.setString (1, itemModel);
					insert.setString (2, itemName);
					insert.setString (3, itemImagePath);
					insert.setDouble (4, itemPrice);
				
					insert.execute ();
					
					select = connection.prepareStatement ("select * from pc_motherboard order by motherboard_ID limit 1");
					reader = select.executeQuery (); 
					reader.next ();
					
					items.add (new Item (reader.getLong ("motherboard_ID"), itemName, categoryName, itemModel, itemImagePath, itemPrice));				
					
					select.close ();
					insert.close ();
					reader.close ();
				break;
	
				case "PSU":
					insert = connection.prepareStatement ("insert into pc_psu (psu_model, psu_name, psu_imagepath, psu_price) values (?, ?, ?, ?)");

					insert.setString (1, itemModel);
					insert.setString (2, itemName);
					insert.setString (3, itemImagePath);
					insert.setDouble (4, itemPrice);
				
					insert.execute ();
					
					select = connection.prepareStatement ("select * from pc_psu order by psu_ID limit 1");
					reader = select.executeQuery (); 
					reader.next ();
					
					items.add (new Item (reader.getLong ("psu_ID"), itemName, categoryName, itemModel, itemImagePath, itemPrice));
					
					select.close ();
					insert.close ();
					reader.close ();
				break;
	
				case "SSD":
					insert = connection.prepareStatement ("insert into pc_ssd (ssd_model, ssd_name, ssd_imagepath, ssd_price) values (?, ?, ?, ?)");

					insert.setString (1, itemModel);
					insert.setString (2, itemName);
					insert.setString (3, itemImagePath);
					insert.setDouble (4, itemPrice);
				
					insert.execute ();
					insert.close ();
					
					select = connection.prepareStatement ("select * from pc_ssd order by ssd_ID limit 1");
					reader = select.executeQuery (); 
					reader.next ();
					
					items.add (new Item (reader.getLong ("ssd_ID"), itemName, categoryName, itemModel, itemImagePath, itemPrice));
					
					select.close ();
					reader.close ();
				break;
			}
			
			connection.close ();
			//Create new file with image name
			File newImage = new File (uploadLocation, "ImageName");
			
			//Copy file
			try (InputStream imageContent = image.getInputStream ())
			{
			    Files.copy (imageContent, newImage.toPath ());
			}
			
			//Redirect back to admin page
			request.getRequestDispatcher ("admin.jsp").forward (request, response);
		}
		catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException exception)
		{
			exception.printStackTrace ();
		}
	}
}