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
<title>ShowRoomDetails</title>
<%-- <%@include file="/commoncomponents/commonheaders.html" %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
 --%>
</head>
<body>



<%
String accid=request.getParameter("id");
int acid=0;
if(accid!=null)
	acid=Integer.parseInt(accid);
System.out.println(acid);
UserDao dao=new UserDao();
ArrayList<RoomDetails_Type>roomlist=dao.viewAllRooms(acid);
if(roomlist.size()>0)
{
%>
<h3 style="text-align:center;color:Red">Room Details</h3>

<table class="table table-dark" style="margin-left:10px;">
  <thead>
    <tr>
    	
      <th scope="col">AccommodationName</th>
           <th scope="col">Email</th>
        <th scope="col">Phone</th>
          <th scope="col">NoOfRooms</th>
           <th scope="col">RoomType</th>
            <th scope="col">Charges</th>
             <th scope="col">Facilities</th>
      
    </tr>
  </thead>
  <tbody>
  
  <%
  for(RoomDetails_Type rt:roomlist)
  {
  %>
  <tr><td><%=rt.getName() %></td>
  
  <td><%=rt.getEmail()%></td>
  
  <td>  <%=rt.getPhone() %></td>
  
  
  <td><%=rt.getNoofrooms()%></td>
  <td><%=rt.getType()%></td>
  <td><%=rt.getCharges()%></td>
  <td><%=rt.getFacilities()%></td>
  <tr>
  <%} %>
  </tbody>

</table>
 
<%} 
  
  else{
	  %>
	  <h2 style="text-align: center;color:Red">No Room Details Available!!!</h2>
	  
	  
 <%  } %>
<%-- <%@include file="/commoncomponents/commonfooters.html" %> --%>
</body>
</html>