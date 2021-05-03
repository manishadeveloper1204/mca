<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="accommodation_finder.models.*" %> 
   <%@ page import="accommodation_finder.dao.*" %>
   <%@ page import="accommodation_finder.common.*" %>
   
   
  <%
  Users user=(Users)session.getAttribute("userdetails");
  if(user==null)
  {  RequestDispatcher rd= request.getRequestDispatcher("/commonjsp/login.jsp");
	request.setAttribute("msg", CommonMessage.LOGIN_UNAUTHORISED);
	rd.forward(request, response);
	  return;
  }  

%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>answerquery</title>
<%@ include file="/commoncomponents/commonheaders.html" %>
</head>
<body>

<%
String queryid=request.getParameter("qid");
OwnerDao dao=new OwnerDao ();
  Query query= dao.postAnswer(queryid);
%>
<%@ include file="/headers/owner_header.jsp" %>
<div class="col d-flex justify-content-center">
<div class="card text-center card text-white bg-dark my-5 w-50">
  <h5 class="card-header">Query Asked</h5>
  <div class="card-body">
    <h5 class="card-title"><%=query.getQuestion() %></h5>
    <p class="card-text">
    <form method= "post" action="/Accommodation_Finder/PostAnswer">
    <div class="form-group">
    <label for="exampleFormControlTextarea1">Your Answer</label>
    <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="txtanswer"></textarea>
    <input type="hidden" name="qid" value="<%=query.getQuesid()%>">
  </div>
  <p>
  <button class="btn btn-primary" type="submit">Submit</button>
    </p>
    </form>
    
    <a href="/Accommodation_Finder/owner/viewquery.jsp" class="btn btn-primary">Back</a>
  </div>
  <div class="card-footer text-muted">Asked on Date <%=query.getQuestiondate() %></div>
 
</div>
</div>

<%@ include file="/commoncomponents/commonfooters.html" %>

</body>
</html>