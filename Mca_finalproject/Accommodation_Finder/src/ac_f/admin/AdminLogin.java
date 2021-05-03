package ac_f.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import accommodation_finder.common.CommonMessage;
import accommodation_finder.dao.AdminDao;
import accommodation_finder.models.admin;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	AdminDao admindao;
	
	@Override
	public void init() throws ServletException 
	{
		admindao =new AdminDao();
	}
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
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
		String id= request.getParameter("txtid");
		String pass=request.getParameter("txtpass");
		System.out.println(id+pass);
		//admin admin=new admin(id,pass);  //bean class object
		admin admin=admindao.login(id,pass);
		if(admin!=null)
		{
			HttpSession hs=request.getSession(); //create a session
			hs.setAttribute("admininfo", admin);
			
			response.sendRedirect("/Accommodation_Finder/admin/admin_home.jsp");
			
			
		}
		
		else 
		{
		
			RequestDispatcher rd=request.getRequestDispatcher("/admin/admin_login.jsp");
			request.setAttribute("msg", CommonMessage.LOGIN_ERROR);
			rd.forward(request, response);
			
			
		}
	}

}
