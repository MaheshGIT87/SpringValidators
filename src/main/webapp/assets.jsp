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
			<div class="row">
		        <div class="col-md-6">
		    		<h4>Asset Search</h4>
		            <div id="custom-search-input">
		                <div class="input-group col-md-12">
		                    <input type="text" class="form-control input-lg" placeholder="External Id" />
		                    <span class="input-group-btn">
		                        <button class="btn btn-info btn-lg" type="button" onClick="performAssetSearch()">
		                            <i class="glyphicon glyphicon-search"></i>
		                        </button>
		                    </span>
		                </div>
		            </div>
		        </div>
			</div>
			<hr />
			<div class="panel panel-default">
				<div class="panel-heading collapsed" data-toggle="collapse" data-target="#collapseOrderItems1"> 
					<span class="glyphicon glyphicon-info-sign"></span>&nbsp;&nbsp;&nbsp;<b>Asset Details</b> <i class="indicator glyphicon glyphicon-chevron-down pull-right" ></i>
				</div>
				<div class="collapse" id="collapseOrderItems1">
					<div class="panel-body">
						<form method="post" name="form1">
							<input type="hidden" name="type" value="add"/>
							<div class="row col-md-6 col-md-offset-3">
								<div class="col-md-6">
									<div class="form-group">
										<label>Login ID</label>
										<input type="text" name="login" class="form-control">
									</div>
									<div class="form-group">
										<label>First Name</label>
										<input type="text" name="first_name" class="form-control" id="" value="">
									</div>
									<div class="form-group">
										<label>Email Address</label>
										<input type="text" name="email" class="form-control" id="" value="">
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label>Password</label>
										<input type="password" name="password" class="form-control">
									</div>
									<div class="form-group">
										<label>Last Name</label>
										<input type="text" name="last_name" class="form-control" id="" value="">
									</div>
									<div class="form-group">
										<label>User Type</label><br/>
										<select class="form-control" name="user_type">
											<option value="NORMAL USER">NORMAL USER</option>
											<option value="ADMINISTRATOR">ADMINISTRATOR</option>
										</select>
									</div>
								</div>
								<div class="col-md-9 col-md-offset-5">
									<div class="form-group">
										<input type="button" class="btn btn-primary" name="b1" value="Create User" onclick="submitForm()"/>
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
			
			<table class="table table-striped table-bordered table-hover table-condensed" id="tblUsers">
				<thead>
					<tr>
						<th>External Id</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>User Type</th>
						<th data-orderable="false">Actions</th>
					</tr>
				</thead>
				<tbody>
					
				</tbody>
			</table>
			
		</div>
	</body>
</html>