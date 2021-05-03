package accommodation_finder.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import accommodation_finder.dao.CommonDao;
import accommodation_finder.models.Users;

/**
 * Servlet implementation class UsersLogin
 */
@WebServlet("/UsersLogin")
public class UsersLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	CommonDao commondao;
	@Override
		public void init() throws ServletException {
		
		
		commondao=new CommonDao();
		
		
			
		}
	
    
    public UsersLogin() {
        super();
        
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
		String id=request.getParameter("txtid");
		String pass=request.getParameter("txtpass");
		
		
		
		Users users=commondao.login(id,pass);
		if(users!=null)
		{
			HttpSession hs=request.getSession();    //create a session
			hs.setAttribute("userdetails", users);
			String usertype=users.getUsertype();
			  
			if(usertype.equalsIgnoreCase("user"))
				response.sendRedirect("/Accommodation_Finder/user/user_home.jsp");
			
			if(usertype.equalsIgnoreCase("ho")||usertype.equalsIgnoreCase("po"))
			response.sendRedirect("/Accommodation_Finder/owner/owner_home.jsp");
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("/commonjsp/user_login.jsp");
			request.setAttribute("msg", CommonMessage.LOGIN_ERROR);
			rd.forward(request, response);
			
		}
		
		
	}

}
