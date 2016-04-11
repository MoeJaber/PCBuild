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
<link href="../public/css/colorbox.css" rel="stylesheet">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery.colorbox/1.6.3/jquery.colorbox-min.js"></script>
<style>
body {
	background: url("../public/img/backdrop.png");
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
  	<jsp:include page="../components/navbar.jsp"/>

	<!--- Sales --->
	<div class="container">
		<h2>
			<a href="../index.jsp">Home</a> >> <a href="accessories.jsp">Accessories</a>
		</h2>
		<p>Showing 8 items in Accessories</p>
		<hr>
		<br>
		<div class="row">
			<div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan">
				<a href="#"><img
					src="../public/img/website/categories/batteries.jpg"
					class="img-responsive center-block" alt="Batteries & Power">Batteries
					& Power</a>
			</div>
			<div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan">
				<a href="#"><img
					src="../public/img/website/categories/media.jpg"
					class="img-responsive center-block" alt="Blank Media">Blank
					Media</a>
			</div>
			<div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan">
				<a href="#"><img
					src="../public/img/website/categories/cables.jpg"
					class="img-responsive center-block" alt="Cables">Cables</a>
			</div>
			<div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan">
				<a href="#"><img
					src="../public/img/website/categories/cases.jpg"
					class="img-responsive center-block" alt="Carrying Cases">Carrying
					Cases</a>
			</div>
			<div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan">
				<a href="#"><img
					src="../public/img/website/categories/mousepads.jpg"
					class="img-responsive center-block" alt="Mousepads">Mouse-pads</a>
			</div>
			<div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan">
				<a href="accessories/headsets.jsp"><img
					src="../public/img/website/categories/headphones.jpg"
					class="img-responsive center-block" alt="PC Headsets">PC
					Headsets</a>
			</div>
			<div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan">
				<a href="#"><img
					src="../public/img/website/categories/powermanagements.jpg"
					class="img-responsive center-block" alt="Power Management">Power
					Management</a>
			</div>
			<div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan">
				<a href="#"><img
					src="../public/img/website/categories/audio.jpg"
					class="img-responsive center-block" alt="Speakers & Audio">Speakers
					& Audio</a>
			</div>
		</div>
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