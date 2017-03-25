

$(document).ready(function() {
	
	/**
	 * Used to highlight the selected menu in header
	 */
	$(".nav a").on("click", function(){
	   $(".nav").find(".active").removeClass("active");
	   $(this).parent().addClass("active");
	});
	
	
	/**
	 * 
	 */
	$('div.dropdown ul.dropdown-menu li a').click(function (e) {
	    //e.preventDefault();
	    $('.selected').html($(this).html());
	})
});