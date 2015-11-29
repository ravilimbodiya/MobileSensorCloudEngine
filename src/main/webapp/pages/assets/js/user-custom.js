
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
        	$('#sensors').DataTable({
                "ajax": "sensors.ac",
                "columns": [
                    { "data": "virtualSensorId" },
                    { "data": "dimensions" },
                    { "data": "signalSpeed" },
                    { "data": "numOfPins" },
                    { "data": "outputSignal" },
                    { "data": "operatingRangeFrom" },
                    { "data": "operatingRangeTo" },
                    { "data": "installationDateTime" },
                    { "data": "removalDateTime" },
                    { "data": "status" },
                    { "data": "totalEarning" },
                    { "data": "usage" },
                    { "data": "billing" },
                    { "data": "latitude" },
                    { "data": "longitude" },
                    { "data": "sensorCity" },
                ]
            });
        	
        	Morris.Bar({
                element: 'morris-usage-chart',
                data: [{
                    y: '2006',
                    a: 100,
                    b: 90
                }, {
                    y: '2007',
                    a: 75,
                    b: 65
                }, {
                    y: '2008',
                    a: 50,
                    b: 40
                }, {
                    y: '2009',
                    a: 75,
                    b: 65
                }, {
                    y: '2010',
                    a: 50,
                    b: 40
                }, {
                    y: '2011',
                    a: 75,
                    b: 65
                }, {
                    y: '2012',
                    a: 100,
                    b: 90
                }],
                xkey: 'y',
                ykeys: ['a', 'b'],
                labels: ['Series A', 'Series B'],
                hideHover: 'auto',
                resize: true
            });
        	Morris.Bar({
                element: 'morris-billing-chart',
                data: [{
                    y: '2006',
                    a: 100,
                    b: 90
                }, {
                    y: '2007',
                    a: 75,
                    b: 65
                }, {
                    y: '2008',
                    a: 50,
                    b: 40
                }, {
                    y: '2009',
                    a: 75,
                    b: 65
                }, {
                    y: '2010',
                    a: 50,
                    b: 40
                }, {
                    y: '2011',
                    a: 75,
                    b: 65
                }, {
                    y: '2012',
                    a: 100,
                    b: 90
                }],
                xkey: 'y',
                ykeys: ['a', 'b'],
                labels: ['Series A', 'Series B'],
                hideHover: 'auto',
                resize: true
            });
           
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
        zoom: 2,
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