


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
<title>editprofile</title>
<%@include file="/commoncomponents/commonheaders.html" %>
</head>
<body>
<%@include file="/headers/user_header.jsp" %>
<div class="container-fluid bg-success">

<h3 class="text-danger">Hello <%=user.getName() %></h3>
</div>

<form method="post" action="/Accommodation_Finder/User_EditProfile" >
<div class="card" style="width: 18rem; margin-left:500px">
  <img src="<%=imagepath%>"    class="card-img-top" alt="...">
  <div class="card-body">
    <h5 class="card-title">Edit Your Profile </h5>
   
  </div>
  <ul class="list-group list-group-flush">
    <li class="list-group-item">
    <input type="text" name="txtemail"required="required" value="<%=user.getEmail()%>">
    </li>
    <li class="list-group-item">
    <input type="text" name="txtphone"required="required" value="<%=user.getPhone() %>">
    </li>
    <li class="list-group-item">
    <input type="text" name="txtcity"required="required" value="<%=user.getCity() %>">
    </li>
  </ul>
  <div class="card-body">
  <button type="submit"class="btn btn btn-success"></button>
    <a href="/Accommodation_Finder/user/user_viewprofile.jsp" class="card-link">View Profile</a>
   
  </div>
</div>
</form>


<%@include file="/commoncomponents/commonfooters.html" %>
</body>
</html>