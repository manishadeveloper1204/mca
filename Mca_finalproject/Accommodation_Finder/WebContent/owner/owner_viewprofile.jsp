


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="accommodation_finder.models.*" %>
    <%@page import="accommodation_finder.dao.*" %>
    <%@page import="accommodation_finder.common.*" %>
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

<% 
String path=request.getContextPath();
System.out.println("path is "+path);//projectname
String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
System.out.print("basepath is "+basePath);
String imagepath="";
String imgname=user.getPicname();
String userid=user.getId();
if(imgname==null)
{
	imagepath="/Accommodation_Finder/images/default-profile-pic.jpg";
}
else{
	
	imagepath=basePath+userid+"/"+imgname;
	System.out.print("imagepath is "+imagepath);
}

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>viewprofile</title>
<%@include file="/commoncomponents/commonheaders.html" %>
</head>
<body>
<%@include file="/headers/user_header.jsp" %>
<div class="container-fluid bg-success">

<h3 class="text-danger">Hello <%=user.getName() %></h3>
</div>


<div class="card" style="width: 18rem; margin-left:500px">
  <img src="<%=imagepath%>"   class="card-img-top" alt="...">
  <div class="card-body">
    <h5 class="card-title">Your Profile </h5>
   
  </div>
  <ul class="list-group list-group-flush">
    <li class="list-group-item">Email:<%=user.getEmail() %></li>
    <li class="list-group-item">Phone:<%=user.getPhone() %></li>
    <li class="list-group-item">City:<%=user.getCity() %></li>
  </ul>
  <div class="card-body">
    <a href="/Accommodation_Finder/user/user_editprofile.jsp" class="card-link">Edit Profile</a>
   
  </div>
</div>


<%@include file="/commoncomponents/commonfooters.html" %>
</body>
</html>