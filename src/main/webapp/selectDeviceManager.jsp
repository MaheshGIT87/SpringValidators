<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>Device Dealer Portal</title>
		<%@ include file="common/javascript.jsp" %>
		<%@ include file="common/css.jsp" %>
	</head>
	<script type="text/javascript"></script>
	<body>
		<%@ include file="common/menu.jsp" %>
		<div class="container-fluid">
			<div class="container theme-showcase" role="main">
				<div class="jumbotron">
					<h1>Select Device Manager</h1>
					<div class="row">
					    <div class="col-xs-12">
							<div class="dropdown">
								<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
								Region:  <span class="selected"></span>
								<span class="caret"></span>
								</button>
								<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
									<c:forEach items="${deviceManagerList}" var="deviceManager">
								        <li><a href="#">${deviceManager.dmName}</a></li>
								    </c:forEach>
								</ul>
							</div>
			    		</div>
					</div>
					
				</div>
			</div>
		</div>
	</body>
</html>