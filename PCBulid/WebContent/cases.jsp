<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import= "parts_servlet.CasesServlet" %>
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
    background: url("public/img/backdrop.png");
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
  	<!--- Jumbotron Prestige Computers --->
    <div class="jumbotron">
		<div class="container text-center">
    		<img src = "public/img/website/banner.png" class="img-responsive center-block" alt="Prestige Computers">
  		</div>
	</div>
	<nav class="navbar navbar-default" style = "margin-top: -2.1em;">
	  <div class="container-fluid">
	    <!-- Navigation -->
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
	        <span class="sr-only">Toggle navigation</span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	      </button>
	      <a class="navbar-brand" href="#"><span class="glyphicon glyphicon-globe logo"></span> Prestige Computers</a>
	    </div>
	
	    <!-- Departments -->
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	      <ul class="nav navbar-nav">
	        <li class="dropdown">
	          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Department<span class="caret"></span></a>
	          <ul class="dropdown-menu" style = "padding-top: 1em;">
	            <li><a href="#">Computer Hardware</a></li>
	            <li><a href="#">Laptop & Tablet</a></li>
	            <li><a href="#">Networking</a></li>
	            <li><a href="#">TV & Home Theatre</a></li>
	            <li><a href="#">Mobile Phones</a></li>
	            <li><a href="#">Electronics</a></li>
	            <li><a href="#">Monitors</a></li>
	            <li><a href="#">Desktop</a></li>
	            <li><a href="#">Accessories</a></li>
	            <li><a href="#">Gadget & Toys</a></li>
	            <li><a href="#">Game Consoles</a></li>
	            <li><a href="#">Printers</a></li>
	            <li><a href="#">Point of Sale</a></li>
	            <li><a href="#">Software</a></li>
	          </ul>
	        </li>
	        <!--- Brands --->
	        <li class="dropdown">
	          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Brands<span class="caret"></span></a>
	          <div class="dropdown-menu" style = "width: 50em !important;">
	            <div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan"><a href="#"><img src="public/img/brands/adata.gif" class="img-responsive" alt="ADATA"></a></div>
	            <div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan"><a href="#"><img src="public/img/brands/amd.gif" class="img-responsive" alt="AMD"></a></div>
	            <div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan"><a href="#"><img src="public/img/brands/asus.gif" class="img-responsive" alt="ASUS"></a></div>
	            <div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan"><a href="#"><img src="public/img/brands/benq.gif" class="img-responsive" alt="BENQ"></a></div>
	            <div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan"><a href="#"><img src="public/img/brands/corsair.gif" class="img-responsive" alt="Corsair"></a></div>
	            <div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan"><a href="#"><img src="public/img/brands/evga.gif" class="img-responsive" alt="EVGA"></a></div>
	            <div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan"><a href="#"><img src="public/img/brands/gigabyte.gif" class="img-responsive" alt="Gigabyte"></a></div>
	            <div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan"><a href="#"><img src="public/img/brands/gopro.gif" class="img-responsive" alt="GoPro"></a></div>
	            <div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan"><a href="#"><img src="public/img/brands/intel.gif" class="img-responsive" alt="Intel"></a></div>
	            <div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan"><a href="#"><img src="public/img/brands/kingston.gif" class="img-responsive" alt="Kingston"></a></div>
	            <div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan"><a href="#"><img src="public/img/brands/lenovo.gif" class="img-responsive" alt="Lenovo"></a></div>
	            <div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan"><a href="#"><img src="public/img/brands/linksys.gif" class="img-responsive" alt="Linksys"></a></div>
	            <div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan"><a href="#"><img src="public/img/brands/logitech.gif" class="img-responsive" alt="Logitech"></a></div>
	            <div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan"><a href="#"><img src="public/img/brands/microsoft.gif" class="img-responsive" alt="Microsoft"></a></div>
	            <div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan"><a href="#"><img src="public/img/brands/msi.gif" class="img-responsive" alt="MSi"></a></div>
	            <div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan"><a href="#"><img src="public/img/brands/nvidia.gif" class="img-responsive" alt="nVidia"></a></div>
	            <div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan"><a href="#"><img src="public/img/brands/samsung.gif" class="img-responsive" alt="Samsung"></a></div>
	            <div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan"><a href="#"><img src="public/img/brands/sandisk.gif" class="img-responsive" alt="SanDisk"></a></div>
	            <div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan"><a href="#"><img src="public/img/brands/seagate.gif" class="img-responsive" alt="Seagate"></a></div>
	          </div>
	        </li>
	        <!--- Communities Dropdown --->
	        <li class="dropdown">
	          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Communities<span class="caret"></span></a>
	          <div class="dropdown-menu" style = "width: 50em !important;">
	          	<div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan" style="padding-top: 1em;"><a href="#"><img src="public/img/website/icons/ico-sale.jpg" class="img-center" alt="Weekly Sale"></a><h3><a href="#"  style = "text-decoration: none;">Weekly Sale</a></h3>
				<p>Get great deals every week with our weekly sale. Starts 6pm EST every Wednesday!</p></div>
	            <div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan" style="padding-top: 1em;"><a href="#"><img src="public/img/website/icons/ico-store.jpg" class="img-center" alt="Clearance"></a><h3><a href="#"  style = "text-decoration: none;">Clearance</a></h3>
				<p>Discounts on clearance and end-of-life items!</p></div>
				<div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan" style="padding-top: 1em;"><a href="#"><img src="public/img/website/icons/ico-deals.jpg" class="img-center" alt="Weekend Deals"></a><h3><a href="#"  style = "text-decoration: none;">Weekend Deals</a></h3>
				<p>End your week with some great technology deals, posted every Friday.</p></div>
				<div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan" style="padding-top: 1em;"><a href="#"><img src="public/img/website/icons/ico-subscribe.jpg" class="img-center" alt="Subscribe"></a><h3><a href="#"  style = "text-decoration: none;">Subscribe & Win!</a></h3>
				<p>Get email alerts on all our great deals and offers. Get a chance to win great prizes!</p></div>
	          </div>
	        </li>
	      </ul>
	      
	      <!--- Search Bar --->
	      <form class="navbar-form navbar-left" role="search">
	        <div class="form-group">
	          <input type="text" class="form-control" placeholder="Search Products">
	        </div>
	        <button type="submit" class="btn btn-default">Go</button>
	      </form>
	      
	      <!--- Right Side Nav --->
	      <ul class="nav navbar-nav navbar-right">
			<li class="dropdown" id="menuLogin">
		        <a class="dropdown-toggle" href="#" data-toggle="dropdown" id="navLogin"><span class="glyphicon glyphicon-user"></span> Your Account<span class="caret"></span></a>
		        <div class="dropdown-menu" style="padding:17px; width: 25em !important;">
		          <form>
		            <div class="form-group"><input type="email" class="form-control"  class="form-control input-sm" placeholder="Email"></div>
		            <div class="form-group"><input type="password" class="form-control"  class="form-control input-sm" placeholder="Password"></div>
		            <div class="form-group"><button type="submit" class="btn btn-info btn-block">Sign in</button></div>
		            <div class="checkbox">
			            <label><input name="remember" type="checkbox" value="Remember Me">Remember Me
			            <a href="forgot.jsp" class="pull-right">Forgot Password?</a>
			            </label>
					</div>
		          </form>
		          <div class="text-center">
					<a href="register.jsp" >Don't have an account? Register</a>
				  </div>
				</div>
		      </li>
	        
	        
	        
	        
	        <li><a href="#"><span class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
     	  </ul>
	    </div><!-- /.navbar-collapse -->
	  </div><!-- /.container-fluid -->
	</nav>
	
	
	
	
	
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
	    <div class="item active"><img src="public/img/website/ads/1.jpg" alt="Advert" class="img-responsive center-block"></div>
	    <div class="item"><img src="public/img/website/ads/2.jpg" alt="Advert" class="img-responsive center-block"></div>
	    <div class="item"><img src="public/img/website/ads/3.jpg" alt="Advert" class="img-responsive center-block"></div>
	    <div class="item"><img src="public/img/website/ads/4.jpg" alt="Advert" class="img-responsive center-block"></div>
	    <div class="item"><img src="public/img/website/ads/5.jpg" alt="Advert" class="img-responsive center-block"></div>
	    <div class="item"><img src="public/img/website/ads/6.jpg" alt="Advert" class="img-responsive center-block"></div>
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
				<img src = "public/img/website/categories/extremedeal-left.gif">
				<img src = "public/img/website/categories/home-extremedeal_right.jpg" style = "margin-left: -0.2em;">
				<span>
		  			<img src="public/img/products/77086ss.jpg" class="img-center">
		  			<span class="panel-heading">Toshiba DT01AC1300 3TB SATA3 7200RPM 64MB Cache 3.5in Internal Hard Disk Drive HDD</span>
		  			<div class="panel-footer"><span class ="pull-right">You save $36.99</span> <p style = "text-decoration: line-through;">Reg: 146.99</p><h4>$109.99</h4><button type="button" class="btn pull-right" style = "margin-top: -3em;">Buy now</button></div>
				</span>
			</div>
		</div>
	</div>
	
	 <%
