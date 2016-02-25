package parts_servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/JdbcConnection")
public class CasesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 Connection connection = null;
	 ResultSet resultSet = null;
	 PreparedStatement preparedStatement = null;
	 String query = null;
	 String url = null;
	 String username = null;
	 String password = null;
	
 
 public void init(ServletConfig config) throws ServletException {
 
  url = "jdbc:mysql://localhost:3306/form";
  username = "root"; 
  password = "password"; 
  try {
   Class.forName("com.mysql.jdbc.Driver").newInstance();
 
   connection = DriverManager.getConnection(url, username , password);
  }
  catch (Exception e) {
 
   e.printStackTrace();
  }
 
 }
 
 protected void doGet(
   HttpServletRequest request, 
   HttpServletResponse response
   ) throws ServletException, IOException {
 
  doPost(request, response);
 
 }   
 
 protected void doPost(
   HttpServletRequest request, 
   HttpServletResponse response
   ) throws ServletException, IOException {
 
  response.setContentType("text/html;charset=UTF-8");
  PrintWriter out = response.getWriter();
 
  query = "SELECT * FROM pc_cases";
  try {
   preparedStatement = connection.prepareStatement(query);
   resultSet = preparedStatement.executeQuery();
 
   out.println("<html><body><h2>The Select query has following results : </h2>");
   out.println("<hr></br><table cellspacing='0' cellpadding='5' border='1'>");
   out.println("<tr>");
   out.println("<td><b>Model</b></td>");
   out.println("<td><b>Name</b></td>");
   out.println("<td><b>Price</b></td>");
   out.println("</tr>");
 
   while(resultSet.next()) {
    out.println("<tr>");
    out.println("<td>"+resultSet.getString(1) + "</td>");
    out.println("<td>"+resultSet.getString(2) + "</td>");
    out.println("<td>"+resultSet.getString(3) + "</td>");
    out.println("</tr>");
    request.setAttribute("str1", "Test1");
    request.setAttribute("str2", "Test2");
 
   }
   RequestDispatcher rd=request.getRequestDispatcher("cases.jsp");    
   rd.forward(request,response);    
   out.println("</table></br><hr></body></html>");
  }
  catch (SQLException e) {
 
   e.printStackTrace();
  }
   
 }
 
@Override
public void destroy() {
    try {               
        resultSet.close();
                preparedStatement.close();
    }
    catch (SQLException e) {
 
        e.printStackTrace();
    }   
 
}
 
 
}


  