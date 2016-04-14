<%@page import="cart.Cart"%>
<!DOCTYPE html>
<html lang="en">
  <head>
   <link rel="stylesheet" href="/styles/main_style.css">
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
  	<jsp:include page="/components/navbar.jsp"/>
	
			<% Cart cart = ((Cart)session.getAttribute("cart"));
			if(session.getAttribute ("user") == null || cart == null || cart.getProductCount () == 0)
				response.sendRedirect (request.getContextPath () + "/" + "cart.jsp");
			%>
			
	<br>
	<div class="container">
<h2><a href = "/index.jsp">Home</a> >> <a href = "../../cart.jsp">Cart</a> >> <a href = "checkout.jsp">Checkout</a></h2>
<hr>
<br>
		Checkout Information: <hr> <br />
		
		<form>
		    <div class="form-group"><input name = "address" type="text" class="form-control"  class="form-control input-sm" placeholder="Full Address" required = "required"></div>
		    <div class="form-group"><input name = "addressLine2" type="text" class="form-control"  class="form-control input-sm" placeholder="Address Line 2"></div>
		    <div class="form-group"><input name = "city" type="text" class="form-control"  class="form-control input-sm" placeholder="City" required = "required"></div>
		    <div class="form-group"><input name = "postal" type="text" class="form-control"  class="form-control input-sm" placeholder="Postal Code" required = "required"></div>
		    <div class="form-group"><input name = "fullName" type="text" class="form-control"  class="form-control input-sm" placeholder="Cardholder Full Name" required = "required"></div>
		    <div class="form-group"><input name = "number" type="number" class="form-control"  class="form-control input-sm" placeholder="Credit Card Number" required = "required"></div>
		    <div class="form-group"><input name = "expiry" type="text" class="form-control"  class="form-control input-sm" placeholder="Expiry Date" required = "required"></div>
		    <div class="form-group"><input name = "cvc" type="number" class="form-control"  class="form-control input-sm" placeholder="CVC Code" required = "required"></div>
		    <a type="button" class="btn btn-info" href = "index.jsp">Submit</a>
		</form> <br /> <br />
		<a type="button" class="btn btn-info" href = "index.jsp">Home Page</a>
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