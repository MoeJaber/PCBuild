package cart;

public class CartItem 
{
	private long id = 0L;
	private String name = null;
	private String model = null;
	/**
	 * TODO: Add image field
	 */
	private double price = 0.0d;
	
	public long getID ()
	{
		return id;
	}
	
	public String getName ()
	{
		return name;
	}
	
	public String getModel ()
	{
		return model;
	}
	
	public double getPrice ()
	{
		return price;
	}
	
	public CartItem (long id, String name, String model, double price)
	{
		this.id = id;
		this.name = name;
		this.model = model;
		this.price = price;
	}
	
	@Override
	public boolean equals (Object obj)
	{
		CartItem equal = (CartItem) obj;
		
		return (id == equal.id && name.equals (equal.name) && model.equals (equal.model) && price == price);
	}
	
	@Override
	public int hashCode ()
	{
		return (int) id * name.hashCode () * model.hashCode () * (int) price;
	}
	
	@Override
	public String toString ()
	{
		return "ID: " + id + ", Name: " + name + ", Model: " + model + ", Price: " + price;
	}
}
