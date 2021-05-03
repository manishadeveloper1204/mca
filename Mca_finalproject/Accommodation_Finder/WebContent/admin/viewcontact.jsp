<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="accommodation_finder.models.*" %>
    <%@ page import="accommodation_finder.common.*" %>
    <%@ page import="accommodation_finder.dao.*"%>
  <%@page import="java.util.*" %>
  
  <%
     admin admin=(admin)session.getAttribute("admininfo");
     if(admin==null)
     {
    	 RequestDispatcher rd=request.getRequestDispatcher("/admin/user_login.jsp");
			request.setAttribute("msg", CommonMessage.LOGIN_UNAUTHORISED);
			rd.forward(request, response);
    	 return;
     }
    
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Contact</title>

<%@include file="/commoncomponents/commonheaders.html" %>

<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.24/css/dataTables.bootstrap4.min.css">
 <script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script> 

<script src="https://cdn.datatables.net/1.10.23/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.24/js/dataTables.bootstrap4.min.js"></script> 
 <script>
$(document).ready(function() {
	//alert("in function")
	$.noConflict();
    $('#contactus').DataTable();
} );

</script>
 
</head>
<body>
<%@include file="/headers/admin_header.jsp" %> 

<div class="row">
<div class="col-5-warning">
<h3 class="text-danger">hello<%=admin.getName() %></h3>
</div>
</div>
<div class="col-5-primary">
<h3 class="text-light"><%=new java.util.Date().toString() %></h3>
</div>

<% 
AdminDao admindao=new AdminDao();

ArrayList<Ucontactus>usercontact=admindao.viewcontactus();

%>
<table class="table table-bordered" id="userdetails" style="width:100%">
  <thead>
    <tr class="table-danger">
      <!-- <th scope="col">UserId</th> -->
      <th scope="col">Name</th>
      <th scope="col">Email</th>
      <th scope="col">Phone</th>
      <th scope="col">YourQuery</th>
      <th scope="col">Date</th>
    </tr>
  </thead>
  <tbody>
  
  <%
  for(Ucontactus u:usercontact)
  {
  %>
  
  <tr class="table-primary">
  <td><%=u.getName() %></td>
  <td><%=u.getEmail() %></td>
  <td><%=u.getPhone() %></td>
  <td><%=u.getYourquery() %></td>
  <td><%=u.getDate() %></td>
  <tr>
  <%} %>
  </tbody>
</table>

<%@include file="/commoncomponents/commonfooters.html" %>
</body>
</html>