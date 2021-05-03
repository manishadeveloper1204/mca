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
import accommodation_finder.models.AccommodationDetails;
import accommodation_finder.models.Users;

/**
 * Servlet implementation class AddAccommodationDetails
 */
@WebServlet("/AddAccommodationDetails")
public class AddAccommodationDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	OwnerDao dao =null;
	@Override
		public void init() throws ServletException {
			dao=new OwnerDao();
		}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAccommodationDetails() {
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
		
		Users user=		(Users)hs.getAttribute("userdetails");
		
		String ownerid=user.getId();
		
		
	String latitude=request.getParameter("txtlat");
	String longitude=request.getParameter("txtlong");
	
	double lat=Double.parseDouble(latitude);
	double lng=Double.parseDouble(longitude);
	
	String rdtype=request.getParameter("rdtype");
    String rdfor=request.getParameter("rdfor");
	String name=request.getParameter("txtname");
	String email=request.getParameter("txtemail");
	String phone=request.getParameter("txtphone");
	String address=request.getParameter("txtaddress");

	String description=request.getParameter("txtdescription");
	String landmark=request.getParameter("txtlandmark");
	
	AccommodationDetails ad=new AccommodationDetails (ownerid, name, email, phone, address,landmark, rdtype,rdfor,description ,lat,lng);
	
	int status=dao.addAccommodationDetails(ad);
	
	if(status>0)
	{
		System.out.println("accommodation added");
		RequestDispatcher rd=request.getRequestDispatcher("/owner/owner_home.jsp");
		request.setAttribute("messagesuccess",CommonMessage.DETAILS_SUCCESS);
		rd.forward(request, response);
		//write codev to send on corrosponding home and show Modal there
	}
	
	
	
	//System.out.println(latitude+ptype+longitude);
	
	
	}

	}


