

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
function isValueNotEmpty(id) {
	return !isValueEmpty(id);
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
