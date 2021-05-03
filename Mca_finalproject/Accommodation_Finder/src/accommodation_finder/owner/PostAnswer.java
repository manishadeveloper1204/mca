package accommodation_finder.owner;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import accommodation_finder.common.CommonMessage;
import accommodation_finder.dao.OwnerDao;
import accommodation_finder.models.Query;


/**
 * Servlet implementation class PostAnswer
 */
@WebServlet("/PostAnswer")
public class PostAnswer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	OwnerDao ownerdao;
    @Override
 public void init() throws ServletException 
    {
 	   ownerdao=new OwnerDao();
    }
	/**
     * @see HttpServlet#HttpServlet()
     */
    public PostAnswer() {
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
		//System.out.println("starting of dopost");
		String tarea=request.getParameter("txtanswer");
		String qrid=request.getParameter("qid");
		int qid=Integer.parseInt(qrid);
		Query qrd=new Query();
		//System.out.println("before updateans");

		int status=ownerdao.updateAnswer(qid, tarea);
		if (status>0)
		{
			//System.out.println("status is > 0");

			RequestDispatcher rd=request.getRequestDispatcher("/owner/viewquery.jsp");
			request.setAttribute("msg", CommonMessage.ANSWER);
			request.setAttribute("custom", "Answer Update");
			rd.forward(request, response);
		}
	}

}
