<%@ page import = "cart.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Prestige Computers</title>
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<link
	href="//netdna.bootstrapcdn.com/bootswatch/3.1.0/united/bootstrap.min.css"
	rel="stylesheet">
<link href="public/css/colorbox.css" rel="stylesheet">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery.colorbox/1.6.3/jquery.colorbox-min.js"></script>
<style>
body {
	background: url("public/img/backdrop.png");
	font: 400 15px Lato, sans-serif;
}

.centered-form .panel {
	background: rgba(255, 255, 255, 0.8);
	box-shadow: rgba(0, 0, 0, 0.3) 20px 20px 20px;
}

.panel:hover {
	box-shadow: 5px 0px 40px rgba(0, 0, 0, .2);
}

.centered-form {
	margin-top: 60px;
}

.register:hover {
	box-shadow: 0px 0px 0px rgba(0, 0, 0, 0);
}

.register {
	display: block;
}
</style>
</head>
<body>
  	<jsp:include page="components/navbar.jsp"/>

	<!--- Main --->
	<div class="container">
		<h2>
			<a href="index.jsp">Home</a> >> <a href="cart.jsp">My Shopping Cart</a>
		</h2>
		<% Cart cart = ((Cart)session.getAttribute("cart"));
		if(cart == null){ %>
		<p>Your shopping cart is empty!</p>
		<% } else if( cart.getProductCount() <= 0 ){ %>
		<p>Your shopping cart is empty!</p>
		<% } else if(cart.getProductCount() > 0){ 
			out.print("Items: <hr>");
			for(int i = 0; i < cart.getProductCount(); i++){
				Item item = cart.getItem(i);%>
				
				<div class="col-sm-12">
					<div class="panel panel-danger">
						<div class="panel-heading"><%out.print(item.getName());%>
						<p style="font-size: 0.7em;"><%out.print(item.getModel());%></p>
						</div>
						<div class="panel-body">
							<img
								src="<%out.print(item.getImagePath().substring(6));%>" style = "height: 6em;" />
						</div>
						<div class="panel-footer" style="height: 5.35em;">

							<form action = "/PCBulid/RemoveItemServlet" method = "post">
								<input type="hidden" name="index" value="<%out.print(i);%>">
								<input type="submit" value="Remove" class="btn pull-right"/>
							</form>
							<h5>$<%out.print(item.getPrice());%></h5>
						</div>
					</div>
				</div>
			<% }
			out.print("Total: $" + String.format ("%.2d", cart.getTotal ()));%>
			<hr>
			<form action = "/PCBulid/EmptyCartServlet" method = "post">
				<input type="submit" value="Empty Cart" class="btn btn-danger pull-right"/>
			</form>
		<% } %>
		
		<a type="button" class="btn btn-info" href = "index.jsp">Continue Shopping</a>
		<br>
		<% if(cart!=null) {
			if(cart.getProductCount() > 0){ %>
		<hr>
		<a type="button" class="btn btn-info btn-block" href = "index.jsp">Checkout</a>
		<% }
			} %>
	</div>

	<br>
	<br>
	<footer class="container-fluid text-center">
		<p>Copyright 2016, Prestige Computers</p>
		<form class="form-inline">
			Get deals: <input type="email" class="form-control" size="50"
				placeholder="Email Address">
			<button type="button" class="btn btn-danger">Sign Up</button>
		</form>
	</footer>

</body>
</html>