package pcbuild;

public class Product 
{
	private int id;
	private String name;
	private String description;
	private double price;
	private int quantity;
	
	public Product (int id, String name, String description, double price, int quantity)
	{
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}
	
	public int getID ()
	{
		return id;
	}
	
	public String getName ()
	{
		return name;
	}
	
	public String getDescription ()
	{
		return description;
	}
	
	public double getPrice ()
	{
		return price;
	}
	
	public int getQuantity ()
	{
		return quantity;
	}
	
	@Override
	public boolean equals (Object obj)
	{
		Product equal = (Product) obj;
		
		return (id == equal.id && name.equals (equal.name) && description.equals (equal.description) && price == equal.price && quantity == equal.quantity);
	}
	
	@Override
	public String toString ()
	{
		return "Product \nName: " + name + "\nID: " + id + "\nDescription: " + description + "\nPrice: $" + price + "\nQuantity: " + quantity;
	}
	
	@Override
	public int hashCode ()
	{
		return id + name.hashCode () + description.hashCode () + (int) price + quantity;
	}
}
