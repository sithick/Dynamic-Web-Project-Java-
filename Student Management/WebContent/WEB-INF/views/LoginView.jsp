<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<style>

</style>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">

</head>
<body>
<div class="container">
<br>  <p class="text-center"><strong>Welcome Aspirants !!!</strong></p>
<hr>

<div class="row justify-content-center">
<div class="col-md-6">


<div class="card">
<article class="card-body">
	<a href="register" class="float-right btn btn-outline-primary">Sign up</a>
	<h4 class="card-title mb-4 mt-1">Sign in</h4>
	<hr>
	<form method="post" action="login">
    <div class="form-group">
        <input class="form-control" placeholder="Email or login" type="text" name="useremail">
    </div> <!-- form-group// -->
    <div class="form-group">
        <input class="form-control" placeholder="******" type="password" name="userpassword">
    </div> <!-- form-group// -->                                      
    <div class="row">
        <div class="col-md-6">
            <div class="form-group">
                <button style="align-content: center;" type="submit" class="btn btn-primary btn-block"> Login  </button>
            </div> <!-- form-group// -->
        </div>                                            
    </div>                                                          
</form>
</article>
</div>

	</div>

</div> 

</div> 
</body>
</html>