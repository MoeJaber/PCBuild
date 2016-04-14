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
import javax.servlet.annotation.MultipartConfig;
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
@MultipartConfig
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
		
		if (session.getAttribute ("items") == null || request.getParameter ("categoryName") == null || request.getParameter ("itemName") == null || request.getParameter ("itemModel") == null || request.getParameter ("itemBrand") == null || request.getParameter ("itemSeries") == null || request.getParameter ("itemModelNumber") == null || request.getParameter ("itemType") == null || request.getParameter ("itemCapacity") == null || request.getParameter ("itemInterface") == null || request.getParameter ("itemDescription") == null || request.getParameter ("itemPrice") == null)
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
		
		//Parse price String to double
		try 
		{
			itemPrice = Double.parseDouble (request.getParameter ("itemPrice"));
		}
		catch (NumberFormatException format)
		{
			request.getRequestDispatcher ("addItem.jsp").forward (request, response);
		}

		String itemImagePath = "No Image";
		
		if (request.getPart ("image") != null && request.getPart ("image").getSize () > 0)
		{
			//Image file parameters
			final Part image = request.getPart ("image");
			
			itemImagePath = "/PCBulid/public/img/" + image.getName ();
			final File uploadLocation = new File (itemImagePath);
			
			//Create new file with image name
			File newImage = new File (uploadLocation, itemImagePath);
			
			//Copy file
			try (InputStream imageContent = image.getInputStream ())
			{
			    Files.copy (imageContent, newImage.toPath ());
			}
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
					insert = connection.prepareStatement ("insert into cases (casesModel, casesName, casesImagePath, casesPrice) values (?, ?, ?, ?)");
					
					//Set parameters
					insert.setString (1, itemModel);
					insert.setString (2, itemName);
					insert.setString (3, itemImagePath);
					insert.setDouble (4, itemPrice);
				
					insert.execute ();
					
					//Get id
					select = connection.prepareStatement ("select max(casesID) as casesID from cases");
					reader = select.executeQuery ();
					reader.next ();
					
					//Add item to Admin page item list
					items.add (new Item (reader.getLong ("casesID"), itemName, categoryName, itemModel, itemImagePath, itemPrice));
					
					select.close ();
					insert.close ();
					reader.close ();
				break;
	
				case "CPU":
					insert = connection.prepareStatement ("insert into cpu (cpuModel, cpuName, cpuImagePath, cpuPrice) values (?, ?, ?, ?)");

					insert.setString (1, itemModel);
					insert.setString (2, itemName);
					insert.setString (3, itemImagePath);
					insert.setDouble (4, itemPrice);
				
					insert.execute ();
					
					select = connection.prepareStatement ("select max(cpuID) as cpuID from cpu");
					reader = select.executeQuery (); 
					reader.next ();
					
					items.add (new Item (reader.getLong ("cpuID"), itemName, categoryName, itemModel, itemImagePath, itemPrice));
					
					select.close ();
					insert.close ();
					reader.close ();
				break;
	
				case "GPU":
					insert = connection.prepareStatement ("insert into gpu (gpuModel, gpuName, gpuImagePath, gpuPrice) values (?, ?, ?, ?)");

					insert.setString (1, itemModel);
					insert.setString (2, itemName);
					insert.setString (3, itemImagePath);
					insert.setDouble (4, itemPrice);
				
					insert.execute ();
					
					select = connection.prepareStatement ("select max(gpu_ID) as gpuID from gpu");
					reader = select.executeQuery (); 
					reader.next ();
					
					items.add (new Item (reader.getLong ("gpuID"), itemName, categoryName, itemModel, itemImagePath, itemPrice));	
					
					select.close ();
					insert.close ();
					reader.close ();
				break;
	
				case "Harddrive":
					insert = connection.prepareStatement ("insert into hdd (hddModel, hddName, hddImagePath, hddPrice, hddBrand, hddSeries, hddModelNumber, hddCapacity, hddInterface, hddDescription) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

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
					
					select = connection.prepareStatement ("select max(hddID) as hddID from harddrive");
					reader = select.executeQuery (); 
					reader.next ();
					
					items.add (new Item (reader.getLong ("hddID"), itemName, categoryName, itemModel, itemImagePath, itemPrice));				
					
					select.close ();
					insert.close ();
					reader.close ();
				break;
	
				case "Headset":
					insert = connection.prepareStatement ("insert into headset (headsetModel, headsetName, headsetImagePath, headsetPrice) values (?, ?, ?, ?)");

					insert.setString (1, itemModel);
					insert.setString (2, itemName);
					insert.setString (3, itemImagePath);
					insert.setDouble (4, itemPrice);
				
					insert.execute ();
					
					select = connection.prepareStatement ("select max(headsetID) as headsetID from headset");
					reader = select.executeQuery (); 
					reader.next ();
					
					items.add (new Item (reader.getLong ("headsetID"), itemName, categoryName, itemModel, itemImagePath, itemPrice));		
					
					select.close ();
					insert.close ();
					reader.close ();
				break;
	
				case "Memory":
					insert = connection.prepareStatement ("insert into memory (memoryModel, memoryName, memoryImagePath, memoryPrice) values (?, ?, ?, ?)");

					insert.setString (1, itemModel);
					insert.setString (2, itemName);
					insert.setString (3, itemImagePath);
					insert.setDouble (4, itemPrice);
				
					insert.execute ();
					
					select = connection.prepareStatement ("select max(memoryID) as memoryID from memory");
					reader = select.executeQuery (); 
					reader.next ();
					
					items.add (new Item (reader.getLong ("memoryID"), itemName, categoryName, itemModel, itemImagePath, itemPrice));			
					
					select.close ();
					insert.close ();
					reader.close ();
				break;
	
				case "Motherboard":
					insert = connection.prepareStatement ("insert into motherboard (motherboardModel, motherboardName, motherboardImagePath, motherboardPrice) values (?, ?, ?, ?)");

					insert.setString (1, itemModel);
					insert.setString (2, itemName);
					insert.setString (3, itemImagePath);
					insert.setDouble (4, itemPrice);
				
					insert.execute ();
					
					select = connection.prepareStatement ("select max(motherboardID) as motherboardID from motherboard");
					reader = select.executeQuery (); 
					reader.next ();
					
					items.add (new Item (reader.getLong ("motherboardID"), itemName, categoryName, itemModel, itemImagePath, itemPrice));				
					
					select.close ();
					insert.close ();
					reader.close ();
				break;
	
				case "PSU":
					insert = connection.prepareStatement ("insert into psu (psuModel, psuName, psuImagePath, psuPrice) values (?, ?, ?, ?)");

					insert.setString (1, itemModel);
					insert.setString (2, itemName);
					insert.setString (3, itemImagePath);
					insert.setDouble (4, itemPrice);
				
					insert.execute ();
					
					select = connection.prepareStatement ("select max(psuID) as psuID from psu");
					reader = select.executeQuery (); 
					reader.next ();
					
					items.add (new Item (reader.getLong ("psuID"), itemName, categoryName, itemModel, itemImagePath, itemPrice));
					
					select.close ();
					insert.close ();
					reader.close ();
				break;
	
				case "SSD":
					insert = connection.prepareStatement ("insert into ssd (ssdModel, ssdName, ssdImagePath, ssdPrice) values (?, ?, ?, ?)");

					insert.setString (1, itemModel);
					insert.setString (2, itemName);
					insert.setString (3, itemImagePath);
					insert.setDouble (4, itemPrice);
				
					insert.execute ();
					insert.close ();
					
					select = connection.prepareStatement ("select max(ssdID) as ssdID from ssd");
					reader = select.executeQuery (); 
					reader.next ();
					
					items.add (new Item (reader.getLong ("ssdID"), itemName, categoryName, itemModel, itemImagePath, itemPrice));
					
					select.close ();
					reader.close ();
				break;
			}
			
			connection.close ();
			
			//Redirect back to admin page
			request.getRequestDispatcher ("admin.jsp").forward (request, response);
		}
		catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException exception)
		{
			exception.printStackTrace ();
		}
	}
}