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
		
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3"></div>
			<div class="col-sm-6">
				<div class="card">
					<div class="card-body font-weight-bold px-2">
						<form:form action="register" modelAttribute="user">
						<form:hidden path="id" />
							<p class="h4 mb-4">Register</p>
							<label>Name</label>
							<form:input path="name" class="form-control mb-4"
								placeholder="Name"/>
							<form:errors path="name" cssClass="error" />
							<br>
							<label>UserName</label>
							<form:input path="username" class="form-control mb-4"
								placeholder="UserName for login"/>
							<form:errors path="username" cssClass="error" />
							<br>					
							<label>Password</label>
							<form:password path="password" class="form-control mb-4"
								placeholder="Password" />
							<form:errors path="password" cssClass="error" />
							<br>
							<label>City</label>
							<form:input path="city" class="form-control mb-4"
								placeholder="City"/>
							<form:errors path="city" cssClass="error" />
							<br>							
							<button
								class="btn btn-dark shadow btn-block text-white font-weight-bold px-2"
								type="submit">								
								Submit</button>
								<br>
								<br>
						</form:form>
					</div>
				</div>
			</div>
			<div class="col-sm-3"></div>
		</div>
	</div>
</body>
	
</body>

</html>

