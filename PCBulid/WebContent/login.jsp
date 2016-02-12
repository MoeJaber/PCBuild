<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>View Template that use Bootstrap</title>

    <!-- Referencing Bootstrap CSS that is hosted locally -->
    <link href="//netdna.bootstrapcdn.com/bootswatch/3.1.0/superhero/bootstrap.min.css" rel="stylesheet">
    <link href="css/pages/login.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
  </head>
  <body>
    <!-- Referencing Bootstrap JS that is hosted locally -->
    
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
      <a href="WebContent/register.jsp" >Don't have an account? Register</a>
    </div>
  </div>
</div>
  </body>
</html>