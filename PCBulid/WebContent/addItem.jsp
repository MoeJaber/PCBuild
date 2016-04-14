<%@ page import = "admin.*" %>
<%@ page import = "cart.Item" %>
<%@page import = "user.User" %>

<!-- 
	Admin add item page, contains a form to add a new item to the store.
	
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

	<% if (session.getAttribute ("user") == null || !((User) session.getAttribute ("user")).getAdmin ()) 
		response.sendRedirect (request.getContextPath () + "/" + "index.jsp");
		%>
		
	<!--- Main --->
	<div class="container">
		<h2>
			<a href="index.jsp">Home</a> >> <a href="addItem.jsp">Add Item</a>
		</h2>
		Add Item: <hr> <br />
		
		<form action = "/PCBulid/AdminAddItemServlet" method = "post" enctype = "multipart/form-data">
			<div class="form-group">
				<select class="form-control"  class="form-control input-sm" required = "required" name = "categoryName">
					<option>Select an item category</option>
					<option value = "Cases">Cases</option>
					<option value = "CPU">CPU</option>
					<option value = "GPU">GPU</option>
					<option value = "Harddrive">Harddrive</option>
					<option value = "Headset">Headset</option>
					<option value = "Memory">Memory</option>
					<option value = "Motherboard">Motherboard</option>
					<option value = "PSU">PSU</option>
					<option value = "SSD">SSD</option>
				</select>
			</div>
			
		    <div class="form-group"><input name = "itemName" type="text" class="form-control"  class="form-control input-sm" placeholder="Item Name" required = "required"></div>
		    <div class="form-group"><input name = "itemModel" type="text" class="form-control"  class="form-control input-sm" placeholder="Item Model" required = "required"></div>
		    <div class="form-group"><input name = "itemPrice" type="text" class="form-control"  class="form-control input-sm" placeholder="Item Price" required = "required"></div>
		    <div class="form-group"><input name = "itemBrand" type="text" class="form-control"  class="form-control input-sm" placeholder="Item Brand" required = "required"></div>
		    <div class="form-group"><input name = "itemSeries" type="text" class="form-control"  class="form-control input-sm" placeholder="Item Series" required = "required"></div>
		    <div class="form-group"><input name = "itemModelNumber" type="text" class="form-control"  class="form-control input-sm" placeholder="Item Model Number" required = "required"></div>
		    <div class="form-group"><input name = "itemType" type="text" class="form-control"  class="form-control input-sm" placeholder="Item Type" required = "required"></div>
		    <div class="form-group"><input name = "itemCapacity" type="text" class="form-control"  class="form-control input-sm" placeholder="Item Capacity" required = "required"></div>
		    <div class="form-group"><input name = "itemInterface" type="text" class="form-control"  class="form-control input-sm" placeholder="Item Interface" required = "required"></div>
		    <div class="form-group"><input name = "itemDescription" type="text" class="form-control"  class="form-control input-sm" placeholder="Item Description" required = "required"></div>
		    <div>Select an image to upload:</div><div class="form-group"><input name = "image" type="file" class="form-control" accept = ".png, .jpg, .jpeg, .bmp, .gif, image/*" class="form-control input-sm" placeholder="Item Image"></div>
		    <button type="submit" class="btn btn-info btn-block">Add Item</button>
		</form> <br /> <br />
		
		<a type="button" class="btn btn-info" href = "admin.jsp">Admin Home</a> <br /> <br />
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
