
$(document).ready(function() {
	
	/**
	 * Used to highlight the selected menu in header
	 */
	$(".nav a").on("click", function(){
	   $(".nav").find(".active").removeClass("active");
	   $(this).parent().addClass("active");
	});
	
	
	$('#dyna_selDeviceManager').change(function (e) { 
		var selectedValue = getSelectedValue("#dyna_selDeviceManager");
		var selectedText = $("#dyna_selDeviceManager option:selected").text();
		var URL = "./selectEnv/"+selectedValue+"/"+selectedText;
	    performAJAX(URL, "GET", "", "", changeRegionEnv_callBack, "", "");
	});
	
	function changeRegionEnv_callBack(callBackArguments, result, status, xhr){	
		$("#dyna_selectedDmName").html(result.selectedDmName);
		$("#dyna_selectedDmDisplayName").html(result.selectedDmDisplayName);
	}
	
});