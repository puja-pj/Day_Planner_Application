<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View Saved Notes</title>

</head>
<body style="background-color: #A7BA9E">


	<div class="container-fluid">
		<div class="container viewnotes">
			<h2>Saved Notes</h2>
			<br>
			<table class="table table-dark">
				<thead>
					<tr>
						<th>Note Name</th>
						<th>Content</th>
						<th>Delete</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="notes" items="${AllNotes}">
						<tr>
							<td>${notes.noteName}</td>
							<td>${notes.content}</td>
							<td><a href="deleteNotes/${notes.noteid}">Delete</a></td>

						</tr>
					</c:forEach>
				</tbody>
			</table>
			<br>
			<br>
			
			<div class="row">
					<div class="col-sm-3" text-center>
			<button
							class="btn btn-dark shadow btn-block"
							type="submit">
							<a class="text-white font-weight-bold px-2" href="userHome">Return to Home</a>
							</button>
				</div>
				</div>
		</div>
	</div>
</body>
</html>