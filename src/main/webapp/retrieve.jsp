<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Retrieve Page</title>
<%@ include file="common/javascript.jsp"%>
<%@ include file="common/css.jsp"%>
<link href="assets/css/signin.css" rel="stylesheet" type="text/css">
<link href="assets/css/custom.css" rel="stylesheet" type="text/css">
<style>
.error {
	color: red;
	font-weight: bold;
}
</style>
</head>
<body>
	<div class="container">
		<div class="login-form">
			<c:if test="${not empty error}">
				<div class="alert alert-danger">
					<strong>Error! </strong>${error}
				</div>
			</c:if>
			<form:form action="retrieve" commandName="retrieveForm">
				<h1>Fidelity AWS</h1>
				<div class="form-group ">
					<div class="inner-addon left-addon">
						<i class="glyphicon glyphicon-user"></i>
						<!-- <input type="text" name="userName" class="form-control" placeholder="Username" /> -->
						<form:input path="cmkArn" cssClass="form-control" />
						<form:errors path="cmkArn" cssClass="error" />
					</div>
				</div>
				<span></span>
				<input name="b1" class="log-btn" type="submit" value="Retrieve" />
			</form:form>
		</div>
	</div>
</body>
</html>
