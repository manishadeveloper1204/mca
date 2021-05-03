<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UserFeedback</title>
<%@include file="/commoncomponents/commonheaders.html" %>
</head>
<body>
<%@include file="/headers/user_header.jsp" %> 

<div
		style="width: 100%; height: auto;  float:left ;margin-bottom: 40px">
		<span
			style="margin-left: 500px; text-decoration:underline;  color:black;  font-weight:bold; font-size:xx-large;text-transform:  capitalize;">
			FeedBack</span>
	</div>
	
<form action="/Accommodation_Finder/User_Feedback"class="needs-validation" novalidate method="post">
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
      <label for="inputSubject">Subject</label>
      <input type="password" class="form-control" required="required" name="txtsubject" id="inputSubject">
      
      <div class="valid-feedback"></div>
      <div class="invalid-feedback">
      Subject Required
      </div>
      
   
  </div>
  <div class="form-group">
    <label for="Text">Text</label>
    <textarea rows="5" cols="10" class="form-control" required="required" name="txtfeedback"  id="inputFeedback" placeholder="feedback"></textarea>
    
    <div class="valid-feedback"></div>
    
    
    
    <div class="invalid-feedback">
    Feedback Required
    </div>
    </div>
    
    
    <div class="form-group ">
      <label for="inputRating">Rating</label>
      
      <div class="valid-feedback"></div> 
    
    <select id="inputCity" class="form-control" name="cmbrating">
        <option selected>Give Rating</option>
        <option>1</option>
        <option>2</option>
        <option>3</option>
        <option>4</option>
        <option>5</option>
      </select>
      <div class="invalid-feedback">
    Rating Required
    </div>
    </div>
    
  <button type="submit" class="btn btn-success">Submit</button>
  
  </div>
  
</form>
	
	
<%@include file="/commoncomponents/commonfooters.html" %>
</body>
</html>