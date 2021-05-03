


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="accommodation_finder.models.*" %>
    <%@page import="accommodation_finder.dao.*" %>
    <%@page import="accommodation_finder.common.*" %>
    <%@page import="java.util.*" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ViewServices</title>
<%@include file="/commoncomponents/commonheaders.html" %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

</head>
<body>

<%
UserDao dao=new UserDao();
ArrayList<Accommodation_Service>servicelist=dao.viewAllServices();

%>
<h3 style="text-align:center;color:Red">Services Offered By Onwers</h3>
<form method="post" action ="/Accommodation_Finder/DeleteFeedback">
<table class="table table-dark">
  <thead>
    <tr>
    	<th>ServiceName</th>
      <th scope="col">AccommodationName</th>
      <th scope="col">Address</th>
      <th scope="col">Email</th>
        <th scope="col">Phone</th>
          <th scope="col">AccommodationType</th>
            <th scope="col">AccommodationFor</th>
      
    </tr>
  </thead>
  <tbody>
  
  <%
  for(Accommodation_Service ad_sc:servicelist)
  {
  %>
  <tr><td><%=ad_sc.getServicename() %></td>
  
  <td><%=ad_sc.getName()%></td>
  
  <td>  <%=ad_sc.getAddress() %></td>
  
  
  <td><%=ad_sc.getEmail()%></td>
  <td><%=ad_sc.getPhone()%></td>
  <td><%=ad_sc.getAccommodationtype()%></td>
  <td><%=ad_sc.getAccommodationfor()%></td>
  <tr>
  <%} %>
  </tbody>
 
  
</table>
</form>
<div class="d-flex justify-content-center">
<a href="/Accommodation_Finder/index.jsp"><i class="fa fa-home" style="font-size:48px;color:red"></i></a>
</div>
<%@include file="/commoncomponents/commonfooters.html" %>
</body>
</html>