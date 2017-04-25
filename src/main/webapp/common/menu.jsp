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
				Fedility Aws
			</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li>
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> 
						Home
					</a>
				</li>
				<li>
					<a href="./assignGroup.jsp">Assign Group</a>
				</li>
				<li>
					<a href="./download.jsp">Download</a>
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
<div class="container">
	<div id="dyna_errorAlert" class="row" style="display:none;">
		<div class="alert alert-danger fade in">
		    <a href="#" class="close" data-dismiss="alert">&times;</a>
		    <strong>Error!</strong> <span>A problem has been occurred while submitting your data.</span>
		</div>
	</div>
</div>