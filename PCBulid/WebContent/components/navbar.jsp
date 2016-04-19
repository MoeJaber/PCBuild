<%@ page import = "user.User" %> 	
<%@ page import = "registration.RegistrationServlet" %> 		
<%@ page import = "login.LoginServlet" %> 	
<%@ page import = "cart.*" %>

<%
String language = (String) request.getParameter("lang");
if (language == null) language = ((String) session.getAttribute("lang")!=null ? (String) session.getAttribute("lang") : "english");
else session.setAttribute("lang",language);
%>

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
	          <% if(language.equals("english")){ %>
	          	<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Department<span class="caret"></span></a>
	          <% }
	          if(language.equals("french")){%>
	          	<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Departement<span class="caret"></span></a>
	          <% } %>
	          <ul class="dropdown-menu" style = "padding-top: 1em;">
	          	<% if(language.equals("english")){ %>
	            <li><a href="/PCBulid/category/computerhardware.jsp">Computer Hardware</a></li>
	            <li><a href="/PCBulid/category/laptoptablet.jsp">Laptop & Tablet</a></li>
	            <li><a href="/PCBulid/category/networking.jsp">Networking</a></li>
	            <% }
	          	if(language.equals("french")) {%>
	          	
	            <li><a href="/PCBulid/category/computerhardware.jsp">Materiel Informatique</a></li>
	            <li><a href="/PCBulid/category/laptoptablet.jsp">Ordinateur portable et Tablet</a></li>
	            <li><a href="/PCBulid/category/networking.jsp">La mise en reseau</a></li>
	            
	          	<% } %>
	          </ul>
	        </li>
	      </ul>
	      
	      <!--- Search Bar --->
		      	<% if(language.equals("english")){ %>
		        	<form action = "/PCBulid/SearchServlet" method = "post" class="navbar-form navbar-left">
		          		<div class="form-group"><input type="text" class="form-control" placeholder="Search Products" name = "search"></div>
						<div class="form-group"><input type="submit" value="Go" class="btn btn-default"/></div>
					</form>
				<% } %>
				<% if(language.equals("french")){ %>
				
		        	<form action = "/PCBulid/SearchServlet" method = "post" class="navbar-form navbar-left">
		          		<div class="form-group"><input type="text" class="form-control" placeholder="Recherche de produits" name = "search"></div>
						<div class="form-group"><input type="submit" value="Aller" class="btn btn-default"/></div>
					</form>
				<% } %>
	      
	      <!--- Right Side Nav --->
	      <ul class="nav navbar-nav navbar-right">
			<li class="dropdown" id="menuLogin">
				<% if(language.equals("english")){ %>
		        <a class="dropdown-toggle" href="#" data-toggle="dropdown" id="navLogin"><span class="glyphicon glyphicon-user"></span> Your Account<span class="caret"></span></a>
		        <% } %>
		        <% if(language.equals("french")){ %>
		        <a class="dropdown-toggle" href="#" data-toggle="dropdown" id="navLogin"><span class="glyphicon glyphicon-user"></span> Votre Compte<span class="caret"></span></a>
		       
		        <% } %>
		        <div class="dropdown-menu" style="padding:17px; width: 25em !important;">
		          <% if(session.getAttribute("user")==null){ %>
		          <form action = "/PCBulid/LoginServlet" method = "post">
		            <div class="form-group"><input name = "email" 'type="email" class="form-control"  class="form-control input-sm" placeholder="Email"></div>
		            <div class="form-group"><input name = "password" type="password" class="form-control"  class="form-control input-sm" placeholder="Password"></div>
		            <% if(session.getAttribute("warning")!=null){ %> <div class="alert alert-danger"> <% out.print(session.getAttribute("warning")); %> </div> <% } %>
		            <div class="form-group"><button type="submit" class="btn btn-info btn-block">Sign in</button></div>
		            <div class="checkbox">
		            	<% if(language.equals("english")){ %>
			            <label><input name="remember" type="checkbox" value="Remember Me">Remember Me
			            <a href="forgot.jsp" class="pull-right">Forgot Password?</a>
			            <% } %>
			            <% if(language.equals("french")){ %>
			            <label><input name="remember" type="checkbox" value="Remember Me">Souviens-toi de moi
			            <a href="forgot.jsp" class="pull-right">Mot de passe oublie?</a>
			            <% } %>
			            </label>
					</div>
		          </form>
		          <div class="text-center">
		          	<% if(language.equals("english")){ %>
					<a class="inline" href="#inline_content">Don't have an account? Register</a>
					<% } %>
					
		          	<% if(language.equals("french")){ %>
					<a class="inline" href="#inline_content">Ne pas avoir un compte? Registre</a>
					<% } %>
				  </div>
				  
				  
		          <% }
		          else {
		        	  
		          %>
		          
		          
	            	<div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan"><img src="/PCBulid/public/img/website/icons/user.png" class="img-responsive" alt="User"></div>
	            	<% if(language.equals("english")){ %>
		            	<p>Hello, <% 
		            	User user = (User) session.getAttribute("user");
		            	Cart cart = ((Cart)session.getAttribute("cart"));
		            	out.print(user.getFirstName()); %>!</p>
		            	<% if(cart == null){ %>
		            		<p>You have 0 items in your cart.</p>
		            	<% } 
		            	if(cart != null) {%>
			            	<% if(cart.getProductCount() > 0){ %>
			            		<p>You have <% cart.getProductCount(); %> items in your cart.</p>
			            	<% }%>
			            	<% if(cart.getProductCount() <= 0){ %>
			            		<p>You have 0 items in your cart.</p>
			            	<% } %>
			            <% } %>
		            	<p>Select a language: <a href = "/PCBulid/index.jsp?lang=english">English</a>      <a href = "/PCBulid/index.jsp?lang=french">French</a></p>
			          <% } %>
		          	<% if(language.equals("french")){%>
			          	<p>Bonjour, <% 
		            	User user = (User) session.getAttribute("user");
		            	Cart cart = ((Cart)session.getAttribute("cart"));
		            	out.print(user.getFirstName()); %>!</p>
		            	
		            	<% if(cart == null){ %>
		            		<p>Vous avez 0 articles dans votre panier.</p>
		            	<% } %>
		            	<% if(cart != null) { %>
			            	<% if(cart.getProductCount() > 0){ %>
			            		<p>Vous avez <% cart.getProductCount(); %> articles dans votre panier.</p>
			            	<% }%>
			            	<% if(cart.getProductCount() <= 0){ %>
			            		<p>Vous avez 0 articles dans votre panier.</p>
			            	<% } %>
			            <% } %>
		            	<p>Select a language: <a href = "/PCBulid/index.jsp?lang=english">English</a>      <a href = "/PCBulid/index.jsp?lang=french">French</a></p>
			          	
		          	
		          	<% } %>
					<%if (((User) session.getAttribute ("user")).getAdmin ())
						{
						%>
						<% if(language.equals("english")){ %>
							<p><a href = "/PCBulid/admin.jsp">Admin Home</a> <br /> <a href = "/PCBulid/addItem.jsp">Add Item</a></p>
						<% } %>
						<% if(language.equals("french")){ %>
							<p><a href = "/PCBulid/admin.jsp">Accueil admin</a> <br /> <a href = "/PCBulid/addItem.jsp">Ajouter un item</a></p>
						<% } %>
						<%} %>
						
						<% if(language.equals("english")){ %>
							<form action = "/PCBulid/LogoutServlet" method = "post">
								<input type="submit" value="Logout" class="btn btn-info btn-block"/>
							</form>
						<% } %>
						<% if(language.equals("french")){ %>
							<form action = "/PCBulid/LogoutServlet" method = "post">
								<input type="submit" value="Se deconnecter" class="btn btn-info btn-block"/>
							</form>
						<% } %>
					
		          <% }%>
				</div>
		      </li>
	        
	        
	        
	        <% if(language.equals("english")){ %>
	        	<li><a href="/PCBulid/cart.jsp"><span class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
	        <% } %>
	        <% if(language.equals("french")){ %>
	        	<li><a href="/PCBulid/cart.jsp"><span class="glyphicon glyphicon-shopping-cart"></span> Chariot</a></li>
	        <% } %>
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