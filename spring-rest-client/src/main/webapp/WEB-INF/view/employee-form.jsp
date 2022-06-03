<%@page import="javax.servlet.jsp.tagext.Tag"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Add employee</title>
<meta charset="utf-8">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>
	<div class="container">
		<div
			class="row d-flex justify-content-center align-items-center h-100">
			<div class="col-12 col-md-7 col-lg-5 col-xl-4">
				<div class="card shadow-2-strong" style="border-radius: 1rem;">
					<div class="card-body p-5 text-center">
						<form:form action="saveEmployee" modelAttribute="employee"
							method="post">
							<form:hidden path="id" />
							<input type="text" class="form-control mb-3" name="firstName"
								placeholder="First name" value="${employee.firstName}"
								id="floatFirstName" />

							<input type="text" class="form-control mb-3" name="lastName"
								placeholder="Last name" value="${employee.lastName }"
								id="floatLastname" />

							<input type="email" class="form-control mb-3" name="email"
								placeholder="example@email.com" value="${employee.email }"
								id="floatEmail" />

							<form:select class="form-control mb-3" path="department.id">
								<c:forEach items="${departments}" var="department">
									<c:if test="${department.id == employee.department.id}">
										<option selected value="${department.id}">${department.name}</option>
									</c:if>
									<c:if test="${department.id != employee.department.id}">
										<option value="${department.id}">${department.name}</option>
									</c:if>
								</c:forEach>
								
							</form:select>

							<div class="d-grid">
								<input type="submit" value="Save" class="btn btn-primary">
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>