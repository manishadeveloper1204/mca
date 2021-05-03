package accommodation_finder.owner;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import accommodation_finder.dao.OwnerDao;
import accommodation_finder.models.Users;

/**
 * Servlet implementation class OwnerRegistration
 */
@WebServlet("/OwnerRegistration")
public class OwnerRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
     OwnerDao ownerdao; 
     
     @Override
    public void init() throws ServletException {
    	ownerdao=new OwnerDao();
    }
     
     
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OwnerRegistration() {
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
		
		String userid=request.getParameter("txtid");
		String userpass=request.getParameter("txtpass");
		String username=request.getParameter("txtname");
		String userphone=request.getParameter("txtphone");
		String useremail=request.getParameter("txtemail");
		String usercity=request.getParameter("cmbcity");
		String usertype=request.getParameter("cmbusertype");
		
		
		String userstatus="true";
		
		java.util.Date dt=new java.util.Date();
		java.sql.Date sqldate=new java.sql.Date(dt.getTime());
		Users u= new Users(userid, userpass, username, useremail, usercity, usertype, userstatus, sqldate,userphone);
		int status=ownerdao.registration(u);
		if(status>0)
		{
			System.out.println("Registration done");
			response.sendRedirect("/Accommodation_Finder/commoncomponents/registrationmessage.jsp");
			
		}
		
		
		System.out.println(userid+userpass+username+userphone+useremail+usercity);
		
	}

		
		
		
	}


