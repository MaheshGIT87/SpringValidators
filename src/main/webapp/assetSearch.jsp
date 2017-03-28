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
		                    <input type="text" id="dyna_searchSerialNo" class="form-control input-lg" placeholder="Serial No." />
		                    <span class="input-group-btn">
		                        <button id="dyna_searchButton" class="btn btn-info btn-lg" type="button" onClick="performAssetSearch()">
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
					Asset Id: <b><span id="dyna_header_assetId">-</span></b> 
					&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
					Dealer Code: <b><span id="dyna_header_dealerCode">-</span></b> 
					&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
					Source: <b><span id="dyna_header_source">-</span></b>
					<i class="indicator glyphicon glyphicon-chevron-down pull-right" ></i>
				</div>
				<div class="collapse" id="collapseOrderItems1">
					<div class="panel-body">
						<div class="row">
							<div class="col-md-3">
								<dl>
									<dt>ID</dt>
									<dd><span id="dyna_assetId">-</span></dd>
								</dl>
								<dl>
									<dt>Serial Number</dt>
									<dd><span id="dyna_serialNumber">-</span></dd>
								</dl>
							</div>
							<div class="col-md-3">
								<dl>
									<dt>Dealer Id</dt>
									<dd><span id="dyna_dealerId">-</span></dd>
								</dl>
								<dl>
									<dt>Source</dt>
									<dd><span id="dyna_source">-</span></dd>
								</dl>
							</div>
							<div class="col-md-3">
								<dl>
									<dt>Device Mgr URL</dt>
									<dd><span id="dyna_deviceMgrUrl">-</span></dd>
								</dl>
								<dl>
									<dt>Type</dt>
									<dd><span id="dyna_assetType">-</span></dd>
								</dl>
							</div>
							<div class="col-md-3">
								<dl>
									<dt>Pod Flash Log Level</dt>
									<dd><span id="dyna_podFlashLogLevel">-</span></dd>
								</dl>
								<dl>
									<dt>Pod Log Level</dt>
									<dd><span id="dyna_podLogLevel">-</span></dd>
								</dl>
							</div>
						</div>
					</div>
				</div>
			</div>
			
			<table class="table table-striped table-bordered table-hover table-condensed" id="tblFieldUsers">
				<thead>
					<tr>
						<th>External Id</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Source</th>
						<th>Owner</th>
					</tr>
				</thead>
				<tbody>
					
				</tbody>
			</table>
			
		</div>
	</body>
</html>