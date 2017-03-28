
/**
 * Perform Field user Search
 */
function performFieldUserSearch() {
	if(isNotEmpty("#dyna_searchExternalId")) {
		var selectedText = $("#dyna_searchExternalId").val();
		var URL = "./fieldUser/"+selectedText;
		performAJAX(URL, "GET", "", "", performFieldUserSearch_callBack, "", "");
	} else {
		alert("Enter external id value");
	}
}


/**
 * Perform field user Search CallBack 
 * @param callBackArguments
 * @param result
 * @param status
 * @param xhr
 */
function performFieldUserSearch_callBack(callBackArguments, result, status, xhr){
	if(result.status) {
		var fieldUserDetails = result.fieldUser;
		var assetListData = convertAssetListForDatatables(result.assetList);
		
		populateFieldUserPanelHeaderDetails(fieldUserDetails);
		populateFieldUserDetails(fieldUserDetails);
		populateAssetTable("#tblAssets", assetListData);
		
	} else {
		$("#dyna_errorAlert").find("span").text(result.errMsg);
		$("#dyna_errorAlert").show();
		$("#dyna_errorAlert").fadeOut();
	}
}

/**
 * Populate Field User Panel Header Details
 * @param assetDetails
 */
function populateFieldUserPanelHeaderDetails(fieldUserDetails) {
	setValue("#dyna_header_firstName", fieldUserDetails.lastName);
	setValue("#dyna_header_lastName", fieldUserDetails.firstName);
	setValue("#dyna_header_dealerCode", "TODO");
}

/**
 * Populate Field User Details
 * @param assetDetails
 */
function populateFieldUserDetails(fieldUserDetails) {
	setValue("#dyna_fieldUserId", fieldUserDetails.id);
	setValue("#dyna_externalId", fieldUserDetails.externalId);
	setValue("#dyna_firstName", fieldUserDetails.firstName);
	setValue("#dyna_lastName", fieldUserDetails.lastName);
	setValue("#dyna_portalId", fieldUserDetails.portalId);
	setValue("#dyna_source", fieldUserDetails.source);
	setValue("#dyna_owner", fieldUserDetails.owner);
}

/**
 * 
 * @param tableId
 * @param fieldUserData
 */
function populateAssetTable(tableId, assetListData) {
	
	$(tableId).DataTable({
		"destroy": true,
		"pageLength": 100,
		"data": assetListData,
		"columns": [
            { title: "Serial No" },
            { title: "Pod Type" },
            { title: "Source" },
            { title: "DM Url" }
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
 * Convert asset data for Data tables
 * @param fieldUserList
 * @returns {Array}
 */
function convertAssetListForDatatables(assetList) {
	var rtnValue = [];
	$.each(assetList, function(index,obj) {
		var x1 = [obj.serialNumber, obj.type, obj.source, obj.deviceMgrUrl];
		rtnValue.push(x1);
	});
	return rtnValue;
}