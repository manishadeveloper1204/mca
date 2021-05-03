<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="accommodation_finder.models.*" %> 
    <%@page import="accommodation_finder.dao.*" %>
  <%@page import="accommodation_finder.common.*,java.util.*" %>
  
  <%
	Users user=	(Users)session.getAttribute("userdetails");
  if(user==null)
  {	
  RequestDispatcher rd=request.getRequestDispatcher("/commonjsp/login.jsp");
	request.setAttribute("msg", CommonMessage.LOGIN_UNAUTHORISED);
	rd.forward(request, response);
  return;
  }
%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>viewqueryanswer</title>
<%@include file="/commoncomponents/commonheaders.html" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>

<%
UserDao userdao=new UserDao();
ArrayList<Query>answerlist=	userdao.viewAnswer(user.getId());
%>
<%@include file="/headers/user_header.jsp" %>
<div class="container-fluid bg-warning">
<h3 class="text-danger">Hello<%=user.getName()%>  </h3>

</div>

<%
Query q=answerlist.get(0);

%>
<h2 style="text-align:center;color:red"> Answers of Your Queries!!!!</h2>
<div class="container  w-50">
<div class="accordion" id="accordionExample">
  <div class="card">
    <div class="card-header"  style="background-color:navy" id="heading<%=q.getId()%>">
      <h2 class="mb-0">
        <button class="btn btn-link btn-block text-left" style="color:white" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
         <%=q.getQuestion() %>
        </button>
      </h2>
    </div>

    <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordionExample">
      <div class="card-body bg-warning">
       <%=q.getAnswer() %>
      </div>
    </div>
  </div>


<%
for(int i=1;i<answerlist.size();i++)
{
Query q1=answerlist.get(i);
%>

<div class="card">
    <div class="card-header" style="background-color:navy" id="heading<%=q1.getId()%>">
      <h2 class="mb-0">
        <button class="btn btn-link btn-block text-left collapsed" style="color:white" type="button" data-toggle="collapse" data-target="#collapse<%=q1.getId() %>" aria-expanded="false" aria-controls="collapse<%=q1.getId()%>">
          <%=q1.getQuestion() %>
        </button>
      </h2>
    </div>
    <div id="collapse<%=q1.getId() %>" class="collapse" aria-labelledby="heading<%=q1.getId() %>" data-parent="#accordionExample">
      <div class="card-body bg-warning">
     <%=q1.getAnswer() %>
      </div>
    </div>
  </div>

<%} %>
</div>
</div>

<%@include file="/commoncomponents/commonfooters.html" %>

</body>
</html>