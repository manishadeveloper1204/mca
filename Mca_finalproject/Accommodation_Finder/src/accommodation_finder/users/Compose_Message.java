package accommodation_finder.users;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import accommodation_finder.common.CommonMessage;
import accommodation_finder.dao.UserDao;
import accommodation_finder.models.Message;
import accommodation_finder.models.Users;

/**
 * Servlet implementation class Compose_Message
 */
@WebServlet("/Compose_Message")
public class Compose_Message extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	UserDao userdao;
	@Override
		public void init() throws ServletException {
			userdao=new UserDao();
		}
    
    public Compose_Message() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		
		  /*response.setContentType("text/html"); 
		  PrintWriter out=response.getWriter();
		  String uid=request.getParameter("id");
		  if(uid==null)
		  {
			  
		  //System.out.println("on registration servlet"+uid);
		  if(userdao.checkReceiverId(uid)==false) {
		  
		  out.println("No Such User Exists");//this will be received by Ajax response
		  return;
		  
		  }
		  
		  }
		  
		  else {*/
		 
		HttpSession hs=request.getSession(false);
		Users user=(Users)hs.getAttribute("userdetails");
		String senderid=user.getId();
		
		
        String receiverid=request.getParameter("txtrid");
		String subject=request.getParameter("txtsubject");
		String messagetext=request.getParameter("txtmsg");
		
		String rstatus="true";
		String sstatus="true";
		
		java.util.Date dt=new java.util.Date();
		java.sql.Date sqldate=new java.sql.Date(dt.getTime());
		Message m= new  Message(senderid,receiverid,subject,messagetext,rstatus,sstatus,sqldate);
		
		
		
		  /*if(userdao.checkReceiverId(uid)==true) {
		  System.out.println("already exists"); request.setAttribute("regmsg",
		  "No Such User Exists");
		  
		  RequestDispatcher
		  rd=request.getRequestDispatcher("/user/compose_message.jsp");
		  rd.forward(request, response);
		  
		  }
		 

		else {*/
		int status=userdao.compose(m);
        if(status>0)
		{
			System.out.println("message sent successfully");
			RequestDispatcher rd=request.getRequestDispatcher("/user/user_home.jsp");
			request.setAttribute("successmessage",CommonMessage.COMPOSE_SUCCESS);
			
		rd.forward(request, response);

			
			
		}
		
		
		
		
	}


	}
	
