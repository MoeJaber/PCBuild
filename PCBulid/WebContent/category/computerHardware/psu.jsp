<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import = "dbconstants.DBConstants" %>

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
<h2><a href = "../../index.jsp">Home</a> >> <a href = "../computerhardware.jsp">Computer Hardware</a> >> <a href = "psu.jsp">PSU</a></h2>
<hr>
<br>
<div class="row">

 <%
try {
Class.forName(DBConstants.DRIVER);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}

Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;       
%>


<%
try{ 
connection = DriverManager.getConnection(DBConstants.URL, DBConstants.DB_USER_NAME, DBConstants.DB_PASSWORD);
statement=connection.createStatement();
String sql ="SELECT * FROM psu";

resultSet = statement.executeQuery(sql);
 
while(resultSet.next()){
%>

	
<!--- Sales --->





	<form action="specs.jsp" method="GET" >
	
	<input type="hidden" name="itemId" value="<%=resultSet.getString("psuID") %>">
		  <div class="col-sm-6">
		    <div class="panel panel-danger" style = "height: 13.5em;">
		      <div class="panel-heading"><%=resultSet.getString("psuName") %><p style = "font-size: 0.7em;"><%=resultSet.getString("psuModel") %></p></div>
		      <div class="panel-body"><img src="<%=resultSet.getString("psuImagePath")%>"  style = "height: 6em;" alt=""></div>
		      <div class="panel-footer" style = "height: 5.35em;"><span class = "pull-right" style = "color:red;  font-size: 0.8em;">	</span><p style = "text-decoration: line-through; font-size: 0.6em;">	</p><input type="submit" value="More Info" class="btn pull-right" /><button type="button" class="btn pull-right">Add to cart</button><h5>$<%=resultSet.getString("psuPrice") %></h5></div>
		    </div>
		  </div>
    </form>
		
<% 
}
resultSet.close ();
statement.close ();
connection.close ();

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