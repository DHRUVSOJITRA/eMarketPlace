package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connection.ServicesProxy;

/**
 * Servlet implementation class sellingportal
 */
public class sellingportal extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServicesProxy proxy = new ServicesProxy();       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sellingportal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String emailid = (String) session.getAttribute("emailid");
		String categories = proxy.rendercategory();
		String[] categoriesToSend = categories.split(";");
		//System.out.println("res1 " + res);
		String username = proxy.getname(emailid);
		request.setAttribute("username", username);
		request.setAttribute("categoriesToSend", categoriesToSend);
		request.getRequestDispatcher("/View/sellingportal.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
