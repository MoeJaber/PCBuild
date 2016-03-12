package cart;

public class Item 
{
	private long id = 0L;
	private String name = null;
	private String model = null;
	private String imagePath = null;
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
	
	public String getImagePath ()
	{
		return imagePath;
	}
	
	public double getPrice ()
	{
		return price;
	}
	
	public Item (long id, String name, String model, String imagePath, double price)
	{
		this.id = id;
		this.name = name;
		this.model = model;
		this.imagePath = imagePath;
		this.price = price;
	}
	
	@Override
	public boolean equals (Object obj)
	{
		Item equal = (Item) obj;
		
		return (id == equal.id && name.equals (equal.name) && model.equals (equal.model) && imagePath.equals (equal.imagePath) && price == price);
	}
	
	@Override
	public int hashCode ()
	{
		return (int) id * name.hashCode () * model.hashCode () * imagePath.hashCode () * (int) price;
	}
	
	@Override
	public String toString ()
	{
		return "ID: " + id + ", Name: " + name + ", Model: " + model + ", Image Path: " + imagePath + ", Price: " + price;
	}
}
