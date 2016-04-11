<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Prestige Computers</title>
    <script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
	<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
    <link href="//netdna.bootstrapcdn.com/bootswatch/3.1.0/united/bootstrap.min.css" rel="stylesheet">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <style>
body{
    background: url("../../public/img/backdrop.png");
    font: 400 15px Lato, sans-serif;
}

.centered-form .panel{
    background: rgba(255, 255, 255, 0.8);
    box-shadow: rgba(0, 0, 0, 0.3) 20px 20px 20px;
}
.panel:hover {
    box-shadow: 5px 0px 40px rgba(0,0,0, .2);
}

.centered-form{
    margin-top: 60px;
}
	</style>
  </head>
  <body>
  	<jsp:include page="../../components/navbar.jsp"/>
	
	
	<br>
	<div class="container">
<h2><a href = "../../index.jsp">Home</a> >> <a href = "../computerhardware.jsp">Computer Hardware</a> >> <a href = "harddrives.jsp">Harddrives</a></h2>
<p>Showing 2 items in Harddrives</p>
<hr>
<br>
<div class="row">

 <%
String id = request.getParameter("userId");
String driverName = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String dbName = "form";
String userId = "root";
String password = "admin";

try {
Class.forName(driverName);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}

Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>


<%
try{ 
connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
statement=connection.createStatement();
String sql ="SELECT * FROM pc_harddrive where harddrive_ID = '2'";

resultSet = statement.executeQuery(sql);

while(resultSet.next()){
%>
<!--- Sales --->

<!-- Overview -->
<p>
  WD Blue drives are designed and manufactured with the proven technology found in WD's original award-winning
  desktop and mobile hard drives. Built to the highest standards of quality and reliability, these drives offer
  the features and capacity ideal for your everyday computing needs. 
  These drives are available in a broad range of capacities, cache sizes, form factors and interfaces 
  so you can be sure there's a drive that's the perfect fit for your system, in more ways than one.
</p>

<!-- IMG -->
<img src="<%=resultSet.getString("harddrive_imagepath")%>" style = "height: 6em;" alt="">
    <%=resultSet.getString("harddrive_path2") %>
    
<!-- Specs -->
  
	<%=resultSet.getString("harddrive_brand") %>
	<%=resultSet.getString("harddrive_series") %>
	<%=resultSet.getString("harddrive_modelnum") %>
	<%=resultSet.getString("harddrive_type") %>
	<%=resultSet.getString("harddrive_form") %>
	<%=resultSet.getString("harddrive_capacity") %>
	<%=resultSet.getString("harddrive_interface") %>

	
		
<% 
}

} catch (Exception e) {
e.printStackTrace();
}
%>


	</div>
	</div>
	<br><br>
	<footer class="container-fluid text-center">
	  <p>Copyright 2016, Prestige Computers </p>  
	  <form class="form-inline">Get deals:
	    <input type="email" class="form-control" size="50" placeholder="Email Address">
	    <button type="button" class="btn btn-danger">Sign Up</button>
	  </form>
	</footer>

  </body>
</html>