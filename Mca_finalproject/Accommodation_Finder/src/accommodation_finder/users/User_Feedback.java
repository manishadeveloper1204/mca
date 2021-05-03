package accommodation_finder.users;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import accommodation_finder.common.CommonMessage;
import accommodation_finder.dao.UserDao;
import accommodation_finder.models.FeedBack;
import accommodation_finder.models.Users;

/**
 * Servlet implementation class User_Feedback
 */
@WebServlet("/User_Feedback")
public class User_Feedback extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    UserDao userdao;
    @Override
    	public void init() throws ServletException {
    		userdao = new UserDao();
    	}
    
    
    
    
    
    
    public User_Feedback() {
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
		HttpSession hs=request.getSession(false);
		Users user=(Users)hs.getAttribute("userdetails");
		String senderid=user.getId();
		
		String receiverid =request.getParameter("txtrid");
		String subject=request.getParameter("txtsubject");
		String feedback=request.getParameter("txtfeedback");
		String rating=request.getParameter("cmbrating");
		
		int user_value= Integer.parseInt(rating);
		
		java.util.Date dt=new java.util.Date();
		java.sql.Date sqldate=new java.sql.Date(dt.getTime());
		FeedBack f= new FeedBack(senderid, receiverid, subject, feedback, user_value, sqldate);
		int status=userdao.postFeedBack(f);
		if(status>0)
		{
			System.out.println("FeedBack has been updated");
			request.setAttribute("successmessage", CommonMessage.FEEDBACK_SUCCESS);
			
			RequestDispatcher rd=request.getRequestDispatcher("/user/user_home.jsp");
		
			rd.forward(request, response);
		}
		
		
		
		
	

}
				
		
		
	}


