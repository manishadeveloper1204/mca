<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UserLogin</title>
<%@include file="/commoncomponents/commonheaders.html" %> 
<style>
.mainblock
{
width: 100%;
height: 100%;
margin-top:100px;
float: left;
} 

.divblock1
{
margin:100px;
width:50%;
height:200px;
font-size:xx-large;
text-align:center;
font-variant:small-caps;
margin-top: 5px;
margin-left: 350px;;
float:left;
} 
</style>
</head>
<body style="margin:0px;background-color:pink">
<%@include file="/commoncomponents/commonmessage.jsp" %>

<div class="mainblock"> 


<div class="divblock1">
<img alt="Image not found" src="/Accommodation_Finder/images/image 131.jpg"height=100% width=100%>

<form method="post" action="/Accommodation_Finder/UsersLogin">
  <div class="form-group">
  
    <label for="inputid">User Id</label>
    <input type="email" class="form-control" id="inputid" required="required" name="txtid"  aria-describedby="emailHelp">
    
    <div class="valid-feedback"></div>
    
   <div class="invalid-feedback">
    Id Required
    </div>
    
    </div>
  <div class="form-group">
    <label for="InputPassword">Password</label>
    <input type="password" class="form-control" required="required" name="txtpass"id="InputPassword">
    <div class="valid-feedback"></div>
    
   <div class="invalid-feedback">
    Password Required
    </div>
    </div>
  
  <button type="submit" class="btn btn-success">Submit</button>
</form> 
</div>

<%@include file="/commoncomponents/commonfooters.html" %> 

</body>
</html>