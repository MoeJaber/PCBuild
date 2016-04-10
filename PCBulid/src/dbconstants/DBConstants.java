/**
 * Web Application Programming 2016: Prestige Computers
 * Algonquin College
 * 
 * - Kieran Gillibrand
 * - Moe Jaber
 * - Nick Horlings
 */

package dbconstants;

/**
 * Static class that contain database constants as credentials so they can be easily changed for all servlets that perform database IO
 * @author Kieran Gillibrand, Student 040-756-866
 * @see com.mysql.jdbc.Driver
 */
public class DBConstants 
{
	/**
	 * Database url to connect with (jdbc:mysql://<b>hostname</b>/<b>database name</b>
	 */
	public static final String URL = "jdbc:mysql://us-cdbr-azure-east-a.cloudapp.net:3306/web app testing";  
	/**
	 * Database driver class path
	 */
	public static final String DRIVER = "com.mysql.jdbc.Driver";  
	/**
	 * Database username
	 */
	public static final String DB_USER_NAME = "b8ebfad0623483";  
	/**
	 * Database password
	 */
	public static final String DB_PASSWORD = "b8df9f4f";
}
