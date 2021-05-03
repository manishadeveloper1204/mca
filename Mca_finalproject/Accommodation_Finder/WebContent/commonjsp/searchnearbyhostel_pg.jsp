<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@page import="accommodation_finder.models.* "%> 
<%@page import="accommodation_finder.dao.*" %>
<%@page import="accommodation_finder.common.*,java.util.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Near By Hostel_PG</title>
<%@ include file="/commoncomponents/commonheaders.html" %>
</head>
<body>

<%
String current_lati=request.getParameter("lati");
String current_longi=request.getParameter("longi");
String usertype=request.getParameter("utype");
System.out.println(current_lati);
System.out.println(current_longi);
float latitude=0.0f;
float longitude=0.0f;
if(current_lati!=null &&current_longi!=null)
{
latitude=Float.parseFloat(current_lati);
longitude=Float.parseFloat(current_longi);
}
CommonDao dao=new CommonDao();
ArrayList<CommonDetails>nearbylist=dao.nearBySearch(latitude, longitude,usertype);
if(nearbylist.size()>0)
{
%>

<table class="table">
  <thead>
    <tr>
      <th scope="col">UserId</th>
      <th scope="col">Name</th>
      <th scope="col">Address</th>
      <th scope="col">Phone</th>
       <th scope="col">Email</th>
       <th scope="col">Landmark</th>
        <th scope="col">AccommodationFor</th>
        <th scope="col">AccommodationType</th> 
    </tr>
  </thead>
  <tbody>
  <%
  for(CommonDetails cd:nearbylist)
  {
  %>
    <tr>
      <th scope="row"><%=cd.getId()  %></th>
      <td><%=cd.getName() %></td>
      <td><%=cd.getAddress() %></td>
        <td><%=cd.getPhone() %></td>
          <td><%=cd.getEmail() %></td>
          <td><%=cd.getLandmark() %></td>
              <td><%=cd.getAccommodationfor() %></td> 
              <td><%=cd.getAccommodationtype() %></td> 
    </tr>
  <%} 
  %>
  </tbody>
</table>
<div class="d-flex justify-content-center">
<a href="/Accommodation_Finder/index.jsp"><i class="fa fa-home" style="font-size:48px;color:red"></i></a>
</div>
<%} 
else{
%>
<h2>Sorry!!! No hostel or pg in your Near By area Upto 5KM</h2>
<div class="d-flex justify-content-center">
<a href="/Accommodation_Finder/index.jsp"><i class="fa fa-home" style="font-size:48px;color:red"></i></a>
</div>

<%} %>






<%@ include file="/commoncomponents/commonfooters.html" %>
</body>
</html>