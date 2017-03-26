

/**
 * Check for the empty status on value (NOT jquery Id)
 * 
 * @param value
 *            value
 * @returns {Boolean} true: if empty false: if not empty
 */
function isValueEmpty(value) {
	value = $.trim(value);
	if (value == undefined || value === 'NULL' || value === ''
			|| value === 'null'||value ==null||value ==" ") {
		return true;
	}
	return false;
}

/**
 * Check for the empty status on value (NOT jquery Id)
 * 
 * @param value
 *            value
 * @returns {Boolean} true: if NOT empty false: if empty
 */
function isValueNotEmpty(value) {
	return !isValueEmpty(value);
}

/**
 * Check the value of jquery ID object
 * @param value
 * 		value 
 * @returns {Boolean}
 * 		true: if NOT empty
 * 		false: if empty
 */
function isNotEmpty(id) {
	return !isEmpty(id);
}

/**
 * Check the value of jquery ID object
 * @param value
 * 		value 
 * @returns {Boolean}
 * 		true: if empty
 * 		false: if not empty
 */
function isEmpty(id) {
	var value = $(id).val();
	value = $.trim(value);
	if(value == undefined || value === 'NULL' || value === '' || value === 'null'||value==" "){
		return true;
	}
	return false;
}

/**
 * Compares both the values
 * @param var1
 * @param var2
 * @returns {Boolean}
 * 		true: if equal
 * 		false: if not equal
 */
function areValuesSame(var1,var2) {
	var1 = $.trim(var1);
	var2 = $.trim(var2);
	
	if(var1.toLowerCase() === var2.toLowerCase()) {
		return true;
	} else {
		return false;
	}
}

/**
 * Check for value selection
 * @param id
 * 		id of the object
 * @returns {Boolean}
 * 		true: if selected (values other than select)
 * 		false: if not selected (value is select)
 */
function hasValueSelected(id){
	if($(id).val() === 'select' || isEmpty(id)){
		return false;
	} 
	return true;
}

/**
 * Get the selected value
 * @param id
 * 		id of the object
 * @returns
 * 		Selected value
 */
function getSelectedValue(id){
	return hasValueSelected(id) ? $(id).val() : EMPTY_STRING;
}

/**
 * Set the given value to provided SpanId
 * @param spanId
 * @param value
 */
function setValue(spanId, value) {
	if(isValueEmpty(value)) {
		value = "-";
	}
	$(spanId).html(value);
}

/**
 * 
 * @param requestUrl
 * @param requestMethod
 * @param postData
 * @param formId
 * @param callbackFn
 * @param callbackFnArgumentsArray
 * @param myContentType
 * @returns
 */
function performAJAX(requestUrl, requestMethod, postData, formId, callbackFn,
		callbackFnArgumentsArray, myContentType) {
	$.ajax({
		url : requestUrl,
		data : postData,
		type : requestMethod,
		contentType : myContentType,
		success : function(result, status, xhr) {
			console.log(status)
			callbackFn(callbackFnArgumentsArray, result, status, xhr);
		},
		error : function(xhr, status, error) {
			console.log("Error Block in AJAX response");
			console.log(xhr.readyState);
			console.log(xhr.status);
			console.log(status);
			console.log(error);
			callbackFn(callbackFnArgumentsArray, error, status, xhr);
		}
	}); 
}

function loadBookMarkedTiles(){
	performAJAX(BASE_URL+MYPODTILEIDS_URL+getUserId(), "GET", "", "", loadBookMarkedTiles_callBack, "", "application/json");		
}

function loadBookMarkedTiles_callBack(callBackArguments, result, status, xhr){	
	bookMarkedTilesArray=result;	
}
