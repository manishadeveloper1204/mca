<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ComposeMessage</title>
<%@include file="/commoncomponents/commonheaders.html" %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<script>
$(document).ready(function()
		
	{
		$.noConflict();
		$("#txtrid").blur(function() 
			{
		
		var uid=this.value;
			//alert(uid)
		
		 $.post("/Accommodation_Finder/Compose_Message", 
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
<%@include file="/headers/user_header.jsp" %>

<div
		style="width: 100%; height: auto;  float:left ;margin-bottom: 40px">
		<span
			style="margin-left: 500px; text-decoration:underline;  color:black;  font-weight:bold; font-size:xx-large;text-transform:  capitalize;">
			Compose Message</span>
	</div>
	
<form action="/Accommodation_Finder/Compose_Message"class="needs-validation" novalidate method="post">
<div class="container ">
<div class="form-row">
    
    
      <label for="inputrid">ReceiverId</label>
      <input type="id" class="form-control" required="required" name="txtrid" id="txtrid">
      
      <div class="valid-feedback"></div>
    
     <div class="invalid-feedback">
     Id Required
     </div>
     </div>
    
    <div class="form-group">
      <label for="inputSubject">Subject</label>
      <input type="password" class="form-control" required="required" name="txtsubject" id="inputSubject">
      <span id="usermsg" style="color:red"></span>
      <div class="valid-feedback"></div>
      <div class="invalid-feedback">
      Subject Required
      </div>
      
   
  </div>
  <div class="form-group">
    <label for="Text"> Your Text</label>
    <textarea rows="5" cols="10" class="form-control" required="required" name="txtmsg"  id="inputFeedback" placeholder="feedback"></textarea>
    
    <div class="valid-feedback"></div>
    
    
    
    <div class="invalid-feedback">
    Message Required
    </div>
    </div>
    
    
  <button type="submit" class="btn btn-success">Submit</button>
  
  </div>
  
</form>
<%@include file="/commoncomponents/commonfooters.html" %>
</body>
</html>