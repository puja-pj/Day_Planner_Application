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
 
  body {
      position: relative; 
  }
  #home {}
  #notes {padding-top:50px;height:600px;color: black;background-color: #DCDCDC;}
  #weather {padding-top:50px;height:600px;color: white;}
  #deals {padding-top:50px;height:600px;color: white; background-color:#A7BA9E}
  #logout {padding-top:50px;height:100px;color: white; background-color: white;}
  </style>
</head>
<body data-spy="scroll" data-target=".navbar" data-offset="50">

<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#">Day Planner</a>
    </div>
    <div>
      <div class="collapse navbar-collapse" id="myNavbar">
        <ul class="nav navbar-nav navbar-right">
          <li><a href="#home">Home</a></li>
          <li><a href="#notes">Create Notes</a></li>
           <li><a href="#weather">Check Weather</a></li>
            <li><a href="#deals">Popular Deals</a></li>
            <li><a href="#logout">Logout</a></li>
        
            </ul>
          </li>
        </ul>
      </div>
    </div>
  </div>
</nav>    
	<div id="home">
	<div class="jumbotron text-center" style="background-color: #A6CDD5">
		<h1>Day Planner</h1>
	</div>
</div>


<div id="notes" class="container-fluid">
<div class="container"> 
  <h2>Create Note</h2>
  <br>
<form:form action="userHome" modelAttribute="notes">
<form:hidden path="noteid" />
<form:hidden path="user" />

      Note Name:<form:input path="noteName" />
      <form:errors path="noteName" cssClass="error" />
      <br><br>
      
      Content: <br> <form:textarea path="content" rows="10" cols="30" />
      <form:errors path="content" cssClass="error" /><br><br>
      
      <input type="submit" value="Submit" /> <br><br>
 
  <h3><a href="viewNotes" style="background-color: #A6CDD5">View Notes</a></h3>
 
  </form:form>
	
</div>
</div>

<div id="weather" class="container-fluid" style="background-image: url(../images/weather.jpg);">

<div class="container">
<h2>Weather in ${user.city}, Canada</h2><br>
   <h3><img src="${iconurl}"/>  ${weatherData.temp} °C </h3>
    </div>
  </div>


<div id="deals" class="container-fluid">
<div class="container">
  <h2>Popular Deals</h2>
  <br>         
  <table class="table table-dark">
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



<div id="logout" class="container-fluid">
<div class="container"> 
  <h2>
	<a href="logout" style="background-color: #A6CDD5">Logout</a>
 </h2>

</div>
</div>

</body>
</html>