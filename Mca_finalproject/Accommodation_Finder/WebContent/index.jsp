<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>

<style>

.mainblock
{
width: 100%;
height: 100%;
background-color: buttonhighlight;
float: left;
} 
</style>



<%@include file="/commoncomponents/commonheaders.html" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>


<body >

<%
String message=(String)request.getAttribute("msg");

System.out.println(message);
if(message!=null)
{
%>
<script>
    $(document).ready(function(){
    	//alert("in fun")
        $("#myModal").modal('show');
    });
</script>
<div class="container">
  <!-- The Modal -->
  <div class="modal" id="myModal">
    <div class="modal-dialog">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">Logout Message</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
         <%=message %>
        </div>
        
        <!-- Modal footer -->
        <div class="modal-footer">
          <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
        </div>
        
      </div>
    </div>
  </div>
  
</div>

<%} %>







<!-- <div
	style="width: 100%; height: auto; background-color: teal; float: left; ;margin-bottom: 30px">
		<i class="fa fa-home fa-3x" style="color:white" aria-hidden="true"></i>
		<span
			style="margin-left: 500px; text-decoration:underline;  color:white;  font-weight:bold; font-size:xx-large;text-transform:  capitalize;">
			HomePage </span>  -->
<link rel="stylesheet"type="text/css"href="/Accommodation_Finder/css/style.css">
<nav class="navbar navbar-expand-lg navbar-light bg-danger">
  

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="/Accommodation_Finder/commonjsp/aboutus.jsp"><i class="fa fa-home" aria-hidden="true"></i>About us <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item ">
        <a class="nav-link" href="/Accommodation_Finder/user/contactus.jsp"> Contact us<span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item ">
        <a class="nav-link" href="/Accommodation_Finder/commonjsp/index_viewservices.jsp">ServicesOffered</a>
      </li>
      
      
      <li class="nav-item ">
        <a class="nav-link" href="/Accommodation_Finder/commonjsp/nearbyArea.jsp"> SearchnearbyArea<span class="sr-only">(current)</span></a>
      </li>
      
      
      
      
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Search Accommodation
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
         
   <a class="dropdown-item" href="/Accommodation_Finder/commonjsp/search_hostelowner.jsp?ptype=ho">For Hostel</a>
  <a class="dropdown-item" href="/Accommodation_Finder/commonjsp/search_PGowner.jsp?ptype=po">For PG</a>
         </div>
      </li>
      
      <li class="nav-item ">
        <a class="nav-link" href="/Accommodation_Finder/commonjsp/faq.jsp"> FAQ<span class="sr-only">(current)</span></a>
      </li>
      
      
      
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Registration
        </a>
        
        
        <div class="dropdown-menu bg-warning" aria-labelledby="navbarDropdown">
        
          <a class="dropdown-item" href="/Accommodation_Finder/user/user_registration.jsp">User</a>
          <a class="dropdown-item" href="/Accommodation_Finder/owner/owner_registration.jsp">Owner</a>
          
        </div>
      </li>
          </ul>
          
          <form class="form-inline my-2 my-lg-0">
				<!-- <input class="form-control mr-sm-2" type="search"
					placeholder="Search" aria-label="Search">
				<button class="btn btn-outline-success my-2 my-sm-0" type="button">Search</button> -->
				<button class="btn btn-success my-2 my-sm-0" type="button"
					data-toggle="modal" data-target="#loginform"id="btnlogin">Login</button>
			</form>
          
          
    <!-- <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form> -->
  <!-- </div> -->
</nav>
</div>

               <!-- </div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					
				</div>
			</div>
		</div>
	</div> -->
<div class="mainblock">
	<div class="container mt-4"> 			
<div id="carouselExampleIndicators" class="carousel slide mt-4"
		data-ride="carousel">
		<ol class="carousel-indicators ">
			<li data-target="#carouselExampleIndicators" data-slide-to="0"
				class="active"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
		</ol>


		<div class="container ">
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img src="https://source.unsplash.com/1400x300/?flower"
						class="d-block w-100" alt="...">
				</div>
				<div class="carousel-item">
					<img src="https://source.unsplash.com/1400x300/?mountain"
						class="d-block w-100" alt="...">
				</div>
				<div class="carousel-item">
					<img src="https://source.unsplash.com/1400x300/?flower" class="d-block w-100"
						alt="...">
				</div>
			</div>
			<a class="carousel-control-prev" href="#carouselExampleIndicators"
				role="button" data-slide="prev"> <span
				class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="sr-only">Previous</span>
			</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
				role="button" data-slide="next"> <span
				class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="sr-only">Next</span>
			</a>
		</div>
	</div>
	</div>
	
	<div class="container mt-4"> 
	<div class="card-deck">
  <div class="card">
    <img src="/Accommodation_Finder/images/34592150293_e85e5b3aef_b.jpg" class="card-img-top" alt="...">
    <div class="card-body">
      <h5 class="card-title">Advantages to live in hostel</h5>
      <p class="card-text">Staying on campus has many advantages. Students from Lucknow University colleges express their views on living in paying guest accommodations (PGs) versus staying in hostels on campus.

      </p>
      
    </div>
  </div>
  <div class="card">
    <img src="/Accommodation_Finder/images/hostel3.jpg" class="card-img-top" alt="...">
    <div class="card-body">
      <h5 class="card-title">Advantages to live in hostel</h5>
      <p class="card-text">Staying on campus has many advantages. Students from Delhi University colleges express their views on living in paying guest accommodations (PGs) versus staying in hostels on campus.

      </p>
          </div>
  </div>
  <div class="card">
    <img src="/Accommodation_Finder/images/student.jpg" class="card-img-top" alt="...">
    <div class="card-body">
      <h5 class="card-title">Advantages to live in hostel</h5>
      <p class="card-text">It is easier to study while you are in hostel. It is also more economical and we get a balanced and healthy diet compared to the food in the canteen. In PGs, we have to cook our own food.</p>
      
    </div>
  </div>
</div>
</div>
</div>	
	
	
	
	
	

<script >

var bt=document.getElementById("btnlogin");

bt.addEventListener("click",function()
		{
	/* alert("in button") */ //only for test
	
	window.location.href="/Accommodation_Finder/commonjsp/user_login.jsp"
		}

);

</script>





<%@include file="/commoncomponents/commonfooters.html" %>
</body>
</html>