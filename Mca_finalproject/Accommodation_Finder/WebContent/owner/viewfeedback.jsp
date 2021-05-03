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
<title>View Feedback</title>
<%@include file="/commoncomponents/commonheaders.html" %>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>


</head>
<body>
<%@include file="/headers/owner_header.jsp" %>

<div class="row">
<div class="col-5-warning">
<h3 class="text-danger"> hello<%= user.getName()  %></h3>
</div>
</div>
<div class="col-5-primary">
<h3 class="text-light"><%=new java.util.Date().toString() %></h3>
</div>
<%
OwnerDao ownerdao=new OwnerDao();
ArrayList<FeedBack>userfeedback=ownerdao.viewfeedback(user.getId());

%>

<form method="post" action ="/Accommodation_Finder/DeleteFeedback">
<table class="table table-dark">
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
  for(FeedBack f:userfeedback)
  {
  %>
  <tr><td><input type="checkbox" name="chk" value="<%=f.getId()%>"></td>
  
  <td><%=f.getSenderid() %></td>
  
  <td><a href="#" data-toggle="popover" title="Ratings is:<%=f.getRating() %>" data-content="<%=f.getFeedbacktext()%>">
  <%=f.getSubject() %></a></td>
  
  
  <td><%=f.getDate()%></td>
  <tr>
  <%} %>
  </tbody>
  <tr><td colspan=4><button class="btn btn-success"type="submit" >delete</button>
  
</table>
</form>
<script>
$(document).ready(function(){
    $('[data-toggle="popover"]').popover();   
});
</script>
<%@include file="/commoncomponents/commonfooters.html" %>
</body>
</html>