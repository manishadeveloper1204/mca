<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="accommodation_finder.models.*" %>
    <%@ page import="accommodation_finder.common.*" %>
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
<title>AdminHome</title>


<%@include file="/commoncomponents/commonheaders.html" %>

</head>
<body>
<%@include file="/headers/admin_header.jsp" %> <!-- admin header is getting included here -->

<div class="row">
<div class="col-5-warning">
<h3 class="text-danger"> hello<%= admin.getName() %></h3>
</div>
</div>
<div class="col-5-primary">
<h3 class="text-light"><%=new java.util.Date().toString() %></h3>
</div>
<%@include file="/commoncomponents/commonfooters.html" %>
</body>
</html>