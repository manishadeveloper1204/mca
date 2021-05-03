<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="accommodation_finder.models.*" %>
    <%@ page import="accommodation_finder.common.*" %>
    <%@ page import="accommodation_finder.dao.*"%>
  <%@page import="java.util.*" %>
  
  <%
    HttpSession hs=request.getSession(false);
	Users user=(Users)hs.getAttribute("userdetails");
	
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
<title>Inbox</title>
<%@include file="/commoncomponents/commonheaders.html" %>

<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.24/css/dataTables.bootstrap4.min.css">
 <script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script> 

<script src="https://cdn.datatables.net/1.10.23/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.24/js/dataTables.bootstrap4.min.js"></script> 

<script>
$(document).ready(function() {
	//alert("in function")
	$.noConflict();
    $('#usermesssage').DataTable();
} );

</script>


</head>
<body>
<%@include file="/headers/user_header.jsp" %>

<div class="row">
<div class="col-5-warning">
<h3 class="text-danger">hello<%=user.getName() %></h3>
</div>
</div>
<div class="col-5-primary">
<h3 class="text-light"><%=new java.util.Date().toString() %></h3>
</div>
<% 
UserDao userdao=new UserDao();

ArrayList<Message>messagelist=userdao.viewInbox(user.getId());

%>
<table class="table table-dark" id="usermessage" style="width:100%">
  <thead>
    <tr>
    	<th>Select</th>
      <th scope="col">SenderId</th>
      <th scope="col">Subject</th>
      <th scope="col">Date</th>
      
    </tr>
  </thead>
  <tbody>
  
  <%
  for(Message m:messagelist)
  {
  %>
  <tr><td><input type="checkbox" name="chk"></td>
  
  <td><%=m.getSenderid() %></td>
  
  <td>
  
  <a href="/Accommodation_Finder/user/showmessage.jsp?mid=<%=m.getMsgid() %>"><%=m.getSubject() %></a>
  
  <td><%=m.getDate()%></td>
  </tr>
  <%} %>
  </tbody>
</table>


<%@include file="/commoncomponents/commonfooters.html" %>
</body>
</html>