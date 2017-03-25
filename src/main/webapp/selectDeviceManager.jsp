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
					<select id="dyna_selDeviceManager">
						<c:forEach items="${deviceManagerList}" var="deviceManager">
					        <option value="dm_${deviceManager.region}${deviceManager.dmEnvType}">${deviceManager.dmName}</option>
					    </c:forEach>
					</select>
				</div>
			</div>
		</div>
	</body>
</html>