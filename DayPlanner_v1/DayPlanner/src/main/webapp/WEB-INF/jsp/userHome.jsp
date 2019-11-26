

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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

<!-- Nav bar Section -->

<body data-spy="scroll" data-target=".navbar" data-offset="50">
	<nav
		class="navbar navbar-expand-sm navbar-dark bg-dark navbar-light fixed-top shadow">
	<a class="navbar-brand text-white">Day Planner</a>
	<button class="navbar-toggler" type="button" class="navbar-toggler"
		data-toggle="collapse" data-target="#myNavBar">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="myNavBar">
		<ul class="navbar-nav ml-auto navbar-right font-weight-bold px-2">
			<li class="nav-item"><a class="nav-link" href="#weather">Weather</a></li>
			<li class="nav-item"><a class="nav-link" href="#notes">Create
					Notes</a></li>
			<li class="nav-item"><a class="nav-link" href="#deals">Popular
					Deals</a></li>
			<li class="nav-item"><a class="nav-link" href="logout">Logout</a></li>
		</ul>
	</div>
	</nav>
	<br>
	<br>
	<div class="container">
		<div class="card" style="background-color: #A6CDD5">
			<div class="card-body">
				<div class="row">
					<div class="col-sm-8">
						<h4>Weather in ${user.city}, Canada</h4>
					</div>
					<div class="col-sm-4">
						<h3>
							<img src="${iconurl}" /> ${weatherData.temp} °C
						</h3>
					</div>
				</div>
			</div>
		</div>
	</div>
	<br>


<br>

	<!-- Notes Creation Section -->
	<!-- Notes Creation Section -->
	<div id="notes">
		<div class="container">
			<h5>Create Notes</h5>
			<form:form action="userHome" modelAttribute="notes" method="post">
				<form:hidden path="noteid" />
				<form:hidden path="user" />
				<!-- 		Responsive form -->
				<div class="form-row">
					<div class="form-group col-md-6">
						<label>Note Name:</label>
						<form:input path="noteName" class="form-control"
							placeholder="Note Name" />
						<form:errors path="noteName" cssClass="error"  />
					</div>
				</div>
				<div class="textarea">
					<label>Content</label>
					<form:textarea path="content" class="form-control" rows="8"
						cols="30" placeholder="Note Content goes here" />
					<form:errors path="content" cssClass="error"  />
				</div>
				<br>
				<div class="form-row">
					<div class="form-group col-md-2">
						<button
							class="btn btn-dark shadow btn-block text-white font-weight-bold px-2"
							type="submit">Submit</button>
					</div>
					<div class="form-group col-md-2">
						<button class="btn btn-dark shadow btn-block">
						<a class="text-white font-weight-bold px-2" href="viewNotes">Saved Notes</a>
						</button>
				</div>
		
					</div>
				</div>
				
			</form:form>
			</form>
		</div>
	</div>



<br><br>
	<div id="deals" class="container-fluid">
		<div class="container" style="background-color: #A7BA9E">
			<h2>Popular Deals</h2>
			<br>
			<table class="table table-blue">
				<thead>
					<tr>
						<th>Store Name</th>
						<th>Deal</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="deal" items="${deals}">
						<tr>
							<td>${deal.key}</td>
							<td>${deal.value}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
<br>
</body>
<footer class="page-footer font-small">
<div class="footer-copyright text-center py-3">
	© 2019 : <aclass-"text-white">Puja Mullapudi</a>
</div>
</footer>
</html>
