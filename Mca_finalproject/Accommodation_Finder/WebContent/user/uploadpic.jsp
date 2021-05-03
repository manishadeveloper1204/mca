<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="accommodation_finder.models.*" %> 
    <%@page import="accommodation_finder.dao.*" %>
  <%@page import="accommodation_finder.common.*" %>
    
<%
	Users user=	(Users)session.getAttribute("userdetails");
  if(user==null)
  {	
  RequestDispatcher rd=request.getRequestDispatcher("/commonjsp/login.jsp");
	request.setAttribute("msg", CommonMessage.LOGIN_UNAUTHORISED);
	rd.forward(request, response);
  return;
  }
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>uploadpic</title>

<%@include file="/commoncomponents/commonheaders.html" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

</head>
<body>

<%@include file="/headers/user_header.jsp" %>
<div class="container-fluid bg-warning">
<h3 class="text-danger">Hello<%=user.getName()%>  </h3>
</div>

<form method="post" action="/Accommodation_Finder/UploadPic" enctype="multipart/form-data">
<div class="col d-flex justify-content-center">
<input type="file" name="fileupload" id="fileupload" onchange="return filetype_preview()">
<button type="submit" class="btn btn-success">upload pic</button>
</div>

<div id="imagePreview" class="col d-flex justify-content-center">

</div>
</form>
    <script>
        function filetype_preview() {
            var fileInput = 
                document.getElementById('fileupload');
              
            var filePath = fileInput.value;
          
            // Allowing file type
            var allowedExtensions = 
                    /(\.jpg|\.jpeg|\.png|\.gif)$/i;
              
            if (!allowedExtensions.exec(filePath)) {
                alert('Invalid file type');
                fileInput.value = '';
                return false;
            } 
            else 
           
	         { 	
            	
              	
			            	
                // Image preview
                if (fileInput.files && fileInput.files[0]) {
                    var reader = new FileReader();
                    reader.onload = function(e) {
                        document.getElementById(
                            'imagePreview').innerHTML = 
                            '<img src="' + e.target.result
                            + '"/>';
                            
                          
                    };
                      
                    reader.readAsDataURL(fileInput.files[0]);
                }
            }
        }
    </script>


<%@include file="/commoncomponents/commonfooters.html" %>

</body>
</html>