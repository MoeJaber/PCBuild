/**
 * Web Application Programming 2016: Prestige Computers
 * Algonquin College
 * 
 * - Kieran Gillibrand
 * - Moe Jaber
 * - Nick Horlings
 */

package cart;

import java.security.InvalidParameterException;

/**
 * A class that represents an item in the store, more detailed information is not stored by these objects but is retreived from the database by the specs.jsp page
 * @author Kieran Gillibrand, Student 040-756-866
 */
public class Item 
{
	/**
	 * The database id of the Item
	 */
	private long id = 0L;
	/**
	 * The name of the item
	 */
	private String name = null;
	/**
	 * The category name of the item
	 */
	private String categoryName = null;
	/**
	 * The model of the item
	 */
	private String model = null;
	/**
	 * The path to the item's image
	 */
	private String imagePath = null;
	/**
	 * The price of the item
	 */
	private double price = 0.0d;
	
	/**
	 * Get the database id
	 * @return The id as a long int
	 * @author Kieran Gillibrand, Student 040-756-866
	 */
	public long getID ()
	{
		return id;
	}
	
	/**
	 * Get the item name
	 * @return The name as a String
	 * @author Kieran Gillibrand, Student 040-756-866
	 */
	public String getName ()
	{
		return name;
	}
	
	/**
	 * Get the category name
	 * @return The category name as a String
	 * @author Kieran Gillibrand, Student 040-756-866
	 */
	public String getCategoryName ()
	{
		return categoryName;
	}
	
	/**
	 * Get the model name
	 * @return The model as a String
	 * @author Kieran Gillibrand, Student 040-756-866
	 */
	public String getModel ()
	{
		return model;
	}
	
	/**
	 * Get the imagePath
	 * @return The imagePath as a String
	 * @author Kieran Gillibrand, Student 040-756-866
	 */
	public String getImagePath ()
	{
		return imagePath;
	}
	
	/**
	 * Get the price of the item
	 * @return The price as a double
	 * @author Kieran Gillibrand, Student 040-756-866
	 */
	public double getPrice ()
	{
		return price;
	}
	
	/**
	 * Constructor that sets all fields
	 * @param id The database id to use
	 * @param name The name to use
	 * @param categoryName The category name to use
	 * @param model The model name to use
	 * @param imagePath The image path to use
	 * @param price The price to use
	 * @exception InvalidParameterException If the reference values are null or the id or price is < 0 or 0.0
	 * @author Kieran Gillibrand, Student 040-756-866
	 */
	public Item (long id, String name, String categoryName, String model, String imagePath, double price) throws IllegalArgumentException
	{
		if (id < 0L || name == null || categoryName == null || model == null || imagePath == null || price < 0.0d)
			throw new InvalidParameterException ();
		
		this.id = id;
		this.name = name;
		this.categoryName = categoryName;
		this.model = model;
		this.imagePath = imagePath;
		this.price = price;
	}
	
	@Override
	public boolean equals (Object obj)
	{
		Item equal = (Item) obj;
		
		return (id == equal.id && name.equals (equal.name) && categoryName.equals (equal.categoryName) && model.equals (equal.model) && imagePath.equals (imagePath) && price == price);
	}
	
	@Override
	public int hashCode ()
	{
		return (int) id + name.hashCode () + categoryName.hashCode () + model.hashCode () + imagePath.hashCode () + (int) price;
	}
	
	@Override
	public String toString ()
	{
		return "ID: " + id + ", Name: " + name + ", Category Name: " + categoryName + ", Model: " + model + "Image Path: " + imagePath + ", Price: " + price;
	}
}
