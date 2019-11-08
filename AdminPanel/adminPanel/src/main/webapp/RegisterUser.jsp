<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html;charset = UTF-8" language="java"%>
<%@page isELIgnored="false"%>

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

</head>
<body>


	<jsp:include page="WEB-INF/NavigationBar.jsp"></jsp:include>

	<c:if test="${statusMessage != null}">
		<div class="alert alert-danger">${statusMessage}</div>
	</c:if>

	<form:form action="registerUser" method="post">
		<div class="form-group">
			<table class="table">

				<tr>
					<!-- 					<td>Name:</td> -->
					<!-- 					<td><input type="text" id="customerName" name="customerName" -->
					<!-- 						placeholder="Enter name" value="sdfhs" required="required"></td> -->

					<td><form:label path="customerName">Name: </form:label></td>
					<td><form:input type="text" path="customerName"
							required="required" /></td>

				</tr>


				<tr>
					<!-- 					<td>Date of Birth:</td> -->
					<!-- 					<td><input type="date" name="dateOfBirth" id="dateOfBirth" -->
					<!-- 						placeholder="Enter DOB" required="required"></td> -->

					<td><form:label path="dateOfBirth">Date of Birth: </form:label></td>
					<td><form:input type="date" path="dateOfBirth"
							required="required" /></td>

				</tr>

				<tr>
					<!-- 					<td>Contact:</td> -->
					<!-- 					<td><input type="number" name="contactNumber" -->
					<!-- 						id="contactNumber" placeholder="Enter Contact Number" value=897899 -->
					<!-- 						required="required"></td> -->
					<td><form:label path="contactNumber">Contact: </form:label></td>
					<td><form:input type="number" path="contactNumber"
							required="required" /></td>
				</tr>

				<tr>
					<!-- 					<td>Email ID:</td> -->
					<!-- 					<td><input type="email" id="emailID" name="emailID" -->
					<!-- 						placeholder="Enter email" value="sdfhs@gmail.com" -->
					<!-- 						required="required"></td> -->
					<td><form:label path="emailID">Email ID: </form:label></td>
					<td><form:input type="email" path="emailID"
							required="required" /></td>
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