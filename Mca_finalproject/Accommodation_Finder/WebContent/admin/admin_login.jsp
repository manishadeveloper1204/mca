<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AdminLogin</title>
<%@include file="/commoncomponents/commonheaders.html" %> 
<script src="/Accommodation_Finder/js/validation.js"></script>
<style>

.mainblock
{
width: 50%;
height: 50%%;
background-color: pink;
float: right;
text-align: center;

} 

</style>
</head>
<body style="margin:0px;background-color: pink;text-align:center;text-transform: capitalize;font-style: italic;font-weight: bold;">

<div class="mainblock">


<img alt="Image not found" src="/Accommodation_Finder/images/beds-182965_640.jpg"height=100% width=50%>
</div>
<%@include file="/commoncomponents/commonmessage.jsp" %>

<%-- <%@include file="/headers/admin_header.jsp" %> --%>
 <form class="needs-validation" novalidate method="post" action="/Accommodation_Finder/AdminLogin"> 

<div style="width: 100%; height: auto;  float:right; ;margin-bottom: 110px">
</div>
</div>

<div class="container mt-5">
<div class="divbock1">
  <div class="form-group">
    <label for="exampleInputId" class="col-sm-2 col-form-label">Id</label>
    <div class="col-sm-6">
    <input type="text" class="form-control form-control"  required="required" name="txtid" id="exampleInputEmail1" aria-describedby="emailHelp">
    
    <div class="valid-feedback"></div>
    
    
    
    <div class="invalid-feedback">
    Id Required
    </div>
  </div>
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1" class="col-sm-2 col-form-label">Password</label>
    <div class="col-sm-6">
    <input type="password" required="required" class="form-control" name="txtpass"id="exampleInputPassword1">
    
    <div class="valid-feedback"></div>
    
    
    
    <div class="invalid-feedback">
    Password Required
    </div>
 </div>
  </div>
  <button type="login" class="btn btn-success">Login</button>
</form>
</div>
 </div>



<%@include file="/commoncomponents/commonfooters.html" %> 
</body>
</html>