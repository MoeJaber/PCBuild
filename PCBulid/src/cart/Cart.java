package cart;

import java.util.ArrayList;

import cart.CartItem;

public class Cart 
{
	private ArrayList <CartItem> items = null;
	private double total = 0.0d;
	
	private double updateTotal ()
	{
		double total = 0.0d;
		
		for (CartItem item : items)
			total += item.getPrice ();
		
		return total;
	}
	
	public void addItem (CartItem item)
	{
		if (item == null)
			throw new IllegalArgumentException ();
		
		items.add (item);
		
		total = updateTotal ();
	}
	
	public void removeItem (CartItem item)
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
		items = new ArrayList <CartItem> ();
		total = 0.0d;
	}
}
