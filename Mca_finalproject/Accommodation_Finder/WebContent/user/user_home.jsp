


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="accommodation_finder.models.*" %>
    <%@page import="accommodation_finder.dao.*" %>
    <%@page import="accommodation_finder.common.*" %>
<%

     Users user=(Users)session.getAttribute("userdetails");
     if(user==null)
     {
    	 RequestDispatcher rd=request.getRequestDispatcher("/commonjsp/user_login.jsp");
			request.setAttribute("msg", CommonMessage.LOGIN_UNAUTHORISED);
			rd.forward(request, response);
    	 return;
     }
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UserHome</title>
<%@include file="/commoncomponents/commonheaders.html" %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

</head>
<body>

<%
String message=(String)request.getAttribute("successmessage");

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
          <h4 class="modal-title">FeedBack Message</h4>
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


<%@include file="/headers/user_header.jsp" %>
<div class="container-fluid bg-success">

<h3 class="text-danger">Hello <%=user.getName() %></h3>
</div>

<%@include file="/commoncomponents/commonfooters.html" %>
</body>
</html>