<%@ page import = "admin.*" %>
<%@ page import = "cart.Item" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "user.User" %>
<% %>
<!-- 
	Admin home page, displays all items and allows removing them.
	
	- Kieran Gillibrand
	
	- Uses site CSS by Nick Horlings	

-->
 
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
			<a href="index.jsp">Home</a> >> <a href="admin.jsp">Admin Home</a>
		</h2>
		<% if (session.getAttribute ("user") == null || !((User) session.getAttribute ("user")).getAdmin ()) 
			response.sendRedirect (request.getContextPath () + "/" + "index.jsp");
		%>
		
		<jsp:include page = "/AdminListItemsServlet"></jsp:include>

		<% ArrayList <Item> items = ((ArrayList <Item>) session.getAttribute ("items"));
		if(items == null){ %>
		<p>No items found!</p>
		<% } else if(items.size () == 0 ){ %>
		<p>No items found!</p>
		<% } else
			{ 
			out.print("All Items: <hr><br />");
			for (int itemIndex = 0; itemIndex < items.size (); ++itemIndex){
				%>
				
				<div class="col-sm-12">
					<div class="panel panel-danger">
						<div class="panel-heading"> <a href = "/PCBulid/category/computerHardware/specs.jsp?itemId=<%out.print (items.get (itemIndex).getID ());%>"><%out.print(items.get (itemIndex).getName ());%></a>
						<p style="font-size: 0.7em;"><%out.print(items.get (itemIndex).getModel ());%></p>
						</div>
						<div class="panel-body">
							<img
								src="<%out.print(items.get (itemIndex).getImagePath ());%>" style = "height: 6em;" />
						</div>
						<div class="panel-footer" style="height: 5.35em;">
							<form action = "/PCBulid/AdminRemoveItemServlet" method = "post">
								<input type="hidden" name="removeIndex" value="<%out.print(itemIndex);%>">
								<input type="hidden" name="removeID" value="<%out.print(items.get (itemIndex).getID ());%>">
								<input type="hidden" name="categoryName" value="<%out.print(items.get (itemIndex).getCategoryName ());%>">
								<input type="hidden" name="imagePath" value="<%out.print(items.get (itemIndex).getImagePath ());%>">
								<input type="submit" value="Remove" class="btn pull-right"/>
							</form>
							<h5>$<%out.print (items.get (itemIndex).getPrice ());%></h5>
						</div>
					</div>
				</div>
			<% }%>
			<hr>
		<% } %>
		
		<a type="button" class="btn btn-info" href = "addItem.jsp">Add Item</a> <br /> <br />
		<a type="button" class="btn btn-info" href = "index.jsp">Home Page</a>
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
