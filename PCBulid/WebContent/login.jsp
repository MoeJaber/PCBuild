<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>View Template that use Bootstrap</title>

    <!-- Referencing Bootstrap CSS that is hosted locally -->
    <script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
	<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
    <link href="//netdna.bootstrapcdn.com/bootswatch/3.1.0/spacelab/bootstrap.min.css" rel="stylesheet">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <style>
body{
  background: url("public/img/backdrop.png");
}

.centered-form .panel{
  background: rgba(255, 255, 255, 0.8);
  box-shadow: rgba(0, 0, 0, 0.3) 20px 20px 20px;
}

.centered-form{
  margin-top: 60px;
}
	</style>
  </head>
  <body>
    <!-- Referencing Bootstrap JS that is hosted locally -->
    
    
	<nav class="navbar navbar-default">
	  <div class="container-fluid">
	    <!-- Brand and toggle get grouped for better mobile display -->
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
	        <span class="sr-only">Toggle navigation</span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	      </button>
	      <a class="navbar-brand" href="#">Prestige Computers</a>
	    </div>
	
	    <!-- Collect the nav links, forms, and other content for toggling -->
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	      <ul class="nav navbar-nav">
	        <li class="active"><a href="#">Login <span class="sr-only">(current)</span></a></li>
	        <li class="dropdown">
	          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Computer Hardware <span class="caret"></span></a>
	          <ul class="dropdown-menu">
	          	<li class="dropdown-header">Computer Parts</li>
	            <li><a href="#">Cases & Chassis</a></li>
	            <li><a href="#">CPUs & Processors</a></li>
	            <li><a href="#">Cooling</a></li>
	            <li><a href="#">Computer Memory</a></li>
	            <li><a href="#">Hard-drives</a></li>
	            <li><a href="#">Video Cards</a></li>
	            <li><a href="#">Motherboards</a></li>
	          </ul>
	        </li>
	        <li class="dropdown">
	          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
	          <ul class="dropdown-menu">
	            <li><a href="#">Action</a></li>
	            <li><a href="#">Another action</a></li>
	            <li><a href="#">Something else here</a></li>
	            <li role="separator" class="divider"></li>
	            <li><a href="#">Separated link</a></li>
	          </ul>
	        </li>
	      </ul>
	      
	      <form class="navbar-form navbar-left" role="search">
	        <div class="form-group">
	          <input type="text" class="form-control" placeholder="Search Products">
	        </div>
	        <button type="submit" class="btn btn-default">Go</button>
	      </form>
	      <ul class="nav navbar-nav navbar-right">
	        
	      </ul>
	    </div><!-- /.navbar-collapse -->
	  </div><!-- /.container-fluid -->
	</nav>
	<div class="row centered-form">
	  <div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
	    <div class="panel panel-default">
	      <div class="panel-heading">
	        <h3 class="panel-title">Please Login</h3>
	      </div>
	      <div class="panel-body">
	        <form role="form">
	
	          <div class="form-group">
	            <input type="email" name="email" class="form-control input-sm" placeholder="Email Address">
	          </div>
	
	          <div class="form-group">
	            <input type="password" name="password" class="form-control input-sm" placeholder="Password">
	          </div>
	
	          <div class="checkbox">
	            <label>
	              <input name="remember" type="checkbox" value="Remember Me"> Remember Me
	              <a href="/forgot" class="pull-right">Forgot Password?</a>
	            </label>
	          </div>
	
	          <input type="submit" value="Login" class="btn btn-info btn-block">
	
	        </form>
	      </div>
	    </div>
	    <div class="text-center">
	      <a href="register.jsp" >Don't have an account? Register</a>
	    </div>
	  </div>
	</div>
  </body>
</html>