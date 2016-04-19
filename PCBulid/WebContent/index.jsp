
<%
String language = (String) request.getParameter("lang");
if (language == null) language = ((String) session.getAttribute("lang")!=null ? (String) session.getAttribute("lang") : "english");
else session.setAttribute("lang",language);
%>

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
	<jsp:include page="components/navbar.jsp" />

	<!--- Advertisement Carousel --->
	<div id="topAdvert" class="carousel slide" data-ride="carousel"
		style="margin-top: -1.35em;">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#topAdvert" data-slide-to="0" class="active"></li>
			<li data-target="#topAdvert" data-slide-to="1"></li>
			<li data-target="#topAdvert" data-slide-to="2"></li>
			<li data-target="#topAdvert" data-slide-to="3"></li>
			<li data-target="#topAdvert" data-slide-to="4"></li>
			<li data-target="#topAdvert" data-slide-to="5"></li>
			<li data-target="#topAdvert" data-slide-to="6"></li>
		</ol>

		<!-- Wrapper for slides -->
		<div class="carousel-inner" role="listbox">
			<div class="item active">
				<img src="public/img/website/ads/1.jpg" alt="Advert"
					class="img-responsive center-block">
			</div>
			<div class="item">
				<img src="public/img/website/ads/2.jpg" alt="Advert"
					class="img-responsive center-block">
			</div>
			<div class="item">
				<img src="public/img/website/ads/3.jpg" alt="Advert"
					class="img-responsive center-block">
			</div>
			<div class="item">
				<img src="public/img/website/ads/4.jpg" alt="Advert"
					class="img-responsive center-block">
			</div>
			<div class="item">
				<img src="public/img/website/ads/5.jpg" alt="Advert"
					class="img-responsive center-block">
			</div>
			<div class="item">
				<img src="public/img/website/ads/6.jpg" alt="Advert"
					class="img-responsive center-block">
			</div>
		</div>

		<!-- Left and right controls -->
		<a class="left carousel-control" href="#topAdvert" role="button"
			data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"
			aria-hidden="true"></span> <span class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#topAdvert" role="button"
			data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>


	<!--- Under advertisements --->
	<!--- width: 89%; margin-left: 4.5em --->
	<div class="container">
		<div class="col-sm-14">
			<div class="row" style="border: 2px solid; border-radius: 6px;">
				<img src="public/img/website/categories/extremedeal-left.gif">
				<img src="public/img/website/categories/home-extremedeal_right.jpg"
					style="margin-left: -0.2em;"> <span> <img
					src="public/img/products/77086ss.jpg" class="img-center"> <span
					class="panel-heading">Toshiba DT01AC1300 3TB SATA3 7200RPM
						64MB Cache 3.5in Internal Hard Disk Drive HDD</span>
					<div class="panel-footer">
						<span class="pull-right"> <%
 	if (language.equals("english")) {
 %>You save $36.99 <%
 	} else if (language.equals("french")) {
 %>Vous sauvegardez $36.99<%
 	}
 %>
						</span>
						<p style="text-decoration: line-through;">Reg: 146.99</p>
						<h4>$109.99</h4>
						<button type="button" class="btn pull-right"
							style="margin-top: -3em;">
							<%
								if (language.equals("english")) {
							%>Buy now
							<%
								} else if (language.equals("french")) {
							%>Acheter maintenant
							<%
								}
							%>
						</button>
					</div>
				</span>
			</div>
		</div>
	</div>





	<!--- Featured Vendors --->
	<div class="container">
		<%
			if (language.equals("english")) {
		%>
		<h2>Featured Vendors</h2>
		<%
			} else if (language.equals("french")) {
		%>
		<h2>Fournisseurs en Vedette</h2>
		<%
			}
		%>
		<hr>
		<div class="row">
			<div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan">
				<a href="brands/intel.jsp"><img
					src="public/img/brands/intel.gif" class="img-center"></a>
			</div>
			<div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan">
				<a href="brands/asus.jsp"><img src="public/img/brands/asus.gif"
					class="img-center"></a>
			</div>
			<div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan">
				<a href="brands/lenovo.jsp"><img
					src="public/img/brands/lenovo.gif" class="img-center"></a>
			</div>
			<div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan">
				<a href="brands/samsung.jsp"><img
					src="public/img/brands/samsung.gif" class="img-center"></a>
			</div>
			<div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan">
				<a href="brands/amd.jsp"><img src="public/img/brands/amd.gif"
					class="img-center"></a>
			</div>
			<div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan">
				<a href="brands/corsair.jsp"><img
					src="public/img/brands/corsair.gif" class="img-center"></a>
			</div>
			<div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan">
				<a href="brands/nvidia.jsp"><img
					src="public/img/brands/nvidia.gif" class="img-center"></a>
			</div>
			<div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan">
				<a href="brands/logitech.jsp"><img
					src="public/img/brands/logitech.gif" class="img-center"></a>
			</div>
		</div>
	</div>

	<br>

	<!--- Categories --->
	<div class="container">
		<%
			if (language.equals("english")) {
		%>
		<h2>Featured Categories</h2>
		<%
			} else if (language.equals("french")) {
		%>
		<h2>Catégories en Vedette</h2>
		<%
			}
		%>
		<hr>
		<div class="row">
			<div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan">
				<img
					src="public/img/website/categories/headsets.png" class="img-center">
					<%if(language.equals("english")){%><p>Headsets</a>
				<% } %>
				<%if(language.equals("french")){ %><p>
					Casques d'écoute</a>
					<% } %>
				</p>
			</div>
			<div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan">
				<img src="public/img/website/categories/monitors.png"
					class="img-center">
				<%if(language.equals("english")){%><p>
					Monitors</a>
					<% } %>
					<%if(language.equals("french")){ %>
				
				<p>
					Moniteurs</a>
					<% } %>
				
			</div>
			<div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan">
				<img src="public/img/website/categories/laptops.png"
					class="img-center">
				<%if(language.equals("english")){%><p>
					Laptops</a>
					<% } %>
					<%if(language.equals("french")){ %>
				
				<p>
					Ordinateurs portables</a>
					<% } %>
				
			</div>
			<div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan">
				<img src="public/img/website/categories/printers.png"
					class="img-center">
				<%if(language.equals("english")){%><p>
					Printers</a>
					<% } %>
					<%if(language.equals("french")){ %>
				
				<p>
					Imprimantes</a>
					<% } %>
				
			</div>
			<div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan">
				<img src="public/img/website/categories/phones.png"
					class="img-center">
				<%if(language.equals("english")){%><p>
					Phones</a>
					<% } %>
					<%if(language.equals("french")){ %>
				
				<p>
					Téléphones</a>
					<% } %>
				
			</div>
			<div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan">
				<img src="public/img/website/categories/videocards.png"
					class="img-center">
				<%if(language.equals("english")){%><p>
					Video Cards</a>
					<% } %>
					<%if(language.equals("french")){ %>
				
				<p>
					Cartes vidéo</a>
					<% } %>
				
			</div>
			<div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan">
				<img src="public/img/website/categories/television.png"
					class="img-center">
				<%if(language.equals("english")){%><p>
					Television</a>
					<% } %>
					<%if(language.equals("french")){ %>
				
				<p>
					Télévision</a>
					<% } %>
				
			</div>
			<div class="col-xs-6 col-sm-6 col-md-3 text-center leftspan">
				<img src="public/img/website/categories/ssd.png" class="img-center">
				<%if(language.equals("english")){%><p>
					Solid State Drives</a>
					<% } %>
					<%if(language.equals("french")){ %>
				
				<p>
					Un seul disque dur État</a>
					<% } %>
				
			</div>
		</div>
	</div>

	<!--- Deals --->
	<div class="container">
		<%
			if (language.equals("english")) {
		%>
		<h2>This Week's Top Deals</h2>
		<%
			} else if (language.equals("french")) {
		%>
		<h2>Top de cette Semaine</h2>
		<%
			}
		%>
		<hr>
		<br>
		<div class="row">
			<div class="col-sm-4">
				<div class="panel panel-primary">
					<div class="panel-heading">Netgear AC5300 R8500 Nighthawk X8
						WiFi Router</div>
					<div class="panel-body">
						<img src="public/img/products/26052.jpg" class="img-responsive"
							alt="Image">
					</div>
					<div class="panel-footer">
						$519.00
						<%if(language.equals("english")){ %>
						<button type="button" class="btn pull-right">Buy now</button>
						<%} if(language.equals("french")){ %>
						<button type="button" class="btn pull-right">Acheter maintenant</button> <% } %>
						<p style="color: red;">Save $40.00</p>
					</div>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="panel panel-danger">
					<div class="panel-heading">ADATA Premier SP550 480GB SATA
						2.5'' SSD</div>
					<div class="panel-body">
						<img src="public/img/products/23030.jpg" class="img-responsive"
							alt="Image">
					</div>
					<div class="panel-footer">
						$169.99
						<%if(language.equals("english")){ %>
						<button type="button" class="btn pull-right">Buy now</button>
						<%} if(language.equals("french")){ %>
						<button type="button" class="btn pull-right">Acheter maintenant</button> <% } %>
						<p style="color: red;">Save $10.00</p>
					</div>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="panel panel-success">
					<div class="panel-heading">MSI PE70 6QE-058US Notebook</div>
					<div class="panel-body">
						<img src="public/img/products/95982.jpg" class="img-responsive"
							alt="Image">
					</div>
					<div class="panel-footer">
						$1,459.00
						<%if(language.equals("english")){ %>
						<button type="button" class="btn pull-right">Buy now</button>
						<%} if(language.equals("french")){ %>
						<button type="button" class="btn pull-right">Acheter maintenant</button> <% } %>
						<p style="color: red;">Save $40.00</p>
					</div>
				</div>
			</div>
		</div>
	</div>

	<br>
	<br><footer class="container-fluid text-center">
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