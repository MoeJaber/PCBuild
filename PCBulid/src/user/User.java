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
	 * A user's database id
	 */
	private long id = 0L;
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
	 * Boolean representing a user's admin status
	 */
	private boolean isAdmin = false;
	
	/**
	 * Constructor that takes an id, email, first name, last name, and admin status
	 * @param id The database id of the user
	 * @param email The email to use
	 * @param firstName The first name to use
	 * @param lastName The last name to use
	 * @param isAdmin The user's admin status
	 * @author Kieran Gillibrand, Student: 040-756-866
	 */
	public User (long id, String email, String firstName, String lastName, boolean isAdmin) throws IllegalArgumentException
	{
		if (id < 0L || email == null || firstName == null || lastName == null)
			throw new IllegalArgumentException ();
		
		this.id = id;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.isAdmin = isAdmin;
	}

	/**
	 * Gets the user's database id
	 * @return The database id as a long
	 * @author Kieran Gillibrand, Student: 040-756-866
	 */
	public long getID ()
	{
		return id;
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
	
	/**
	 * Gets the user's admin status
	 * @return The admin status as a boolean
	 * @author Kieran Gillibrand, Student: 040-756-866
	 */
	public boolean getAdmin ()
	{
		return isAdmin;
	}
	
	@Override
	public boolean equals (Object obj)
	{
		User equal = (User) obj;
		
		return (id == equal.id && email.equals (equal.email) && firstName.equals (equal.firstName) && lastName.equals (equal.lastName) && isAdmin == equal.isAdmin);
	}
	
	@Override
	public int hashCode ()
	{
		return (int) id + email.hashCode () + firstName.hashCode () + lastName.hashCode ();
	}
	
	@Override
	public String toString ()
	{
		return "Database ID: " + id + ", Email: " + email + ", First Name: " + firstName + ", Last Name: " + lastName + ", Is Admin: " + isAdmin;
	}
}
