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
		    		<h4>Field User Search</h4>
		            <div id="custom-search-input">
		                <div class="input-group col-md-12">
		                    <input type="text" id="dyna_searchExternalId" class="form-control input-lg" placeholder="External Id" />
		                    <span class="input-group-btn">
		                        <button id="dyna_searchButton" class="btn btn-info btn-lg" type="button" onClick="performFieldUserSearch()">
		                            <i class="glyphicon glyphicon-search"></i>
		                        </button>
		                        <button id="dyna_loadingMsg" class="btn btn-sm btn-warning">
					        		<span class="glyphicon glyphicon-refresh glyphicon-refresh-animate"></span> Loading...
					        	</button>
		                    </span>
		                </div>
		            </div>
		        </div>
		        <div class="col-md-6">
		        	<br/><br/>
		        </div>
			</div>
			<hr />
			<div class="panel panel-default">
				<div class="panel-heading text-center collapsed" data-toggle="collapse" data-target="#collapseOrderItems1"> 
					<span class="glyphicon glyphicon-info-sign"></span>&nbsp;&nbsp;&nbsp;
					First Name: <b><span id="dyna_header_firstName">-</span></b> 
					&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
					Last Name: <b><span id="dyna_header_lastName">-</span></b> 
					<i class="indicator glyphicon glyphicon-chevron-down pull-right" ></i>
				</div>
				<div class="collapse" id="collapseOrderItems1">
					<div class="panel-body">
						<div class="row">
							<div class="col-md-3">
								<dl>
									<dt>ID</dt>
									<dd><span id="dyna_fieldUserId">-</span></dd>
								</dl>
								<dl>
									<dt>External Id</dt>
									<dd><span id="dyna_externalId">-</span></dd>
								</dl>
							</div>
							<div class="col-md-3">
								<dl>
									<dt>First Name</dt>
									<dd><span id="dyna_firstName">-</span></dd>
								</dl>
								<dl>
									<dt>Last Name</dt>
									<dd><span id="dyna_lastName">-</span></dd>
								</dl>
							</div>
							<div class="col-md-3">
								<dl>
									<dt>Portal Id</dt>
									<dd><span id="dyna_portalId">-</span></dd>
								</dl>
								<dl>
									<dt>Source</dt>
									<dd><span id="dyna_source">-</span></dd>
								</dl>
							</div>
							<div class="col-md-3">
								<dl>
									<dt>Owner</dt>
									<dd><span id="dyna_owner">-</span></dd>
								</dl>
							</div>
						</div>
					</div>
				</div>
			</div>
			
			<table class="table table-striped table-bordered table-hover table-condensed" id="tblAssets">
				<thead>
					<tr>
						<th>Serial No.</th>
						<th>Pod Type</th>
						<th>Source</th>
						<th>DM Url</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
			
		</div>
	</body>
</html>