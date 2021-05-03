<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="accommodation_finder.models.*"%>
<!-- if we are using class in jsp page we need to import that pkg in page -->
<%@page import="accommodation_finder.models.*"%>
<%@page import="accommodation_finder.dao.*"%>
<%@page import="accommodation_finder.common.*"%>
<%@page import="java.util.*"%>
<%
Users user = (Users) session.getAttribute("userdetails"); //type casting with Users as it is Users class
if (user == null) {
	RequestDispatcher rd = request.getRequestDispatcher("/commonjsp/login.jsp");
	request.setAttribute("msg", CommonMessage.LOGIN_UNAUTHORISED);
	rd.forward(request, response);
	return;
}
%>
        
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Query</title>

<%@include file="/commoncomponents/commonheaders.html"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

</head>
<body>
<%@ include file="/headers/owner_header.jsp" %>             

<div class="row">
<div class="col-5 bg-success">
<h3 class="text-primary">Hello <%=user.getName() %></h3>
</div>
<div class="col-7 bg-warning">
<h3 class="text-light"><%=new java.util.Date().toString() %></h3>
</div>
</div>
<!-- view query code start from here -->

<%
 
OwnerDao ownerdao=new OwnerDao();


ArrayList<Query>querylist=ownerdao.viewQuery(user.getId());
%>
<!-- table start here -->

<div class="mt-5 ml-5 mr-5 ">
<h1 class="border  border-dark bg-dark text-light m-0" style="text-align: center;">Query Table</h1>
<table class="table table-dark">
  <thead>
    <tr>
      <th scope="col">Select</th>
      <th scope="col">Sender id</th>
      <th scope="col">Question</th>
      <th scope="col"> Question Date</th>
      <th scope="col">Give Answer</th>
      </tr>
  </thead>
  <tbody>
   <%
   for(Query qd:querylist)
   {
   
   %>
   <tr> <td> <input type="checkbox" name="chk"> </td> 
   <td><%=qd.getSenderid() %></td>
   <td><%=qd.getQuestion() %></td>
   <td><%=qd.getQuestiondate()%></td>
   <td><a href="/Accommodation_Finder/owner/answer_query.jsp?qid=<%=qd.getQuesid()%>">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
															Reply</a></td>
  
   </tr>
   
    <%} %>
  </tbody>
</table>
<input type="button" value="Delete" >
</div>





<%@include file="/commoncomponents/commonfooters.html" %>
</body>
</html>