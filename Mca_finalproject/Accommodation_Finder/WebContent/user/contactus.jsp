<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact us</title>
<%@include file="/commoncomponents/commonheaders.html" %>
</head>
<body>














<div
		style="width: 100%; height: auto;  float:left ;margin-bottom: 40px">
		<span
			style="margin-left: 500px; text-decoration:underline;  color:black;  font-weight:bold; font-size:xx-large;text-transform:  capitalize;">
			Contact us</span>
	</div>

<form action="/Accommodation_Finder/Contactus"class="needs-validation" novalidate method="post">
<div class="container ">
<div class="form-row">
    
    
      <label for="inputrid">Name</label>
      <input type="name" class="form-control" required="required" name="txtname" id="txtname">
      <div class="valid-feedback"></div>
    
     <div class="invalid-feedback">
     Name Required
     </div>
     </div>
    
    <div class="form-group">
      <label for="inputemail">Email</label>
      <input type="email" class="form-control" required="required" name="txtemail" id="txtemail">
      
      <div class="valid-feedback"></div>
      <div class="invalid-feedback">
      Email Required
      </div>
      </div>
      
      <div class="form-group">
      <label for="inputphone">Phone</label>
      <input type="phone" class="form-control" required="required" name="txtphone" id="txtphone">
      
      <div class="valid-feedback"></div>
      <div class="invalid-feedback">
      Phone Required
      </div>
      </div>
      
      
      
  <div class="form-group">
    <label for="Text"> Your Query</label>
    <textarea rows="5" cols="10" class="form-control" required="required" name="txtyourquery"  id="txtyourquery" placeholder="text here"></textarea>
    
    <div class="valid-feedback"></div>
    
    
    
    <div class="invalid-feedback">
    Your Query Required
    </div>
    </div>
    
    
<button type="submit" class="btn btn-success">Submit</button>
  
  </div>
  
</form>






<%@include file="/commoncomponents/commonfooters.html" %>
</body>
</html>