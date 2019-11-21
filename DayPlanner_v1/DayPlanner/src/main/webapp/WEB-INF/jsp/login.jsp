<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style>
.error {
	color: red
}

h1 {
	color: white
}
</style>
<title>Day Planner</title>
</head>
<body>
	<div class="jumbotron text-center" style="background-color: #A6CDD5">
		<h1>Day Planner</h1>
	</div>
	<div class="container">
	<h2>Login</h2>
	<br><br>
		<form:form action="login" modelAttribute="login">
			<table align="left">
			
				<tr>
					<td>Username:</td>
					<td><form:input path="username" /></td>
					<td><form:errors path="username" cssClass="error" /></td>
				</tr>
				<tr><td></td></tr>
				<tr>
					<td>Password:</td>
					<td><form:password path="password" /></td>
					<td><form:errors path="password" cssClass="error" /></td>
				</tr>
				<tr><td></td></tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Submit" /></td>
				</tr>
			</table>
		</form:form>
		</div>
</body>

</html>
