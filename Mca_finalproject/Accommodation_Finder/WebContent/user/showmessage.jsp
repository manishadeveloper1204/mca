<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="accommodation_finder.models.*" %>
<%@page import="accommodation_finder.dao.*" %>
<%@page import="accommodation_finder.common.*" %>
<%
          Users user= (Users)session.getAttribute("userdetails");
if(user==null)
{
	RequestDispatcher rd=request.getRequestDispatcher("/common_jsp/user_login.jsp");
	request.setAttribute("msg", CommonMessage.LOGIN_UNAUTHORISED);
	rd.forward(request, response);
	return;	
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>showmessage</title>
<%@include file="/commoncomponents/commonheaders.html"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

</head>
<body>
<%@include file="/headers/user_header.jsp" %> 
<%

String messageid=request.getParameter("mid");
UserDao dao=new UserDao();
Message message=dao.viewMessage(messageid);
%>

<div class="col d-flex justify-content-center">

<div class="card text-center card text-primary bg-light my-5   w-75">
  <div class="card-header">
    
  </div>
  <div class="card-body">
    <h5 class="card-title">Send By<%=message.getSenderid() %></h5>
    <p class="card-text"><%=message.getMessagetext() %></p>
    <a href="/Accommodation_Finder/user/userinbox.jsp" class="btn btn-primary">Back</a>
  </div>
  <div class="card-footer text-muted">
    Send on date&nbsp;&nbsp;&nbsp;&nbsp;<%=message.getDate() %>
  </div>
</div>

</div>




<%@include file="/commoncomponents/commonfooters.html" %>

</body>
</html>