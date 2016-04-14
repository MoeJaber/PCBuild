/**
 * Web Application Programming 2016: Prestige Computers
 * Algonquin College
 * 
 * - Kieran Gillibrand
 * - Moe Jaber
 * - Nick Horlings
 */

package cart;

import java.util.ArrayList;
import java.util.Objects;
import java.lang.StringBuilder;

import cart.Item;

/**
 * Class that represents a user's shopping cart
 * 
 * @author Kieran Gillibrand, Student 040-756-866
 * @see Item
 */
public class Cart 
{
	/**
	 * List of all <tt>CartItems</tt> in cart
	 */
	private ArrayList <Item> items = null;
	
	/**
	 * Total price of all <tt>CartItems</tt> in cart
	 */
	private double total = 0.0d;
	
	/**
	 * Private utility method <br /> <br />
	 * Loops through <tt>CartItems</tt> and calculates the total price
	 * @return The total price of all items as a double
	 */
	private double updateTotal ()
	{
		double total = 0.0d;
		
		for (Item item : items)
			total += item.getPrice ();
		
		return total;
	}
	
	/**
	 * Gets the <tt>CartItem</tt> at the specified index <br /> <br />
	 * @param itemIndex The index of the item to remove
	 * @return The <tt>CartItem</tt> at the index
	 * @exception IndexOutOfBoundsException If the specified index is < 0 or >= the list size
	 * @author Kieran Gillibrand, Student 040-756-866
	 */
	public Item getItem (int itemIndex) throws IndexOutOfBoundsException
	{
		try
		{
			return items.get (itemIndex);
		}
		catch (IndexOutOfBoundsException bounds)
		{
			throw bounds;
		}
	}
	
	/**
	 * Gets the list of <tt>CartItems</tt> <br /> <br />
	 * @return The list of <tt>CartItems</tt>
	 * @author Kieran Gillibrand, Student 040-756-866
	 */
	public ArrayList <Item> getItems ()
	{
		return items;
	}
	
	/**
	 * Gets the total price of all items
	 * @return The total as a double
	 * @author Kieran Gillibrand, Student 040-756-866
	 */
	public double getTotal ()
	{
		return total;
	}
	
	/**
	 * Adds a <tt>CartItem</tt> to the list of items and updates the total <br /> <br />
	 * @param item The <tt>CartItem</tt> to add to the list
	 * @exception IllegalArgumentException If the passed <tt>CartItem</tt> reference is null
	 * @author Kieran Gillibrand, Student 040-756-866
	 */
	public void addItem (Item item) throws IllegalArgumentException
	{
		if (item == null)
			throw new IllegalArgumentException ();
		
		items.add (item);
		
		total = updateTotal ();
	}
	
	/**
	 * Removes a <tt>CartItem</tt> from the list of items and updates the total <br /> <br />
	 * @param item The <tt>CartItem</tt> to remove from the list
	 * @exception IllegalArgumentException If the passed <tt>CartItem</tt> reference is null
	 * @author Kieran Gillibrand, Student 040-756-866
	 */
	public void removeItem (Item item) throws IllegalArgumentException
	{
		if (item == null)
			throw new IllegalArgumentException ();
		
		items.remove (item);
		
		total = updateTotal ();
	}
	
	/**
	 * Removes a <tt>CartItem</tt> from the list of items and updates the total <br /> <br />
	 * @param removeIndex The index of the <tt>CartItem</tt> to remove from the list
	 * @exception IllegalArgumentException If the passed index is < 0 or >= the list size
	 * @author Kieran Gillibrand, Student 040-756-866
	 */
	public void removeItem (int removeIndex) throws IllegalArgumentException
	{
		if (removeIndex < 0 || removeIndex >= items.size ())
			throw new IllegalArgumentException ();
		
		items.remove (removeIndex);
		
		total = updateTotal ();
	}
	
	/**
	 * Removes all <tt>CartItems</tt> from the list of items and updates the total <br /> <br />
	 * @author Kieran Gillibrand, Student 040-756-866
	 */
	public void removeAllItems ()
	{		
		items.clear ();
		
		total = 0.0d;
	}
	
	/**
	 * Gets the number of <tt>CartItems</tt> in the list
	 * @return The number of items as an int
	 * @author Kieran Gillibrand, Student 040-756-866
	 */
	public int getProductCount ()
	{
		return items.size ();
	}
	
	/**
	 * Default constructor, allocates the items <tt>ArrayList</tt> with the default size and sets the total to 0.0
	 * @author Kieran Gillibrand, Student 040-756-866
	 */
	public Cart ()
	{
		items = new ArrayList <Item> ();
		total = 0.0d;
	}
	
	@Override
	public boolean equals (Object obj)
	{
		Cart equal = (Cart) obj;
		
		if (equal == null)
			return false;
		
		//Reference equals
		if (Objects.equals(this, equal))
			return true;
		
		return (items.equals (equal.items) && total == equal.total);
	}
	
	@Override
	public int hashCode ()
	{
		return items.hashCode () * (int) total;
	}
	
	@Override
	public String toString ()
	{
		StringBuilder returnString = new StringBuilder ("Items: \n");
		
		for (Item item : items)
			returnString.append (item.toString () + "\n");
		
		returnString.append ("Total: " + total);
		
		return returnString.toString ();
	}
}
