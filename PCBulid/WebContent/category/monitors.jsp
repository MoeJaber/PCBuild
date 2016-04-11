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
			<a href="../index.jsp">Home</a> >> <a href="monitors.jsp">Monitors</a>
		</h2>
		<p>Showing 8 items in Monitors</p>
		<hr>
		<br>
		<div class="row">
			<div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan">
				<a href="#"><img src="../public/img/website/categories/4k.jpg"
					class="img-responsive center-block" alt="4K Monitors">4K
					Monitors</a>
			</div>
			<div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan">
				<a href="#"><img
					src="../public/img/website/categories/curved.jpg"
					class="img-responsive center-block" alt="Curved Monitors">Curved
					Monitors</a>
			</div>
			<div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan">
				<a href="#"><img
					src="../public/img/website/categories/digitalsignage.jpg"
					class="img-responsive center-block" alt="Digital Signage">Digital
					Signage</a>
			</div>
			<div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan">
				<a href="#"><img
					src="../public/img/website/categories/gamingmonitors.jpg"
					class="img-responsive center-block" alt="Gaming Monitors">Gaming
					Monitors</a>
			</div>
			<div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan">
				<a href="#"><img
					src="../public/img/website/categories/graphicsmonitors.jpg"
					class="img-responsive center-block" alt="Graphics Monitors">Graphics
					Monitors</a>
			</div>
			<div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan">
				<a href="#"><img
					src="../public/img/website/categories/lcdmonitors.jpg"
					class="img-responsive center-block" alt="LCD Monitors">LCD
					Monitors</a>
			</div>
			<div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan">
				<a href="#"><img
					src="../public/img/website/categories/monitoraccessories.jpg"
					class="img-responsive center-block" alt="Monitor Accessories">Monitor
					Accessories</a>
			</div>
			<div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan">
				<a href="#"><img
					src="../public/img/website/categories/touchscreen.jpg"
					class="img-responsive center-block" alt="Touchscreen">Touchscreen</a>
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