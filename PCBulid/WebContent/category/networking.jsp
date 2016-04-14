<!DOCTYPE html>

<%
String language = (String) request.getParameter("lang");
if (language == null) language = ((String) session.getAttribute("lang")!=null ? (String) session.getAttribute("lang") : "english");
else session.setAttribute("lang",language);
%>
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
		<% if(language.equals("english")){ %>
		<h2>
			<a href="../index.jsp">Home</a> >> <a href="networking.jsp">Networking</a>
		</h2>
		<p>Showing 8 items in Networking</p>
		<% } %>
		<% if(language.equals("french")){ %>
		<h2>
			<a href="../index.jsp">Accueil</a> >> <a href="networking.jsp">La mise en reseau</a>
		</h2>
		<p>Affichage de 8 articles en reseau</p>
		<% } %>
		<hr>
		<br>
		<div class="row">
			<% if(language.equals("english")){ %>
			<div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan">
				<a href="#"><img
					src="../public/img/website/categories/networkadapters.jpg"
					class="img-responsive center-block" alt="Network Adapters">Network Adapters</a>
			</div>
			<div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan">
				<a href="#"><img
					src="../public/img/website/categories/networkswitches.jpg"
					class="img-responsive center-block" alt="Network Switches">Network Switches</a>
			</div>
			<div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan">
				<a href="#"><img
					src="../public/img/website/categories/networktransceivers.jpg"
					class="img-responsive center-block" alt="Network Transceivers">Network Transceivers</a>
			</div>
			<div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan">
				<a href="#"><img
					src="../public/img/website/categories/powerlineethernet.jpg"
					class="img-responsive center-block" alt="Powerline Ethernet">Powerline Ethernet</a>
			</div>
			<div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan">
				<a href="#"><img
					src="../public/img/website/categories/securityfirewall.jpg"
					class="img-responsive center-block" alt="Security Firewall">Security Firewall</a>
			</div>
			<div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan">
				<a href="#"><img
					src="../public/img/website/categories/wifirouters.jpg"
					class="img-responsive center-block" alt="Wi-Fi Routers">Wi-Fi Routers</a>
			</div>
			<div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan">
				<a href="#"><img
					src="../public/img/website/categories/wirelessaccesspoint.jpg"
					class="img-responsive center-block" alt="Wireless Access Points">Wireless Access Points</a>
			</div>
			<div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan">
				<a href="#"><img
					src="../public/img/website/categories/wirelessaccessories.jpg"
					class="img-responsive center-block" alt="Wireless Accessories">Wireless Accessories</a>
			</div>
			<% } %>
			<% if(language.equals("french")){ %>
			<div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan">
				<a href="#"><img
					src="../public/img/website/categories/networkadapters.jpg"
					class="img-responsive center-block" alt="Network Adapters">Adaptateurs reseau</a>
			</div>
			<div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan">
				<a href="#"><img
					src="../public/img/website/categories/networkswitches.jpg"
					class="img-responsive center-block" alt="Network Switches">Commutateurs reseau</a>
			</div>
			<div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan">
				<a href="#"><img
					src="../public/img/website/categories/networktransceivers.jpg"
					class="img-responsive center-block" alt="Network Transceivers">Transceivers reseau</a>
			</div>
			<div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan">
				<a href="#"><img
					src="../public/img/website/categories/powerlineethernet.jpg"
					class="img-responsive center-block" alt="Powerline Ethernet">Ligne electrique Ethernet</a>
			</div>
			<div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan">
				<a href="#"><img
					src="../public/img/website/categories/securityfirewall.jpg"
					class="img-responsive center-block" alt="Security Firewall">Pare-feu de securite</a>
			</div>
			<div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan">
				<a href="#"><img
					src="../public/img/website/categories/wifirouters.jpg"
					class="img-responsive center-block" alt="Wi-Fi Routers">Wifi Routeurs</a>
			</div>
			<div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan">
				<a href="#"><img
					src="../public/img/website/categories/wirelessaccesspoint.jpg"
					class="img-responsive center-block" alt="Wireless Access Points">Points d'acces sans fil</a>
			</div>
			<div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan">
				<a href="#"><img
					src="../public/img/website/categories/wirelessaccessories.jpg"
					class="img-responsive center-block" alt="Wireless Accessories">Accessoires sans fil</a>
			</div>
			<% } %>
		</div>
	</div>

	<br>
	<br>
	<footer class="container-fluid text-center">
		<% if(language.equals("english")){ %>
		<p>Copyright 2016, Prestige Computers</p>
		<form class="form-inline">
			Get deals: <input type="email" class="form-control" size="50"
				placeholder="Email Address">
			<button type="button" class="btn btn-danger">Sign Up</button>
		</form>
		<% } %>
		
		<% if(language.equals("french")){ %>
		<p>Droit d'auteur 2016, Prestige Ordinateurs</p>
		<form class="form-inline">
			Obtenez les offres: <input type="email" class="form-control" size="50"
				placeholder="Email Address">
			<button type="button" class="btn btn-danger">S'inscrire</button>
		</form>
		<% } %>
	</footer>

</body>
</html>