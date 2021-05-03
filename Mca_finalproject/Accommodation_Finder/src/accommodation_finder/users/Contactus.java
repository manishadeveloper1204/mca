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
/*import accommodation_finder.models.FeedBack*/
import accommodation_finder.models.Query;
import accommodation_finder.models.Ucontactus;
import accommodation_finder.models.Users;

/**
 * Servlet implementation class Contactus
 */
@WebServlet("/Contactus")
public class Contactus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    UserDao userdao;
    @Override
    	public void init() throws ServletException {
    		userdao=new UserDao();
    	}
    public Contactus() {
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
		
		
		String name=request.getParameter("txtname");
		String email=request.getParameter("txtemail");
		String phone=request.getParameter("txtphone");
		String yourquery=request.getParameter("txtyourquery");
		
		java.util.Date dt=new java.util.Date();
		java.sql.Date sqldate=new java.sql.Date(dt.getTime());
		Ucontactus u= new  Ucontactus(name,email,phone, yourquery,sqldate);
		int Status=userdao.Ucontactus(u);

		if(Status>0)
		{
			
			System.out.println("query sent successfully");
			/* request.setAttribute("successquery",CommonMessage.ANSWER); */
			RequestDispatcher rd=request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
		}
		
		
	

}
				
		
		
		

}
