<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SearchNearByArea</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<%@ include file="/commoncomponents/commonheaders.html" %>

</head>
<body>

<h2 style="text-align:center;color:red">Near By hostel or pg</h2>

<input type="hidden" id="txtlat">
<input type="hidden" id="txtlong">
<select id="cmbtype">
<option value="def">search type</option>
<option value="po">PG</option>
<option value="ho">Hostel</option>
</select>
<button  id="btnshow"  class="btn btn-success" style="align-self: center;">Click here to Search</button>



<script>
$(document).ready(function()
		{
	$.noConflict();
	var lat,long
    if (navigator.geolocation)
    {
      navigator.geolocation.getCurrentPosition(successFunction, errorFunction);

    }
    else 
    {
        alert('It seems like Geolocation, which is required for this page, is not enabled in your browser.');
    }  
	
	
	$("#btnshow").click(function()
			
	{
		var latitude= document.getElementById("txtlat").value
		var longitude= document.getElementById("txtlong").value
		var usertype=document.getElementById("cmbtype").value
		alert("on show button click "+latitude+longitude)
		
	 $.post("/Accommodation_Finder/commonjsp/searchnearbyhostel_pg.jsp", 
			 {
		   
		   	lati:latitude,
		   	longi:longitude,
		   utype:usertype 
		   	  
		 	 },
			 
			 function(response, status)
			 
			 {
	    	  	  
		 	
	    	// alert(response+status)
	    	 $("#shopdiv").html(response)
	    	 $("#shopdiv").show() 
			 		 
			 });
		
		
		
		
		
	});
});

function successFunction(position) 
{
     lat = position.coords.latitude;
     lng = position.coords.longitude;
   // alert('Your latitude is :'+lat+' and longitude is '+lng);
   document.getElementById("txtlat").value=lat
   document.getElementById("txtlong").value=lng
}

function errorFunction(position) 
{
    alert('Error!');
}
/* function callme()
{
var latitude= document.getElementById("txtlat").value
var longitude= document.getElementById("txtlong").value
alert("on button click "+latitude+longitude)
	
	} */

</script>

<div class="container" id="shopdiv" style="display: none">
</div>


<%@include file="/commoncomponents/commonfooters.html" %>
</body>
</html>