jQuery(document).ready(function() {
	  jQuery(".panel-body").hide();

	  jQuery(".btn").click(function()
	  {
	    jQuery(this).next(".panel-body").slideToggle(500);
	  });	  
	});