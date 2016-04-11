/**
 * Web Application Programming 2016: Prestige Computers
 * Algonquin College
 * 
 * - Kieran Gillibrand
 * - Moe Jaber
 * - Nick Horlings
 */

package user;

/**
 * A class that represents a logged in user of the site. <br />
 * A user is considered logged in when the session ("user") is != null, otherwise they are logged in
 * @author Kieran Gillibrand, Student: 040-756-866
 */
public class User 
{
	/**
	 * A user's email
	 */
	private String email = null;
	/**
	 * A user's first name
	 */
	private String firstName = null;
	/**
	 * A user's last name
	 */
	private String lastName = null;
	
	/**
	 * Constructor that takes an email, first name, and last name
	 * @param email The email to use
	 * @param firstName The first name to use
	 * @param lastName The last name to use
	 * @author Kieran Gillibrand, Student: 040-756-866
	 */
	public User (String email, String firstName, String lastName) throws IllegalArgumentException
	{
		if (email == null || firstName == null || lastName == null)
			throw new IllegalArgumentException ();
		
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	 * Gets the user email
	 * @return The email as a String
	 * @author Kieran Gillibrand, Student: 040-756-866
	 */
	public String getEmail ()
	{
		return email;
	}
	
	/**
	 * Gets the user first name
	 * @return The first name as a String
	 * @author Kieran Gillibrand, Student: 040-756-866
	 */
	public String getFirstName ()
	{
		return firstName;
	}
	
	/**
	 * Gets the user last name
	 * @return The last name as a String
	 * @author Kieran Gillibrand, Student: 040-756-866
	 */
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
