<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ask Query</title>
<%@include file="/commoncomponents/commonheaders.html" %>
</head>
<body>
<%@include file="/headers/user_header.jsp" %>

<div
		style="width: 100%; height: auto;  float:left ;margin-bottom: 40px">
		<span
			style="margin-left: 500px; text-decoration:underline;  color:black;  font-weight:bold; font-size:xx-large;text-transform:  capitalize;">
			Query</span>
	</div>
	
<form action="/Accommodation_Finder//Ask_Query"class="needs-validation" novalidate method="post">
<div class="container ">
<div class="form-row">
    
    
      <label for="inputrid">ReceiverId</label>
      <input type="id" class="form-control" required="required" name="txtrid" id="inputrid">
      <div class="valid-feedback"></div>
    
     <div class="invalid-feedback">
     Id Required
     </div>
     </div>
    
    
  <div class="form-group">
    <label for="Text"> Question</label>
    <textarea rows="5" cols="10" class="form-control" required="required" name="txtques"  id="inputFeedback" placeholder="feedback"></textarea>
    
    <div class="valid-feedback"></div>
    
    
    
    <div class="invalid-feedback">
    Question Required
    </div>
    </div>
    
    
  <button type="submit" class="btn btn-success">Submit</button>
  
  </div>
  
</form>






<%@include file="/commoncomponents/commonfooters.html" %>
</body>
</html>