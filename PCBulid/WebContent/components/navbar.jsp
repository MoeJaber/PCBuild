<%@ page import = "user.User" %> 	
<%@ page import = "registration.RegistrationServlet" %> 		
<%@ page import = "login.LoginServlet" %> 	
<script>
	jQuery(document).ready(function() {
		$(".inline").colorbox({
			inline : true,
			width : "50%"
		});
	});
	

</script>
 	<!--- Jumbotron Prestige Computers --->
    <div class="jumbotron">
		<div class="container text-center">
    		<img src = "/PCBulid/public/img/website/banner.png" class="img-responsive center-block" alt="Prestige Computers">
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
	      <a class="navbar-brand" href="/PCBulid/index.jsp"><span class="glyphicon glyphicon-globe logo"></span> Prestige Computers</a>
	    </div>
	
	    <!-- Departments -->
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	      <ul class="nav navbar-nav">
	        <li class="dropdown">
	          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Department<span class="caret"></span></a>
	          <ul class="dropdown-menu" style = "padding-top: 1em;">
	            <li><a href="/PCBulid/category/computerhardware.jsp">Computer Hardware</a></li>
	            <li><a href="/PCBulid/category/laptoptablet.jsp">Laptop & Tablet</a></li>
	            <li><a href="/PCBulid/category/networking.jsp">Networking</a></li>
	            <li><a href="/PCBulid/category/hometheatre.jsp">TV & Home Theatre</a></li>
	            <li><a href="/PCBulid/category/mobilephones.jsp">Mobile Phones</a></li>
	            <li><a href="/PCBulid/category/electronics.jsp">Electronics</a></li>
	            <li><a href="/PCBulid/category/monitors.jsp">Monitors</a></li>
	            <li><a href="/PCBulid/category/desktop.jsp">Desktop</a></li>
	            <li><a href="/PCBulid/category/accessories.jsp">Accessories</a></li>
	            <li><a href="/PCBulid/category/gadget.jsp">Gadget & Toys</a></li>
	            <li><a href="/PCBulid/category/consoles.jsp">Game Consoles</a></li>
	            <li><a href="/PCBulid/category/printers.jsp">Printers</a></li>
	            <li><a href="/PCBulid/category/pointofsale.jsp">Point of Sale</a></li>
	            <li><a href="/PCBulid/category/software.jsp">Software</a></li>
	          </ul>
	        </li>
	        <!--- Brands --->
	        <li class="dropdown">
	          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Brands<span class="caret"></span></a>
	          <div class="dropdown-menu" style = "width: 50em !important;">
	            <div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan"><a href="/PCBulid/brands/adata.jsp"><img src="/PCBulid/public/img/brands/adata.gif" class="img-responsive" alt="ADATA"></a></div>
	            <div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan"><a href="/PCBulid/brands/amd.jsp"><img src="/PCBulid/public/img/brands/amd.gif" class="img-responsive" alt="AMD"></a></div>
	            <div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan"><a href="/PCBulid/brands/asus.jsp"><img src="/PCBulid/public/img/brands/asus.gif" class="img-responsive" alt="ASUS"></a></div>
	            <div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan"><a href="/PCBulid/brands/benq.jsp"><img src="/PCBulid/public/img/brands/benq.gif" class="img-responsive" alt="BENQ"></a></div>
	            <div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan"><a href="/PCBulid/brands/corsair.jsp"><img src="/PCBulid/public/img/brands/corsair.gif" class="img-responsive" alt="Corsair"></a></div>
	            <div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan"><a href="/PCBulid/brands/evga.jsp"><img src="/PCBulid/public/img/brands/evga.gif" class="img-responsive" alt="EVGA"></a></div>
	            <div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan"><a href="/PCBulid/brands/gigabyte.jsp"><img src="/PCBulid/public/img/brands/gigabyte.gif" class="img-responsive" alt="Gigabyte"></a></div>
	            <div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan"><a href="/PCBulid/brands/gopro.jsp"><img src="/PCBulid/public/img/brands/gopro.gif" class="img-responsive" alt="GoPro"></a></div>
	            <div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan"><a href="/PCBulid/brands/intel.jsp"><img src="/PCBulid/public/img/brands/intel.gif" class="img-responsive" alt="Intel"></a></div>
	            <div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan"><a href="/PCBulid/brands/kingston.jsp"><img src="/PCBulid/public/img/brands/kingston.gif" class="img-responsive" alt="Kingston"></a></div>
	            <div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan"><a href="/PCBulid/brands/lenovo.jsp"><img src="/PCBulid/public/img/brands/lenovo.gif" class="img-responsive" alt="Lenovo"></a></div>
	            <div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan"><a href="/PCBulid/brands/linksys.jsp"><img src="/PCBulid/public/img/brands/linksys.gif" class="img-responsive" alt="Linksys"></a></div>
	            <div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan"><a href="/PCBulid/brands/logitech.jsp"><img src="/PCBulid/public/img/brands/logitech.gif" class="img-responsive" alt="Logitech"></a></div>
	            <div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan"><a href="/PCBulid/brands/microsoft.jsp"><img src="/PCBulid/public/img/brands/microsoft.gif" class="img-responsive" alt="Microsoft"></a></div>
	            <div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan"><a href="/PCBulid/brands/msi.jsp"><img src="/PCBulid/public/img/brands/msi.gif" class="img-responsive" alt="MSi"></a></div>
	            <div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan"><a href="/PCBulid/brands/nvidia.jsp"><img src="/PCBulid/public/img/brands/nvidia.gif" class="img-responsive" alt="nVidia"></a></div>
	            <div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan"><a href="/PCBulid/brands/samsung.jsp"><img src="/PCBulid/public/img/brands/samsung.gif" class="img-responsive" alt="Samsung"></a></div>
	            <div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan"><a href="/PCBulid/brands/sandisk.jsp"><img src="/PCBulid/public/img/brands/sandisk.gif" class="img-responsive" alt="SanDisk"></a></div>
	            <div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan"><a href="/PCBulid/brands/seagate.jsp"><img src="/PCBulid/public/img/brands/seagate.gif" class="img-responsive" alt="Seagate"></a></div>
	          </div>
	        </li>
	      </ul>
	      
	      <!--- Search Bar --->
	        	<form action = "/PCBulid/SearchServlet" method = "post" class="navbar-form navbar-left">
	          		<div class="form-group"><input type="text" class="form-control" placeholder="Search Products" name = "search"></div>
					<div class="form-group"><input type="submit" value="Go" class="btn btn-default"/></div>
				</form>
	      
	      <!--- Right Side Nav --->
	      <ul class="nav navbar-nav navbar-right">
			<li class="dropdown" id="menuLogin">
		        <a class="dropdown-toggle" href="#" data-toggle="dropdown" id="navLogin"><span class="glyphicon glyphicon-user"></span> Your Account<span class="caret"></span></a>
		        <div class="dropdown-menu" style="padding:17px; width: 25em !important;">
		          <% if(session.getAttribute("user")==null){ %>
		          <form action = "/PCBulid/LoginServlet" method = "post">
		            <div class="form-group"><input name = "email" 'type="email" class="form-control"  class="form-control input-sm" placeholder="Email"></div>
		            <div class="form-group"><input name = "password" type="password" class="form-control"  class="form-control input-sm" placeholder="Password"></div>
		            <% if(session.getAttribute("warning")!=null){ %> <div class="alert alert-danger"> <% out.print(session.getAttribute("warning")); %> </div> <% } %>
		            <div class="form-group"><button type="submit" class="btn btn-info btn-block">Sign in</button></div>
		            <div class="checkbox">
			            <label><input name="remember" type="checkbox" value="Remember Me">Remember Me
			            <a href="forgot.jsp" class="pull-right">Forgot Password?</a>
			            </label>
					</div>
		          </form>
		          <div class="text-center">
					<a class="inline" href="#inline_content">Don't have an account? Register</a>
				  </div>
				  
				  
		          <% }
		          else {
		        	  
		          %>
		          
		          
	            	<div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan"><img src="/PCBulid/public/img/website/icons/user.png" class="img-responsive" alt="User"></div>
	            	<p>Hello, <% 
	            	User user = (User) session.getAttribute("user");
	            	out.print(user.getFirstName()); %>!</p>
	            	<p>You have 0 items in your cart.</p>
	            	<p>Select a language: <a href = "/PCBulid/index.jsp?lang=english">English</a>      <a href = "/PCBulid/index.jsp?lang=french">French</a></p>
		          	<form action = "/PCBulid/LogOutServlet" method = "post">
						<input type="submit" value="Logout" class="btn btn-info btn-block"/>
					</form>
		          
		          <% }%>
				</div>
		      </li>
	        
	        
	        
	        
	        <li><a href="/PCBulid/cart.jsp"><span class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
     	  </ul>
	    </div><!-- /.navbar-collapse -->
	  </div><!-- /.container-fluid -->
	</nav>
	
	
	<br>
	<!-- Hidden Register Form -->
	<div style="display: none;">
		<div id="inline_content">
			<form class="form-horizontal" role="form" method = "post" action = "/PCBulid/RegistrationServlet">
				<fieldset>
					<div class="panel-heading">
						<h2 class="panel-title">Register a New Account</h2>
					</div>
					<hr>

					<div class="control-group">
						<!-- Username -->
						<label class="control-label" for="username">First Name</label>
						<div class="controls">
							<input type="text" name="first_name"
								class="form-control input-sm" placeholder="First Name">
							<p class="help-block">First name, eg. John</p>
						</div>
					</div>
					<div class="control-group">
						<!-- Username -->
						<label class="control-label" for="username">Last Name</label>
						<div class="controls">
							<input type="text" name="last_name" class="form-control input-sm"
								placeholder="Last Name">
							<p class="help-block">Last name, eg. Smith</p>
						</div>
					</div>

					<div class="control-group">
						<!-- E-mail -->
						<label class="control-label" for="email">E-mail</label>
						<div class="controls">
							<input type="email" id="email" name="email"
								placeholder="Email Address" class="form-control input-sm">
							<p class="help-block">Please provide your E-mail</p>
						</div>
					</div>

					<div class="control-group">
						<!-- Password-->
						<label class="control-label" for="password">Password</label>
						<div class="controls">
							<input type="password" id="password" name="password"
								placeholder="Password" class="form-control input-sm">
							<p class="help-block">Password should be at least 4
								characters</p>
						</div>
					</div>

					<div class="control-group">
						<!-- Password -->
						<label class="control-label" for="password_confirm">Password
							(Confirm)</label>
						<div class="controls">
							<input type="password" id="password_confirmation"
								name="password_confirmation" placeholder="Confirm Password"
								class="form-control input-sm">
							<p class="help-block">Please confirm password</p>
						</div>
					</div>

					<div class="control-group">
						<!-- Button -->
						<div class="controls">
							<input type="submit" value="Register"
								class="btn btn-info btn-block"/>
						</div>
					</div>
				</fieldset>
			</form>
		</div>
	</div>