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
import accommodation_finder.models.Room_Details;
import accommodation_finder.models.Services;
import accommodation_finder.models.Users;

/**
 * Servlet implementation class AddServices
 */
@WebServlet("/AddRoomDetails")
public class AddRoomDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	OwnerDao dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	
	@Override
	public void init() throws ServletException {

		dao=new OwnerDao();
	}
    public AddRoomDetails() {
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
		String roomtype=request.getParameter("cmbroomtype");
		String acid=request.getParameter("cmbacid");
		int ac_id=Integer.parseInt(acid);
		String facilities=request.getParameter("facilities");
		String charges=request.getParameter("charges");
		String roomno=request.getParameter("noofrooms");
		int noofrooms=Integer.parseInt(roomno);

Room_Details room_details=new Room_Details(user.getId(), roomtype, facilities, noofrooms, ac_id, noofrooms,charges);
	int status=	dao.addRoomDetails(room_details);
	if(status>0)
		
	{
		
		RequestDispatcher rd=request.getRequestDispatcher("/owner/addroomdetails.jsp");
		request.setAttribute("msg", CommonMessage.ROOM_DETAIL_MESSAGE);
		request.setAttribute("custom", "RoomDetails Message");
		rd.forward(request, response);
		
	}
		
	}

}
