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
  	
  	<!-- Navbar component -->
	<%@ include file="../../components/navbar.jsp" %> 
	
	
	
	
	
	<!--- Advertisement Carousel --->
	<div id="topAdvert" class="carousel slide" data-ride="carousel" style = "margin-top: -1.35em;">
	  <!-- Indicators -->
	  <ol class="carousel-indicators">
	    <li data-target="#topAdvert" data-slide-to="0" class="active"></li>
	    <li data-target="#topAdvert" data-slide-to="1"></li>
	    <li data-target="#topAdvert" data-slide-to="2"></li>
	    <li data-target="#topAdvert" data-slide-to="3"></li>
	    <li data-target="#topAdvert" data-slide-to="4"></li>
	    <li data-target="#topAdvert" data-slide-to="5"></li>
	    <li data-target="#topAdvert" data-slide-to="6"></li>
	  </ol>
	
	  <!-- Wrapper for slides -->
	  <div class="carousel-inner" role="listbox">
	    <div class="item active"><img src="../../public/img/website/ads/1.jpg" alt="Advert" class="img-responsive center-block"></div>
	    <div class="item"><img src="../../public/img/website/ads/2.jpg" alt="Advert" class="img-responsive center-block"></div>
	    <div class="item"><img src="../../public/img/website/ads/3.jpg" alt="Advert" class="img-responsive center-block"></div>
	    <div class="item"><img src="../../public/img/website/ads/4.jpg" alt="Advert" class="img-responsive center-block"></div>
	    <div class="item"><img src="../../public/img/website/ads/5.jpg" alt="Advert" class="img-responsive center-block"></div>
	    <div class="item"><img src="../../public/img/website/ads/6.jpg" alt="Advert" class="img-responsive center-block"></div>
	  </div>
	
	  <!-- Left and right controls -->
	  <a class="left carousel-control" href="#topAdvert" role="button" data-slide="prev">
	    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
	    <span class="sr-only">Previous</span>
	  </a>
	  <a class="right carousel-control" href="#topAdvert" role="button" data-slide="next">
	    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
	    <span class="sr-only">Next</span>
	  </a>
	</div>
	
	
	<!--- Under advertisements --->
	<!--- width: 89%; margin-left: 4.5em --->
	<div class = "container">
		<div class="col-sm-14"> 
			<div class = "row" style = "border: 2px solid; border-radius: 6px;">
				<img src = "../../public/img/website/categories/extremedeal-left.gif">
				<img src = "../../public/img/website/categories/home-extremedeal_right.jpg" style = "margin-left: -0.2em;">
				<span>
		  			<img src="../../public/img/products/77086ss.jpg" class="img-center">
		  			<span class="panel-heading">Toshiba DT01AC1300 3TB SATA3 7200RPM 64MB Cache 3.5in Internal Hard Disk Drive HDD</span>
		  			<div class="panel-footer"><span class ="pull-right">You save $36.99</span> <p style = "text-decoration: line-through;">Reg: 146.99</p><h4>$109.99</h4><button type="button" class="btn pull-right" style = "margin-top: -3em;">Buy now</button></div>
				</span>
			</div>
		</div>
	</div>
	<div class="container">
		<h2>This Week's Top Deals</h2>
		<hr>
		<br>
		<div class="row">
	
<!--- Deals --->


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

try{ 
connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
statement=connection.createStatement();
String sql ="SELECT * FROM cases";

resultSet = statement.executeQuery(sql);

 %>

<%  while(resultSet.next()){
%>


  			<div class="col-sm-4">
   				<div class="panel panel-primary">
    				<div class="panel-heading"><%=resultSet.getString("cases_model") %><%=resultSet.getString("cases_name") %></div>
		      		<div class="panel-body"><img src="" class="img-responsive" alt="Placeholder Image"></div>
		      		<div class="panel-footer">$<%=resultSet.getInt("cases_price") %>.00 <button type="button" class="btn pull-right">Buy now</button><p style = "color:red;">Save $40.00</p></div>
		    	</div>
		  	</div>

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