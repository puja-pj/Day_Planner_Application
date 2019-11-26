<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Day Planner</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<link href="<spring:url value="/css/style.css" />" rel="stylesheet"
	type="text/css" />
</head>
<body>

	<div class="jumbotron text-center" style="background-color: #A6CDD5">
		<h1>Day Planner</h1>
	</div>

	<div class="container">
	
		<div class="row">
			
			<div class="col-sm-6" text-center>
				<br>
				<h3>What Can you do with Day Planner?</h3>
			
					<br>
					 <div class="card bg-light text-dark">
                        <div class="card-body">Create Notes to organize your tasks</div>
                     </div>
					<br>
					
					 <div class="card bg-light text-dark">
                        <div class="card-body">Get Weather updates</div>
                     </div>
					<br>
					<div class="card bg-light text-dark">
                        <div class="card-body">Find out Popular deals in your City</div>
                     </div>
				
				<br> <br>

				<div class="row">
					<div class="col-sm-3" text-center>
						<button
							class="btn btn-dark shadow btn-block"
							type="submit">
							<a class="text-white font-weight-bold px-2"  href="login">Login</a>							
							</button>
					</div>
					<div class="col-sm-3" text-center>
						<button
							class="btn btn-dark shadow btn-block"
							type="submit">
							<a class="text-white font-weight-bold px-2" href="register">Register</a>
							</button>
					</div>
				</div>
				</div>

			<div class="col-sm-6" id="logo">
				<img src="/images/quote.png" alt="/img/background.png">
			</div>
		</div>
	</div>

	<div class="container footer">
	
	<br>
	<br>
	</div>

</body>
<footer class="page-footer font-small">
<div class="footer-copyright text-center py-3">
	© 2019 : <aclass-"text-white">Puja Mullapudi</a>
</div>
</footer>
</html>
