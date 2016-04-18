<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
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
<h2><a href = "../../index.jsp">Home</a> >> <a href = "../computerhardware.jsp">Computer Hardware</a> >> <a href = "harddrives.jsp">Harddrives</a></h2>
<hr>
<br>
<div class="row">

 <%
 if (request.getParameter ("itemId") == null)
	 response.sendRedirect (request.getContextPath () + "/" + "index.jsp");

try {
Class.forName(DBConstants.DRIVER);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}

Connection connection = null;
PreparedStatement statement = null;
ResultSet resultSet = null;
%>


<%
try{ 
connection = DriverManager.getConnection(DBConstants.URL, DBConstants.DB_USER_NAME, DBConstants.DB_PASSWORD);
statement=connection.prepareStatement("SELECT * FROM hdd where hddID = ?");


long itemId = 0;

try
{
	itemId = Long.parseLong (request.getParameter ("itemId"));
}
catch (NumberFormatException format)
{
	response.sendRedirect (request.getContextPath () + "/" + "index.jsp");
}

statement.setLong (1, itemId);

resultSet = statement.executeQuery ();

while(resultSet.next()){
%>


 <div class="col-sm-6">
		    <img src = "<%= resultSet.getString ("hddImagePath") %>" alt = "No Image Uploaded"></img>
		     
		      <div class="panel-footer" style = "height: 5.35em;"><span class = "pull-right" style = "color:red;  font-size: 0.8em;">	</span><p style = "text-decoration: line-through; font-size: 0.6em;">	</p><h5>$<%=resultSet.getString("hddPrice") %></h5></div>
		    </div>
		  </div>

    
<!-- Specs -->
<div class="col-sm-6">
		    <div class="panel panel-danger" style = "height: 13.5em;">
		      <div class="panel-heading"><p style = "font-size: 0.7em;">Specifications</p></div>
		      <div class="panel-body">
		      
		      
		      <table class="floatL" border="0" cellpadding="0" cellspacing="0">
			   	<tr>
			        <td><img src="./pictures/pixel_trans.gif" border="0" alt="" width="100%" height="10"></td>
				</tr>
                  <tr>
				   <td align="left" >
				   <table width="100%" align="center"  border="0">
				    <tr>
             
					<td width="25%" valign="top" class="specification" >
                    <tr>
                    <td width="25%" align="left" valign="top" class="specification">Brand</td>
                    <td width="75%" class="spec_contend">&nbsp;&nbsp;  <%=resultSet.getString("hddBrand") %></td></tr>
                    
                    <tr><td width="25%" align="left" valign="top" class="specification">Model</td>
                    <td width="75%" class="spec_contend">&nbsp;&nbsp;  <%=resultSet.getString("hddModelNumber") %></td></tr>
                    
                    <tr><td width="25%" align="left" valign="top" class="specification">Series</td>
                    <td width="75%" class="spec_contend">&nbsp;&nbsp; <%=resultSet.getString("hddSeries") %></td></tr>
                    
                    <tr><td width="25%" align="left" valign="top" class="specification">Capacity</td>
                    <td width="75%" class="spec_contend">&nbsp;&nbsp;  <%=resultSet.getString("hddCapacity") %></td></tr>
                    
                    <tr><td width="25%" align="left" valign="top" class="specification">Interface</td>
                    <td width="75%" class="spec_contend">&nbsp;&nbsp;  <%=resultSet.getString("hddInterface") %></td></tr>
                    
					 </table>
					</td>
				</tr>
				 <tr>
			        <td><img src="./pictures/pixel_trans.gif" border="0" alt="" width="100%" height="10"></td>
				</tr>
			 </table>

    <form action = "/PCBulid/AddItemServlet" method = "POST">
    	<input type = "hidden" value = "<%=resultSet.getLong("hddID") %>" name = "itemID">
    	<input type = "hidden" value = "Harddrive" name = "categoryName">
    	<input type="submit" class="btn submit" value = "Add to Cart">
    </form>
		      </div>
		      
		    </div>
		  </div>
		    <div class="col-sm-6">
		    <div class="panel panel-danger" style = "height: 13.5em;">
		      <div class="panel-heading"><p style = "font-size: 0.7em;">Overview</p></div>
		      <div class="panel-body"><p><%=resultSet.getString("hddDescription") %></p></div>	
		    </div>
		  </div>

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