package accommodation_finder.users;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import accommodation_finder.common.CommonMessage;

import accommodation_finder.dao.UserDao;
import accommodation_finder.models.Users;

/**
 * Servlet implementation class UserRegistration
 */
@WebServlet("/UserRegistration")
public class UserRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	UserDao userdao;
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		userdao =new UserDao();
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegistration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String uid=request.getParameter("id");
	
		if(uid!=null)
		{
		//System.out.println("on regsitartion servlet"+uid);
		if(userdao.checkUserId(uid)==true)
		{
		
			out.println("UserId Already Exists");//this will be received by Ajax response
			return;
			
		}
			
		}
		
		
		
		else {
		
		
		
		
		
		
		String userid=request.getParameter("txtid");
		String userpass=request.getParameter("txtpass");
		String username=request.getParameter("txtname");
		String userphone=request.getParameter("txtphone");
		String useremail=request.getParameter("txtemail");
		String usercity=request.getParameter("cmbcity");
		
		String usertype="user";
		String userstatus="true";
		
		java.util.Date dt=new java.util.Date();
		java.sql.Date sqldate=new java.sql.Date(dt.getTime());
		Users u= new Users(userid, userpass, username, useremail, usercity, usertype, userstatus, sqldate,userphone);
		
		if(userdao.checkUserId(userid)==true)
		{
			//System.out.println("already exists");
			request.setAttribute("regmsg", "UserID Already Exists");

			RequestDispatcher rd=request.getRequestDispatcher("/user/user_registration.jsp");
			rd.forward(request, response);
			
		}

		else {
		
		int status=userdao.registration(u);
		if(status>0)
		{
			/* System.out.println("Registration done"); */
			response.sendRedirect("/Accommodation_Finder/commoncomponents/registrationmessage.jsp");
			System.out.println("Registration done");
		}
		
		
		System.out.println(userid+userpass+username+userphone+useremail+usercity);
		
	}

	}
	}
}
