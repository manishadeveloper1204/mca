<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>OwnerHome</title>
<%@include file="/commoncomponents/commonheaders.html" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

</head>
<%@include file="/headers/owner_header.jsp" %>
<body>
<%
String message=(String)request.getAttribute("messagesuccess");



System.out.println(message);
if(message!=null)
{
%>
<script>
    $(document).ready(function(){
    	/* alert("in fun") */
        $("#myModal").modal('show');
    });
</script>
<div class="container">
  <!-- The Modal -->
  <div class="modal" id="myModal">
    <div class="modal-dialog">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">Message</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
        <%=message %>
        </div>
        
        <!-- Modal footer -->
        <div class="modal-footer">
 <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
        </div>
        
      </div>
    </div>
  </div>
  
</div>

<%}%>





<%@include file="/commoncomponents/commonfooters.html" %>
</body>
</html>