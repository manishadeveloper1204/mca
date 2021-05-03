<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
<!-- <link rel="stylesheet" type="text/css" href="/Accommodation_Finder/css/style1.css"> -->
<%@include file="/commoncomponents/commonheaders.html" %>
<script src="/Accommodation_Finder/js/validation.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
$(document).ready(function()
		
	{
		$.noConflict();
		$("#txtid").blur(function() 
			{
		
		var uid=this.value;
			//alert(uid)
		
		 $.post("/Accommodation_Finder/UserRegistration", 
				 {
			   	id:uid//we are sending to Servlet get method
			   	  
			 	 },
				 
				 function(response, status)
				 
				 {
		    	  	  
			 		//alert(response)
		    
		    	 $("#usermsg").html(response)
		    
				 		 
				 });
		
		 
});
	
}
		)


</script>



</head>
<body>

<%

String message=(String)request.getAttribute("regmsg");

if(message!=null)
{
%>
<div class="alert alert-warning alert-dismissible fade show" role="alert">
  <%=message %>
  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
    <span aria-hidden="true">&times;</span>
  </button>
</div>
<%} %>



<div
		style="width: 100%; height: auto;  float:left ;margin-bottom: 40px">
		<!-- <i class="fa fa-home fa-3x" style="color:black" aria-hidden="true"></i> -->
		<span
			style="margin-left: 500px; text-decoration:underline;  color:black;  font-weight:bold; font-size:xx-large;text-transform:  capitalize;">
			Registration Form </span>
	</div>


<form action="/Accommodation_Finder/UserRegistration"class="needs-validation" novalidate method="post">
<div class="container ">
<div class="form-row">
    
    <label class="label" for="username">UserId</label> 
      <!-- <label for="inputid">Id</label> -->
      <input type="text" class="form-control" required="required" name="txtid" id="txtid">
      <span id="usermsg" style="color:red"></span>
      <div class="valid-feedback"></div>
    
     <div class="invalid-feedback">
     Id Required
     </div>
     </div>
    
    <div class="form-group">
      <label for="inputPassword4">Password</label>
      <input type="password" class="form-control" required="required" name="txtpass" id="inputPassword4">
      
      <div class="valid-feedback"></div>
      <div class="invalid-feedback">
      Password Required
      </div>
      
   
  </div>
  <div class="form-group">
    <label for="name">Name</label>
    <input type="text" class="form-control" required="required" name="txtname"  id="inputName" placeholder="name">
    
    <div class="valid-feedback"></div>
    
    
    
    <div class="invalid-feedback">
    Name Required
    </div>
    </div>
    
    <div class="form-group">
    <label for="inputemail">Phone no</label>
    <input type="text" class="form-control" required="required" name="txtphone"  id="inputEmail" placeholder="Phone">
    <div class="valid-feedback"></div>
    
    
    
    <div class="invalid-feedback">
    Phone no Required
    </div>
    
    
  </div>
    
    
    
    
    
    <div class="form-group">
    <label for="inputemail">Email</label>
    <input type="text" class="form-control" required="required" name="txtemail"  id="inputEmail" placeholder="Email">
    <div class="valid-feedback"></div>
    
    
    
    <div class="invalid-feedback">
    Email Required
    </div>
    
    
  </div>
  
    <div class="form-group ">
      <label for="inputCity">City</label>
      
      <div class="valid-feedback"></div> 
    
    <select id="inputCity" class="form-control" name="cmbcity">
        <option selected>Choose...</option>
        <option>Lucknow</option>
        <option>Delhi</option>
        <option>Gorakhpur</option>
        <option>Kanpur</option>
        
      </select>
      <div class="invalid-feedback">
    City Required
    </div>
    </div>
    
  <button type="submit" class="btn btn-success">Submit</button>
  <button type="submit" class="btn btn-danger">Reset</button>
  </div>
  
</form>

<!-- <input type="text" id="txtid">
<input type="text">
<p id="idmsg" style="color:red;display: none"></p> 
-->

<%@include file="/commoncomponents/commonfooters.html" %>
</body>
</html>