String id = request.getParameter("userId");
String driverName = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String dbName = "form";
String userId = "root";
String password = "password";

try {
Class.forName(driverName);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}

Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>

<table align="center" cellpadding="5" cellspacing="5" border="1">
<tr>

</tr>
<tr >
<td><b>Model</b></td>
<td><b>Name</b></td>
<td><b>Price</b></td>
</tr>
<%
try{ 
connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
statement=connection.createStatement();
String sql ="SELECT * FROM pc_cases";

resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr >

<td><%=resultSet.getString("cases_model") %></td>
<td><%=resultSet.getString("cases_name") %></td>
<td><%=resultSet.getInt("cases_price") %></td>

</tr>

<% 
}

} catch (Exception e) {
e.printStackTrace();
}
%>
</table>
	
	
<!--- Deals --->
	<div class="container">
		<h2>This Week's Top Deals</h2>
		<hr>
		<br>
		<div class="row">
		  <div class="col-sm-4">
		    <div class="panel panel-primary">
		      <div class="panel-heading">Netgear AC5300 R8500 Nighthawk X8 WiFi Router</div>
		      <div class="panel-body"><img src="public/img/products/26052.jpg" class="img-responsive" alt="Image"></div>
		      <div class="panel-footer">$519.00 <button type="button" class="btn pull-right">Buy now</button><p style = "color:red;">Save $40.00</p></div>
		    </div>
		  </div>
		  <div class="col-sm-4"> 
		    <div class="panel panel-danger">
		      <div class="panel-heading">ADATA Premier SP550 480GB SATA 2.5'' SSD</div>
		      <div class="panel-body"><img src="public/img/products/23030.jpg" class="img-responsive" alt="Image"></div>
		      <div class="panel-footer">$169.99 <button type="button" class="btn pull-right">Buy now</button><p style = "color:red;">Save $10.00</p></div>
		    </div>
		  </div>
		  <div class="col-sm-4"> 
		    <div class="panel panel-success">
		      <div class="panel-heading">MSI PE70 6QE-058US Notebook</div>
		      <div class="panel-body"><img src="public/img/products/95982.jpg" class="img-responsive" alt="Image"></div>
		      <div class="panel-footer">$1,459.00 <button type="button" class="btn pull-right">Buy now</button><p style = "color:red;">Save $40.00</p></div>
		      </div>
		    </div>
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