
/*=============================================================
    Authour URI: www.binarycart.com
    Version: 1.1
    License: MIT
    
    http://opensource.org/licenses/MIT

    100% To use For Personal And Commercial Use.
   
    ========================================================  */

(function ($) {
    "use strict";
    var mainApp = {
        main_fun: function () {       	
        	$('#main-menu').metisMenu();

            /*====================================
               LOAD APPROPRIATE MENU BAR
            ======================================*/
            $(window).bind("load resize", function () {
                 if ($(this).width() < 768) {
                     $('div.sidebar-collapse').addClass('collapse')
                 } else {
                     $('div.sidebar-collapse').removeClass('collapse')
                 }
            });
        	
        	// Dashboard content display
		    $("#admin_dashboard").click(function() {		        
		        	$("#section2").fadeIn("slow");
		        	$("#section3").fadeIn("slow");
		        	$("#section4").fadeIn("slow");
		        	$("#section5").fadeIn("slow");
		        	$("#removeSensor").fadeOut("slow");
		        	$("#provider_dashboard").addClass("active-menu");
		        	$("#addSensor").removeClass("active-menu");
		        	$("#removeSensor").removeClass("active-menu");
		    });
		    
		    $('#providers-list').DataTable({
    			"ajax" : "providers.ac",
    			"columns" : [ {
    				"data" : "userId"
    			}, {
    				"data" : "firstName"
    			}, {
    				"data" : "lastName"
    			}, {
    				"data" : "email"
    			}, {
    				"data" : "phoneNum"
    			} ]
    		});                       
           
    		$('#users-list').DataTable({
    			"ajax" : "users.ac",
    			"columns" : [ {
    				"data" : "userId"
    			}, {
    				"data" : "firstName"
    			}, {
    				"data" : "lastName"
    			}, {
    				"data" : "email"
    			}, {
    				"data" : "phoneNum"
    			} ]
    		});   		   
        },

        initialization: function () {
            mainApp.main_fun();
        }
    }    

    $(document).ready(function () {
        mainApp.main_fun();
    });

}(jQuery));
