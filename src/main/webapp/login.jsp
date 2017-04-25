<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
	<head>
		<title>Fidelity Aws Group</title>
		<%@ include file="common/javascript.jsp" %>
		<%@ include file="common/css.jsp" %>
		<link href="assets/css/signin.css" rel="stylesheet" type="text/css">
		<link href="assets/css/custom.css" rel="stylesheet" type="text/css">
		<style>
    .error {
        color: red; font-weight: bold;
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
				<form:form action="login" commandName="userForm">
					<h1>Fedility AWS</h1>
					<div class="form-group ">
						<div class="inner-addon left-addon">
							<i class="glyphicon glyphicon-user"></i>
							<!-- <input type="text" name="userName" class="form-control" placeholder="Username" /> -->
							<form:input path="userName" cssClass="form-control" />
							<form:errors path="userName" cssClass="error"/>
						</div>
					</div>
					<div class="form-group ">
						<div class="inner-addon left-addon">
							<i class="glyphicon glyphicon-lock"></i>
							<form:input path="password" cssClass="form-control" />
							<form:errors path="password" cssClass="error"/>
						</div>
					</div>
					
					<div class="form-group ">
						<div class="inner-addon left-addon">
							<i class="glyphicon glyphicon-lock"></i>
							<form:input path="arn" cssClass="form-control" />
							<form:errors path="arn" cssClass="error"/>
						</div>
					</div>
					<span></span>
					<input name="b1" class="log-btn" type="submit" value="Login"/>
				</form:form>
			</div>
		</div>
	</body>
</html>
