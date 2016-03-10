package user;

public class User 
{
	private String email;
	private String firstName;
	private String lastName;
	
	public User (String email, String firstName, String lastName)
	{
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getEmail ()
	{
		return email;
	}
	
	public String getFirstName ()
	{
		return firstName;
	}
	
	public String getLastName ()
	{
		return lastName;
	}
	
	@Override
	public boolean equals (Object obj)
	{
		User equal = (User) obj;
		
		return (email.equals (equal.email) && firstName.equals (equal.firstName) && lastName.equals (equal.lastName));
	}
	
	@Override
	public int hashCode ()
	{
		return email.hashCode () * firstName.hashCode () * lastName.hashCode ();
	}
	
	@Override
	public String toString ()
	{
		return "Email: " + email + ", First Name: " + firstName + ", Last Name: " + lastName;
	}
}
