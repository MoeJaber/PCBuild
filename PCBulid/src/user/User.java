package user;

import java.sql.Timestamp;

public class User 
{
	private String email;
	private String firstName;
	private String lastName;
	private Timestamp created;
	
	public User (String email, String firstName, String lastName, Timestamp created)
	{
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.created = created;
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
	
	public Timestamp getCreated ()
	{
		return created;
	}
	
	@Override
	public boolean equals (Object obj)
	{
		User equal = (User) obj;
		
		return (email.equals (equal.email) && firstName.equals (equal.firstName) && lastName.equals (equal.lastName) && created.equals (equal.created));
	}
	
	@Override
	public int hashCode ()
	{
		return email.hashCode () * firstName.hashCode () * lastName.hashCode () * created.hashCode ();
	}
	
	@Override
	public String toString ()
	{
		return "Email: " + email + ", First Name: " + firstName + ", Last Name: " + lastName + ", Created: " + created.toString ();
	}
}
