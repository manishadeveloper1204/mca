<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="accommodation_finder.common.*" %>
   
    <%@ page import="accommodation_finder.models.*" %> 
    <%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Accommodation details</title>

<%
Users user= (Users)session.getAttribute("userdetails");

if(user==null)
{
	RequestDispatcher rd=request.getRequestDispatcher("/commonjsp/user_login.jsp");
	request.setAttribute("msg", CommonMessage.LOGIN_UNAUTHORISED);
	rd.forward(request, response);	
	return;
}

%>
<%@include file="/commoncomponents/commonheaders.html" %>

<link rel="stylesheet" href="https://unpkg.com/leaflet@1.7.1/dist/leaflet.css" integrity="sha512-xodZBNTC5n17Xt2atTPuE1HxjVMSvLVW9ocqUKLsCC5CXdbqCmblAshOMAS6/keqq/sMZMZ19scR4PsZChSR7A==" crossorigin=""/>
 <script src="https://unpkg.com/leaflet@1.7.1/dist/leaflet.js" integrity="sha512-XQoYMqMTK8LvdxXYG3nZ448hOEQiglfqkJs1NOQV44cWnUrBc8PkAOcXy20w0vlaXaVUearIOBhiXZ5V3ynxwA==" crossorigin=""></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous"></script>

</head>
<body>
<%@include file="/headers/owner_header.jsp" %>

<div class="container-fluid bg-warning">
<h6>hello<%=user.getName() %></h6>
</div>
<h6 style="color:red ;text-align:center"> Add Accommodation Details</h6>

<form method="post" action="/Accommodation_Finder/AddAccommodationDetails">
<div class="row">

<div class="col-4 offset-1">

<div class="form-group">
    <label for="name">Name</label>
    <input type="text" class="form-control" id="txtname" name="txtname"  placeholder="name" >
  </div>
  
  <div class="form-group">
    <label for="email">Email</label>
    <input type="text" class="form-control" id="txtemail" name="txtemail"  placeholder="email" >
  </div>
  
  <div class="form-group">
    <label for="phone">Phone</label>
    <input type="text" class="form-control" id="txtphone" name="txtphone"  placeholder="phone" >
  </div>
  
 <div class="form-group">
    <label for="Address">Address</label>
    <Textarea rows=3 class="form-control" id="txtaddress" name="txtaddress"  placeholder="Addresss Here">
    </Textarea>
  </div>
  
  <div class="form-group">
    <label for="landmark">Landmark</label>
    <Textarea rows=3  class="form-control" id="txtlandmark" name="txtlandmark"  placeholder="Landmark Here" >
    </Textarea>
  </div>
  
  <div class="form-group">
    <label for="Description">Description</label>
    <Textarea rows=3  class="form-control" id="txtdescription" name="txtdescription"  placeholder="Description Here" >
    </Textarea>
  </div>
  
  <div class="form-group">
  <p>AccommodationType:</p>
  <input type="radio" id="rdtype" name="rdtype" value="PG">
  <label for="pg">PG</label><br>
  <input type="radio" id="rdtype" name="rdtype" value="Hostel">
  <label for="hostel">Hostel</label><br>
  </div>
   
<div class="form-group">
  <p>AccommodationFor:</p>
  <input type="radio" id="rdfor" name="rdfor" value="Boys">
  <label for="boys">Boys</label><br>
  <input type="radio" id="rdfor" name="rdfor" value="Girls">
  <label for="girls">Girls</label><br>
  </div>

<div class="form-group">
    <div class="col-sm-10">
      <button type="submit" class="btn btn-primary">AddDetails</button>
    </div>
  </div>
  
</div>
  
  <div id="mapid" class="col-7"></div>
  
Latitude:<input type="text" id="latitude" name="txtlat">
Longitude:<input type="text" id="longitude" name="txtlong">
<script>

	var mymap = L.map('mapid').setView([26.8467, 80.9462], 13);
	//var mymap = L.map('mapid').setView([20.5937, 78.9629], 13)
	
var marker=null;
	L.tileLayer('https://api.mapbox.com/styles/v1/{id}/tiles/{z}/{x}/{y}?access_token=pk.eyJ1IjoibWFwYm94IiwiYSI6ImNpejY4NXVycTA2emYycXBndHRqcmZ3N3gifQ.rJcFIG214AriISLbB6B5aw', {
		maxZoom: 18,
		attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors, ' +
			'Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
		id: 'mapbox/streets-v11',
		tileSize: 512,
		zoomOffset: -1
	}).addTo(mymap);

	mymap.on("click", function(e){
		if(marker!=null){
		marker.remove();
		}
        marker = new L.Marker([e.latlng.lat, e.latlng.lng]).addTo(mymap);
		$("#latitude").val(parseFloat(e.latlng.lat).toFixed(5));
		$("#longitude").val(parseFloat(e.latlng.lng).toFixed(5));
        //alert(mp.getLatLng());
 });

</script>
  
  
  </div>


 </form>


<%@include file="/commoncomponents/commonfooters.html" %>


</body>
</html>