<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>NavBar</title>

<link rel="stylesheet"
	href="<c:url value="/resources/css/NavBar.css" />">

</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<a class="navbar-brand" href="index.jsp"> <img class="casinoLogo"
			alt="casinoLogo"
			src="<c:url value="resources/Images/casinoLogo.png" />">
		</a>

		<!-- Links -->
		<ul class="navbar-nav mr-auto">
			<li class="nav-item"><a class="nav-link" href="index.jsp">Home</a></li>
			<li class="nav-item"><a class="nav-link" href="register">Register</a></li>
			<li class="nav-item"><a class="nav-link" href="showUsers">User
					List</a></li>
		</ul>
		<ul class="navbar-nav">
			<li class="nav-item"><span class="nav-link disabled">Welcome
					to Casino Admin App!</span></li>
		</ul>
	</nav>

</body>
</html>