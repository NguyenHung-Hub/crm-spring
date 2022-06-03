<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>List customer</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div class="content">
			<input type="button" value="Add employee" class="btn btn-info mb-2"
				onclick="window.location.href='showFormAddEmployee'; return false;" />
				
			<table class="table table-striped">
				<tr>
					<th scope="col">First name</th>
					<th scope="col">Last name</th>
					<th scope="col">Email</th>
					<th scope="col">Department</th>
					<th scope="col">Action</th>
				</tr>
				
				<c:forEach var="tempEmployee" items="${employees}">
						<c:url var="loadUpdateLink" value="showFormUpdateEmployee">
							<c:param name="employeeId" value="${tempEmployee.id}"/>
						</c:url>
						
						<c:url var="deleteLink" value="delete">
							<c:param name="employeeId" value="${tempEmployee.id}"/>
						</c:url>
						
						<tr>
							<td>${tempEmployee.firstName}</td>
							<td>${tempEmployee.lastName}</td>
							<td>${tempEmployee.email}</td>
							<td>${tempEmployee.department.name}</td>
							<td>
								<a class="btn btn-primary" href="${loadUpdateLink}">UPDATE</a>
							<a class="btn btn-danger" href="${deleteLink}"
							onclick= "if(!(confirm('Are you sure you want delete this employee?'))) return false;">DELETE</a>
							</td>
						</tr>
					</c:forEach>
			</table>
		</div>
	
	</div>
	<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>