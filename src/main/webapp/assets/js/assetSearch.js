

/**
 * Perform Asset Search
 */
function performAssetSearch() {
	if(isNotEmpty("#dyna_searchSerialNo")) {
		var selectedText = $("#dyna_searchSerialNo").val();
		var URL = "./asset/"+selectedText;
		performAJAX(URL, "GET", "", "", performAssetSearch_callBack, "", "");
	} else {
		alert("Enter Serial No.");
	}
}

/**
 * Perform Asset Search CallBack 
 * @param callBackArguments
 * @param result
 * @param status
 * @param xhr
 */
function performAssetSearch_callBack(callBackArguments, result, status, xhr){
	if(result.status) {
		var assetDetails = result.asset;
		var dealerDetails = result.dealer;
		var fieldUserData = convertFieldUserForDatatables(result.fieldUserList);
		
		populateAssetPanelHeaderDetails(assetDetails, dealerDetails);
		populateAssetDetails(assetDetails);
		populateFieldUserTable("#tblFieldUsers", fieldUserData);
	} else {
		$("#dyna_errorAlert").find("span").text(result.errMsg);
		$("#dyna_errorAlert").show();
		$("#dyna_errorAlert").fadeOut();
	}
}


/**
 * Populate Asset Panel Header Details
 * @param assetDetails
 */
function populateAssetPanelHeaderDetails(assetDetails, dealerDetails) {
	setValue("#dyna_header_assetId", assetDetails.id);
	setValue("#dyna_header_dealerCode", dealerDetails.dealerCode);
	setValue("#dyna_header_source", assetDetails.source);
}

/**
 * Populate Asset Details
 * @param assetDetails
 */
function populateAssetDetails(assetDetails) {
	setValue("#dyna_assetId", assetDetails.id);
	setValue("#dyna_serialNumber", assetDetails.serialNumber);
	setValue("#dyna_dealerId", assetDetails.dealerId);
	setValue("#dyna_source", assetDetails.source);
	setValue("#dyna_deviceMgrUrl", assetDetails.deviceMgrUrl);
	setValue("#dyna_assetType", assetDetails.type);
	setValue("#dyna_podFlashLogLevel", assetDetails.podFlashLogLevel);
	setValue("#dyna_podLogLevel", assetDetails.podLogLevel);
}

/**
 * 
 * @param tableId
 * @param fieldUserData
 */
function populateFieldUserTable(tableId, fieldUserData) {
	
	$(tableId).DataTable({
		"destroy": true,
		"pageLength": 100,
		"data": fieldUserData,
		"columns": [
            { title: "External Id" },
            { title: "First Name" },
            { title: "Last Name" },
            { title: "Source" },
            { title: "Owner" }
        ],
		"fixedHeader": {
			footer: false,
			header: true
		},
		"paging": true,
		"aaSorting": [],
		"dom": 'Bfrtip',
		"buttons": [
			'pageLength',
			{
			    extend: 'excelHtml5',
			    exportOptions: { 
			    	columns: [0,1,2,3,4]
				},
				title: 'Users'
			},
			{
				extend: 'pdfHtml5',
                exportOptions: {
                    columns: [0,1,2,3,4]
                },
                title: 'Users'
			}
        ]
	});
}

/**
 * Convert field user data for Datatables
 * @param fieldUserList
 * @returns {Array}
 */
function convertFieldUserForDatatables(fieldUserList) {
	var rtnValue = [];
	$.each(fieldUserList, function(index,obj) {
		var x1 = [obj.id, obj.externalId, obj.firstName, obj.lastName, obj.source, obj.owner];
		rtnValue.push(x1);
	});
	return rtnValue;
}