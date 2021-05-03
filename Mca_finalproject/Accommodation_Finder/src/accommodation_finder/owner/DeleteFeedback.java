package accommodation_finder.owner;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import accommodation_finder.dao.OwnerDao;

/**
 * Servlet implementation class DeleteFeedback
 */

@WebServlet("/DeleteFeedback")
public class DeleteFeedback extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	OwnerDao dao;
	@Override
	public void init() throws ServletException {
		
		dao=new OwnerDao();
	}
	
    public DeleteFeedback() {
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
		String[] feedbackids=request.getParameterValues("chk");
		System.out.println(feedbackids.length);
		
	int status=	dao.deleteFeedBack(feedbackids);
	if (status>0)
		
	{
		
		
	response.sendRedirect("/Accommodation_Finder/owner/viewfeedback.jsp");
	}
		
		
		
		
	}

}
