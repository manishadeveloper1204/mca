<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Owner</title>
<link rel="stylesheet" type="text/css" href="/Accommodation_Finder/css/style1.css">
<%@include file="/commoncomponents/commonheaders.html" %>
<script src="/Accommodation_Finder/js/validation.js"></script>

<style>

.mainblock
{
width: 60%;
height: 40%%;
background-color:infobackground;
float: right;
font-variant:small-caps;
font-weight:bolder;
text-align: center;

} 
</style>


</head>

<div class="mainblock">

<body>

<div
		style="width: 100%; height:auto;  float:left ;margin-bottom: 30px">
		<!-- <i class="fa fa-home fa-3x" style="color:black" aria-hidden="true"></i> -->
		<span
			style="margin-left: 200px; text-decoration:underline;color:blue;  font-weight:bold; font-size:xx-large;text-transform:  capitalize;">
			Owner Registration Form </span>
	</div>


<form action="/Accommodation_Finder/OwnerRegistration"class="needs-validation" novalidate method="post">
<div class="container ">

<div class="form-row">
    <label for="inputid">Id</label>
      
      <input type="id" class="form-control" required="required" name="txtid" id="inputid" placeholder="id">
      <div class="valid-feedback"></div>
      <div class="invalid-feedback">
      Id Required
      </div>
      
      </div>
    
      <div class="form-group">
      <label for="inputPassword4">Password</label>
      
      <input type="password" class="form-control" required="required" name="txtpass" id="inputPassword4" placeholder="password">
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
      <label for="inputowner">Owner</label>
      <!-- <input type="text" class="form-control" required="required" name="cmbowner"  id="input" placeholder="Owner"> -->
      <div class="valid-feedback"></div> 
      <select id="inputCity" class="form-control"name="cmbusertype">
       <option selected>Choose Owner</option>
       <option value="ho">Hostelowner</option>
       <option value="po">PGowner</option>
       </select>
       <div class="invalid-feedback">
       Owner Required
       </div>
  
      <div class="form-group ">
      <label for="inputCity">City</label>
      <!-- <input type="text" class="form-control" required="required" name="cmbcity"  id="inputcity" placeholder="Email"> -->
      <div class="valid-feedback"></div> 
      <select id="inputCity" class="form-control" name="cmbcity">
        <option selected>Choose...</option> 
        <option>Lucknow</option>
        <option>Delhi</option>
        <option>Gorakhpur</option>
        <option>Kanpur</option>
        <!-- <option>Other</option> -->
      </select>
      <div class="invalid-feedback">
    City Required
    </div>
    </div>
    
  
  <button type="submit" class="btn btn-success">Submit</button>
  <button type="submit" class="btn btn-danger">Reset</button>
  </div>
  
</form>
</div>
<%@include file="/commoncomponents/commonfooters.html" %>
</body>
</html>