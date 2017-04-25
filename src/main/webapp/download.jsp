<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>Fidelity Aws Group</title>
		<%@ include file="common/javascript.jsp" %>
		<%@ include file="common/css.jsp" %>
	</head>
	<body>
		<%@ include file="common/menu.jsp" %>
		<div class="container-fluid">
			<div class="page-header">
		   		<h1>Assign Group</h1>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading"> 
					<span class="glyphicon glyphicon-plus-sign"></span>&nbsp;&nbsp;&nbsp;<b>Assign</b>
				</div>
				<div class="panel-body">
					<form method="get" name="form1">
						<input type="hidden" name="type" value="add"/>
						<div class="row col-md-6 col-md-offset-3">
							<div class="col-md-6">
								<div class="form-group">
									<label>Field1</label>
									<input type="text" name="field1" id="field1" class="form-control">
								</div>
							</div>
							<div class="col-md-9 col-md-offset-5">
								<div class="form-group">
									<input type="button" class="btn btn-primary" name="b1" 
									value="Download File" onclick="performRetrievePolicy1()"/>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>