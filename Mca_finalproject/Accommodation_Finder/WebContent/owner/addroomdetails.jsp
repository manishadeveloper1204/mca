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
<title>AddService</title>
<%@include file="/commoncomponents/commonheaders.html" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

</head>
<%@include file="/headers/owner_header.jsp" %>
<body>
<%
String message=(String)request.getAttribute("msg");
String specificemessage=(String)request.getAttribute("custom");


System.out.println(message);
if(message!=null)
{
%>
<script>
    $(document).ready(function(){
    	/* alert("in fun") */
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
          <h4 class="modal-title"><%=specificemessage %></h4>
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

<%}%>
<div class="container offset-3 bg-success mt-5 w-50">

<%

OwnerDao dao=new OwnerDao();
ArrayList<RoomType>roomtypelist=	dao.displayRoomType();
ArrayList<AccommodationDetails>detail_list=	dao.viewAccommodation(user.getId());
%>
	
	<form method="post" action="/Accommodation_Finder/AddRoomDetails">
  
  <div class="form-group">
    <label for="accommodationtype">Select Accommodation</label>
    <select class="form-control" id="cmbroomtype" name="cmbroomtype">
      <option value="def">Select Room Type</option>
<%
for(RoomType rt:roomtypelist)
{
%>      
 
 <option value="<%=rt.getTypeid()%>"><%=rt.getTypename()%></option>
 <%} %>
    </select>
  </div>
  
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
  
  
  <div class="form-group">
    <label for="ServiceName">NO Of Rooms</label>
    <input type="text" class="form-control" id="noofrooms" name="noofrooms" placeholder="No Of Rooms">
  </div>
  <div class="form-group">
    <label for="charges">Charged</label>
    <input type="text" class="form-control" id="charges" name="charges" placeholder="charges per month">
  </div>
  
   <div class="form-group">
    <label for="Facilities">Facilities</label>
    <textarea class="form-control" id="facilities" rows="3" name="facilities"></textarea>
  </div>
  <button class="btn btn-primary">submit</button>
</form>

</div>




<%@include file="/commoncomponents/commonfooters.html" %>
</body>
</html>