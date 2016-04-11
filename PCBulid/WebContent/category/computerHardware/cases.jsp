<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
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
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
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
</style>
</head>
<body>
	<jsp:include page="../../components/navbar.jsp" />


	<br>
	<div class="container">
		<h2>
			<a href="index.jsp">Home</a> >> <a href="../computerhardware.jsp">Computer
				Hardware</a> >> <a href="cases.jsp">Cases</a>
		</h2>
		<p>Showing 2 items in Cases</p>
		<hr>
		<br>
		<div class="row">

			<%
				String id = request.getParameter("userId");
				String driverName = "com.mysql.jdbc.Driver";
				String connectionUrl = "jdbc:mysql://localhost:3306/";
				String dbName = "form";
				String userId = "root";
				String password = "admin";

				try {
					Class.forName(driverName);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}

				Connection connection = null;
				Statement statement = null;
				ResultSet resultSet = null;
			
			%>


			<%
				try {
					connection = DriverManager.getConnection(connectionUrl + dbName, userId, password);
					statement = connection.createStatement();
					String sql = "SELECT * FROM pc_cases";

					resultSet = statement.executeQuery(sql);

					while (resultSet.next()) {
			%>


			<!--- Sales --->

			<div class="col-sm-6">
				<div class="panel panel-danger" style="height: 13.5em;">
					<div class="panel-heading"><%=resultSet.getString("cases_name")%><p
							style="font-size: 0.7em;"><%=resultSet.getString("cases_model")%></p>
					</div>
					<div class="panel-body">
						<img
							src="<%=resultSet.getString("cases_imagepath")%>" style = "height: 6em;" />
					</div>
					<div class="panel-footer" style="height: 5.35em;">
						<form action = "http://localhost:8081/PCBulid/AddItemServlet" method = "post">
							<input type="hidden" name="category" value="Cases">
							<input type="hidden" name="id" value="<%out.print(resultSet.getString("cases_ID"));%>">
							<input type="submit" value="Add to Cart" class="btn pull-right"/>
						</form>
						<h5>$<%=resultSet.getString("cases_price")%></h5>
					</div>
				</div>
			</div>

			<%
				}

				} catch (Exception e) {
					e.printStackTrace();
				}
			%>


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