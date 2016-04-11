<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
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
<p>Showing 1 items in Harddrives</p>
<hr>
<br>
<div class="row">

 <%
 String id = request.getParameter("userId");
 String driverName = "com.mysql.jdbc.Driver";
 String connectionUrl = "jdbc:mysql://us-cdbr-azure-east-a.cloudapp.net:3306/";  
 String dbName = "web app testing";
 String userId = "b8ebfad0623483";
 String password = "b8df9f4f";


try {
Class.forName(driverName);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}

Connection connection = null;
PreparedStatement statement = null;
ResultSet resultSet = null;
%>


<%
try{ 
connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
statement=connection.prepareStatement("SELECT * FROM pc_harddrive where harddrive_ID = ?");

if (request.getParameter ("itemId") == null)
	return;

int itemId = 0;

try
{
	itemId = Integer.parseInt ((String) request.getParameter ("itemId"));
}
catch (NumberFormatException format)
{
	format.printStackTrace ();
}

statement.setInt (1, itemId);

resultSet = statement.executeQuery ();

while(resultSet.next()){
%>


 <div class="col-sm-6">
		    <div class="panel panel-danger" style = "height: 30.5em;">
		      <div class="panel-heading"><%=resultSet.getString("harddrive_name") %><p style = "font-size: 0.7em;"><%=resultSet.getString("harddrive_model") %></p></div>
		      <div class="preview_img" style="min-width:200px;min-height:100px;padding:3px;">
				<a href="javascript:popupWindow('/popup_image.php?pID=077305','750','100','100','no','yes')"> <img src="<%=resultSet.getString("harddrive_imagepath")%>" border="0"  width="200" height="200" vspace="5" hspace="5" border="0"  name="imgShow" class="preview_item"> </a>
				<noscript>
				<a href="/popup_image.php?pID=077305"><img src="http://img.canadacomputers.com/Products/200x200/077/077305/82308.jpg" border="0" width="200" height="200" hspace="5" vspace="5" name="imgShow" class="preview_item"></a></noscript>
				 <div class="prod_thumb">
        <ul >
        	<li><a href="javascript:popupWindow('/popup_image.php?pID=077305','750','100','100','no','yes')"> <img src="<%=resultSet.getString("harddrive_imagepath")%>" width="40" height="40" border="0" onMouseOver="document.imgShow.src='<%=resultSet.getString("harddrive_imagepath")%>';keepRatio('.preview_item');"> </a></li>
              <li><a href="javascript:popupWindow('/popup_image.php?pID=077305','750','100','100','no','yes')"> <img src="<%=resultSet.getString("harddrive_path2") %>" width="40" height="40" border="0" onMouseOver="document.imgShow.src='<%=resultSet.getString("harddrive_path2") %>';keepRatio('.preview_item');"> </a></li>
         </ul> 
		 </div>
				</div>
		     
		      <div class="panel-footer" style = "height: 5.35em;"><span class = "pull-right" style = "color:red;  font-size: 0.8em;">	</span><p style = "text-decoration: line-through; font-size: 0.6em;">	</p><button type="button" class="btn pull-right">Add to cart</button><h5>$<%=resultSet.getString("harddrive_price") %></h5></div>
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
                    <td width="75%" class="spec_contend">&nbsp;&nbsp;  <%=resultSet.getString("harddrive_brand") %></td></tr>
                    
                    <tr><td width="25%" align="left" valign="top" class="specification">Model</td>
                    <td width="75%" class="spec_contend">&nbsp;&nbsp;  <%=resultSet.getString("harddrive_modelnum") %></td></tr>
                    
                    <tr><td width="25%" align="left" valign="top" class="specification">Series</td>
                    <td width="75%" class="spec_contend">&nbsp;&nbsp; <%=resultSet.getString("harddrive_series") %></td></tr>
                    
                    <tr><td width="25%" align="left" valign="top" class="specification">Type</td>
                    <td width="75%" class="spec_contend">&nbsp;&nbsp;  <%=resultSet.getString("harddrive_type") %></td></tr>
                    
                    <tr><td width="25%" align="left" valign="top" class="specification">Form</td>
                    <td width="75%" class="spec_contend">&nbsp;&nbsp;  <%=resultSet.getString("harddrive_form") %></td></tr>
                    
                    <tr><td width="25%" align="left" valign="top" class="specification">Capacity</td>
                    <td width="75%" class="spec_contend">&nbsp;&nbsp;  <%=resultSet.getString("harddrive_capacity") %></td></tr>
                    
                    <tr><td width="25%" align="left" valign="top" class="specification">Interface</td>
                    <td width="75%" class="spec_contend">&nbsp;&nbsp;  <%=resultSet.getString("harddrive_interface") %></td></tr>
                    
					 </table>
					</td>
				</tr>
				 <tr>
			        <td><img src="./pictures/pixel_trans.gif" border="0" alt="" width="100%" height="10"></td>
				</tr>
			 </table>

		      </div>
		      
		    </div>
		  </div>
		    <div class="col-sm-6">
		    <div class="panel panel-danger" style = "height: 13.5em;">
		      <div class="panel-heading"><p style = "font-size: 0.7em;">Overview</p></div>
		      <div class="panel-body"><p><%=resultSet.getString("description") %></p></div>	
		    </div>
		  </div>

<% 
}
resultSet.close ();

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