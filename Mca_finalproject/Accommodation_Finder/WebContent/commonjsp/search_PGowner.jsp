<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="accommodation_finder.models.* "%> 
<%@page import="accommodation_finder.dao.*" %>
<%@page import="accommodation_finder.common.*,java.util.*" %>
       
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search PGowner</title>

<%@ include file="/commoncomponents/commonheaders.html" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js">
</script>

<style>
li{
font-size: 15px;
font-weight: bold;
color:navy

}
</style>

</head>
<body>

<div class="d-flex justify-content-center">
<h3 style="color:red">PG Owners details Your Search Ends Here!!!</h3>
</div>

<% 
String usertype=request.getParameter("ptype");
if(usertype!=null)
{

CommonDao dao=new CommonDao();

ArrayList<CommonDetails>commonlist=dao.searchDetails(usertype);

%>

    <% 
String path=request.getContextPath();
System.out.println("path is "+path);//projectname
String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
System.out.print("basepath is "+basePath);
String imagepath="";

%> 

<div class="row row-cols-1 row-cols-md-2">
<%
for(CommonDetails cd:commonlist)
{

	String imgname=cd.getPicname();
	String userid=cd.getId();
	if(imgname==null)
	{
		imagepath="/Accommodation_Finder/images/default.jpg";
	}
	else{
		
		imagepath=basePath+userid+"/"+imgname;
		System.out.print("imagepath is "+imagepath);
	}

%>

  <div class="col mb-4">
    <div class="card">
      <img src="<%=imagepath%>" class="card-img-top" alt="..." style="width:100px;height: 100px">
      <div class="card-body">
        <%-- <h5 class="card-title">Card title<%=i%></h5> --%>
       <!--  <p class="card-text"> -->
	        <ul style="list-style-type: none" class="card-text">
	        	<li><i class="fa fa-user" style="font-size:24px" ></i><%=cd.getName() %></li>
	        <li><i  class="fa fa-building" style="font-size:24px"></i><%=cd.getAddress()%></li>
	         <li>
<i class="fa fa-envelope" style="font-size:24px"></i>&nbsp;&nbsp;<%=cd.getEmail()%></li>
	          <li><i class="fa fa-phone-square" style="font-size:24px"></i>&nbsp;&nbsp;<%=cd.getPhone()%></li>
	<%--            <li><i class="fa fa-address-card" style="font-size:24px"></i>&nbsp;&nbsp;<%=cd.get%></li> --%>

	<li><a href="/Accommodation_Finder/user/user_registration.jsp"> do Registration to get in touch</a>
	        </ul>
		   <!--  </p> -->
			
      </div>
    </div>
  </div>
 

<%} }
%>

</div>

<div class="d-flex justify-content-center">
<a href="/Accommodation_Finder/index.jsp"><i class="fa fa-home" style="font-size:48px;color:red"></i></a>
</div>



<script>
var bt=document.getElementById("btnlogin");
bt.addEventListener("click",function()
{
	window.location.href="/Accommodation_Finder/commonjsp/user_login.jsp"
	
	}
);






</script>	


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

   
 
    
    <%@ include file="/commoncomponents/commonfooters.html" %>
</body>
</html>