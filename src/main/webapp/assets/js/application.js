

function performRetrievePolicy1() {
	var requestUrl = "./download/sample";
	//performAJAX(URL, "GET", "", "", performRetrievePolicy_callBack, "", "");
	
	$.ajax({
		url : requestUrl,
		type : "GET",
		beforeSend  : function(jqXHR, settings ) {
			
		},
		success : function(result, status, xhr) {
			//callbackFn("", result, status, xhr);
		},
		error : function(xhr, status, error) {
			console.log("Error Block in AJAX response");
			console.log(xhr.readyState);
			console.log(xhr.status);
			console.log(status);
			console.log(error);
			//callbackFn(callbackFnArgumentsArray, error, status, xhr);
		},
		complete : function(xhr, status) {
			
		}
	}); 
}


/**
 * Perform Asset Search
 */
function performRetrievePolicy() {
	
	var postData = {
			"arnValue" : $("#field1").val()
		};
	var requestUrl = "./newdownload";
	
	performAJAX(URL, "GET", JSON.stringify(postData), "", performRetrievePolicy_callBack, "", "");
	
	
	var requestMethod = "POST";
	/*$.ajax({
		url : requestUrl,
		data : postData,
		type : requestMethod,
		beforeSend  : function(jqXHR, settings ) {
			
		},
		success : function(result, status, xhr) {
			callbackFn(callbackFnArgumentsArray, result, status, xhr);
		},
		error : function(xhr, status, error) {
			console.log("Error Block in AJAX response");
			console.log(xhr.readyState);
			console.log(xhr.status);
			console.log(status);
			console.log(error);
			callbackFn(callbackFnArgumentsArray, error, status, xhr);
		},
		complete : function(xhr, status) {
			
		}
	}); */
}

function performRetrievePolicy_callBack(callBackArguments, result, status, xhr){
	console.log(result);
}

/**
 * Perform Asset Search
 */
function performAssignGroup() {
	
	var postData = {
			"field1" : $("#field1").val(),
			"field2" : $("#field2").val(),
			"field3" : $("#field3").val(),
			"field4" : $("#field4").val()
		};
	
	var URL = "./assign";
	performAJAX(URL, "POST", JSON.stringify(postData), "", performAssignGroup_callBack, "", "");
}

/**
 * Perform Asset Search CallBack 
 * @param callBackArguments
 * @param result
 * @param status
 * @param xhr
 */
function performAssignGroup_callBack(callBackArguments, result, status, xhr){
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