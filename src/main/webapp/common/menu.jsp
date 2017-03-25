<nav class="navbar navbar-default navbar-static-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
			<span class="sr-only">Toggle navigation</span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">
				Device Manager
			</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li>
					<a href="./selectDeviceManager.jsp">Home (Region: <strong><span id="dyna_selectedDmDisplayName"><c:out value='${selectedDmDisplayName}'/></span></strong>)</a>
				</li>
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
					Search By<span class="caret"></span>
					</a>
					<ul class="dropdown-menu">
						<li><a href="assets.jsp">Assets</a></li>
						<li><a href="#">Dealer</a></li>
						<li><a href="#">Field User</a></li>
					</ul>
				</li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown current-user">
					<a data-toggle="dropdown" data-hover="dropdown" class="dropdown-toggle capitalize" data-close-others="true" href="#">
					<c:out value="${sessionScope.loggedInUser.firstName}"/>&nbsp;<c:out value="${sessionScope.loggedInUser.lastName}"/><span class="caret"></span>
					</a>
					<ul class="dropdown-menu">
						<li><a href="./logout.jsp">Profile</a></li>
						<li><a href="./logout.jsp">Logout</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</div>
</nav>