package cart;

import java.util.ArrayList;
import java.lang.StringBuilder;

import cart.Item;

public class Cart 
{
	private ArrayList <Item> items = null;
	private double total = 0.0d;
	
	private double updateTotal ()
	{
		double total = 0.0d;
		
		for (Item item : items)
			total += item.getPrice ();
		
		return total;
	}
	
	public ArrayList <Item> getItems ()
	{
		return items;
	}
	
	public void addItem (Item item)
	{
		if (item == null)
			throw new IllegalArgumentException ();
		
		items.add (item);
		
		total = updateTotal ();
	}
	
	public void removeItem (Item item)
	{
		if (item == null)
			throw new IllegalArgumentException ();
		
		items.remove (item);
		
		total = updateTotal ();
	}
	
	public void removeItem (int removeIndex)
	{
		if (removeIndex < 0 || removeIndex >= items.size ())
			throw new IllegalArgumentException ();
		
		items.remove (removeIndex);
		
		total = updateTotal ();
	}
	
	public void removeAllItems ()
	{		
		items.clear ();
		
		total = 0.0d;
	}
	
	public int getProductCount ()
	{
		return items.size ();
	}
	
	public Cart ()
	{
		items = new ArrayList <Item> ();
		total = 0.0d;
	}
	
	@Override
	public boolean equals (Object obj)
	{
		Cart equal = (Cart) obj;
		
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
