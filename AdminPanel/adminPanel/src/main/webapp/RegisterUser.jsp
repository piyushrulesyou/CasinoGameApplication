<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
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

<link rel="stylesheet"
	href="<c:url value="/resources/css/UserList.css" />">


</head>
<body>


	<jsp:include page="WEB-INF/NavigationBar.jsp"></jsp:include>

	<c:if test="${statusMessage != null}">
		<div class="alert alert-danger">${statusMessage}</div>
	</c:if>

	<form:form action="registerUser" modelAttribute="customerDetails"
		method="post">
		<div class="form-group">
			<table class="table">

				<tr>
					<spring:bind path="customerName">
						<td><form:label path="customerName">Name: </form:label></td>
						<td><form:input type="text" path="customerName"
								required="required" /></td>
					</spring:bind>
				</tr>


				<tr>
					<spring:bind path="dateOfBirth">
						<td><form:label path="dateOfBirth">Date of Birth: </form:label></td>
						<td><form:input type="date" path="dateOfBirth"
								required="required" /></td>
					</spring:bind>
				</tr>

				<tr>
					<spring:bind path="contactNumber">
						<td><form:label path="contactNumber">Contact: </form:label></td>
						<td><form:input type="number" path="contactNumber"
								required="required" /></td>
					</spring:bind>
				</tr>

				<tr>
					<spring:bind path="emailID">
						<td><form:label path="emailID">Email ID: </form:label></td>
						<td><form:input type="email" path="emailID"
								required="required" /></td>
					</spring:bind>
				</tr>


				<tr>
					<td>Identity Proof:</td>
					<td><input type="file" id="idProof" name="idProof"
						accept="image/*" placeholder="ID Proof"></td>
				</tr>

			</table>

			<button type="submit" class="btn btn-primary mb-2">Register</button>
		</div>
	</form:form>




</body>
</html>