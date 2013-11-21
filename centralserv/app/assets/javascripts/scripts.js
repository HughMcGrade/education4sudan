$(document).ready(function(){
	function initialize() {
		$mapContainer = $("#map-canvas");

	  var mapOptions = {
	    center: new google.maps.LatLng(7.002764,29.870224),
	    zoom: 7
	  };
	  var map = new google.maps.Map(document.getElementById("map-canvas"),
	          mapOptions);

	 	var schoolNames = $mapContainer.attr("names").split("|");

		var contentString = '<div id="content">'+
      '<div id="siteNotice">'+
      '</div>'+
      '<h1 id="firstHeading" class="firstHeading">$name</h1>'+
      '<div id="bodyContent">'+
      '<p><a href="schools/1" class="btn btn-primary" >Visit >></a></p>'+
      '</div>'+
      '</div>';

   	var infowindow = new google.maps.InfoWindow({
      	content: contentString
  	});

	  $.each($mapContainer.attr("data-point").split("|"),function(index,coords){
	  	

	  	var myLatlng = new google.maps.LatLng(parseInt(coords.split(",")[0]),parseInt(coords.split(",")[1]));

	  	var marker = new google.maps.Marker({
    		position: myLatlng,
    		map: map,
    		title:schoolNames[index]
			});
	  	 marker.setAnimation(google.maps.Animation.BOUNCE);
			google.maps.event.addListener(marker, 'click', function() {
				infowindow.setContent(contentString.replace("$name",schoolNames[index]));
    		infowindow.open(map,marker);
  		});
	  });

	  
	}

	google.maps.event.addDomListener(window, 'load', initialize);
});
	