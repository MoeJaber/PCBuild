package parts;

import java.sql.*;

public class pcCases {
	 static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	 static final String DB_URL = "jdbc:mysql://localhost:3306/";
	 static final String dbName = "form";  


	 static final String USER = "root";
	 static final String PASS = "password";

	 public static void main(String[] args) {
	  Connection conn = null;
	  Statement stmt = null;
	  try {

	   Class.forName("com.mysql.jdbc.Driver");

	   conn = DriverManager.getConnection(DB_URL + dbName, USER, PASS);
	   stmt = conn.createStatement();
	   String sql;
	   sql = "SELECT cases_model, cases_name, cases_price FROM pc_cases";
	   ResultSet rs = stmt.executeQuery(sql);

	   while (rs.next()) {

	    String MODEL = rs.getString("cases_model");
	    String NAME = rs.getString("cases_name");
	    int PRICE = rs.getInt("cases_price");

	    System.out.print("CPU: " + MODEL);
	    System.out.print(", GPU: " + NAME);
	    System.out.print(", PSU: " + PRICE);	   
	   }

	   rs.close();
	   stmt.close();
	   conn.close();
	  } catch (SQLException se) {
	   
	   se.printStackTrace();
	  } catch (Exception e) {
	   
	   e.printStackTrace();
	  } finally {
	   
	   try {
	    if (stmt != null)
	     stmt.close();
	   } catch (SQLException se2) {
	   } 
	   try {
	    if (conn != null)
	     conn.close();
	   } catch (SQLException se) {
	    se.printStackTrace();
	   } 
	  } 
	  
	 }
	}


