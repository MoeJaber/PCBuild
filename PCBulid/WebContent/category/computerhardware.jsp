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
		<% if(language.equals("english")){%>
		<h2>
			<a href="../index.jsp">Home</a> >> <a href="computerhardware.jsp">Computer
				Hardware</a>
		</h2>
		<p>Showing 8 items in Computer Hardware</p>
		<% } %>
		<% if(language.equals("french")){ %>
		<h2>
			<a href="../index.jsp">Accueil</a> >> <a href="computerhardware.jsp">Materiel informatique</a>
		</h2>
		<p>Affichage 8 pieces Materiel informatique</p>
		<% } %>
		<hr>
		<br>
		<div class="row">
		  <% if(language.equals("english")){ %>
		  <div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan"><a href="computerHardware/harddrives.jsp"><img src="../public/img/website/categories/hard drives.jpg" class="img-responsive center-block" alt="Hard-drives">Hard Drives</a></div>
          <div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan"><a href="computerHardware/cpu.jsp"><img src="../public/img/website/categories/cpu.jpg" class="img-responsive center-block" alt="Intel & AMD CPU">Intel & AMD CPU</a></div>
          <div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan"><a href="computerHardware/gpu.jsp"><img src="../public/img/website/categories/video-cards.jpg" class="img-responsive center-block" alt="Video Cards">Video Cards</a></div>
          <div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan"><a href="computerHardware/cases.jsp"><img src="../public/img/website/categories/computer-cases.jpg" class="img-responsive center-block" alt="Computer Cases">Computer Cases</a></div>
          <div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan"><a href="computerHardware/ram.jsp"><img src="../public/img/website/categories/ram.jpg" class="img-responsive center-block" alt="RAM">RAM</a></div>
          <div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan"><a href="computerHardware/ssd.jsp"><img src="../public/img/website/categories/ssds.jpg" style = "height: 4em;" class="img-responsive center-block" alt="SSD">Solid States Drive</a></div>
          <div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan"><a href="computerHardware/motherboard.jsp"><img src="../public/img/website/categories/motherboards.jpg" class="img-responsive center-block" alt="Motherboards">Motherboards</a></div>
          <div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan"><a href="computerHardware/psu.jsp"><img src="../public/img/website/categories/powersupplies.jpg" class="img-responsive center-block" alt="Power Supplies">Power Supplies</a></div>
		  <% } %>
		  <% if(language.equals("french")){ %>
		  
		  <div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan"><a href="computerHardware/harddrives.jsp"><img src="../public/img/website/categories/hard drives.jpg" class="img-responsive center-block" alt="Hard-drives">Disques durs</a></div>
          <div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan"><a href="computerHardware/cpu.jsp"><img src="../public/img/website/categories/cpu.jpg" class="img-responsive center-block" alt="Intel & AMD CPU">Intel et AMD CPU</a></div>
          <div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan"><a href="computerHardware/gpu.jsp"><img src="../public/img/website/categories/video-cards.jpg" class="img-responsive center-block" alt="Video Cards">Cartes video</a></div>
          <div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan"><a href="computerHardware/cases.jsp"><img src="../public/img/website/categories/computer-cases.jpg" class="img-responsive center-block" alt="Computer Cases">Boitiers d'ordinateurs</a></div>
          <div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan"><a href="computerHardware/ram.jsp"><img src="../public/img/website/categories/ram.jpg" class="img-responsive center-block" alt="RAM">RAM</a></div>
          <div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan"><a href="computerHardware/ssd.jsp"><img src="../public/img/website/categories/ssds.jpg" style = "height: 4em;" class="img-responsive center-block" alt="SSD">Solide Etats dur</a></div>
          <div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan"><a href="computerHardware/motherboard.jsp"><img src="../public/img/website/categories/motherboards.jpg" class="img-responsive center-block" alt="Motherboards">Cartes meres</a></div>
          <div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan"><a href="computerHardware/psu.jsp"><img src="../public/img/website/categories/powersupplies.jpg" class="img-responsive center-block" alt="Power Supplies">Alimentation de puissance</a></div>
		  
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