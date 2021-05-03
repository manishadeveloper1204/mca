<% 
String message= (String)request.getAttribute("msg");
if(message!=null)
{
%>
<div class="alert alert-danger w-50 mx-auto my-5 alert-dismissible fade show"  role="alert">
  <strong><%=message %></strong> 
  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
    <span aria-hidden="true">&times;</span>
  </button>
</div>
<%} %>