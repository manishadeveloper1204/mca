package accommodation_finder.owner;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import accommodation_finder.common.CommonMessage;
import accommodation_finder.dao.OwnerDao;
import accommodation_finder.models.Services;
import accommodation_finder.models.Users;

/**
 * Servlet implementation class AddServices
 */
@WebServlet("/AddServices")
public class AddServices extends HttpServlet {
	private static final long serialVersionUID = 1L;
	OwnerDao dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	
	@Override
	public void init() throws ServletException {

		dao=new OwnerDao();
	}
    public AddServices() {
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

		HttpSession hs = request.getSession(false);// create a session
		Users user = (Users) hs.getAttribute("userdetails");
		String acid=request.getParameter("cmbacid");
		int ac_id=Integer.parseInt(acid);
		String servicename=request.getParameter("servicename");
		Services service=new Services(ac_id, user.getId(), servicename);

	int status=	dao.addService(service);
	if(status>0)
		
	{
		
		RequestDispatcher rd=request.getRequestDispatcher("/owner/addservice.jsp");
		request.setAttribute("msg", CommonMessage.SERVICE_MESSAGE);
		request.setAttribute("custom", "Service Message");
		rd.forward(request, response);
		
	}
		
	}

}
