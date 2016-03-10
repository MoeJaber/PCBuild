package pcbuild;

import java.util.ArrayList;

import pcbuild.Product;

public class Cart 
{
	private ArrayList <Product> products;
	
	public Cart ()
	{
		products = new ArrayList <Product> ();
	}
	
	public ArrayList <Product> getProducts ()
	{
		return products;
	}
	
	public void addProduct (Product add)
	{
		products.add (add);
	}
	
	public void removeProduct (int removeIndex)
	{
		products.remove (removeIndex);
	}
	
	@Override
	public boolean equals (Object obj)
	{
		Cart equal = (Cart) obj;
		
		return products.equals (equal.products);
	}
	
	@Override
	public String toString ()
	{
		return products.toString ();
	}
	
	@Override
	public int hashCode ()
	{
		return products.hashCode ();
	}
}
