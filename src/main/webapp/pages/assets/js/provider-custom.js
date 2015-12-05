
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
		    $("#provider_dashboard").click(function(){
		        
		        	$("#section2").fadeIn("slow");
		        	$("#section3").fadeIn("slow");
		        	$("#section4").fadeIn("slow");
		        	$("#section5").fadeIn("slow");
		        	$("#removeSensor").fadeOut("slow");
		        	$("#provider_dashboard").addClass("active-menu");
		        	$("#addSensor").removeClass("active-menu");
		        	$("#removeSensor").removeClass("active-menu");
		    });

            // Add Sensor Form ajax call
            $("#addSensor").click(function(){
                $.ajax({url: "addSensor.ac", success: function(result){
                	$("#section2").fadeOut("slow");
                	$("#section3").fadeOut("slow");
                	$("#section4").fadeOut("slow");
                	$("#section5").fadeOut("slow");
                	$("#removeSensorSection").fadeOut("slow");
                	$("#provider_dashboard").removeClass("active-menu");
                	$("#removeSensor").removeClass("active-menu");
                	$("#addSensor").addClass("active-menu");
                    $("#addSensorSection").html(result);
                    $("#addSensorSection").fadeIn("slow");
                }});
            });
            
         // Remove Sensor ajax call
            $("#removeSensor").click(function(){
            	var sensorTable = $('#remove_virtual_sensors').DataTable({
        			"ajax" : "removeSensor.ac",
        			"columns" : [ {
        				"data" : "virtualSensorId"
        			},{
        				"data" : "installationDateTime"
        			}, {
        				"data" : "status"
        			}, {
        				"data" : "sensorCity"
        			} , {
	                    "targets": -1,
	                    "data": null,
	                    "defaultContent": "<button id='remove' class='btn btn-danger btn-sm'>Remove</button>"
	                }
        			]
	            	
        		});
            	
            	$("#section2").fadeOut("slow");
            	$("#section3").fadeOut("slow");
            	$("#section4").fadeOut("slow");
            	$("#section5").fadeOut("slow");
            	$("#addSensorSection").fadeOut("slow");
            	$("#provider_dashboard").removeClass("active-menu");
            	$("#addSensor").removeClass("active-menu");
            	$("#removeSensor").addClass("active-menu");
            	$("#removeSensorSection").fadeIn("slow");
            	
            	
            	
            	$('#remove_virtual_sensors tbody').on( 'click', '#remove', function () {
            		var row = sensorTable.row( $(this).parents('tr'));
                    var data = row.data();
                    $.ajax({url: "removeSensorSubmit.ac?vsId=" + data.virtualSensorId, method: "get", success: 
                    	function(result) {
                    	alert($(this).html());
    		            	row.remove().draw();
                    	}
                    });
                } );
            	
            	
            });
         
            
           
        		$('#virtual_sensors').DataTable({
        			"ajax" : "removeSensor.ac",
        			"columns" : [ {
        				"data" : "virtualSensorId"
        			}, {
        				"data" : "signalSpeed"
        			}, {
        				"data" : "signalType"
        			}, {
        				"data" : "outputSignal"
        			}, {
        				"data" : "installationDateTime"
        			}, {
        				"data" : "removalDateTime",
        				"defaultContent" : "Not removed"
        			}, {
        				"data" : "status"
        			}, {
        				"data" : "sensorCity"
        			} ]
        		});
        		
        		
        		
        		var usageChart = Morris.Bar({
                    element: 'morris-bar-chart',
                    xkey: 'y',
                    ykeys: ['a', 'b'],
                    labels: ['Usage', 'Billing'],
                    hideHover: 'auto',
                    resize: true,
                    hoverCallback: function (index, options, content, row) {
                    	return "Sensor ID: " + row.y + ", Usage Hours: " + row.a + ", Bill: $" + row.b;
                    }
                });
        		
        		$.ajax({url: "getThisProviderUsage.ac", method: "get", success: 
                	function(result) {
            			var usageChartData = [];
            			var data = result.data;
    	            	for (var i=0; i<data.length; i++) {
    	            		usageChartData.push({'y':data[i].virtualSensorId, 'a':data[i].billing, 'b':data[i].amount});
    	            	}
    	            	usageChart.setData(usageChartData);
                	}
                });
        		
     
        },

        initialization: function () {
            mainApp.main_fun();
        }
    }
    
    var map;

    function initializeSensorMap() {
      var mapOptions = {
        zoom: 4,
        center: {lat: -33.865427, lng: 151.196123},
        mapTypeId: google.maps.MapTypeId.TERRAIN
      };
      map = new google.maps.Map(document.getElementById('sensor-map'), mapOptions);

      // Create a <script> tag and set the USGS URL as the source.
      var script = document.createElement('script');

      script.src = 'http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/2.5_week.geojsonp';
      document.getElementsByTagName('head')[0].appendChild(script);
    }

    window.eqfeed_callback = function(results) {
	    for (var i = 0; i < results.features.length; i++) {
	      var coords = results.features[i].geometry.coordinates;
	      var latLng = new google.maps.LatLng(coords[1],coords[0]);
	      var marker = new google.maps.Marker({
	        position: latLng,
	        map: map
	      });
	    }
    };

    $(document).ready(function () {
        mainApp.main_fun();
        //initializeSensorMap();
    });

}(jQuery));
