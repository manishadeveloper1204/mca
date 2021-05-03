<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="accommodation_finder.models.*" %>
    <%@page import="accommodation_finder.dao.*" %>
    <%@page import="accommodation_finder.common.*" %>
    <%@page import="java.util.*" %>
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
<title>ViewRoomDetails</title>
<%@include file="/commoncomponents/commonheaders.html" %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>



<script>
$(document).ready(function()
		
	{
		$.noConflict();
		$("#cmbacid").change(function() 
			{
		
		var acid=this.value;
			alert(acid)
		
		 $.post("/Accommodation_Finder/user/showroomdetails.jsp", 
				 {
			   	id:acid//we are sending to Servlet get method
			   	  
			 	 },
				 
				 function(response, status)
				 
				 {
		    	  	  
			 		//alert(response)
		     $("#roomdetails").html(response)
		     
				 		 
				 });
		
		 
});
	
}
		)


</script>

</head>
<body bgcolor="cyan">




<%@include file="/headers/owner_header.jsp" %>
<div class="container-fluid bg-success">

<h3 class="text-danger">Hello <%=user.getName() %></h3>
</div>
<%
OwnerDao dao=new OwnerDao();
ArrayList<AccommodationDetails>detail_list=dao.viewAccommodation(user.getId());
if(detail_list.size()>0)
{
%>
<div class="container w-25">
<div class="form-group">
    <label for="accommodationtype">Select Accommodation</label>
    <select class="form-control" id="cmbacid" name="cmbacid">
      <option value="def">Select</option>
<%
for(AccommodationDetails dl:detail_list)
{
%>      
 
 <option value="<%=dl.getAccommodationid()%>"><%=dl.getName() %></option>
 <%} %>
    </select>
  </div>
  </div>
  <%}
else{%>
<h2 style="text-align:center;color:red">No details of Rooms</h2>
<%} %>

<div class="container-fluid" id="roomdetails">

</div>



<%@include file="/commoncomponents/commonfooters.html" %>
</body>
</html>