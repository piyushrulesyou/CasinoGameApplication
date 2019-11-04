<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<title>UsersList</title>
<meta charset="utf-8">

<meta name="viewport" content="width=device-width, initial-scale=1">


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<link rel="stylesheet"
	href="<c:url value="/resources/css/UserList.css" />">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">




</head>
<body>

	<jsp:include page="WEB-INF/NavigationBar.jsp"></jsp:include>

	Total ${listOfUsers.size()} users found!!

	<form action="filterUsers" method="post">
		Name <input type="text" id="filterName" name="filterName">
		Contact <input type="number" id="filterContact" name="filterContact">
		Email ID <input type="text" id="filterEMail" name="filterEMail">
		<input type="submit" value="Search">
	</form>
	<br>

	<a href="showUsers"><button class="btn btn-primary">Show
			All Users</button></a>

	<c:if test="${listOfUsers.size() == 0}">
		<div class="alert alert-danger">No Users Found!!</div>
	</c:if>

	<br>
	<br>

	<c:if test="${listOfUsers.size() != 0}">

		<table width="100%" class="w3-table-all w3-centered">
			<tr>
				<th>S.No.</th>
				<th>Name</th>
				<th>DOB</th>
				<th>Contact</th>
				<th>Email</th>
				<th>Balance(in Rs.)</th>
				<th>Blocked Amount</th>
				<th>Recharge</th>
			</tr>

			<%-- 			<c:set var="count" value="0" scope="page" /> --%>

			<c:forEach items="${listOfUsers}" var="eachUser">

				<tr>
					<td>${userCounter=userCounter+1}</td>
					<%-- 					<c:set var="count" value="${count + 1}" scope="page" /> --%>
					<%-- 					<td>${count}</td> --%>
					<td>${eachUser.customerName}</td>
					<td>${eachUser.dateOfBirth}</td>
					<td>${eachUser.contactNumber}</td>
					<td>${eachUser.emailID}</td>
					<td>${eachUser.accountBalance}</td>
					<td>${eachUser.blockedAmount}</td>
					

					<td><button
							id="${eachUser.customerID}-${eachUser.customerName}"
							type="button" data-toggle="modal" data-target="#modalID"
							class="rechargeAmountButton">
							<img class="plusLogo" alt="plusDatabaseIcon"
								src="<c:url value="resources/Images/add.png" />">
						</button></td>

				</tr>
			</c:forEach>
		</table>
	</c:if>




	<!-- Modal -->
	<div class="modal fade" id="modalID" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Recharge
						Balance</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<form action="rechargeWallet" method="post">
					<div class="modal-body">

						Name: <input type="text" class="customerNameReadOnly"
							id="customerName" name="customerName" value=""
							disabled="disabled"> <input type="text" id="rechargeID"
							name="rechargeID" value="" hidden="hidden"> <br> <br>
						Amount (in Rs.)<input type="number" min="0" step=".01"
							id="rechargeAmount" name="rechargeAmount" value=""> <br>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>

						<button type="submit" class="btn btn-success">Recharge</button>
					</div>

				</form>
			</div>
		</div>
	</div>

<script type="text/javascript" src="resources/js/UserList.js"></script>

</body>
</html>