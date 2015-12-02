
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
        	var sensorTable = $('#user_sensors').DataTable({
    			"ajax" : "getUserSensors.ac",
    			"columns" : [ 
    			    {
	    				"data" : "virtualSensorId"
	    			}, {
	    				"data" : "allocationDate"
	    			}, {
	    				"data" : "releaseDate"
	    			}, {
	    				"data" : "amount"
	    			}, {
	                    "targets": -1,
	                    "data": null,
	                    "defaultContent": "<button>Deactivate</button>"
	                }
    			]            	
    		});
        	
        	$('#user_sensors tbody').on( 'click', 'button', function () {
                var data = sensorTable.row( $(this).parents('tr') ).data();
                $.ajax({url: "deactiveSensor.ac?usageId=" + data.usageId, method: "get", success: 
                	function(result) {
		            	
                	}
                });
            } );
        	
        	$("#user_dashboard").click(function() {                
            	$("#section1").fadeIn("slow");
            	$("#section2").fadeIn("slow");
            	$("#section3").fadeIn("slow");
            	$("#user_dashboard").addClass("active-menu");
            	$("#reqSensor").removeClass("active-menu");
            	$("#manageSensor").removeClass("active-menu");
        	});
        	
        	$("#reqSensor").click(function(){
                $.ajax({url: "reqSensor.ac", method: "post", success: 
                	function(result) {
		            	$("#msg").fadeOut("slow");
		            	$("#section1").fadeOut("slow");
		            	$("#section2").fadeOut("slow");
		            	$("#section3").fadeOut("slow");
		            	$("#user_dashboard").removeClass("active-menu");
		            	$("#reqSensor").addClass("active-menu");
		            	$("#manageSensor").removeClass("active-menu");
		                $("#reqSensorSection").html(result);
                	}
                });
        	});
        	
        	var usageData = [
	        	{
	                x: 1,
	                y: 100
	            }, {
	                x: 2,
	                y: 75
	            }, {
	                x: 3,
	                y: 50
	            }, {
	                x: 3,
	                y: 75
	            }, {
	                x: 4,
	                y: 50
	            }, {
	                x: 5,
	                y: 75
	            }, {
	                x: 6,
	                y: 100
	            }
	        ];
        	
        	var usageChart = Morris.Bar({
                element: 'morris-usage-chart',
                xkey: 'x',
                ykeys: ['y'],
                labels: ['Usage'],
                hideHover: 'auto',
                resize: true,
                hoverCallback: function (index, options, content, row) {
            	  return "Sensor Id: " + row.x + " Usage: " + row.y + " Hours";
            	}
            });
        	
        	usageChart.setData(usageData);
        	
        	var billingData = [
	        	{
	                x: 1,
	                y: 75
	            }, {
	                x: 2,
	                y: 85
	            }, {
	                x: 3,
	                y: 50
	            }, {
	                x: 3,
	                y: 75
	            }, {
	                x: 4,
	                y: 80
	            }, {
	                x: 5,
	                y: 75
	            }, {
	                x: 6,
	                y: 80
	            }
	        ];
        	
        	var billingChart = Morris.Bar({
                element: 'morris-billing-chart',                
                xkey: 'x',
                ykeys: ['y'],
                labels: ['Billing'],
                hideHover: 'auto',
                resize: true,
                hoverCallback: function (index, options, content, row) {
              	  return "Sensor Id: " + row.x + " Billing: $" + row.y;
              	}
            });
        	
        	billingChart.setData(billingData);
           
        	Morris.Donut({
                element: 'morris-sensor-chart',
                data: [{
                    label: "Active Users",
                    value: 12
                }, {
                    label: "Active UV Sensors",
                    value: 30
                }, {
                    label: "NOT IN USE Sensors",
                    value: 20
                }],
                resize: true
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
        initializeSensorMap();
    });

}(jQuery));
