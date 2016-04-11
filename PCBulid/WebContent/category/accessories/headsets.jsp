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
<link href="../../public/css/colorbox.css" rel="stylesheet">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery.colorbox/1.6.3/jquery.colorbox-min.js"></script>
<style>
body {
	background: url("../../public/img/backdrop.png");
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
  	<jsp:include page="../../components/navbar.jsp"/>

	<!--- Sales --->
	<div class="container">
		<h2>
			<a href="../../index.jsp">Home</a> >> <a href="../accessories.jsp">Accessories</a>
			>> <a href="headsets.jsp">Headsets</a>
		</h2>
		<p>Showing 7 items in Headsets</p>
		<hr>
		<br>
		<div class="row">
			<div class="col-sm-6">
				<div class="panel panel-danger" style="height: 16.5em;">
					<div class="panel-heading">
						Genius MIC-05A, Multimedia Microphone
						<p style="font-size: 0.7em;">Item Code: HSGE000135</p>
					</div>
					<div class="panel-body">
						<img src="../../public/img/products/68493.jpg"
							class="img-responsive center-block" alt="Image">
					</div>
					<div class="panel-footer" style="height: 5.35em;">
						<span class="pull-right" style="color: red; font-size: 0.8em;">
						</span>
						<p style="text-decoration: line-through; font-size: 0.6em;"></p>
						<button type="button" class="btn pull-right">Add to cart</button>
						<h5>$7.99</h5>
					</div>
				</div>
			</div>
			<div class="col-sm-6">
				<div class="panel panel-danger" style="height: 16.5em;">
					<div class="panel-heading">
						Kingston HyperX Cloud II Cloud II- Pro Gaming Headset (Red)
						<p style="font-size: 0.7em;">Item Code: HSKT000046</p>
					</div>
					<div class="panel-body">
						<img src="../../public/img/products/44938.jpg"
							class="img-responsive center-block" alt="Image">
					</div>
					<div class="panel-footer" style="height: 5.35em;">
						<span class="pull-right" style="color: red; font-size: 0.8em;">Save
							$20.00</span>
						<p style="text-decoration: line-through; font-size: 0.6em;">$139.99</p>
						<button type="button" class="btn pull-right">Add to cart</button>
						<h5>$119.99</h5>
					</div>
				</div>
			</div>
			<div class="col-sm-6">
				<div class="panel panel-danger">
					<div class="panel-heading">MSI PE70 6QE-058US Notebook</div>
					<div class="panel-body">
						<img src="../../public/img/products/95982.jpg"
							class="img-responsive center-block" alt="Image">
					</div>
					<div class="panel-footer">
						$1,459.00
						<button type="button" class="btn pull-right">Add to cart</button>
						<p style="color: red;">Save $40.00</p>
					</div>
				</div>
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