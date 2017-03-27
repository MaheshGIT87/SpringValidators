
$(document).ready(function() {
	
	// IMPORTANT: to hide by default.
	$("#dyna_loadingMsg").hide();
	
	/**
	 * Used to highlight the selected menu in header
	 */
	$(".nav a").on("click", function(){
	   $(".nav").find(".active").removeClass("active");
	   $(this).parent().addClass("active");
	});
	
	/**
	 * For Search 
	 */
    $('.search-panel .dropdown-menu').find('a').click(function(e) {
		e.preventDefault();
		var param = $(this).attr("href").replace("#","");
		var concept = $(this).text();
		$('.search-panel span#search_concept').text(concept);
		$('.input-group #search_param').val(param);
	});
	
    
    $('#dyna_selDeviceManager li').click(function (e) { 
    	var dmDisplayName = $(this).find("a").text();
    	var dmSchemaName = $(this).find("a").attr("title");
		var URL = "./selectEnv/"+dmSchemaName+"/"+dmDisplayName;
	    performAJAX(URL, "GET", "", "", changeRegionEnv_callBack, "", "");
	});
	
//	$('#dyna_selDeviceManager').change(function (e) { 
//		var selectedValue = getSelectedValue("#dyna_selDeviceManager");
//		var selectedText = $("#dyna_selDeviceManager option:selected").text();
//		var URL = "./selectEnv/"+selectedValue+"/"+selectedText;
//	    performAJAX(URL, "GET", "", "", changeRegionEnv_callBack, "", "");
//	});
	
	function changeRegionEnv_callBack(callBackArguments, result, status, xhr){	
		$("#dyna_selectedDmName").html(result.selectedDmName);
		$("#dyna_selectedDmDisplayName").html(result.selectedDmDisplayName);
	}
	
});